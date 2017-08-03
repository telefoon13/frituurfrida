<%--
  Created by IntelliJ IDEA.
  User: miked
  Date: 2/08/2017
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<html>
  <head>
    <title>Frituur Frida</title>
  </head>
  <body>
  <%
      int dag = LocalDate.now().getDayOfWeek().getValue();

      if (dag == 1 || dag == 4) {
          out.println("Vandaag Gesloten");
      } else {
          out.println("Vandaag OPEN");
      }
  %>
  </body>
</html>
