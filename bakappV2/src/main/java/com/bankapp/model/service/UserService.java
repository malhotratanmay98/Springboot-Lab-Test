package com.bankapp.model.service;

import com.bankapp.model.dao.user.User;

public interface UserService {
	public void addUser(User user);
	public User getUserByUsername(String username);
}
