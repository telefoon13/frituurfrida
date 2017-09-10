package be.vdab.Servlet;

import be.vdab.enteties.User;
import be.vdab.repositories.GastenboekRepository;
import be.vdab.repositories.SausRepository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/gastenboek.htm", name = "GastenboekServlet")
public class GastenboekServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/gastenboek.jsp";
	private final transient GastenboekRepository gastenboekRepository = new GastenboekRepository();
	private static final String REDIRECT_URL = "%s/gastenboek.htm";

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		gastenboekRepository.setDataSource(dataSource);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("delete") != null){
			String[] idAlsString = request.getParameterValues("id");
			if (idAlsString != null){
				gastenboekRepository.delete(Arrays.stream(idAlsString).map(id-> Long.parseLong(id)).collect(Collectors.toSet()));
			}
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));

		} else if (request.getParameter("toevoegen") != null){
			String bericht = request.getParameter("bericht");
			String posteridS =  request.getParameter("posterid");
			Long posterid = Long.parseLong(posteridS);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String nu = dateFormat.format(date);
			gastenboekRepository.insert( posterid,bericht,nu);
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
		} else {
			request.setAttribute("gastenboek", gastenboekRepository.readAll());
			request.getRequestDispatcher(VIEW).forward(request,response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("gastenboek", gastenboekRepository.readAll());
		request.getRequestDispatcher(VIEW).forward(request,response);

	}
}
