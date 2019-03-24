
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Übersicht Kühlschrank
    </jsp:attribute>

            <jsp:attribute name="head">
         <link rel="stylesheet" href="<c:url value="/css/kuehlschrank.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
        <c:choose>
            <c:when test="${empty alleProdukte}">
                <p>
                    Es wurden keine Produkte gefunden
                </p>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="utils" class="dhbwka.wwi.fridgeshare.common.web.WebUtils"/>

                <%--  geht über die Liste und gibt alle Produkte aus --%>
                <c:forEach items="${alleProdukte}" var="produkt">
                         <div class="row">
                            <div class="col-2 " style="color:#000000">
                                <c:out value="${produkt.name}"/>
                            </div>
                            <div class="col-2">
                                <c:out value="${produkt.type.label}"/>
                            </div>
                             <div class="col-2">
                               <c:out value="${produkt.menge}"/>
                            </div>
                            
                            <div class="col-1">
                            <button 
                                    <i class="fas fa-snowflake"></i>
                            </button>
                            </div>
                            <div class="col-1">
                            <button >
                                <i class="fas fa-trash-alt"></i>
                            </button>
                            </div>  
                            <div class="col-1">
                                <a href="">
                                    <button type="button" name="button">
                                        <i class="fas fa-cogs"></i>
                                    </button>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
            </c:otherwise>
        </c:choose>
                      
    </jsp:attribute>
</template:base>