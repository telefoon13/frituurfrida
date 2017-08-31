<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<fmt:setBundle basename="teksten"/>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Frituur Frida"/>
    </c:import>
</head>
<body  class="${cookie.thema.value}">
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Frituur Frida</h1>

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
<h2><fmt:message key="vandaagZijnWe"/></h2>
<img src="../../images/${openGesloten}${extra}.png" alt="${openGesloten}">
<br>
<h3><fmt:message key="adres"/></h3>
${adres.straat} ${adres.huisNr}<br>
${adres.gemeente.postCode} ${adres.gemeente.naam}
<footer style="text-align: center">
<fmt:message key="helpDesk"/> : ${helpDeskTelefoon}
</footer>
</body>
</html>
