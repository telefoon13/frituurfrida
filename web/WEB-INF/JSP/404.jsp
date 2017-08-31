<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setBundle basename="teksten"/>
<!DOCTYPE html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Frituur Frida - 404"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1><fmt:message key="404"/> (404)</h1>

<iframe src="https://notfound-static.fwebservices.be/404/index.html?&amp;key=a6969001bec15c051d0ab31f6b7934cc" width="50%" height="650" frameborder="0"></iframe>

</body>
</html>