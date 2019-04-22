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
        <jsp:include page="/helpers/common_head_include.jsp"></jsp:include>
        <script type="text/javascript" src="../js/form_teatro.js"></script>
        </head>
        <body>
        <center>
            <h1>Cadastro de Teatro</h1>
        <c:if test="${teatro != null}">
            <form action="atualizacao" onsubmit="return validaForm()">
            </c:if>
            <c:if test="${teatro == null}">
                <form action="insercao" onsubmit="return validaForm()">
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
                            <input type="text" name="email" size="45" id="emailTeatro"
                                   value="<c:out value='${teatro.email}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="password" name="senha" size="45" id="senhaTeatro"
                                   value="<c:out value='${teatro.senha}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>CNPJ: </th>
                        <td>
                            <input type="text" name="CNPJ" size="45" id="cnpjTeatro"
                                   value="<c:out value='${teatro.CNPJ}' />" 
                                    />
                        </td>
                    </tr>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45" id="nomeTeatro"
                                   value="<c:out value='${teatro.nome}'/>"
                                    />
                        </td>
                    </tr>
                    <tr>
                        <th>Cidade: </th>
                        <td>
                            <input type="text" name="cidade" size="45" id="cidadeTeatro"
                                   value="<c:out value='${teatro.cidade}'/>"
                                    />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salva" id="submitTeatro"
                                   />
                        </td>
                    </tr>
                </table>
            </form>
    </center>
</body>
</html>