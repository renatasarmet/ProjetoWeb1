/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.model.Promocao;
import java.io.IOException;
import java.util.Date;
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
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    @Override
    public void init() {
        dao = new PromocaoDAO();
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
                case "remocao":
                    remove(request, response);
                    break;
                default:
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/formulario.jsp");
        log("entrou funcao forms");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        Date data_sessao =  sdf.parse(request.getParameter("data_sessao"));
        Promocao promocao = new Promocao(url,cnpj,nome,preco,data_sessao);
        dao.insert(promocao);
        response.sendRedirect("lista");
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Promocao> listaPromocao = dao.getAll();
        log("PROMOCOES:");
        log(listaPromocao.get(0).getUrl());
        request.setAttribute("listaPromocao", listaPromocao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/lista.jsp");
        dispatcher.forward(request, response);
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
