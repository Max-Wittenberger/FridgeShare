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
      <div class="login-container"> 
            <div class="login-form">
                    <h1> FridgeShare </h1>
                    <hr>
                    <h3> Registrieren </h3>
                       <form>
                        <input type="hidden" name="csrf_token" value="${csrf_token}">
                        <div class="form-group">
                             <input class="" type="text" name="signup_username" value="${user.username}" placeholder="Benutzername *" readonly>
                        </div>
                        <div class="form-group">
                             <input class="" type="email" name="email" value="${user.email}" placeholder="E-mail *">
                        </div>
                        <div class="form-group">
                             <input class="" type="color" name="color" value="${user.color}" placeholder="Deine persönliche Farbe">
                        </div>
                         
                            <c:forEach items="${gruppen}" var="gruppe">
                                <div>${gruppe} bin da</div>
                            </c:forEach>
                     
                        <div class="form-group">
                            <button class="btnSubmit" type="submit">
                               Speichern
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