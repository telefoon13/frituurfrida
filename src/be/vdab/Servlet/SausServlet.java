package be.vdab.Servlet;

import be.vdab.enteties.Saus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.*;

@WebServlet(urlPatterns = "/sauzen.htm", name = "SausServlet")
public class SausServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Saus> sauzen = asList(
				new Saus(1L,"Cocktail", asList("Mayonaise", "Cognac", "Ketchup")),
				new Saus(2L,"Mayonaise", asList("Ei", "Mosterd", "Olie")),
				new Saus(3L,"Mosterd", asList("Azijn", "Mosterd", "Witte Wijn")),
				new Saus(4L,"Tartare", asList("Mayonaise", "Agurk", "Tabasco")),
				new Saus(5L,"Vinaigrette", asList("Azijn", "Mosterd", "Olijfolie"))
		);
		request.setAttribute("sauzen", sauzen);
		request.getRequestDispatcher(VIEW).forward(request,response);
	}
}
