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
                <input type="hidden" name="owner" value="${pageContext.request.userPrincipal.name}" readonly="readonly"> 
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
                           <input type="checkbox" name="meine" class="onoffswitch-checkbox" id="myonoffswitch" 
                                  <c:if test="${produkt.owner != pageContext.request.userPrincipal.name}">
                                      checked
                                  </c:if>
                                  >
                            <label class="onoffswitch-label" for="myonoffswitch">
                                 <div class="onoffswitch-inner"></div>
                                 <div class="onoffswitch-switch"></div>
                            </label>
                        </div>
                              </div>
                        <div class="form-group">
                            <input name="name" value="${produkt.name}" placeholder="Produktname" required>
                        </div>
                        <div class="form-group">
                           <select name="type">
                            <c:forEach items="${produktKategorie}" var="produktKategorie">
                                <option value="${produktKategorie}" ${produkt.type.label == produktKategorie ? 'selected' : ''}>${produktKategorie.label}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input name="menge" type="number" value="${produkt.menge}" min="1" placeholder="Menge" required>
                        </div>
                        <div class="form-group">
                            <select name="mass">
                            <c:forEach items="${produktMaßeinheit}" var="produktMaßeinheit">
                                <option value="${produktMaßeinheit}" ${produkt.maß == produktMaßeinheit ? 'selected' : ''}>${produktMaßeinheit.label}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                        <select name="ort">
                            <option value="E" ${produkt.ort == "E" ? 'selected' : ''}> Einkaufsliste</option>
                            <option value="K" ${produkt.ort == "K" ? 'selected' : ''}> Kühlschrank</option>
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