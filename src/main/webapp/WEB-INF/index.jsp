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
    <jsp:attribute name="title">Übersicht</jsp:attribute>
        
    <jsp:attribute name="main">
        <h1>FrigeShare</h1>
        
        <div class="margin-bottom">
            <a href="<c:url value="/new/"/>">Neues Produkt anlegen</a>
        </div>
        
        <c:choose>
            <c:when test="${!empty alleProdukte}">
                <%-- Liste aller Schnippsel --%>
                <table>
                    <c:forEach items="${alleProdukte}" var="produkt">
                        <tr>
                            <td class="waste_name">
                                <%-- Name des Schnippsels, mit Link --%>
                               <c:out value="${produkt.name}"/>
                            </td>
                            <td>
                                <c:out value="${produkt.type.label}"/>
                            </td>
                            <td>
                                <c:out value="${produkt.menge}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <%-- Hinweis, dass es noch keine Produkte gibt --%>
                <div class="message">
                    Es sind noch keine Produkte vorhanden. <br/>
                    Am besten lege gleich einen an.
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:attribute>
</template:base>