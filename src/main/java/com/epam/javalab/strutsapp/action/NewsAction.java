package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.Comment;
import com.epam.javalab.strutsapp.form.NewsForm;
import com.epam.javalab.strutsapp.service.INewsService;
import com.epam.javalab.strutsapp.service.IUserService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class NewsAction extends DispatchActionSupport {

	private INewsService service;
	private IUserService userService;
	private NewsForm newsForm;

	@Override
	protected void onInit() {
		super.onInit();
		userService = (IUserService) getWebApplicationContext().getBean("userService");
		service = (INewsService) getWebApplicationContext().getBean("newsService");
	}

	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		newsForm = (NewsForm) form;
		newsForm.setNews(service.getNewsById(newsForm.getId()));

		return mapping.findForward("news");
	}

	public ActionForward showUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("newsList", service.getNewsByAuthor(request.getRemoteUser()));

		return mapping.findForward("user");
	}

	public ActionForward admin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("myNewsList", service.getNewsByAuthor(request.getRemoteUser()));
		request.setAttribute("newsList", service.getAllNews());
		request.setAttribute("userList", userService.getAllUsers());

		return mapping.findForward("admin");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		newsForm = (NewsForm) form;
		if (newsForm.getNews().getDate() == null) {
			newsForm.getNews().setDate(new Date());
		}
		newsForm.getNews().setAuthor(request.getRemoteUser());
		service.setNews(newsForm.getNews());

		System.out.println(newsForm.getNews().getId());
		return mapping.findForward("main");
	}

	public ActionForward openEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		newsForm = (NewsForm) form;
		newsForm.setNews(service.getNewsById(newsForm.getId()));
		System.out.println(newsForm.getNews().getId());

		return mapping.findForward("edit");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		newsForm = (NewsForm) form;
		if ((request.getParameterValues("deleteNewsCheckbox")) != null) {
			for (String s : request.getParameterValues("deleteNewsCheckbox")) {
				service.deleteNews(Integer.parseInt(s));
			}
		} else {
			service.deleteNews(newsForm.getId());
		}
		return mapping.findForward("main");
	}

	public ActionForward addComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		newsForm = (NewsForm) form;

		NewsDTO newsDTO = service.getNewsById(newsForm.getId());
		Comment comment = new Comment();
		comment.setUsername(request.getRemoteUser());
		comment.setDate(new Date());
		comment.setComment(newsForm.getComment());
		newsDTO.getComments().add(comment);
		service.setNews(newsDTO);

		return mapping.findForward("main");
	}
}
