package be.vdab.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener()
public class StatistiekListener implements ServletContextListener, ServletRequestListener {

	private static final String STATISTIEK = "statistiek";
	private static final Set<String> UITGESLOTEN_EXTENSIES = new CopyOnWriteArraySet<>(Arrays.asList("png", "gif", "css", "jpg", "js", "ico"));

	// Public constructor is required by servlet spec
	public StatistiekListener() {
	}

	// -------------------------------------------------------
	// ServletContextListener implementation
	// -------------------------------------------------------

	@Override
	public void contextInitialized(ServletContextEvent sce) {

	  /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
	  //sce.getServletContext().setAttribute(STATISTIEK, new ConcurrentHashMap<String,AtomicInteger>());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre){

		/*if (sre.getServletRequest() instanceof HttpServletRequest){
			HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
			String url = request.getRequestURI();
			boolean verwerkRequest = true;
			int laatstePuntIndex = url.lastIndexOf('.');
			if (laatstePuntIndex != -1){
				String extensie = url.substring(laatstePuntIndex+1).toLowerCase();
				if (UITGESLOTEN_EXTENSIES.contains(extensie)){
					verwerkRequest = false;
				}
			}
			if (verwerkRequest) {
				int index = url.indexOf(";jsessionid=");
				if (index != -1) {
					url = url.substring(0, index);
				}
				@SuppressWarnings("uncheked")
				ConcurrentHashMap<String, AtomicInteger> statistiek = (ConcurrentHashMap<String, AtomicInteger>) request.getServletContext().getAttribute(STATISTIEK);
				AtomicInteger aantalReedsAanwezig = statistiek.putIfAbsent(url, new AtomicInteger(1));
				if (aantalReedsAanwezig != null) {
					aantalReedsAanwezig.incrementAndGet();
				}
			}
		}*/
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre){

	}
}
