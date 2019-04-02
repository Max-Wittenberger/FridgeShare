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
        <%--     <div class="login-container"> 
<div class="login-form">--%>
        <div class="headstyle">
             <title> FridgeShare </title>
                <h1> FRIDGESHARE </h1>
        </div>
        <body>
            <div class="container">
                <div class="row">
                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center">Registrieren</h5>
                                
                        <input type="hidden" name="csrf_token" value="${csrf_token}">
                        <form class="stacked" method="post">
                            <div class="form-label-group">
                                <input class="form-control" id="signup_username" type="text" name="signup_username" value="" placeholder="Benutzername *">
                                <label for="signup_username" onclick="document.getElementById('signup_username').focus();">Benutzername</label>
                            </div>
                            
                            <div class="form-label-group">
                                <input class="form-control" id="email" type="email" name="email" value="" placeholder="E-mail *">
                                <label for="email" onclick="document.getElementById('email').focus();">E-Mail</label>
                            </div>
                            
                            <div class="form-label-group">
                             <input class="form-control colorchoose" type="color" name="color" value="" placeholder="Deine persönliche Farbe" style="">
                            </div>
                            
                        <div class="form-label-group">
                             <input class="form-control" id="signup_password1" type="password" name="signup_password1" value="" placeholder="Passwort *" >
                             <label for="signup_password1" onclick="document.getElementById('signup_password1').focus();">Passwort</label>
                        </div>
                        <div class="form-label-group">
                             <input class="form-control" id="signup_password2" type="password" name="signup_password2" value="" placeholder="Passwort (wdh.) *">
                             <label for="signup_password2" onclick="document.getElementById('signup_password2').focus();">Passwort (wdh.)</label>
                        </div>
                        <div class="form-label-group">
                             <input class="form-control" id="gruppe" type="text" name="gruppe" placeholder="Deine Gruppe" required>
                             <label for="gruppe" onclick="document.getElementById('gruppe').focus();">Gruppe</label>
                        </div>
                        <div class="form-label-group">
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrieren</button>
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