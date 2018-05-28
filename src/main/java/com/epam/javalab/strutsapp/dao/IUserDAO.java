package com.epam.javalab.strutsapp.dao;

import com.epam.javalab.strutsapp.entity.User;

import java.util.List;

public interface IUserDAO {
	void saveUser(User user);
	List<User> getAllUsers();
	void deleteUser(int id);
}
