package com.kinsolutions.users.service;

import java.util.List;

import com.kinsolutions.model.Users;

public interface UserService {
	
	public Users getUserByUserId(Integer userId);
	
	public List<Users> getAllActiveInActiveExceptLoggedInUsers(Integer userId);
	
	public Users getAllUsers(Integer userId);

}
