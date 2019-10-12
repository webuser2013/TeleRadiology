package com.kinsolutions.radcenter.service;

import java.util.List;

import com.kinsolutions.model.RadCenter;
import com.kinsolutions.model.Sites;

public interface RadCenterService {
	
	public RadCenter getRadCenterByUserId(Integer userId);
	
	public RadCenter getRadCenterByRadCenterId(Integer radCenterId);
	
	public RadCenter saveOrUpdateRadCenter(RadCenter radCenter);
	
	public boolean isRadCenterExists(String radCenterName);
	
	public List<RadCenter> getAllRadCenter();
	
	public List<RadCenter> getRadCenterByRadcenterInfo(String radcenterName,String servicetype,int privilegeCd);

}
