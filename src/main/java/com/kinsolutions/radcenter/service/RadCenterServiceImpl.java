package com.kinsolutions.radcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinsolutions.login.dao.LoginDao;
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

}
