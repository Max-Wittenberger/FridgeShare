

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="head">
         <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>


    <jsp:attribute name="content">
 <form action="j_security_check" method="post">
 <div class="login-container"> 
            <div class="login-form">
                <form>
                    <h1> FridgeShare </h1>
                    <hr>
                    <h3> Login </h3>
                    <form>
                        <div class="form-group">
                            <input class="" type="text" name="j_username" placeholder=" E-Mail-Adresse *">
                        </div>
                        <div class="form-group">
                            <input class="" type="password" name="j_password" placeholder="Dein Passwort *">
                        </div>
                        <div class="form-group">
                            <button class="btnSubmit" type="submit">
                                Einloggen
                            </button>
                        </div>
                        <div class="form-group">
                            <a href="<c:url value="/signup/"/>">Registrieren</a>
                        </div>
                    </form>
                </div>
    </div> 
 </form>
    </jsp:attribute>
</template:base>