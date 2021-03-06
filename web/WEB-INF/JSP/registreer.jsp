<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key="registreer" var="titel"/>

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
<label><fmt:message key="gebruikersnaam"/>
    <input name="gebruikersnaam" value="${param.gebruikersnaam}" required autofocus>
    <span>${fouten.gebruikersnaam}</span></label>

<label><fmt:message key="email"/>
    <input name="email" value="${param.email}" required>
    <span>${fouten.email}</span></label>

<label><fmt:message key="wachtwoord"/>
    <input name="password" type="password" required minlength="8">
    <span>${fouten.pass}</span></label>

<label><fmt:message key="wachtwoordHerhaal"/>
    <input name="password2" type="password" required minlength="8"></label>

    <input type="submit" name="signupKnop" value="${titel}" id="signupKnop">
</form>
</body>
</html>