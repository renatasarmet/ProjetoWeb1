<%-- 
    Document   : formulario
    Created on : Apr 15, 2019, 12:10:53 AM
    Author     : Leonardo
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
        <h1><fmt:message key="cadastro_site_venda_ingresso"/></h1>
    </center>
    <div align="center">
        <c:if test="${site == null}">
            <form action="insercao" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <tr>
                <th><fmt:message key="email"/></th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${site.email}' />"/>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="senha"/></th>
                <td>
                    <input type="text" name="senha" size="45"
                           value="<c:out value='${site.senha}' />"/>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="url"/></th>
                <td>
                    <input type="text" name="url" size="45"
                           value="<c:out value='${site.url}' />"/>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="nome"/></th>
                <td>
                    <input type="text" name="nome" size="45"
                           value="<c:out value='${site.nome}' />"/>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="telefone"/></th>
                <td>
                    <input type="text" name="telefone" size="45"
                           value="<c:out value='${site.telefone}' />"
                           />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value=<fmt:message key="salvar"/> />
                </td>
            </tr>
        </table>
    </form>
</div>
</fmt:bundle>
</body>
</html>

