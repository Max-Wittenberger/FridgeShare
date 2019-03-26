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
  
 <div class="login-container"> 
            <div class="login-form">
                <form>
                    <h1> FridgeShare </h1>
                    <hr>
                    <h3> HOPPLA </h3>
                    <form>
                        <div class="form-group">
                          Das hat leider nicht geklappt
                        </div>
                        <div class="form-group">
                           <a href="<c:url value="/logout/"/>">Nochmal Vesuchen</a>
                        </div>
                    </form>
                </div>
    </div> 
    </jsp:attribute>
</template:base>