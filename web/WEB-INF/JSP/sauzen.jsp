<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Frituur Frida - Sauzen"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1><fmt:message key="sauzen"/></h1>
<form method="post" action="/sauzen/verwijderen.htm" name="verwijderForm">

    <c:forEach var="saus" items="${sauzen}">
        <h2><label>
            <input type="checkbox" name="id" value="${saus.nummer}">${saus.naam}
        </label></h2>
        <img src="../../images/${saus.naam}.png" alt="${saus.naam}">
        <b><fmt:message key="ingredienten"/> :</b>
        <c:forEach var="ingredient" items="${saus.ingredienten}" varStatus="status">
            ${ingredient}
            <c:if test="${not status.last}">
                ,
            </c:if>
        </c:forEach>
    </c:forEach>
    <div><input type="submit" name="verwijderKnop" id="verwijderKnop" value="<fmt:message key="verwijderSaus"/>."></div>
</form>


</body>
</html>
