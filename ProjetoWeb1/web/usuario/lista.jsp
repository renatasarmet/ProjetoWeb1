<%-- 
    Document   : lista
    Created on : Apr 15, 2019, 10:24:03 AM
    Author     : root
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Livraria Virtual</title>
    </head>
    <body>
    <center>
        <h1>Lista de usuarios</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de usuarios</h2></caption>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Tipo</th>
                <th colspan="2" >Opçoes</th>
            </tr>
            <c:forEach var="usuarios" items="${listaUsuarios}">
                <tr>
                <td><c:out value="${usuarios.id}" /></td>
                <td><c:out value="${usuarios.email}" /></td>
                <td><c:out value="${usuarios.senha}" /></td>
                <td><c:out value="${usuarios.tipo}" /></td>
                <td><a href="edicao?id=<c:out value='${usuarios.id}' />">Ediçao</a></td>
                <td><a href="remocao?id=<c:out value='${usuarios.id}' />"onclick="return confirm('Deseja excluir esse usuario?');">Remoçao</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
