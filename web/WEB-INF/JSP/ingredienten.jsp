<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Frituur Frida"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Ingrediënten</h1>
<form>
    <label>Ingredient : <span>${fouten}</span>
        <input type="search" name="ingredient" value="${param.ingredient}"></label>
    <input type="submit" value="Zoek tussen de sauzen">
</form>
<c:if test="${not empty sauzenMetIngredient}">
    <h2>Sauzen die <b>${param.ingredient}</b> bevatten :</h2>
    <ul>
        <c:forEach var="saus" items="${sauzenMetIngredient}">
            <li><c:out value="${saus.naam}"/></li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty sauzenMetIngredient and empty fouten}">
    Geen saus gevonden.
</c:if>
</body>
</html>