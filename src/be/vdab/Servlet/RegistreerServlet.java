package be.vdab.Servlet;

import be.vdab.enteties.User;
import be.vdab.repositories.RepositoryException;
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

@WebServlet(urlPatterns = "/registreer.htm", name = "RegistreerServlet")
public class RegistreerServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/registreer.jsp";
	private static final String REDIRECT_URL = "%s/login.htm";
	private final transient UserRepository userRepository = new UserRepository();
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]{3,40}$";
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	private static final String PASS_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.?!])(?=\\S+$).{8,40}$";

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		userRepository.setDataSource(dataSource);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> fouten = new HashMap<>();
		String gebruikersnaam = request.getParameter("gebruikersnaam");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		User userExist = userRepository.userExist(gebruikersnaam);
		boolean emailExist = userRepository.emailExist(email);
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Pattern emailPattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Pattern passPattern = Pattern.compile(PASS_PATTERN);

		//Gebruikersnaam check
		if (gebruikersnaam == null || gebruikersnaam.isEmpty()){
			fouten.put("gebruikersnaam", "Gelieven een gebruikersnaam in te vullen.");
		}
		if (!pattern.matcher(gebruikersnaam).matches()){
			fouten.put("gebruikersnaam", "Gebruikersnaam voldoet niet aan de voorwaarden (a-Z . - _) min 3 max 40 tekens.");
		}
		if (userExist != null) {
			fouten.put("gebruikersnaam", "Gebruikersnaam bestaad al.");
		}

		//Email check
		if (email == null || email.isEmpty()){
			fouten.put("email", "Gelieven een email adres in te vullen.");
		}
		if (!emailPattern.matcher(email).matches()){
			fouten.put("email", "Dit is geen geldig email adres");
		}
		if (emailExist){
			fouten.put("email", "Dit email adres komt al voor in onze database.");
		}

		//Pass check
		if (pass == null || pass.isEmpty() || pass2 == null || pass2.isEmpty()){
			fouten.put("pass","Gelieven een wachtwoord in te invullen.");
		}
		if (!pass.equals(pass2)){
			fouten.put("pass","Beide wachtwoorden komen niet overeen");
		}
		if (!passPattern.matcher(pass).matches()){
			fouten.put("pass","Wachtwoord voldoet niet aan de voorwaarden " +
					"(min 1 cijfer, 1 kleine letter, 1 grote letter, 1 speciaal teken(@#$%^&+=.?!), min 8 tekens lang en max 40 tekens lang).");
		}

		//Geen fouten
		if (fouten.isEmpty()){
			boolean makeUser = userRepository.signup(gebruikersnaam,email,pass);
			if (makeUser) {
				response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
			}
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(VIEW).forward(request,response);

	}
}
