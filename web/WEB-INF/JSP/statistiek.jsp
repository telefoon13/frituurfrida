<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>

<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Frituur Frida - Statistiek"/>
</head>
<body  class="${cookie.thema.value}">
<vdab:taalkeuze/>
<vdab:menu/>


<h1><fmt:message key="statistiek"/></h1>
<c:if test="${not empty statistiek}">
    <table>
        <thead>
            <tr>
                <th>URL</th>
                <th><fmt:message key="aantalBezoekers"/></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="entry" items="${statistiek}">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


</body>
</html>