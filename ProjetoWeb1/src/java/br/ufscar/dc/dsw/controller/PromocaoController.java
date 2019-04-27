/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.Site_Venda_IngressoDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.model.Promocao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renata
 */
@WebServlet(urlPatterns = {"/promocao/*"})
public class PromocaoController extends HttpServlet {

    private PromocaoDAO dao;
    private Site_Venda_IngressoDAO daoSite;
    private TeatroDAO daoTeatro;
    @Override
    public void init() {
        dao = new PromocaoDAO();
        daoSite = new Site_Venda_IngressoDAO();
        daoTeatro = new TeatroDAO();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String action = request.getRequestURI();
        log(action);
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "insercao":
                    insere(request, response);
                    break;
                case "lista":
                    lista(request, response);
                    break;
                case "edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "atualizacao":
                    atualize(request, response);
                    break;
                case "remocao":
                    remove(request, response);
                    break;
                case "filtrar_url":
                    filtra_url(request, response);
                    break;
                case "filtrar_cnpj":
                    filtra_cnpj(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/error/404.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PromocaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PromocaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listaSite", new Site_Venda_IngressoDAO().getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String email = request.getUserPrincipal().getName().toString();
        String cnpj = daoTeatro.getCNPJ(email);
        String nome = request.getParameter("nome");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String data_sessao =  request.getParameter("data_sessao");
        String horario_sessao =  request.getParameter("horario_sessao");
        Promocao promo = new Promocao(url,cnpj,nome,preco,data_sessao,horario_sessao);
        boolean deu_certo = dao.insert(promo);
        if(!deu_certo){
            //CHAMAR AQUI UM ALERT() avisando que deu horario conflitante
            log("Preciso chamar um alert aqui avisando que teve horario conflitante");
        }
        response.sendRedirect("lista");
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Promocao> listaPromocao = dao.getAll();
        request.setAttribute("listaPromocao", listaPromocao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void filtra_url(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getUserPrincipal().getName().toString();
        List<Promocao> listaPromocao = dao.getPromocaoSite(daoSite.getURL(email));
        request.setAttribute("listaPromocao", listaPromocao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/lista.jsp");
        dispatcher.forward(request, response);
    }
    
     private void filtra_cnpj(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Promocao> listaPromocao = dao.getPromocaoTeatro(request.getParameter("cnpj_desejado"));
        request.setAttribute("listaPromocao", listaPromocao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Promocao promo = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/formulario.jsp");
        request.setAttribute("promocao", promo);        
        request.setAttribute("listaSite", new Site_Venda_IngressoDAO().getAll());
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String data_sessao =  request.getParameter("data_sessao");
        String horario_sessao =  request.getParameter("horario_sessao");
        Promocao promo = new Promocao(id,url,cnpj,nome,preco,data_sessao,horario_sessao);
        boolean deu_certo = dao.update(promo);
        if(!deu_certo){
            //CHAMAR AQUI UM ALERT() avisando que deu horario conflitante
            log("Preciso chamar um alert aqui avisando que teve horario conflitante");
        }
        response.sendRedirect("lista");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Promocao promo = new Promocao(id);
        dao.delete(promo);
        response.sendRedirect("lista");
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
