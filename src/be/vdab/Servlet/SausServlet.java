package be.vdab.Servlet;

import be.vdab.enteties.Saus;
import be.vdab.repositories.SausRepository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/sauzen.htm", name = "SausServlet")
public class SausServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
	private final transient SausRepository sausRepository = new SausRepository();

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		sausRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("sauzen", sausRepository.findAll());

		request.getRequestDispatcher(VIEW).forward(request,response);
	}
}
