<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Frituur Frida"/>
    </c:import>
</head>
<body  class="${cookie.thema.value}">
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Zoek de friet</h1>
<form method="post" id="zoekdefrietForm">
    <c:forEach begin="1" end="${AANTAL_DEUREN}" varStatus="nummer">
        <button name="volgnummer" value="${nummer.index}">
            <c:choose>
                <c:when test="${(gevonden eq nummer.index) and geduwdeDeuren.toString().contains(nummer.index.toString())}">
                    <img src="<c:url value="/images/gevonden.png"/>" alt="Gevonden !">
                </c:when>
                <c:when test='${geduwdeDeuren.toString().contains(nummer.index.toString())}'>
                    <img src="<c:url value="/images/deuropen.png"/>" alt="Open">
                </c:when>
                <c:otherwise>
                    <img src="<c:url value="/images/deurtoe.png"/>" alt="Gesloten">
                </c:otherwise>

            </c:choose>
        </button>
    </c:forEach>
    <input type="submit" value="Nieuw Spel" id="nieuwSpel" name="nieuwSpel">
</form>
</body>
</html>