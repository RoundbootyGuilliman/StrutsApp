package com.epam.javalab.strutsapp.action;

import com.epam.javalab.strutsapp.form.UserForm;
import com.epam.javalab.strutsapp.service.IUserService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import javax.servlet.ServletException;
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

	public ActionForward register(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		userForm = (UserForm) form;
		String password = userForm.getUser().getPassword();
		service.register(userForm.getUser());
		try {
			request.login(userForm.getUser().getUsername(), password);
		} catch (ServletException e) {
			e.printStackTrace();
			return mapping.findForward("login");
		}

		return mapping.findForward("main");
	}

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		userForm = (UserForm) form;
		try {
			request.login(userForm.getUser().getUsername(), userForm.getUser().getPassword());
		} catch (ServletException e) {
			e.printStackTrace();
			return mapping.findForward("login");
		}

		return mapping.findForward("main");
	}

	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}

		return mapping.findForward("main");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		userForm = (UserForm) form;
		service.delete(userForm.getId());

		return mapping.findForward("admin");
	}
}