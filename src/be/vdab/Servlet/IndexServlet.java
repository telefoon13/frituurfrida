package be.vdab.Servlet;

import be.vdab.enteties.OpenGesloten;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDate;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID =1L;
    private static final String VIEW = "/WEB-INF/JSP/index.jsp";

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        int dag = LocalDate.now().getDayOfWeek().getValue();
        request.setAttribute("openGesloten", new OpenGesloten());
        request.getRequestDispatcher(VIEW).forward(request,response);
    }
}