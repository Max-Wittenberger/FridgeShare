<%-- 
    Copyright © 2018 Dennis Schulmeister-Zimolong

    E-Mail: dhbw@windows3.de
    Webseite: https://www.wpvs.de/

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>
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

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/logout/"/>">Einloggen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
   <%--     <div class="container">
            <form method="post" class="stacked">
                <div class="column">
                    <%-- CSRF-Token 
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <%-- Eingabefelder 
                    <label for="signup_username">
                        Benutzername:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="signup_username" value="${signup_form.values["signup_username"][0]}">
                    </div>

                    <label for="signup_password1">
                        Passwort:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="signup_password1" value="${signup_form.values["signup_password1"][0]}">
                    </div>

                    <label for="signup_password2">
                        Passwort (wdh.):
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="signup_password2" value="${signup_form.values["signup_password2"][0]}">
                    </div>

         
                </div>

                <%-- Fehlermeldungen 
                <c:if test="${!empty signup_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${signup_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </form>
        </div> --%>
                
 <div class="login-container">
    <div class="login-form">
                    <h1> FridgeShare </h1>
                    <hr>
                    <h3>Registrieren</h3>
                    <form>
                         <input type="hidden" name="csrf_token" value="${csrf_token}">
                     <div class="form-group">
                         <input class="form-control" type="text" name="signup_username" value="${signup_form.values["signup_username"][0]}" placeholder="Benutzername">
                        </div>    
                        <div class="form-group">
                           <input class="form-control" type="password" name="signup_password1" value="${signup_form.values["signup_password1"][0]}" placeholder="Your Password (wdh.)*" >
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" name="signup_password2" value="${signup_form.values["signup_password2"][0]}" placeholder="Your Password *">
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
           <c:if test="${!empty signup_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${signup_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
    </jsp:attribute>
</template:base>