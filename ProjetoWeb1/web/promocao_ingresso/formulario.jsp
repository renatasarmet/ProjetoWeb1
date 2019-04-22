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
        <jsp:include page="/helpers/common_head_include.jsp"></jsp:include>
        <script type="text/javascript" src="../js/form_promocao.js"></script>
    </head>
    <body>
    <center>
        <h1>Cadastro/Edicao de promoções</h1>
    </center>
    <div align="center">
        <c:if test="${promocao == null}">
            <form action="insercao" method="post">
        </c:if>
        <c:if test="${promocao != null}">
            <form action="atualizacao" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <c:if test="${promocao != null}">
                <input type="hidden" name="id" value="<c:out value='${promocao.id}' />" />
            </c:if>
            <tr>
                <th>Url: </th>
                <td>
                    <input type="text" name="url" size="45" id="urlPromocao"
                           value="<c:out value='${promocao.url}' />"/>
                </td>
            </tr>
            <tr>
                <th>Cnpj </th>
                <td>
                    <input type="text" name="cnpj" size="45" id="cnpjPromocao"
                           value="<c:out value='${promocao.cnpj}' />"/>
                </td>
            </tr>
            <tr>
                <th>Nome da peça: </th>
                <td>
                    <input type="text" name="nome" size="45" id="nomePromocao"
                           value="<c:out value='${promocao.nome}' />"/>
                </td>
            </tr>
            <tr>
                <th>Preço: </th>
                <td>
                    <input type="text" name="preco" size="45" id="precoPromocao"
                           value="<c:out value='${promocao.preco}' />"/>
                </td>
            </tr>
            <tr>
                <th>Data: </th>
                <td>
                    <input type="text" name="data_sessao" size="45" id="dataPromocao"
                           value="<c:out value='${promocao.data_sessao}' />"
                           />
                </td>
            </tr>
            <tr>
                <th>Horário: </th>
                <td>
                    <input type="text" name="horario_sessao" size="45" id="horarioPromocao"
                           value="<c:out value='${promocao.horario_sessao}' />"
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

