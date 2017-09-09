package be.vdab.Servlet;

import be.vdab.enteties.User;
import be.vdab.repositories.SausRepository;
import be.vdab.repositories.UserRepository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.htm", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/login.jsp";
	private final transient UserRepository userRepository = new UserRepository();

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		userRepository.setDataSource(dataSource);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session2 = request.getSession();
		if (request.getParameter("loginKnop") != null){
			User user = userRepository.login(request.getParameter("gebruikersnaam"));
			session2.setAttribute("user",user);
			session2.setAttribute("test",request.getParameter("gebruikersnaam"));
		}

		//Redirect
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(VIEW).forward(request,response);

	}
}
