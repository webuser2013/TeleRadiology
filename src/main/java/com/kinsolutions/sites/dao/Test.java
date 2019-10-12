package com.kinsolutions.sites.dao;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		
		String siteName = null;
		String siteCode = null;
		int privilegeCd = 0;
		
		StringBuffer hqlQuery = new StringBuffer();
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		hqlQuery.append("FROM Sites ");
		int i = 0;
		if(siteName != null || siteCode != null || privilegeCd > 0) {
			hqlQuery.append(" WHERE ");
			
			if(siteName != null){
				hqlQuery.append(" siteName = ? ");
				i++;
				paramMap.put("siteName",i);
			}
			
			if(siteCode != null){
				if( i > 0) {
					hqlQuery.append(" AND siteCode = ? ");						
				} else {						
					hqlQuery.append(" siteCode = ? ");
				}
				i++;
				paramMap.put("siteCode",i);
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
		System.out.println("hqlQuery>>>>>"+hqlQuery);
		System.out.println("I Value>>>>>>"+i);
		
		if(paramMap != null && paramMap.size() > 0){
			if(paramMap.containsKey("siteName")){
				System.out.println("siteName Val >>>> "+paramMap.get("siteName"));
			} 
			
			if(paramMap.containsKey("siteCode")){
				System.out.println("siteCode Val >>>> "+paramMap.get("siteCode"));
			} 
			
			if(paramMap.containsKey("privilegeCd")){
				System.out.println("privilegeCd Val >>>> "+paramMap.get("privilegeCd"));
			}
		}
	}

}
