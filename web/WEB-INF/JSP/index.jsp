<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key='frituurFrida' var="titel"/>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="${titel}"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>
<c:choose>
    <c:when test="${sessionScope.values().toString().contains('nl')}">
        <c:set value="" var="extra"/>
    </c:when>
    <c:when test="${sessionScope.values().toString().contains('en')}">
        <c:set value="_en" var="extra"/>
    </c:when>
    <c:when test="${sessionScope.values().toString().contains('fr')}">
        <c:set value="_fr" var="extra"/>
    </c:when>
    <c:otherwise>
        <c:set value="" var="extra"/>
    </c:otherwise>
</c:choose>


<h1><fmt:message key="frituurFrida"/></h1>
<h2><fmt:message key="vandaagZijnWe"/></h2>
<img src="../../images/${openGesloten}${extra}.png" alt="${openGesloten}">
<br>
<h3><fmt:message key="adres"/></h3>
${adres.straat} ${adres.huisNr}<br>
${adres.gemeente.postCode} ${adres.gemeente.naam}

<footer style="text-align: center">
<fmt:message key="helpDesk"/> : ${helpDeskTelefoon}
</footer>

${user.laatsteLogin}<br>
${user.laatsteIP}

</body>
</html>
