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

<template:base>
    <jsp:attribute name="title">
        Anmeldung nicht möglich
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
  
 <div class="headstyle"> 
    <title> FridgeShare </title>
    <h1>FRIDGESHARE</h1>
 </div>
        <body>
            <div class="container">
                <div class="row">
                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h1 class="card-title text-center">Log-in ERROR!</h1>
                        
                                <form class="form-signin">
                                     <div class="isa_error">
                                         <i class="fa fa-times-circle"></i>
                                         Wrong Username or Password!
                                     </div>
                                        <div class="form-label-group">
                                            <a href="<c:url value="/logout/"/>">Try again</a>
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