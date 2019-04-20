<%-- 
    Document   : formulario
    Created on : 15/04/2019, 09:58:05
    Author     : Renata
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Site de promoções</title>
    </head>
    <body>
    <center>
        <h1>Cadastro de promoções</h1>
    </center>
    <div align="center">
        <c:if test="${promocao == null}">
            <form action="insercao" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <tr>
                <th>Url: </th>
                <td>
                    <input type="text" name="url" size="45"
                           value="<c:out value='${promocao.url}' />"/>
                </td>
            </tr>
            <tr>
                <th>Cnpj </th>
                <td>
                    <input type="text" name="cnpj" size="45"
                           value="<c:out value='${promocao.cnpj}' />"/>
                </td>
            </tr>
            <tr>
                <th>Nome da peça: </th>
                <td>
                    <input type="text" name="nome" size="45"
                           value="<c:out value='${promocao.nome}' />"/>
                </td>
            </tr>
            <tr>
                <th>Preço: </th>
                <td>
                    <input type="text" name="nome" size="45"
                           value="<c:out value='${promocao.preco}' />"/>
                </td>
            </tr>
            <tr>
                <th>Data e horário: </th>
                <td>
                    <input type="date" name="data_sessao" size="45"
                           value="<c:out value='${promocao.data_sessao}' />"
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

