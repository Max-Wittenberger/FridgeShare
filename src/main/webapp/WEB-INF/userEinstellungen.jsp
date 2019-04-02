<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="head">
         <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
         <link rel="stylesheet" href="<c:url value="/css/form.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
      <form method="post" class="stacked">
      <div class="headstyle">
        <title> FridgeShare </title>
    </div>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">Profil bearbeiten</h5>

                        <form class="form-signin">
                        <input type="hidden" name="csrf_token" value="${csrf_token}">
                        <div class="form-label-group">
                             <input class="form-control" id="signup_username" type="text" name="signup_username" value="${user.username}" placeholder="Benutzername *" readonly>
                        </div>
                        <div class="form-label-group">
                             <input class="form-control" type="email" name="email" value="${user.email}" placeholder="E-mail *">
                        </div>
                        <div class="form-label-group">
                             <input class="form-control colorchoose" type="color" name="color" value="${user.color}" placeholder="Deine persönliche Farbe">
                        </div>
                        <%--
                        <div class="form-group">
                             <input class="" type="text" name="old_passwort" placeholder="Altes Passwort *" required>
                        </div>
                        <div class="form-group">
                             <input class="" type="text" name="new_passwort1" placeholder="Neues Passwort *" required>
                        </div>
                        <div class="form-group">
                             <input class="" type="text" name="new_passwort2" placeholder="Neues Passwort (wdh.) *" required>
                        </div>
                        --%>
                        <div class="form-label-group">
                            <input class="form-control" id="gruppe" type="text" name="gruppe" placeholder="Gruppe">
                            <label for="gruppe" onclick="document.getElementById('gruppe').focus();">Gruppe</label>
                        </div> 
                        <select>
                            <c:forEach items="${gruppen}" var="gruppe">
                                <option value="${gruppe}">${gruppe}</option>
                            </c:forEach>
                        </select>
                        <div class="form-label-group">
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="action" value="speichern">
                               Speichern
                            </button><button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="action" value="gruppe_hinzu">
                               Hinzufügen
                            </button>
                            <button class="btn btn-lg btn-warning btn-block text-uppercase" type="submit" name="action" value="gruppe_entfernen">
                               Gruppe löschen
                            </button>
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

        </form>
    </jsp:attribute>
</template:base>