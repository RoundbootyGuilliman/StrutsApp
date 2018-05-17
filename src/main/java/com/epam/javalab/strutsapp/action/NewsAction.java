package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.form.NewsForm;
import com.epam.javalab.strutsapp.service.INewsService;
import com.epam.javalab.strutsapp.service.impl.NewsService;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class NewsAction extends Action {

	INewsService service = new NewsService();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		NewsForm newsForm = (NewsForm) form;
		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);

		newsForm.setNews(service.getNewsById(0, locale));

		return mapping.findForward("success");
	}
}
