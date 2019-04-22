<%-- 
    Document   : formulario
    Created on : 15/04/2019, 09:20:58
    Author     : João
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teatro</title>
    </head>
    <body>
    <center>
        <h1>Cadastro de Teatro</h1>
        <c:if test="${teatro != null}">
            <form action="atualizacao">
                <input type="hidden" name="id" value="<c:out value='${teatro.id}' />" />
            </c:if>
            <c:if test="${teatro == null}">
                <form action="insercao">
                </c:if>
                <table border="1" cellpadding="5">
                    <h2>
                        <c:if test="${teatro != null}">
                            Edição
                        </c:if>
                        <c:if test="${teatro == null}">
                            Cadastro
                        </c:if>
                    </h2>
                    <tr>
                        <th>E-mail: </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${teatro.email}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="password" name="senha" size="45"
                                   value="<c:out value='${teatro.senha}' />" />
                        </td>
                    </tr>
                    <c:if test="${teatro == null}">
                        <tr>
                            <th>CNPJ: </th>
                            <td>
                                <input type="text" name="CNPJ" size="45"
                                       value="<c:out value='${teatro.CNPJ}' />" 
                                       required />
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45"
                                   value="<c:out value='${teatro.nome}'/>"
                                   required />
                        </td>
                    </tr>
                    <tr>
                        <th>Cidade: </th>
                        <td>
                            <input type="text" name="cidade" size="45"
                                   value="<c:out value='${teatro.cidade}'/>"
                                   required />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salva" />
                        </td>
                    </tr>
                </table>
            </form>
    </center>
</body>
</html>
