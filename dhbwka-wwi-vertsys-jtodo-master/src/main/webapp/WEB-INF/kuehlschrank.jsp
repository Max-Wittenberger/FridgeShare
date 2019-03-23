
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Übersicht des ...
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/new"/>">Produkt anlegen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <c:choose>
            <c:when test="${empty alleProdukte}">
                <p>
                    Es wurden keine Produkte gefunden 🙈
                </p>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="utils" class="dhbwka.wwi.vertsys.javaee.jtodo.common.web.WebUtils"/>

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
                    </c:forEach>
            </c:otherwise>
        </c:choose>
    </jsp:attribute>
</template:base>