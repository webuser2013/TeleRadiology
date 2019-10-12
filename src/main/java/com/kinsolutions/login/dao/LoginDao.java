package com.kinsolutions.login.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.Users;

@Transactional
@Repository
public class LoginDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	public Users authenticateUser(String referenceName, String password) {
		List<Users> usersList = null;
		try {
			 
			String hqlQuery = "FROM Users WHERE username = ? AND password = ? AND privilegeCd = ? AND roles.privilegeCd = ?";
			usersList = entityManager.createQuery(hqlQuery, Users.class).setParameter(1, referenceName).setParameter(2, password)
					.setParameter(3, AppConstants.PRIVILEGECD_STATUS_ACTIVE).setParameter(4, AppConstants.PRIVILEGECD_STATUS_ACTIVE).getResultList();
			
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
