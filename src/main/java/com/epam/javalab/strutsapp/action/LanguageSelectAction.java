package com.epam.javalab.strutsapp.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class LanguageSelectAction extends DispatchAction {

	private static final Locale RUSSIAN = new Locale("ru", "KZ");

	public ActionForward english(ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) {

		request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.US);

		return mapping.findForward("success");
	}

	public ActionForward russian(ActionMapping mapping, ActionForm form,
								HttpServletRequest request, HttpServletResponse response) {

		request.getSession().setAttribute(Globals.LOCALE_KEY, RUSSIAN);

		return mapping.findForward("success");
	}
}
