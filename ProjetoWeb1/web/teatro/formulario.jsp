<%-- 
    Document   : formulario
    Created on : 15/04/2019, 09:20:58
    Author     : João
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
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
        <c:if test="${teatro != null}">
            <form action="atualizacao">
            </c:if>
            <c:if test="${teatro == null}">
                <form action="insercao">
                </c:if>
                <table border="1" cellpadding="5">
                    <h2>
                        <c:if test="${teatro != null}">
                            <fmt:message key="edicao_de_teatro"/>
                        </c:if>
                        <c:if test="${teatro == null}">
                            <fmt:message key="cadastro_de_teatro"/>
                        </c:if>
                    </h2>
                    <tr>
                        <th><fmt:message key="email"/></th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${teatro.email}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="senha"/></th>
                        <td>
                            <input type="password" name="senha" size="45"
                                   value="<c:out value='${teatro.senha}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="cnpj"/></th>
                        <td>
                            <input type="text" name="CNPJ" size="45"
                                   value="<c:out value='${teatro.CNPJ}' />" 
                                   required />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="nome"/></th>
                        <td>
                            <input type="text" name="nome" size="45"
                                   value="<c:out value='${teatro.nome}'/>"
                                   required />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="cidade"/></th>
                        <td>
                            <input type="text" name="cidade" size="45"
                                   value="<c:out value='${teatro.cidade}'/>"
                                   required />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value=<fmt:message key="salvar"/> />
                        </td>
                    </tr>
                </table>
            </form>
    </center>
    </fmt:bundle>
</body>
</html>
