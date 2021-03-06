/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.Site_Venda_IngressoDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Site_Venda_Ingresso;
import br.ufscar.dc.dsw.model.Teatro;
import br.ufscar.dc.dsw.model.Usuario;
import java.io.IOException;
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
 * @author Leonardo
 */
@WebServlet(urlPatterns = "/site_venda_crud/*")
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
                case "editar":
                    editarFormulario(request, response);
                    break;
                case "atualizacao":
                    atualize(request, response);
                    break;
                case "remocao":
                    remove(request, response);
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

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site_venda_ingresso/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha1 = request.getParameter("senha1Site");
        String senha2 = request.getParameter("senha2Site");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        Site_Venda_Ingresso site = new Site_Venda_Ingresso(email, senha2, url, nome, telefone);
        if (senha1.equals(senha2)) {
            dao.insert(site);
            response.sendRedirect("/ProjetoWeb1/");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/formulario.jsp");
            request.setAttribute("site", site);
            request.setAttribute("errorUpdate", 1);
            dispatcher.forward(request, response);
        }
    }

    private void editarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getUserPrincipal().getName().toString() != null) {
            Site_Venda_Ingresso site = dao.getByEmail(request.getUserPrincipal().getName().toString());
            request.setAttribute("site", site);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/site_venda_ingresso/formulario.jsp");
            dispatcher.forward(request, response);
        }

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site_venda_ingresso/formulario.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        int id_usuario = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String senhaEncode = request.getParameter("senhaEncode");
        String senhaold = request.getParameter("senhaAntigaSite");
        String senha1 = request.getParameter("senha1Site");
        String senha2 = request.getParameter("senha2Site");
        String email = request.getParameter("email");
        Site_Venda_Ingresso site = new Site_Venda_Ingresso(id_usuario, email, senha1, url, nome, telefone);
        if (encoder.matches(senhaold, senhaEncode) && senha1.equals(senha2)) {
            dao.update(site);
            response.sendRedirect("/ProjetoWeb1/");
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_ingresso/formulario.jsp");
            request.setAttribute("site", site);
            if (!encoder.matches(senhaold, senhaEncode)) {
                request.setAttribute("errorUpdate", 3);
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorConfirmacao", 2);
                dispatcher.forward(request, response);
            }
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Site_Venda_Ingresso site = new Site_Venda_Ingresso(id);
        dao.delete(site);
        response.sendRedirect("lista");
    }

}
