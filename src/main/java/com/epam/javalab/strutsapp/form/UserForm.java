package com.epam.javalab.strutsapp.form;

import javax.servlet.http.HttpServletRequest;

import com.epam.javalab.strutsapp.dto.UserDTO;
import com.epam.javalab.strutsapp.entity.Role;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import java.util.ArrayList;
import java.util.List;

public class UserForm extends ActionForm {

	private int id;
	private UserDTO user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (user.getUsername() == null || ("".equals(user.getUsername()))) {
			errors.add("common.username.err", new ActionMessage("error.common.username.required"));
		}

		if (user.getPassword() == null || ("".equals(user.getPassword()))) {
			errors.add("common.password.err", new ActionMessage("error.common.password.required"));
		}

		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		setId(0);
		setUser(new UserDTO());
	}
}
