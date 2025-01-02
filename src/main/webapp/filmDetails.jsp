<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails du Film</title>
</head>
<body>
    <h1>Détails du Film</h1>
    <c:if test="${not empty film}">
        <p>ID: ${film.id}</p>
        <p>Nom: ${film.nom}</p>
        <!-- Ajoutez d'autres champs du film ici -->
    </c:if>
    <c:if test="${empty film}">
        <p>Film non trouvé.</p>
    </c:if>
</body>
</html>
