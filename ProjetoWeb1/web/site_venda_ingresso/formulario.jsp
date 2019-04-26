<%-- 
    Document   : formulario
    Created on : Apr 15, 2019, 12:10:53 AM
    Author     : Leonardo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="f" tagdir="/WEB-INF/tags"%>

<f:formulario model="${site}" model_id="${site.id}" model_null="${site == null}">

    <jsp:attribute name="head_title_form">
        <fmt:bundle basename="i18n.mensagem">
            <fmt:message key="site_de_promocoes"/>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:attribute name="head_include_form">
        <script type="text/javascript" src="../js/form_site.js"></script>
    </jsp:attribute>

    <jsp:attribute name="titulo_form">
        <fmt:bundle basename="i18n.mensagem">
            <c:if test="${site != null}">
                <fmt:message key="edicao_site_venda_ingresso"/>
            </c:if>
            <c:if test="${site == null}">
                <fmt:message key="cadastro_site_venda_ingresso"/>
            </c:if>
        </fmt:bundle>
    </jsp:attribute>

    <jsp:body>
        <fmt:bundle basename="i18n.mensagem">
            <table border="1" cellpadding="5">
            <tr>
                <th><fmt:message key="email"/></th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${site.email}' />"/>
                </td>
            </tr>
            <c:if test="${site != null}">
                    <tr>
                        <th>Senha antiga</th>
                        <td>
                            <input  type="hidden" name="senhaEncode" size="45" id="senhaEncode" value="<c:out value='${site.senha}' />" />
                            <input type="password" name="senhaAntigaSite" size="45" id="senhaAntigaSite"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <th>Senha Nova</th>
                    <td>
                        <input type="password" name="senha1Site" size="45" id="senha1Site"/>
                    </td>
                </tr>
                <tr>
                    <th>Senha confirma</th>
                    <td>
                        <input type="password" name="senha2Site" size="45" id="senha2Site"/>
                    </td>
                </tr>
            <tr>
                <th><fmt:message key="url"/></th>
                <td>
                    <input type="text" name="url" size="45"
                           value="<c:out value='${site.url}' />"/>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="nome"/></th>
                <td>
                    <input type="text" name="nome" size="45"
                           value="<c:out value='${site.nome}' />"/>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="telefone"/></th>
                <td>
                    <input type="text" name="telefone" size="45"
                           value="<c:out value='${site.telefone}' />"
                           />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value=<fmt:message key="salvar"/> />
                </td>
            </tr>
        </table>
        </fmt:bundle>
    </jsp:body>
</f:formulario>
