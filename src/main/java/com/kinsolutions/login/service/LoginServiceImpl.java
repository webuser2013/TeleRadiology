package com.kinsolutions.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinsolutions.login.dao.LoginDao;
import com.kinsolutions.model.Users;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public Users authenticateUser(String referenceName, String password) { 
		return loginDao.authenticateUser(referenceName,password);
	}

}
