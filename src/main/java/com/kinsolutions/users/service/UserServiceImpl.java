package com.kinsolutions.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinsolutions.login.dao.LoginDao;
import com.kinsolutions.model.Users;
import com.kinsolutions.users.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Users getUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<Users> getAllActiveInActiveExceptLoggedInUsers(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getAllActiveInActiveExceptLoggedInUsers(userId);
	}

	@Override
	public Users getAllUsers(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getAllUsers(userId);
	}

}
