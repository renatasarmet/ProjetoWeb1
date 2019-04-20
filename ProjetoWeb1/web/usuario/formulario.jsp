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
        <h1>Cadastro de usuario</h1>
    </center>
    <div align="center">
        <c:if test="${usuario == null}">
            <form action="insercao" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${usuario.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Senha: </th>
                <td>
                    <input type="text" name="senha" size="45"
                           value="<c:out value='${usuario.senha}' />"/>
                </td>
            </tr>
            <tr>
                <th>Tipo: </th>
                <td>
                    <input type="text" name="tipo" size="45"
                           value="<c:out value='${usuario.url}' />"/>
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

