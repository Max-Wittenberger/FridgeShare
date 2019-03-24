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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <jsp:invoke fragment="head"/>
    </head>
    <header>
                    <%-- Menü --%>
                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <%--                  <div>       
    <nav class="navbar navbar-default">
        <div class="container-fluid" >
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li>FridgeShare  ${title}</li>
              <li><a href="<c:url value="/app/kuehlschrank"/>">Kühlschrank</a></li>
              <li><a href="<c:url value="/app/kuehlschrank"/>">Einkaufswagen</a></li>
              <li> <a href="<c:url value="/app/new"/>">Produkt anlegen</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="<c:url value="/logout/"/>">Logout ${pageContext.request.userPrincipal.name}</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
</div> --%>
    <div class="topnav">
  <a href="<c:url value="/app/kuehlschrank"/>">FridgeShare</a>
  <a href="<c:url value="/app/kuehlschrank"/>">Kühlschrank</a>
  <a href="<c:url value="/app/kuehlschrank"/>">Einkaufswagen</a>
  <a href="<c:url value="/app/new"/>">Produkt anlegen</a>
  <a href="<c:url value="/logout/"/>">Logout ${pageContext.request.userPrincipal.name}</a>
</div>
                    
 
     </c:if>
        
        </header>
    <body>          
       <%-- Hauptinhalt der Seite --%>
        <main>    
            <jsp:invoke fragment="content"/>
        </main>
    </body>
</html>