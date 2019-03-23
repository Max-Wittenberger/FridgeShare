<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="head">
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/signup/"/>">Registrieren</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">

 <form action="j_security_check" method="post" class="stacked">
           
<%-- Eingabefelder --%>
                        Benutzername:
                        <span class="required">*</span>
                       
                        <input type="text" name="j_username">
  
                        Passwort:
                        <span class="required">*</span>
                   
                        <input type="password" name="j_password">
  
                        <%-- Button zum Abschicken --%>
                     <button class="icon-login" type="submit">
                        Einloggen
                    </button>

    </jsp:attribute>
</template:base>