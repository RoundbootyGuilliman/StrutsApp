package com.epam.javalab.strutsapp.service;

import com.epam.javalab.strutsapp.dto.UserDTO;

import java.util.List;

public interface IUserService {

	void register(UserDTO user);
	void edit(UserDTO user);
	void delete(int id);
	List<UserDTO> getAllUsers();
}
