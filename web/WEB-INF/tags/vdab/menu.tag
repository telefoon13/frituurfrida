<%@tag description='menu' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setBundle basename="teksten"/>
<header>
    <nav>
        <ul>
            <li><a href="<c:url value="/"/>"><fmt:message key="welkom"/></a></li>
            <li><a href="<c:url value="/sauzen.htm"/>"><fmt:message key="sauzen"/></a></li>
            <li><a href="<c:url value="/ingredienten.htm"/>"><fmt:message key="ingredienten"/></a></li>
            <li><a href="<c:url value="/thema.htm"/>"><fmt:message key="themaKiezen"/></a></li>
            <li><a href="<c:url value="/zoekdefriet.htm"/>"><fmt:message key="zoekDeFriet"/></a></li>
            <li><a href="<c:url value="/sausraden.htm"/>">Saus raden</a></li>
            <li><a href="<c:url value="/statistiek.htm"/>"><fmt:message key="statistiek"/></a></li>
            <li><a href="<c:url value="/gastenboek.htm"/>"><fmt:message key="gastenboek"/></a></li>
            <c:choose>
            <c:when test="${user.gebruikersnaam ne null}">
                <li><a href="<c:url value="/login.htm?logout=logout"/>"><fmt:message key="logout"/></a></li>
            </c:when>
            <c:otherwise>
                <li><a href="<c:url value="/login.htm"/>"><fmt:message key="login"/></a></li>
                <li><a href="<c:url value="/registreer.htm"/>"><fmt:message key="registreer"/></a></li>
            </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>