package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.form.ShowNewsForm;
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

public class ShowNewsAction extends ActionSupport {

	INewsService service;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		ShowNewsForm showNewsForm = (ShowNewsForm) form;

		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
		WebApplicationContext context = getWebApplicationContext();
		service = (INewsService) context.getBean("newsService");

		showNewsForm.setNews(service.getNewsById(showNewsForm.getId(), locale));

		return mapping.findForward("success");
	}
}
