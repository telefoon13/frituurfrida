<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key="gastenboek" var="titel"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="${titel}"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>
<h1>${titel}</h1>
<form method="post">

<c:choose>
    <c:when test="${user ne null}">
        <textarea name="bericht" autofocus rows="7" cols="60">Jouw bericht</textarea>
        <input type="hidden" value="${user.id}" name="posterid">
        <input type="submit" value="Bericht toevoegen" name="toevoegen">
    </c:when>
    <c:otherwise>
        <p>Als u een bericht wil plaatsen dient u eerst in te loggen.</p>
    </c:otherwise>
</c:choose>

<c:forEach var="gastenboekEntry" items="${gastenboek}">
    <div class="GB">
        <div class="naamEnDatum"><b>${gastenboekEntry.poster}</b> op ${gastenboekEntry.plaatstijd}
            <c:if test="${user.gebruikersnaam eq 'admin'}">
                <label><input type="checkbox" name="id" value="${gastenboekEntry.id}">Delete? </label>
            </c:if>
        </div>
        <div class="gbLEEG"></div>
    <div class="GBbericht">${gastenboekEntry.bericht}</div>
    </div>
</c:forEach>

<c:if test="${user.gebruikersnaam eq 'admin'}">
    <input type="submit" value="Verwijder geselecteerde berichten" name="delete">
</c:if>

</form>
</body>
</html>