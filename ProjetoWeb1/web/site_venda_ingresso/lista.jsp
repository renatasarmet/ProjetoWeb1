<%-- 
    Document   : lista
    Created on : Apr 15, 2019, 10:24:03 AM
    Author     : root
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <fmt:bundle basename="i18n.mensagem">
        <title><fmt:message key="site_de_promocoes"/></title>
        </fmt:bundle>
    </head>
    <body>
        <fmt:bundle basename="i18n.mensagem">
    <center>
        <h1><fmt:message key="lista_site_venda_ingresso"/></h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2><fmt:message key="lista_site_venda_ingresso"/></h2></caption>
            <tr>
                <th><fmt:message key="id"/></th>
                <th><fmt:message key="email"/></th>
                <th><fmt:message key="senha"/></th>
                <th><fmt:message key="url"/></th>
                <th><fmt:message key="nome"/></th>
                <th><fmt:message key="telefone"/></th>
                <th colspan="2" ><fmt:message key="opcoes"/></th>
            </tr>
            <c:forEach var="site" items="${listaSites}">
                <tr>
                    <td><c:out value="${site.id}" /></td>
                <td><c:out value="${site.email}" /></td>
                <td><c:out value="${site.senha}" /></td>
                <td><c:out value="${site.url}" /></td>
                <td><c:out value="${site.nome}" /></td>
                <td><c:out value="${site.telefone}" /></td>
                <td><a href="edicao?id=<c:out value='${site.id}' />"><fmt:message key="edicao"/></a></td>
                <td><a href="remocao?id=<c:out value='${site.id}' />"onclick="return confirm('Deseja excluir esse item?');"><fmt:message key="remocao"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </fmt:bundle>
</body>
</html>
