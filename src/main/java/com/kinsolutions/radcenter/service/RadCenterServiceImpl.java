package com.kinsolutions.radcenter.service;

import java.text.SimpleDateFormat;
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
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			String strDate= formatter.format(new Date()); 
			formatter = new SimpleDateFormat("hh:mm:ss");  
			String strTime= formatter.format(new Date()); 
			if(radCenter.getRadCenterId() != null && radCenter.getRadCenterId() > 0) {
				//Update object
  				radCenter.setModifiedDate(new Date());
  			} else {
 				radCenter.setCreatedDate(new Date());
  				radCenter.setModifiedDate(new Date());
 			}
		}
 		return radCenterDao.saveOrUpdateRadCenter(radCenter);
	}

}
