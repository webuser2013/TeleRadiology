package com.kinsolutions.radcenter.service;

import com.kinsolutions.model.RadCenter;

public interface RadCenterService {
	
	public RadCenter getRadCenterByUserId(long userId);
	
	public RadCenter getRadCenterByRadCenterId(long radCenterId);
	
	public RadCenter saveOrUpdateRadCenter(RadCenter radCenter);

}
