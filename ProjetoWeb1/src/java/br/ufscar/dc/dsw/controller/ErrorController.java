/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/erro/*"})
public class ErrorController extends HttpServlet {

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
                case "403":
                    handle403(request, response);
                    break;
                case "404":
                    handle404(request, response);
                    break;
                default:
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void handle403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getUserPrincipal().getName() != null) {
            String email = request.getUserPrincipal().getName().toString();
            log("Erro 403 - Acesso invalido de: " + email);
        } else {
            log("Erro 403 -Acesso invalido anônimo");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error/403.jsp");
        dispatcher.forward(request, response);
    }

    private void handle404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("Erro 404 - Não encontrado!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error/404.jsp");
        dispatcher.forward(request, response);
    }
}
