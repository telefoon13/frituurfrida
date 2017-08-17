package be.vdab.Servlet;

import be.vdab.enteties.Adres;
import be.vdab.enteties.Gemeente;
import be.vdab.enteties.OpenGesloten;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID =1L;
    private static final String VIEW = "/WEB-INF/JSP/index.jsp";

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setAttribute("openGesloten", new OpenGesloten());
        request.setAttribute("adres", new Adres("Gavermolenstraat","71", new Gemeente("Belsele",9111)));
        request.getRequestDispatcher(VIEW).forward(request,response);
    }
}