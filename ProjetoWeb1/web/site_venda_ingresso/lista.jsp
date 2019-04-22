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
        <h1>Lista de sites de venda de ingresso</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de sites de venda de ingresso</h2></caption>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Ativo</th>
                <th>Telefone</th>
                <th>Url</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th colspan="2" >Opçoes</th>
            </tr>
            <c:forEach var="site" items="${listaSites}">
                <tr>
                <td><c:out value="${site.id}" /></td>
                <td><c:out value="${site.email}" /></td>
                <td><c:out value="${site.senha}" /></td>
                <td><c:out value="${site.ativo}" /></td>
                <td><c:out value="${site.url}" /></td>
                <td><c:out value="${site.nome}" /></td>
                <td><c:out value="${site.telefone}" /></td>
                <td><a href="edicao?id=<c:out value='${site.id}' />">Ediçao</a></td>
                <td><a href="remocao?id=<c:out value='${site.id}' />"onclick="return confirm('Deseja excluir esse item?');">Remoçao</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
