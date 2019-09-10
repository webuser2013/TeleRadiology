package com.kinsolutions.radcenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.RadCenter;
import com.kinsolutions.radcenter.dao.RadCenterDao;

@Service
public class RadCenterServiceImpl implements RadCenterService {
	
	@Autowired
	private RadCenterDao radCenterDao;

	@Override
	public RadCenter getRadCenterByUserId(Integer userId) {
 		return radCenterDao.getRadCenterByUserId(userId);
	}

	@Override
	public RadCenter getRadCenterByRadCenterId(Integer radCenterId) {
 		return radCenterDao.getRadCenterByRadCenterId(radCenterId);
	}

	@Override
	public RadCenter saveOrUpdateRadCenter(RadCenter radCenter) {
		if(radCenter != null){			
			if(radCenter.getRadCenterId() != null && radCenter.getRadCenterId() > 0) {
				//Update object
  				radCenter.setModifiedDate(new Date());
  			} else {
  				radCenter.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
 				radCenter.setCreatedDate(new Date());
  				radCenter.setModifiedDate(new Date());
 			}
		}
 		return radCenterDao.saveOrUpdateRadCenter(radCenter);
	}

	@Override
	public boolean isRadCenterExists(String radCenterName) {
		return radCenterDao.isRadCenterExists(radCenterName);
	}
	
	@Override
	public List<RadCenter> getAllRadCenter(){
		return radCenterDao.getAllRadCenter();
	}

}
