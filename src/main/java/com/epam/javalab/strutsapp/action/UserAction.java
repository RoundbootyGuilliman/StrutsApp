package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.form.UserForm;
import com.epam.javalab.strutsapp.service.IUserService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends DispatchActionSupport {

	private IUserService service;
	private UserForm userForm;

	@Override
	protected void onInit() {
		super.onInit();
		service = (IUserService) getWebApplicationContext().getBean("userService");
	}

	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		userForm = (UserForm) form;

		return mapping.findForward("news");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		userForm = (UserForm) form;
		service.register(userForm.getUser());

		return mapping.findForward("main");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		userForm = (UserForm) form;

		return mapping.findForward("main");
	}
}
