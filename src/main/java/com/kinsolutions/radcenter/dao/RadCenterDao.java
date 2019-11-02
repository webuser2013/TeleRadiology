package com.kinsolutions.radcenter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.RadCenter;
import com.kinsolutions.model.Sites;

@Transactional
@Repository
public class RadCenterDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	public RadCenter getRadCenterByUserId(Integer userId) {
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

	public boolean isRadCenterExists(String radCenterName) {
		List<RadCenter> radCenterList = null;
		try {
			String hqlQuery = "FROM RadCenter WHERE radCenterName = ? AND privilegeCd NOT IN (?)";
			radCenterList = entityManager.createQuery(hqlQuery, RadCenter.class).setParameter(1, radCenterName).setParameter(2, AppConstants.PRIVILEGECD_STATUS_DELETED).getResultList();
			
			if(radCenterList != null && radCenterList.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<RadCenter> getAllRadCenter() {
		List<RadCenter> radCenterList = null;
		try {
			String hqlQuery = "FROM RadCenter WHERE privilegeCd NOT IN (?) ORDER BY radCenterName";
			radCenterList = entityManager.createQuery(hqlQuery, RadCenter.class).setParameter(1, AppConstants.PRIVILEGECD_STATUS_DELETED).getResultList();
			if(radCenterList != null && radCenterList.size() > 0) {
				return radCenterList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RadCenter> getRadCenterByRadcenterInfo(String radcenterName, String servicetype, int privilegeCd) {
		List<RadCenter> radCenterList = null;
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		try {
 			StringBuffer hqlQuery = new StringBuffer();
			hqlQuery.append("FROM RadCenter ");
			System.out.println("radcenterName>>>>>>>>"+radcenterName);
			System.out.println("servicetype>>>>>>>>"+servicetype);
			System.out.println("privilegeCd>>>>>>>>"+privilegeCd);
			if( (radcenterName != null && (!"null".equalsIgnoreCase(radcenterName)) ) || (servicetype != null && (!"null".equalsIgnoreCase(servicetype))) || privilegeCd > 0) {
				hqlQuery.append(" WHERE ");
				
				int i = 0;
				if(radcenterName != null && !"null".equalsIgnoreCase(radcenterName)){
					hqlQuery.append("radCenterName = ? ");
					i++;
					paramMap.put("radCenterName",i);
				}
				
				if(servicetype != null && !"null".equalsIgnoreCase(servicetype)){
					if( i > 0) {
						hqlQuery.append(" AND serviceType = ? ");						
					} else {						
						hqlQuery.append(" serviceType = ? ");
					}
					i++;
					paramMap.put("serviceType",i);
				} 
				
				if(privilegeCd > 0){
					if(i > 0){						
						hqlQuery.append(" AND privilegeCd = ? ");
					} else {						
						hqlQuery.append(" privilegeCd = ? ");
					}
					i++;
					paramMap.put("privilegeCd",i);
				} 
				
			}
			hqlQuery.append(" ORDER BY radCenterName ");
			System.out.println("hqlQuery.toString()>>>>>>"+hqlQuery.toString());
			
			Query hqlQueryObj = entityManager.createQuery(hqlQuery.toString(), RadCenter.class);
			if(paramMap != null && paramMap.size() > 0){
				if(paramMap.containsKey("radCenterName")){
					hqlQueryObj.setParameter(paramMap.get("radCenterName"), radcenterName);
				} 
				
				if(paramMap.containsKey("serviceType")){
					hqlQueryObj.setParameter(paramMap.get("serviceType"), servicetype);
				} 
				
				if(paramMap.containsKey("privilegeCd")){
					hqlQueryObj.setParameter(paramMap.get("privilegeCd"), privilegeCd);
				}
			}
			
			
			radCenterList = hqlQueryObj.getResultList();
			
			if(radCenterList != null && radCenterList.size() > 0) {
				return radCenterList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
