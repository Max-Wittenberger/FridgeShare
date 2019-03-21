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
    <jsp:attribute name="title">Anlegen</jsp:attribute>

    <jsp:attribute name="main">
        <h1> Produkt anlegen</h1>

        <form method="POST">
            <table class="margin-bottom">
                <tr>
                    <td class="label">
                        <label for="name">Name:</label>
                    </td>
                    <td>
                        <input name="name" value="${produkt_form.name}"
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="type">Kategorie:</label>
                    </td>
                    <td>
                        <select name="type">
                            <c:forEach items="${produktKategorie}" var="produktKategorie">
                                <option value="${produktKategorie}" ${produkt_form.type == wasteType ? 'selected' : ''}>${produktKategorie.label}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="menge">Menge:</label>
                    </td>
                    <td>
                        <input name="menge" type="number" value="${produkt_form.menge}" min="1">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <div class="space-between">
                            <button type="submit">✔️ Anlegen</button>
                            <a href="<c:url value="/index.html"/>">Abbrechen</a>
                        </div>
                    </td>
                </tr>
            </table>
        </form>

        <c:if test="${!empty produkt_form.errors}">
            <ul class="errors">
                <c:forEach items="${produkt_form.errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
    </jsp:attribute>
</template:base>