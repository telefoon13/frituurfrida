package be.vdab.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@WebServlet(urlPatterns = "/zoekdefriet.htm", name = "ZoekDeFrietServlet")
public class ZoekDeFrietServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";
	private static final int AANTAL_DEUREN = 9; //Max 9 !!!
	private static final String GEDUWDEDEUREN = "geduwdeDeuren";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session2 = request.getSession();

		//Er word op een deur geduwd
		if(request.getParameter("volgnummer")!= null){

			//Set met nummers van ingeduwde deuren maken en in session zetten
			@SuppressWarnings("uncheked")
			Set<Integer> geduwdeDeuren = (Set<Integer>) session2.getAttribute(GEDUWDEDEUREN);
			if (geduwdeDeuren == null) {
				geduwdeDeuren = new HashSet<>();
			}
			geduwdeDeuren.add(Integer.valueOf(request.getParameter("volgnummer")));
			session2.setAttribute(GEDUWDEDEUREN, geduwdeDeuren);

			//Indien nog geen winnend nummer een genereren
			if(request.getSession(false).getAttribute("gevonden") == null){
				Random rand = new Random();
				int winner = rand.nextInt(AANTAL_DEUREN)+1;
				session2.setAttribute("gevonden",winner);
			}

		}
		//Er word een nieuw spel gevraagd
		if(request.getParameter("nieuwSpel")!= null){
			Random rand = new Random();
			int winner = rand.nextInt(AANTAL_DEUREN)+1;
			session2.setAttribute("gevonden",winner);
			session2.setAttribute(GEDUWDEDEUREN, new HashSet<>());
		}


		//Redirect
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Aantal deuren meegeven aan JSP
		request.setAttribute("AANTAL_DEUREN", AANTAL_DEUREN);

		//Redirect
		request.getRequestDispatcher(VIEW).forward(request, response);

	}
}
