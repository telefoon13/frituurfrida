<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<fmt:message key="themaKiezen" var="titel"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="${titel}"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>

<h1><fmt:message key="themaKiezen"/></h1>
<form method="post" name="themaForm" id="themaForm">
    <label><fmt:message key="standaardThema"/>
        <input type="radio" name="themaKnop" value="" checked></label>
    <label><fmt:message key="roze"/>
        <input type="radio" name="themaKnop" value="roze"></label>
    <label><fmt:message key="rood"/>
        <input type="radio" name="themaKnop" value="rood"></label>
    <label><fmt:message key="blauw"/>
        <input type="radio" name="themaKnop" value="blauw"></label>
    <label><fmt:message key="zwart"/>
        <input type="radio" name="themaKnop" value="zwart"></label>

    <input type="submit" name="kiesThemaKnop" id="kiesThemaKnop" value="<fmt:message key='themaKiezen'/>" >
</form>

<script language="JavaScript">
    document.getElementsById(themaForm).onSubmit = function () {
        document.getElementsById(kiesThemaKnop).disabled = true;
    }
</script>


</body>
</html>