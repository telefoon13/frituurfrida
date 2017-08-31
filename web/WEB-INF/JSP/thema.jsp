<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setBundle basename="teksten"/>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Frituur Frida"/>
    </c:import>
</head>
<body class="${cookie.thema.value}">

<c:import url="/WEB-INF/JSP/menu.jsp"/>

<h1><fmt:message key="themaKiezen"/></h1>
<form method="post" name="themaForm">
    <input type="submit" name="themaKnop" value="<fmt:message key="standaardThema"/>">
    <input type="submit" name="themaKnop" value="roze">
    <input type="submit" name="themaKnop" value="rood">
    <input type="submit" name="themaKnop" value="blauw">
    <input type="submit" name="themaKnop" value="zwart" >
</form>
</body>
</html>