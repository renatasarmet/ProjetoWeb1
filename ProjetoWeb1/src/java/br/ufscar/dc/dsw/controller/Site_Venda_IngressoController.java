/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.Site_Venda_IngressoDAO;
import br.ufscar.dc.dsw.model.Site_Venda_Ingresso;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(urlPatterns = "/")
public class Site_Venda_IngressoController extends HttpServlet {

    private Site_Venda_IngressoDAO dao;

    @Override
    public void init() {
        dao = new Site_Venda_IngressoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/site_cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/site_insercao":
                    insere(request, response);
                    break;
                case "/site_lista":
                    lista(request, response);
                    break;
                default:
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("site_venda_ingresso/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        System.out.print(email);
        String senha = request.getParameter("senha");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        Site_Venda_Ingresso site = new Site_Venda_Ingresso(email, senha, url, nome, telefone);
        dao.insert(site);
        response.sendRedirect("site_cadastro");
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Site_Venda_Ingresso> listaSites = dao.getAll();
        request.setAttribute("listaSites", listaSites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("site_venda_ingresso/lista.jsp");
        dispatcher.forward(request, response);
    }

}
