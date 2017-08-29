package be.vdab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebFilter("*.htm")
public class ServletFilter implements Filter {

	private static final String STATISTIEK = "statistiek";

	//Server Opstarten
	public void init(FilterConfig config) throws ServletException {
		config.getServletContext().setAttribute(STATISTIEK, new ConcurrentHashMap<String,AtomicInteger>());
	}

	//Voor de pagina laad
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

		if (req instanceof HttpServletRequest){
			String url = ((HttpServletRequest) req).getRequestURI();
			int index = url.indexOf(";jsessionid=");
			if (index != -1) {
				url = url.substring(0, index);
			}
			@SuppressWarnings("uncheked")
			ConcurrentHashMap<String, AtomicInteger> statistiek = (ConcurrentHashMap<String, AtomicInteger>) req.getServletContext().getAttribute(STATISTIEK);
			AtomicInteger aantalReedsAanwezig = statistiek.putIfAbsent(url, new AtomicInteger(1));
			if (aantalReedsAanwezig != null) {
				aantalReedsAanwezig.incrementAndGet();
			}
		}

		chain.doFilter(req, resp);
	}

	//Server afsluiten
	public void destroy() {
	}

}
