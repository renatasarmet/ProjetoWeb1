<%-- 
    Document   : lista
    Created on : 19/04/2019, 22:25:44
    Author     : João
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Teatros</title>
    </head>
    <body>
    <center>
        <h1>Lista de teatros</h1>
        <c:if test="${empty listaTeatros}">
            <h2>Não há teatros</h2>
            <a href="cadastro">Inserir!</a>
        </c:if>
        <c:if test="${!empty listaTeatros}">
            <table border="1" cellpadding="5">
                <caption><h2>Lista de teatros</h2></caption>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>CNPJ</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                    <th colspan="2" >Opçoes</th>
                </tr>
                <c:forEach var="teatro" items="${listaTeatros}">
                    <tr>
                        <td><c:out value="${teatro.id}" /></td>
                        <td><c:out value="${teatro.email}" /></td>
                        <td><c:out value="${teatro.senha}" /></td>
                        <td><c:out value="${teatro.CNPJ}" /></td>
                        <td><c:out value="${teatro.nome}" /></td>
                        <td><c:out value="${teatro.cidade}" /></td>
                        <td><a href="cadastro?id=<c:out value='${teatro.id}' />">Ediçao</a></td>
                        <td><a href="remocao?id=<c:out value='${teatro.id}' />"onclick="return confirm('Deseja excluir esse item?');">Remoçao</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <a href="cadastro">Cadastrar novo teatro</a>
    </center>
</body>
</html>
