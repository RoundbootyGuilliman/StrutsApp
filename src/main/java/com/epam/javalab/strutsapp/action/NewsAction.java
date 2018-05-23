package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.form.NewsForm;
import com.epam.javalab.strutsapp.service.INewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class NewsAction extends DispatchActionSupport {

	private INewsService service;

	@Override
	protected void onInit() {
		super.onInit();
		service = (INewsService) getWebApplicationContext().getBean("newsService");
	}

	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		NewsForm newsForm = (NewsForm) form;
		newsForm.setNews(service.getNewsById(newsForm.getId()));

		return mapping.findForward("news");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		NewsForm newsForm = (NewsForm) form;
		newsForm.getNews().setDate(new Date());
		service.setNews(newsForm.getNews());

		return mapping.findForward("main");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		NewsForm newsForm = (NewsForm) form;
		service.deleteNews(newsForm.getId());

		return mapping.findForward("main");
	}
}
