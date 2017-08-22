<jsp:useBean id="adres" scope="request" type="be.vdab.enteties.Adres"/>
<jsp:useBean id="openGesloten" scope="request" type="be.vdab.enteties.OpenGesloten"/>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
<h2>Vandaag zijn we </h2>
<img src="../../images/${openGesloten}.png" alt="${openGesloten}">
<br>
<h3>Adres</h3>
${adres.straat} ${adres.huisNr}<br>
${adres.gemeente.postCode} ${adres.gemeente.naam}
<footer style="text-align: center">
Helpdesk : ${helpDeskTelefoon}
</footer>
</body>
</html>
