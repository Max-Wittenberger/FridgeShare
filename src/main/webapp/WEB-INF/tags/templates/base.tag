<%-- 
    Copyright © 2018 Dennis Schulmeister-Zimolong

    E-Mail: dhbw@windows3.de
    Webseite: https://www.wpvs.de/

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>
<%@tag pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@attribute name="title"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="menu" fragment="true"%>
<%@attribute name="content" fragment="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- https://pixabay.com/de/flach-design-symbol-icon-www-2126884/ -->
        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

        <link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <jsp:invoke fragment="head"/>
    </head>
    
    <header>
                    <%-- Menü --%>
                <c:if test="${not empty pageContext.request.userPrincipal}">

                    <%--<div class="topnav">--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
        <div class="container">
            <a class="navbar-brand" href="<c:url value="/app/kuehlschrank"/>">FRIDGESHARE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/app/kuehlschrank"/>">Kühlschrank</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/app/einkaufsliste"/>">Einkaufswagen</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/app/new/"/>">Produkt anlegen</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/app/user"/>">Profileinstellungen</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout/"/>">Logout ${pageContext.request.userPrincipal.name}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
                    
     </c:if>
        
        </header>
            <body>          
             <%-- Hauptinhalt der Seite --%>
             <main>    
            <jsp:invoke fragment="content"/>
             </main>
            </body>
</html>