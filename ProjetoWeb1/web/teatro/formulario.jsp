<%-- 
    Document   : formulario teatro
    Created on : 15/04/2019, 09:20:58
    Author     : João
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags"%>

<f:formulario model="${teatro}" model_id="${teatro.id}" model_null="${teatro == null}">

    <jsp:attribute name="head_title_form">
        <fmt:bundle basename="i18n.mensagem">
            <c:if test="${teatro != null}">
                <fmt:message key="edicao_de_teatro"/> |
            </c:if>
            <c:if test="${teatro == null}">
                <fmt:message key="cadastro_de_teatro"/> |
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:attribute name="head_include_form">
        <script type="text/javascript" src="../js/form_teatro.js"></script>
    </jsp:attribute>

    <jsp:attribute name="titulo_form">
        <fmt:bundle basename="i18n.mensagem">
            <c:if test="${teatro != null}">
                <h1><fmt:message key="edicao_de_teatro"/></h1>
            </c:if>
            <c:if test="${teatro == null}">
                <h1><fmt:message key="cadastro_de_teatro"/></h1>
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <table border="1" cellpadding="5">
                <tr>
                    <th><fmt:message key="email"/></th>
                    <td>
                        <input type="text" name="email" size="45" id="emailTeatro"
                               value="<c:out value='${teatro.email}' />"/>
                    </td>
                </tr>
                <c:if test="${teatro != null}">
                    <tr>
                        <th>Senha antiga</th>
                        <td>
                            <input  type="hidden" name="senhaEncode" size="45" id="senhaEncode" value="<c:out value='${teatro.senha}' />" />
                            <input type="password" name="senhaAntigaTeatro" size="45" id="senhaAntigaTeatro"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <th><fmt:message key="senha"/></th>
                    <td>
                        <input type="password" name="senha1Teatro" size="45" id="senha1Teatro"/>
                    </td>
                </tr>
                <tr>
                    <th><fmt:message key="confirma_senha"/></th>
                    <td>
                        <input type="password" name="senha2Teatro" size="45" id="senha2Teatro"/>
                    </td>
                </tr>
                <c:if test="${teatro == null}">
                    <tr>
                        <th><fmt:message key="cnpj"/></th>
                        <td>
                            <input type="text" name="CNPJ" size="45" id="cnpjTeatro"
                                   value="<c:out value='${teatro.CNPJ}' />" 
                                   />
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <th><fmt:message key="nome"/></th>
                    <td>
                        <input type="text" name="nome" size="45" id="nomeTeatro"
                               value="<c:out value='${teatro.nome}'/>"
                               />
                    </td>
                </tr>
                <tr>
                    <th><fmt:message key="cidade"/></th>
                    <td>
                        <input type="text" name="cidade" size="45" id="cidadeTeatro"
                               value="<c:out value='${teatro.cidade}'/>"
                               />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value=<fmt:message key="salvar"/> id="submitTeatro"
                               />
                    </td>
                </tr>
            </table>
        </fmt:bundle>
    </jsp:body>
</f:formulario>