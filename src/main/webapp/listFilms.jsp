<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Films</title>
</head>
<body>
    <h1>Liste des Films</h1>
    <c:if test="${not empty films}">
        <ul>
            <c:forEach var="film" items="${films}">
                <li>
                    <a href="filmDetails?id=${film.id}">${film.nom}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty films}">
        <p>Aucun film disponible.</p>
    </c:if>
</body>
</html>
