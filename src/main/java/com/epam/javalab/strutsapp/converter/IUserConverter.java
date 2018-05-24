package com.epam.javalab.strutsapp.converter;

import com.epam.javalab.strutsapp.dto.UserDTO;
import com.epam.javalab.strutsapp.entity.User;

public interface IUserConverter {

	UserDTO convertToDTO(User user);
	User convertToEntity(UserDTO userDTO);
}
