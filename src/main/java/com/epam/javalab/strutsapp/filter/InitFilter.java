package com.epam.javalab.strutsapp.filter;

import org.apache.struts.Globals;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

public class InitFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();


		if (session.getAttribute(Globals.LOCALE_KEY) == null) {
			Locale userPrefLocale = new Locale("ru", "KZ");
			if (request.getLocale().toString().contains("en")) {
				userPrefLocale = new Locale("en", "US");
			}
			session.setAttribute(Globals.LOCALE_KEY, userPrefLocale);
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}
}
