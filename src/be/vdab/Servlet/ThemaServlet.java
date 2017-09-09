package be.vdab.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/thema.htm", name = "ThemaServlet")
public class ThemaServlet extends HttpServlet {

	private static final int COOCKIE_MAX_LEEFTIJD = 60 * 30;/*60sec * 30 min = 30min*/
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/thema.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String kleur = request.getParameter("themaKnop");
		Cookie cookie = new Cookie("thema", URLEncoder.encode(kleur, "UTF-8"));
		cookie.setMaxAge(COOCKIE_MAX_LEEFTIJD);
		response.addCookie(cookie);
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(VIEW).forward(request, response);

	}
}
