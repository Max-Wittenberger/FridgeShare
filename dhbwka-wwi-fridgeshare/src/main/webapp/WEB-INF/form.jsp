<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        <c:choose>
            <c:when test="${edit}">
                Produkt bearbeiten
            </c:when>
            <c:otherwise>
                Produkt anlegen
            </c:otherwise>
        </c:choose>
    </jsp:attribute>

    <jsp:attribute name="head">
         <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
         <link rel="stylesheet" href="<c:url value="/css/form.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
        <form method="post" class="stacked">
            <div class="column">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <%-- Eingabefelder --%>
                <label for="produkt_owner">Eigentümer:</label>
                <div class="side-by-side">
                <%-- <input type="text" name="task_owner" value="${produkt_form.values["task_owner"][0]}" readonly="readonly"> --%>
                </div>

            
      <div class="login-container"> 
            <div class="login-form">
                        <%-- CSRF-Token --%>
                        <input type="hidden" name="csrf_token" value="${csrf_token}">
                <form>
                    <h1>
             <c:choose>
                 <c:when test="${edit}">
                    Produkt bearbeiten
                 </c:when>
                 <c:otherwise>
                    Produkt anlegen
                 </c:otherwise>
            </c:choose>
                    </h1>
                    <form>
                          <div  style="display: inline-block"> 
                       <div class="onoffswitch">
                            <input type="checkbox" name="fürmich" class="onoffswitch-checkbox" id="myonoffswitch" checked>
                            <label class="onoffswitch-label" for="myonoffswitch">
                                 <div class="onoffswitch-inner"></div>
                                 <div class="onoffswitch-switch"></div>
                            </label>
                        </div>
                              </div>
                        <div class="form-group">
                            <input name="name" value="${produkt_form.name}" placeholder="Produktname" required>
                        </div>
                        <div class="form-group">
                           <select name="type">
                            <c:forEach items="${produktKategorie}" var="produktKategorie">
                                <option selected="Sonstiges" value="${produktKategorie}" ${produkt_form.type == wasteType ? 'selected' : ''}>${produktKategorie.label}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input name="menge" type="number" value="${produkt_form.menge}" min="1" placeholder="Menge" required>
                        </div>
                        <div class="form-group">
                           <select name="maß">
                            <c:forEach items="${produktMaßeinheit}" var="produktMaßeinheit">
                                <option value="${produktMaßeinheit}" ${produkt_form.maß == wasteType ? 'selected' : ''}>${produktMaßeinheit.label}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                          <button class="icon-pencil" type="submit" name="action" value="save">
                        Sichern
                    </button>
                    <c:if test="${edit}">
                        <button class="icon-trash" type="submit" name="action" value="delete">
                            Löschen
                        </button>
                    </c:if>
                    </form>
                </div>
    </div> 
 </form>

            <%-- Fehlermeldungen --%>
            <c:if test="${!empty task_form.errors}">
                <ul class="errors">
                    <c:forEach items="${task_form.errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </form>
    </jsp:attribute>
</template:base>