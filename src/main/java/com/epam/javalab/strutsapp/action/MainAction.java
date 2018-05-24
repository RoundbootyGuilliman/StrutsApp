package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.service.INewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		INewsService service = (INewsService) getWebApplicationContext().getBean("newsService");
		request.setAttribute("newsList", service.getAllNews());

		return mapping.findForward("success");
	}
}
