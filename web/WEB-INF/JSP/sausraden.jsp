<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!-- Geen vertaling aangezien de sauzen DB in het nederlands is -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Saus Raden"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1>Saus raden</h1>
<p><fmt:message key="sausRaden"/></p>
<c:choose>
    <c:when test="${sausRaden.verloren}">
        U bent verloren. De saus was : <c:out value="${sausRaden.saus}"/>
    </c:when>
    <c:when test="${sausRaden.gewonnen}">
        U bent gewonnen. De saus was : <c:out value="${sausRaden.saus}"/>
    </c:when>
    <c:otherwise>
        Te raden saus : <c:out value="${sausRaden.sausMetPuntje}"/>
        <form method="post" id="sausradenForm">
            <label>Letter : <input name="letter" size="1" maxlength="1" minlength="1" autofocus required></label>
            <input type="submit" value="Raden !" id="sausradenKnop">
        </form>
    </c:otherwise>
</c:choose>

<script language="JavaScript">
    document.getElementsById(sausradenForm).onSubmit = function () {
        document.getElementsById(sausradenKnop).disabled = true;
    }
</script>

<c:url value="" var="nieuwSpelURL">
    <c:param name="nieuwSpel" value="true"/>
</c:url>
<form method="post" action="${nieuwSpelURL}">
    <input type="submit" value="Nieuw Spel">
</form>

<img src="<c:url value="/images/${sausRaden.verkeerdeBeurten}.png" />" alt="${sausRaden.verkeerdeBeurten} verkeerde beurten">


</body>
</html>