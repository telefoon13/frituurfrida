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
            <li><a href="<c:url value="/sausraden.htm"/>"><fmt:message key="sausRaden"/></a></li>
            <li><a href="<c:url value="/statistiek.htm"/>"><fmt:message key="statistiek"/></a></li>
        </ul>
    </nav>
</header>