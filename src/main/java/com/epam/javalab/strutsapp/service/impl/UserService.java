package com.epam.javalab.strutsapp.service.impl;

import com.epam.javalab.strutsapp.converter.IUserConverter;
import com.epam.javalab.strutsapp.dao.IUserDAO;
import com.epam.javalab.strutsapp.dto.UserDTO;
import com.epam.javalab.strutsapp.entity.Role;
import com.epam.javalab.strutsapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private IUserConverter converter;

	@Override
	public void register(UserDTO user) {
		Role role = new Role();
		role.setUsername(user.getUsername());
		role.setRole("User");
		user.getRoles().add(role);
		userDAO.saveUser(converter.convertToEntity(user));
	}

	@Override
	public void login(UserDTO user) {

	}

	@Override
	public void edit(UserDTO user) {

	}

	@Override
	public void delete(int id) {

	}
}
