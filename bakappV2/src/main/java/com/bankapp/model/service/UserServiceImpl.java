package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.user.User;
import com.bankapp.model.dao.user.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	private UserDao userDao;
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		//encode password before saving it
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
