<%-- 
    Document   : lista
    Created on : 20/04/2019, 00:38:58
    Author     : Renata
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site de promoções</title>
    </head>
    <center>
        <h1>Lista de Promoções</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Promoções</h2></caption>
            <form action="filtrar_url" method="post">
                <label>Filtre por uma url: </label>
                <input type="text" name="url_desejada" size="45" />
                <input type="submit" value="Pesquisar" />
            </form>
            <br>
            <form action="filtrar_cnpj" method="post">
                <label>Filtre por um cnpj </label>
                <input type="text" name="cnpj_desejado" size="45" />
                <input type="submit" value="Pesquisar" />
            </form>
            <tr>
                <th>ID</th>
                <th>Url</th>
                <th>Cnpj</th>
                <th>Nome</th>
                <th>Preco</th>
                <th>Data Sessao</th>
                <th colspan="2" >Opçoes</th>
            </tr>
            <c:forEach var="promo" items="${listaPromocao}">
                <tr>
                    <td><c:out value="${promo.id}" /></td>
                    <td><c:out value="${promo.url}" /></td>
                    <td><c:out value="${promo.cnpj}" /></td>
                    <td><c:out value="${promo.nome}" /></td>
                    <td><c:out value="${promo.preco}" /></td>
                    <td><c:out value="${promo.data_sessao}" /></td>
                    <td><a href="edicao?id=<c:out value='${promo.id}' />">Edição</a></td>
                    <td><a href="remocao?id=<c:out value='${promo.id}' />"onclick="return confirm('Deseja excluir esse item?');">Remoção</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</html>
