package com.kinsolutions.login.service;

import com.kinsolutions.model.Users;

public interface LoginService {

	public Users authenticateUser(String emailId, String password);

}
