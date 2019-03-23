
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Übersicht des Kühlschranks
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/ahja.css"/>" />
    </jsp:attribute>
        
    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/new"/>">Produkt anlegen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
        <c:choose>
            <c:when test="${empty alleProdukte}">
                <p>
                    Es wurden keine Produkte gefunden 🙈
                </p>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="utils" class="dhbwka.wwi.vertsys.javaee.fridgeshare.common.web.WebUtils"/>

                <%--  geht über die Liste und gibt alle Produkte aus --%>
                <c:forEach items="${alleProdukte}" var="produkt">
                        <tr>
                            <td class="">
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
                        <br>
                    </c:forEach>
            </c:otherwise>
        </c:choose>
                        </div>
    </jsp:attribute>
</template:base>