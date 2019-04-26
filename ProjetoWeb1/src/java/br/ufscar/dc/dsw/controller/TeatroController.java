/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.model.Promocao;
import br.ufscar.dc.dsw.model.Teatro;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author João
 */

// TODO: Organizar as rotas
@WebServlet(urlPatterns = "/teatro_crud/*")
public class TeatroController extends HttpServlet {
    
    private TeatroDAO dao;

    @Override
    public void init() {
        dao = new TeatroDAO();
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "editar":
                    editarFormulario(request, response);
                    break;
                case "insercao":
                    insere(request, response);
                    break;
                case "lista":
                    lista(request, response);
                    break;
                case "filtrar_cidade":
                    filtra_cidade(request, response);
                    break;
                case "atualizacao":
                    atualiza(request, response);
                    break;
                case "remocao":
                    remove(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("id") != null){
            Teatro t = dao.get(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("teatro", t);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void editarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getUserPrincipal().getName().toString() != null){
            Teatro t = dao.getByEmail(request.getUserPrincipal().getName().toString());
            request.setAttribute("teatro", t);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/formulario.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha1 = request.getParameter("senha1Teatro");
        String senha2 = request.getParameter("senha2Teatro");
        String CNPJ = request.getParameter("CNPJ");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        if(senha1.equals(senha2)){
            Teatro t = new Teatro(email, senha2, CNPJ, nome, cidade);
            dao.insert(t);
            response.sendRedirect("lista");
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Teatro> listaTeatros = dao.getAll();
        request.setAttribute("listaTeatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void atualiza(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senhaEncode = request.getParameter("senhaEncode");
        String senhaold = request.getParameter("senhaAntigaTeatro");
        String senha1 = request.getParameter("senha1Teatro");
        String senha2 = request.getParameter("senha2Teatro");
        String CNPJ = request.getParameter("CNPJ");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        if(encoder.matches(senhaold,senhaEncode ) && senha1.equals(senha2)){
            Teatro t = new Teatro(id,email, senha2, CNPJ, nome, cidade);
            dao.update(t);
            response.sendRedirect("lista");
        }
    }
    
    private void filtra_cidade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teatro> listaTeatro = dao.getTeatrosCidade(request.getParameter("cidade_desejado"));
        request.setAttribute("listaTeatros", listaTeatro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatro/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        dao.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("lista");
    }

}
