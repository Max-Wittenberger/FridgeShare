

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
     <%--<div class="login-container"> 
<div class="login-form">--%>
                <%--<form>--%>
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
                            <h5 class="card-title text-center">Sign In</h5>

                            <form class="form-signin">
                                <div class="form-label-group">
                                    <input class="form-control" id="j_username" type="text" name="j_username" placeholder="Username*" required autofocus>
                                    <label for="j_username" onclick="document.getElementById('j_username').focus();">Username</label>
                                </div>
                                        
                                <div class="form-label-group"> <%--form-group zu form-label-group gemacht--%>
                                    <input class="form-control" id="j_password" type="password" name="j_password" placeholder="Passwort*" required>
                                    <label for="j_password" onclick="document.getElementById('j_password').focus();">Password</label>
                                </div>
                                            
                                <div class="custom-control custom-checkbox mb-3">
                                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">Remember Password</label>
                                </div>
                                            
                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign In</button>
                                <hr class="my-4">
                                <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>
                                <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>
                                        
                                <div class="registerlink">
                                <a href="<c:url value="/signup/"/>">Create Account</a>
                                </div>
                            </form>
                        </div>
                    </div> 
                </div>
            </div>
        </div>
    </body>
    </jsp:attribute>
</template:base>