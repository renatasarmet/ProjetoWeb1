<%-- 
    Document   : formulario
    Created on : Apr 15, 2019, 12:10:53 AM
    Author     : Leonardo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Site de promoçoes</title>
    </head>
    <body>
    <center>
        <h1>Ediiç�o de site de venda de ingresso</h1>
    </center>
    <div align="center">
        <c:if test="${site != null}">
            <form action="atualizacao" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            </caption>
            <c:if test="${site != null}">
                <input type="hidden" name="id" value="<c:out value='${site.id}' />" />
            </c:if>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${site.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Senha: </th>
                <td>
                    <input type="text" name="senha" size="45"
                           value="<c:out value='${site.senha}' />"/>
                </td>
            </tr>
            <tr>
                <th>Url: </th>
                <td>
                    <input type="text" name="url" size="45"
                           value="<c:out value='${site.url}' />"/>
                </td>
            </tr>
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="nome" size="45"
                           value="<c:out value='${site.nome}' />"/>
                </td>
            </tr>
            <tr>
                <th>Telefone: </th>
                <td>
                    <input type="text" name="telefone" size="45"
                           value="<c:out value='${site.telefone}' />"
                           />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Salva" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

