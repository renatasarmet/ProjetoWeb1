<%-- 
    Document   : genericpage
    Created on : 25/04/2019, 13:36:25
    Author     : João
--%>

<%@tag description="Página genérica" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="head_include" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="title" fragment="true"%>


<%-- any content can be specified here e.g.: --%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><jsp:invoke fragment="title"/></title>
        <jsp:invoke fragment="head_include"/>
    </head>
    <body>
        <div id="header-gen">
            <ul>
                <li><a>Usuário</a></li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="promocao/cadastro">Cadastrar promoção</a></li>
                    <li><a href="site_venda_crud/cadastro">Cadastrar site de venda</a></li>
                    <li><a href="teatro_crud/cadastro">Cadastrar teatro</a></li>
                    <%--TODO: editar próprias infos --%>
                </sec:authorize>

                <sec:authorize access="hasRole('TEATRO')">
                    <li><a href="promocao/cadastro">Cadastrar Promoção</a></li>
                    <%--TODO: editar próprias infos --%>
                </sec:authorize>

                <sec:authorize access="hasRole('SITE')">
                    <li><a href="promocao/filtrar_url">Minhas promoções</a></li>
                    <%--TODO: editar próprias infos--%>
                </sec:authorize>
            </ul>
            <jsp:invoke fragment="header"/>
        </div>
        <div id="conteudo-gen">
            <jsp:doBody/>
        </div>
        <div id="footer-gen">
            <jsp:invoke fragment="footer"/>
        </div>
    </body>
</html>