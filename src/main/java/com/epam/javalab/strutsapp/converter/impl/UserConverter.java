package com.epam.javalab.strutsapp.converter.impl;

import com.epam.javalab.strutsapp.converter.IUserConverter;
import com.epam.javalab.strutsapp.dto.UserDTO;
import com.epam.javalab.strutsapp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements IUserConverter {

	@Override
	public UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setPassword(user.getPassword());
		userDTO.setUsername(user.getUsername());
		userDTO.setRoles(user.getRoles());
		return userDTO;
	}

	@Override
	public User convertToEntity(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setPassword(userDTO.getPassword());
		user.setUsername(userDTO.getUsername());
		user.setRoles(userDTO.getRoles());
		return user;
	}
}
