<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key="ingredienten" var="titel"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="${titel}"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1><fmt:message key="ingredienten"/></h1>
<form>
    <label><fmt:message key="ingredient"/> : <span>${fouten}</span>
        <input type="search" name="ingredient" value="${param.ingredient}"></label>
    <input type="submit" value="<fmt:message key="zoekTussenDeSauzen"/>">
</form>
<c:if test="${not empty sauzenMetIngredient}">
    <h2><fmt:message key="sauzenDie"/> <b>${param.ingredient}</b> <fmt:message key="bevatten"/> :</h2>
    <ul>
        <c:forEach var="saus" items="${sauzenMetIngredient}">
            <li><c:out value="${saus.naam}"/></li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty sauzenMetIngredient and empty fouten}">
    <fmt:message key="geenSausGevonden"/>.
</c:if>


</body>
</html>