<%@ page contentType='text/html;charset=UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jstl/fmt' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key="login" var="titel"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="${titel}"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1>${titel}</h1>
${user.gebruikersnaam}
<form method="post">
<label><fmt:message key="gebruikersnaam"/><input name="gebruikersnaam"></label>
<label><fmt:message key="wachtwoord"/><input type="password" name="password"></label>
<input type="submit" name="loginKnop" value="${titel}" id="loginKnop">
</form>
${test}

</body>
</html>