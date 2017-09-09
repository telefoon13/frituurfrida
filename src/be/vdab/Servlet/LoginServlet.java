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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(urlPatterns = "/login.htm", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/login.jsp";
	private static final String REDIRECT_URL = "%s/gastenboek.htm";
	private final transient UserRepository userRepository = new UserRepository();
	public static final String SALT = "mikedhoore123";

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		userRepository.setDataSource(dataSource);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session2 = request.getSession();

		//Login

			User user = userRepository.login(request.getParameter("gebruikersnaam"));
			boolean good = false;

			if (user == null) {
				request.setAttribute("naamfout","Deze gebruikersnaam komt niet voor in onze database.");
				good = false;
			} else {

				String saltedPassword = SALT + request.getParameter("password");
				String hashedPassword = generateHash(saltedPassword);

				if (user.getPass().compareTo(hashedPassword) != 0){
					request.setAttribute("passfout","Dit wachtwoord is niet correct.");
					good = false;
				} else {
					session2.setAttribute("user", user);
					response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
					good = true;
				}
			}

			if (!good) {
				request.getRequestDispatcher(VIEW).forward(request,response);
			}

		//Logout
		if (request.getParameter("logoutKnop") != null){
			session2.removeAttribute("user");
			request.getRequestDispatcher(VIEW).forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(VIEW).forward(request,response);

	}

	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
}
