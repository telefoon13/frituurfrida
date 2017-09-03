<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>

<!doctype html>
<html lang="nl">
<<head>
    <vdab:head title="Frituur Frida - 500"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1><fmt:message key="dataFout"/> (500)</h1>
<img src="../../images/datafout.jpg" alt="Data fout">
<p><fmt:message key="erIsEenDataFou"/></p>
<div><fmt:message key="helpDesk"/> : ${helpDeskTelefoon}</div>


</body>
</html>