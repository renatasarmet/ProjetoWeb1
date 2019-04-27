<%-- 
    Document   : formulario
    Created on : 15/04/2019, 09:58:05
    Author     : Renata
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="f" tagdir="/WEB-INF/tags"%>


<f:formulario model="${promocao}" model_id="${promocao}" model_null="${promocao == null}">
    
    <jsp:attribute name="head_title_form">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="titulo_principal"/>
        </fmt:bundle>
    </jsp:attribute>
    
    <jsp:attribute name="head_include_form">
        <script type="text/javascript" src="../js/form_promocao.js"></script>
    </jsp:attribute>

    <jsp:attribute name="titulo_form">
        <fmt:bundle basename="i18n.mensagem">
            <c:if test="${promocao == null}">
                <h1><fmt:message key="cadastro_de_promocoes"/></h1>
            </c:if>
            <c:if test="${promocao != null}">
                <h1><fmt:message key="edicao_de_promocoes"/></h1>
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <table border="1" cellpadding="5">
                <tr>
                    <th><fmt:message key="url"/></th>
                    <td>
                        <select id="urlPromocao" name="url">
                            <c:forEach var="site" items="${listaSite}">   
                                <c:choose>
                                    <c:when test="${site.url == promocao.url}">
                                        <option selected value="<c:out value="${site.url}" />"><c:out value="${site.nome}"/> - <c:out value="${site.url}"/></option> 
                                    </c:when>
                                    <c:otherwise>
                                        <option value="<c:out value="${site.url}" />"><c:out value="${site.nome}"/> - <c:out value="${site.url}"/></option> 
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><fmt:message key="nome"/></th>
                    <td>
                        <input type="text" name="nome" size="45" id="nomePromocao"
                               value="<c:out value='${promocao.nome}' />"/>
                    </td>
                </tr>
                <tr>
                    <th><fmt:message key="preco"/></th>
                    <td>
                        <input type="text" name="preco" size="45" id="precoPromocao"
                               value="<c:out value='${promocao.preco}' />"/>
                    </td>
                </tr>
                <tr>
                    <th><fmt:message key="data_sessao"/></th>
                    <td>
                        <input type="text" name="data_sessao" size="45" id="dataPromocao"
                               value="<c:out value='${promocao.data_sessao}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th><fmt:message key="horario_sessao"/></th>
                    <td>
                        <input type="text" name="horario_sessao" size="45" id="horarioPromocao"
                               value="<c:out value='${promocao.horario_sessao}' />"
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
