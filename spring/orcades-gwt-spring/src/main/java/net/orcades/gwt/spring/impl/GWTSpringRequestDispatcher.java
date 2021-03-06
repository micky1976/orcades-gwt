package net.orcades.gwt.spring.impl;

import java.io.IOException;
import java.util.Map;

import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import net.orcades.gwt.server.GWTRequestDispatcher;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.HttpRequestHandler;
/**
 * Spring implementation of the <b>client</b> {@link DispatchService}.<br />
 * This implementation simply delegate the call to injected <b>Server</b> {@link Dispatch}.
 * @author Olivier NOUGUIER
 *
 */
@Named("gwt-handler")
public class GWTSpringRequestDispatcher extends GWTRequestDispatcher implements HttpRequestHandler, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> getServices(@SuppressWarnings("rawtypes") Class clazz) {
		return applicationContext.getBeansOfType(clazz);
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doHandleRequest(request, response);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
