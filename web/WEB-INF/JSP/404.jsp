<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key="404" var="titel"/>

<!DOCTYPE html>
<html lang="nl">
<head>
    <vdab:head title="${titel}"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1><fmt:message key="404"/> (404)</h1>
<iframe src="https://notfound-static.fwebservices.be/404/index.html?&amp;key=a6969001bec15c051d0ab31f6b7934cc" width="50%" height="650" frameborder="0"></iframe>


</body>
</html>