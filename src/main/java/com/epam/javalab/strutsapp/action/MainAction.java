package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.service.INewsService;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MainAction extends ActionSupport {

	private INewsService service;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
		WebApplicationContext context = getWebApplicationContext();
		service = (INewsService) context.getBean("newsService");

		request.setAttribute("newsList", service.getAllNews());

		return mapping.findForward("success");
	}
}
