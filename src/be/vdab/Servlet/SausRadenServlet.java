package be.vdab.Servlet;

import be.vdab.enteties.Saus;
import be.vdab.enteties.SausRaden;
import be.vdab.repositories.SausRepository;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = "/sausraden.htm", name = "SausRadenServlet")
public class SausRadenServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/sausraden.jsp";
	private final SausRepository sausRepository = new SausRepository();
	private static final String SPEL = "sausRaden";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (request.getParameter("nieuwSpel") != null){
			session.removeAttribute(SPEL);
		} else {
			String letter = request.getParameter("letter").toLowerCase();
			SausRaden spel = (SausRaden) session.getAttribute(SPEL);
			if (spel != null && letter != null && !letter.isEmpty()){
				spel.doeGok(letter.charAt(0));
				session.setAttribute(SPEL,spel);
			}
		}
		//Redirecta
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute(SPEL) == null){
			List<Saus> sauzen = new ArrayList<>(sausRepository.findAll());
			Saus randomSaus = sauzen.get(new Random().nextInt(sauzen.size()));
			SausRaden spel = new SausRaden(randomSaus.getNaam());
			session.setAttribute(SPEL,spel);
		}
		//Redirect
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
