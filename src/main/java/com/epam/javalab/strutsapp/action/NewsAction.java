package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.dao.impl.NewsDAO;
import com.epam.javalab.strutsapp.entity.News;
import com.epam.javalab.strutsapp.form.NewsForm;
import com.epam.javalab.strutsapp.util.TimeAndDateHandler;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class NewsAction extends Action {

	private INewsDAO newsDAO = new NewsDAO();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		NewsForm newsForm = (NewsForm) form;

		News news = newsDAO.getNewsById(0);

		TimeAndDateHandler.setDate(news, (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY));

		newsForm.setNews(news);

		return mapping.findForward("success");
	}
}
