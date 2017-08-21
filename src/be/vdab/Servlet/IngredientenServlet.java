package be.vdab.Servlet;

import be.vdab.repositories.SausRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/ingredienten.htm", name = "IngredientenServlet")
public class IngredientenServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/ingredienten.jsp";
	private final SausRepository sausRepository = new SausRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("sauzen", sausRepository.findAll());

		if (request.getQueryString() != null) {
			String ingredient = request.getParameter("ingredient");
			if (ingredient != null){
				if (ingredient.isEmpty()){
					request.setAttribute("fouten", "Gelieven iets in te vullen");
				} else {
					request.setAttribute("sauzenMetIngredient", sausRepository.findByIngredient(ingredient));
				}
			}

		}

		request.getRequestDispatcher(VIEW).forward(request,response);
	}
}
