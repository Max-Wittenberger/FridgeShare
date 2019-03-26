
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="head">
         <link rel="stylesheet" href="<c:url value="/css/kuehlschrank.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
        <c:choose>
            <c:when test="${empty alleProdukte}">
                <p>
                    Es wurden keine Produkte gefunden.
                </p>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="utils" class="dhbwka.wwi.fridgeshare.common.web.WebUtils"/>

                <div class="gruppe"> <h1>Gruppe 1</h1>
                <%--  geht über die Liste und gibt alle Produkte aus für die jeweilige Kategorie --%>
              <c:forEach items="${ProduktKategorie}" var="kategorie">
                   <c:set var= "i" scope="session" value="0"></c:set> 
                <c:forEach items="${alleProdukte}" var="produkt">
                     <c:if test = "${produkt.type.label == kategorie.label}">
                         <c:if test = "${i == 0}">
                             <br>
                            <button class="collapsible"> <c:out value="${kategorie.label}"/> </button>
                            <c:set var= "i" scope="session" value="1"></c:set>
                         </c:if>
                            <div class="row content" style="background: ${user.color}">
                            <div class="col-2 ">
                                <c:out value="${produkt.name}"/>
                            </div>
                            <div class="col-2">
                                <c:out value="${produkt.type.label}"/>
                            </div>
                             <div class="col-2">
                               <c:out value="${produkt.menge}"/>
                            </div>
                            <div class="col-2">
                               <c:out value="${produkt.maß}"/>
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
                            <div class="col-2">
                                <a href="">
                                    <button type="button" name="button">
                                        <i class="fas fa-cogs"></i>
                                    </button>
                                </a>
                            </div>
                            </div>
                         </c:if>   
                    </c:forEach>
                        
                 </c:forEach> 
             </div>
              
              <div class="gruppe">Gruppe 2</div>
            </c:otherwise>
        </c:choose>
                      
    </jsp:attribute>
</template:base>