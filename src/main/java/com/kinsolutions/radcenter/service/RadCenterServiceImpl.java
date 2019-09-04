package com.kinsolutions.radcenter.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinsolutions.model.RadCenter;
import com.kinsolutions.radcenter.dao.RadCenterDao;

@Service
public class RadCenterServiceImpl implements RadCenterService {
	
	@Autowired
	private RadCenterDao radCenterDao;

	@Override
	public RadCenter getRadCenterByUserId(long userId) {
 		return radCenterDao.getRadCenterByUserId(userId);
	}

	@Override
	public RadCenter getRadCenterByRadCenterId(long radCenterId) {
 		return radCenterDao.getRadCenterByRadCenterId(radCenterId);
	}

	@Override
	public RadCenter saveOrUpdateRadCenter(RadCenter radCenter) {
		if(radCenter != null){
			if(radCenter.getRadCenterId() > 0) {
				//Update object
				radCenter.setCreatedDate(new Date());
				radCenter.setModifiedDate(new Date());
 			} else {
 				radCenter.setModifiedDate(new Date());
			}
		}
 		return radCenterDao.saveOrUpdateRadCenter(radCenter);
	}

}
