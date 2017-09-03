<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Frituur Frida - Zoek de friet"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1><fmt:message key="zoekDeFriet"/></h1>
<form method="post" id="zoekdefrietForm">
    <c:forEach begin="1" end="${AANTAL_DEUREN}" varStatus="nummer">
        <button name="volgnummer" value="${nummer.index}">
            <c:choose>
                <c:when test="${(gevonden eq nummer.index) and geduwdeDeuren.toString().contains(nummer.index.toString())}">
                    <img src="<c:url value="/images/gevonden.png"/>" alt="Gevonden !">
                </c:when>
                <c:when test='${geduwdeDeuren.toString().contains(nummer.index.toString())}'>
                    <img src="<c:url value="/images/deuropen.png"/>" alt="Open">
                </c:when>
                <c:otherwise>
                    <img src="<c:url value="/images/deurtoe.png"/>" alt="Gesloten">
                </c:otherwise>

            </c:choose>
        </button>
    </c:forEach>
    <input type="submit" value="<fmt:message key="nieuwSpel"/>" id="nieuwSpel" name="nieuwSpel">
</form>


</body>
</html>