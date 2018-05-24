package com.epam.javalab.strutsapp.service;

import com.epam.javalab.strutsapp.dto.UserDTO;

public interface IUserService {

	void register(UserDTO user);
	void login(UserDTO user);
	void edit(UserDTO user);
	void delete(int id);
}
