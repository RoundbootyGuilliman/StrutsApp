package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.dao.impl.NewsDAO;
import com.epam.javalab.strutsapp.entity.News;
import com.epam.javalab.strutsapp.form.MainForm;
import com.epam.javalab.strutsapp.util.TimeAndDateHandler;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainAction extends Action {

	private INewsDAO newsDAO = new NewsDAO();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		MainForm mainForm = (MainForm) form;
		Map<Integer, News> newsMap = newsDAO.getAllNews();
		for (Map.Entry<Integer, News> entry : newsMap.entrySet()) {
			TimeAndDateHandler.setDate(entry.getValue(), (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY));
		}

		mainForm.setNewsMap(newsMap);

		return mapping.findForward("success");
	}
}
