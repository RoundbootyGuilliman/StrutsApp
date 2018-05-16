package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.form.MainForm;
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

public class MainAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		MainForm mainForm = (MainForm) form;
		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);

		INewsService service = new NewsService();

		mainForm.setNewsMap(service.getAllNews(locale));

		return mapping.findForward("success");
	}
}
