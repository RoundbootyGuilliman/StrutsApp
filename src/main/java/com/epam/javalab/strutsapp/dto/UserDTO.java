package com.epam.javalab.strutsapp.dto;

import com.epam.javalab.strutsapp.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

	private int id;
	private String username;
	private String password;
	private List<Role> roles = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}