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
@WebServlet(urlPatterns = "/site_venda/*")
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
                case "edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "atualizacao":
                    atualize(request, response);
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

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site_venda_ingresso/formulario.jsp");

        log("entrou");
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
        response.sendRedirect("lista");
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Site_Venda_Ingresso> listaSites = dao.getAll();
        request.setAttribute("listaSites", listaSites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site_venda_ingresso/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Site_Venda_Ingresso site = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site_venda_ingresso/formulario_edicao.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        Site_Venda_Ingresso site = new Site_Venda_Ingresso(id, email, senha, url, nome, telefone);
        dao.update(site);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Site_Venda_Ingresso book = new Site_Venda_Ingresso(id);
        dao.delete(book);
        response.sendRedirect("lista");
    }

}
