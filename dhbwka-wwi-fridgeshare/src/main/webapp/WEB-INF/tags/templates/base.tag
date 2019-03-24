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

        <title>Aufgabenliste: ${title}</title>
        
        <!-- https://pixabay.com/de/flach-design-symbol-icon-www-2126884/ -->
        <link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

        <link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

        <jsp:invoke fragment="head"/>
    </head>
    <header>
                    <%-- Menü --%>
                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <div>       
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