package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.form.EditNewsForm;
import com.epam.javalab.strutsapp.service.INewsService;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Locale;

public class AddNewsAction extends ActionSupport {

	INewsService service;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		EditNewsForm editNewsForm = (EditNewsForm) form;
		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
		WebApplicationContext context = getWebApplicationContext();
		service = (INewsService) context.getBean("newsService");
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setTitle(editNewsForm.getTitle());
		newsDTO.setAuthor(editNewsForm.getAuthor());
		newsDTO.setBrief(editNewsForm.getBrief());
		newsDTO.setContent(editNewsForm.getContent());
		newsDTO.setDate(new Date());
		service.setNews(newsDTO);
		return mapping.findForward("success");
	}
}