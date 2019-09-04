package com.kinsolutions.radcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kinsolutions.model.RadCenter;
import com.kinsolutions.model.Users;
import com.kinsolutions.radcenter.resourceInfo.RadCenterRequestInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterResponseInfo;
import com.kinsolutions.radcenter.service.RadCenterService;
import com.kinsolutions.users.service.UserService;

@RestController
@RequestMapping("/RadCenter")
public class RadCenterController {
	
	@Autowired
	private RadCenterService radCenterService;
	
	@Autowired
	private UserService userService; 
	
	
	@RequestMapping(value = "/saveOrUpdateRadCenter", method = RequestMethod.POST)
	public ResponseEntity<RadCenterResponseInfo> saveOrUpdateRadCenter(@RequestBody RadCenterRequestInfo radCenterRequestInfo) {
		RadCenterResponseInfo radCenterResponseInfo = new RadCenterResponseInfo();
		try {
			
			if(radCenterRequestInfo != null){
 				if(radCenterRequestInfo.getRadCenterId() > 0){
					//Update Object
					RadCenter radCenter = radCenterService.getRadCenterByRadCenterId(radCenterRequestInfo.getRadCenterId());
					if(radCenter != null){
						
					}
					
				} else {
					//Create Object
					RadCenter radCenter = new RadCenter();
					radCenter.setRadCenterName(radCenterRequestInfo.getRadCenterName());
					Users users = userService.getUserByUserId(radCenterRequestInfo.getUserId());
					if(users != null){						
						radCenter.setUsers(users);
					}	
					
					radCenterService.saveOrUpdateRadCenter(radCenter);
					
				}
			}
 			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<RadCenterResponseInfo>(radCenterResponseInfo, HttpStatus.OK);
	}

}
