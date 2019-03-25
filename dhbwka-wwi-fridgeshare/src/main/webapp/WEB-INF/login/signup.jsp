<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="base_url" value="<%=request.getContextPath()%>" />

<template:base>
    <jsp:attribute name="title">
        Registrierung
    </jsp:attribute>

    <jsp:attribute name="head">
         <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
   
            <form method="post" class="stacked">
      <div class="login-container"> 
            <div class="login-form">
                    <h1> FridgeShare </h1>
                    <hr>
                    <h3> Registrieren </h3>
                       <form>
                        <input type="hidden" name="csrf_token" value="${csrf_token}">
                        <div class="form-group">
                             <input class="" type="text" name="signup_username" value="${signup_form.values["signup_username"][0]}" placeholder="Benutzername *">
                        </div>
                        <div class="form-group">
                             <input class="" type="email" name="email" value="${signup_form.email}" placeholder="E-mail *">
                        </div>
                        <div class="form-group">
                             <input class="" type="color" name="color" value="${signup_form.color}" placeholder="Deine persönliche Farbe">
                        </div>
                        <div class="form-group">
                             <input class="" type="password" name="signup_password1" value="${signup_form.values["signup_password1"][0]}" placeholder="Passwort *" >
                        </div>
                        <div class="form-group">
                             <input class="" type="password" name="signup_password2" value="${signup_form.values["signup_password2"][0]}" placeholder="Passwort (wdh.) *">
                        </div>
                        <div class="form-group">
                            <button class="btnSubmit" type="submit">
                               Registrieren
                            </button>
                        </div>
                        <div class="form-group">
                            <a href="<c:url value="/logout/"/>">Anmelden</a>
                        </div>
                       </form>
                </div>
             </div> 
                        
                    
                <%-- Fehlermeldungen --%>
                <c:if test="${!empty signup_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${signup_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </form>
     
    </jsp:attribute>
</template:base>