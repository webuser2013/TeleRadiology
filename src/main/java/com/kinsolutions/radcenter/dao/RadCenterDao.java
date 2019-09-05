package com.kinsolutions.radcenter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kinsolutions.model.RadCenter;

@Transactional
@Repository
public class RadCenterDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	public RadCenter getRadCenterByUserId(long userId) {
		List<RadCenter> radCenterList = null;
		try {
			String hqlQuery = "FROM RadCenter WHERE users.userId = ?";
			radCenterList = entityManager.createQuery(hqlQuery, RadCenter.class).setParameter(1, userId).getResultList();
			
			if(radCenterList != null && radCenterList.size() > 0) {
				return radCenterList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public RadCenter getRadCenterByRadCenterId(Integer radCenterId) {
		List<RadCenter> radCenterList = null;
		try {
			String hqlQuery = "FROM RadCenter WHERE radCenterId = ?";
			radCenterList = entityManager.createQuery(hqlQuery, RadCenter.class).setParameter(1, radCenterId).getResultList();
			
			if(radCenterList != null && radCenterList.size() > 0) {
				return radCenterList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public RadCenter saveOrUpdateRadCenter(RadCenter radCenter) {
		try {
			entityManager.persist(radCenter);
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return radCenter;
	}

}
