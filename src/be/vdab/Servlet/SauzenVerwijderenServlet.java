package be.vdab.Servlet;

import be.vdab.repositories.SausRepository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/sauzen/verwijderen.htm", name = "SauzenVerwijderenServlet")
public class SauzenVerwijderenServlet extends HttpServlet {

	private static final long serialVersionUID =1L;
	private final transient SausRepository sausRepository = new SausRepository();
	private static final String REDIRECT_URL = "%s/sauzen.htm";

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		sausRepository.setDataSource(dataSource);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] idAlsString = request.getParameterValues("id");
		if (idAlsString != null){
			sausRepository.delete(Arrays.stream(idAlsString).map(id-> Long.parseLong(id)).collect(Collectors.toSet()));
		}
		response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
	}

}
