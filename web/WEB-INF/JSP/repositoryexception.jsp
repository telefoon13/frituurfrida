<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setBundle basename="teksten"/>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi - 500"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1><fmt:message key="dataFout"/> (500)</h1>
<img src="../../images/datafout.jpg" alt="Data fout">
<p><fmt:message key="erIsEenDataFou"/></p>
<div><fmt:message key="helpDesk"/> : ${helpDeskTelefoon}</div>
</body>
</html>