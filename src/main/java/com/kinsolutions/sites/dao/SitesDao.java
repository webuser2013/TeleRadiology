package com.kinsolutions.sites.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.Sites;

@Transactional
@Repository
public class SitesDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	public Sites getSiteBySiteId(Integer siteId) {
		List<Sites> sitesList = null;
		try {
			String hqlQuery = "FROM Sites WHERE siteId = ?";
			sitesList = entityManager.createQuery(hqlQuery, Sites.class).setParameter(1, siteId).getResultList();
			
			if(sitesList != null && sitesList.size() > 0) {
				return sitesList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Sites saveOrUpdateSites(Sites site) {
		try {
			entityManager.persist(site);
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return site;
	}

	public boolean isSiteExists(String siteName) {
		List<Sites> sitesList = null;
		try {
			String hqlQuery = "FROM Sites WHERE siteName = ? AND privilegeCd != ?";
			sitesList = entityManager.createQuery(hqlQuery, Sites.class).setParameter(1, siteName).setParameter(2, AppConstants.PRIVILEGECD_STATUS_DELETED).getResultList();
			
			if(sitesList != null && sitesList.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Sites> getAllSites() {
		List<Sites> sitesList = null;
		try {
			String hqlQuery = "FROM Sites WHERE privilegeCd != ? ORDER BY siteName";
			sitesList = entityManager.createQuery(hqlQuery, Sites.class).setParameter(1, AppConstants.PRIVILEGECD_STATUS_DELETED).getResultList();
			if(sitesList != null && sitesList.size() > 0) {
				return sitesList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Sites> getSiteBySiteInfo(String siteName, String memberShiptype, int privilegeCd) {
		List<Sites> sitesList = null;
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		try {
			//String hqlQuery = "FROM Sites WHERE privilegeCd != ? ORDER BY siteName";
			StringBuffer hqlQuery = new StringBuffer();
			hqlQuery.append("FROM Sites ");
			if(siteName != null || memberShiptype != null || privilegeCd > 0) {
				hqlQuery.append(" WHERE ");
				
				int i = 0;
				if(siteName != null){
					hqlQuery.append(" siteName = ? ");
					i++;
					paramMap.put("siteName",i);
				}
				
				if(memberShiptype != null){
					if( i > 0) {
						hqlQuery.append(" AND memberShipType = ? ");						
					} else {						
						hqlQuery.append(" memberShipType = ? ");
					}
					i++;
					paramMap.put("memberShipType",i);
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
			hqlQuery.append(" ORDER BY siteName ");
			
			Query hqlQueryObj = entityManager.createQuery(hqlQuery.toString(), Sites.class);
			if(paramMap != null && paramMap.size() > 0){
				if(paramMap.containsKey("siteName")){
					hqlQueryObj.setParameter(paramMap.get("siteName"), siteName);
				} 
				
				if(paramMap.containsKey("memberShipType")){
					hqlQueryObj.setParameter(paramMap.get("memberShipType"), memberShiptype);
				} 
				
				if(paramMap.containsKey("privilegeCd")){
					hqlQueryObj.setParameter(paramMap.get("privilegeCd"), privilegeCd);
				}
			}
			
			
			sitesList = hqlQueryObj.getResultList();
			
			if(sitesList != null && sitesList.size() > 0) {
				return sitesList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
