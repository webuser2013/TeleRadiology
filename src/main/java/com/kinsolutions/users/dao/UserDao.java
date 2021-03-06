package com.kinsolutions.users.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.Users;

@Transactional
@Repository
public class UserDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	public Users getUserByUserId(Integer userId) {
		List<Users> usersList = null;
		try {
			 
			String hqlQuery = "FROM Users WHERE userId = ? AND privilegeCd = ?";
			usersList = entityManager.createQuery(hqlQuery, Users.class).setParameter(1, userId).setParameter(2, AppConstants.PRIVILEGECD_STATUS_ACTIVE).getResultList();
			
			if(usersList != null && usersList.size() > 0) {
				return usersList.get(0);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Users> getAllActiveInActiveExceptLoggedInUsers(Integer userId) {
		List<Users> usersList = null;
		try {
			 
			String hqlQuery = "FROM Users WHERE userId NOT IN (?) AND privilegeCd NOT IN (?)";
			usersList = entityManager.createQuery(hqlQuery, Users.class).setParameter(1, userId).setParameter(2, AppConstants.PRIVILEGECD_STATUS_DELETED).getResultList();
			
			if(usersList != null && usersList.size() > 0) {
				return usersList;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Users getAllUsers(Integer userId) {
		List<Users> usersList = null;
		try {
			 
			String hqlQuery = "FROM Users WHERE userId = ?";
			usersList = entityManager.createQuery(hqlQuery, Users.class).setParameter(1, userId).getResultList();
			
			if(usersList != null && usersList.size() > 0) {
				return usersList.get(0);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
