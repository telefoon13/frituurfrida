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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/login.htm", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/login.jsp";
	private static final String REDIRECT_URL = "%s/gastenboek.htm";
	private final transient UserRepository userRepository = new UserRepository();
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]{3,40}$";
	private static final String PASS_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.?!])(?=\\S+$).{8,40}$";


	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		userRepository.setDataSource(dataSource);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session2 = request.getSession();
		Map<String, String> fouten = new HashMap<>();
		boolean chekPass = userRepository.checkPass(request.getParameter("gebruikersnaam"), request.getParameter("password"));
		String gebruikersnaam = request.getParameter("gebruikersnaam");
		String pass = request.getParameter("password");
		User userExist = userRepository.userExist(gebruikersnaam);
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Pattern passPattern = Pattern.compile(PASS_PATTERN);

		//Gebruikersnaam check
		if (gebruikersnaam == null || gebruikersnaam.isEmpty()){
			fouten.put("gebruikersnaam", "Gelieven een gebruikersnaam in te vullen.");
		}
		if (!pattern.matcher(gebruikersnaam).matches()){
			fouten.put("gebruikersnaam", "Gebruikersnaam voldoet niet aan de voorwaarden (a-Z . - _) min 3 max 40 tekens.");
		}
		if (userExist == null) {
			fouten.put("gebruikersnaam", "Deze gebruikersnaam komt niet voor in onze database.");
		}

		//Pass check
		if (pass == null || pass.isEmpty()){
			fouten.put("pass","Gelieven een wachtwoord in te vullen.");
		}
		if (!chekPass){
			fouten.put("pass","Dit wachtwoord is niet correct.");
		}

		//Geen fouten
		if (fouten.isEmpty() && userExist != null && chekPass){
			session2.setAttribute("user", userExist);
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}

		//Logout
		if (request.getParameter("logoutKnop") != null){
			session2.removeAttribute("user");
			request.getRequestDispatcher(VIEW).forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("logout") != ""){
			HttpSession session2 = request.getSession();
			session2.removeAttribute("user");
		}

		request.getRequestDispatcher(VIEW).forward(request,response);

	}
}
