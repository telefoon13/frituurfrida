<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Frituur Frida"/>
    </c:import>
    <style>
        td:last-child{
            text-align: right;
        }
    </style>
</head>
<body  class="${cookie.thema.value}">
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Statistieken</h1>
<c:if test="${not empty statistiek}">
    <table>
        <thead>
            <tr>
                <th>URL</th>
                <th>Aantal bezoekers</th>
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