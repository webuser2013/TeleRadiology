package com.kinsolutions.radcenter.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;
import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.RadCenter;
import com.kinsolutions.model.Users;
import com.kinsolutions.radcenter.resourceInfo.RadCenterInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterRequestInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterResponseInfo;
import com.kinsolutions.radcenter.service.RadCenterService;
import com.kinsolutions.users.service.UserService;
import com.kinsolutions.utils.AppHelper;
import com.kinsolutions.utils.MessageResourceHelper;

@RestController
@RequestMapping("/RadCenter")
public class RadCenterController {
	
	@Autowired
	private RadCenterService radCenterService;
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private MessageResourceHelper messageResourceHelper;
	
	
	@RequestMapping(value = "/saveOrUpdateRadCenter", method = RequestMethod.POST)
	public ResponseEntity<RadCenterResponseInfo> saveOrUpdateRadCenter(@RequestBody RadCenterRequestInfo radCenterRequestInfo) {
		RadCenterResponseInfo radCenterResponseInfo = new RadCenterResponseInfo();
		RadCenter radCenter = null;
		RadCenterInfo radCenterInfo = new RadCenterInfo();
		Users users = null;
 		HeaderData headerData = new HeaderData();
		boolean isNewMode = true;
		try {
			
			if(radCenterRequestInfo != null){
 				if(radCenterRequestInfo.getRadCenterId() != null && radCenterRequestInfo.getRadCenterId() > 0){
					//Update Object
					radCenter = radCenterService.getRadCenterByRadCenterId(radCenterRequestInfo.getRadCenterId());
					if(radCenter != null){
						radCenter.setRadCenterName(radCenterRequestInfo.getRadCenterName());
						users = userService.getUserByUserId(radCenterRequestInfo.getUserId());
						if(users != null){						
							radCenter.setUsers(users);
						}	
						radCenter.setSecurityDeposit(radCenterRequestInfo.getSecurityDeposit());
						radCenter.setDeploymentFee(radCenterRequestInfo.getDeploymentFee());
						radCenter.setSiteCount(radCenterRequestInfo.getSiteCount());
						radCenter.setRadiologistCount(radCenterRequestInfo.getRadiologistCount());
						radCenter.setModalityCount(radCenterRequestInfo.getModalityCount());
						radCenter.setModeOfCharge(radCenterRequestInfo.getModeOfCharge());
						radCenter.setCtcharge(radCenterRequestInfo.getCtcharge());
						radCenter.setMriCharge(radCenterRequestInfo.getMriCharge());
						radCenter.setxRayCrCharge(radCenterRequestInfo.getxRayCrCharge());
						radCenter.setMammogramCharge(radCenterRequestInfo.getMammogramcharge());
						radCenter.setServerRam(radCenterRequestInfo.getServerRam());
						radCenter.setServerCoreCount(radCenterRequestInfo.getServerCoreCount());
						radCenter.setServerStorage(radCenterRequestInfo.getServerStorage());
						radCenter.setServerMonthlyCharges(radCenterRequestInfo.getServerMonthlyCharges());
						radCenter.setFileName("testsupd.png");
						radCenter.setFilePath("/apps/testupd/");
						radCenter.setCreatedIpAddress("000.000");
						radCenter.setModifiedIpAddress("000.000");
						isNewMode = false;
					}
					
				} else {
					//Create Object
					radCenter = new RadCenter();
					radCenter.setRadCenterName(radCenterRequestInfo.getRadCenterName());
					users = userService.getUserByUserId(radCenterRequestInfo.getUserId());
					if(users != null){						
						radCenter.setUsers(users);
					}	
					radCenter.setPrivilegeCd(1);
					radCenter.setSecurityDeposit(radCenterRequestInfo.getSecurityDeposit());
					radCenter.setDeploymentFee(radCenterRequestInfo.getDeploymentFee());
					radCenter.setSiteCount(radCenterRequestInfo.getSiteCount());
					radCenter.setRadiologistCount(radCenterRequestInfo.getRadiologistCount());
					radCenter.setModalityCount(radCenterRequestInfo.getModalityCount());
					radCenter.setModeOfCharge(radCenterRequestInfo.getModeOfCharge());
					radCenter.setCtcharge(radCenterRequestInfo.getCtcharge());
					radCenter.setMriCharge(radCenterRequestInfo.getMriCharge());
					radCenter.setxRayCrCharge(radCenterRequestInfo.getxRayCrCharge());
					radCenter.setMammogramCharge(radCenterRequestInfo.getMammogramcharge());
					radCenter.setServerRam(radCenterRequestInfo.getServerRam());
					radCenter.setServerCoreCount(radCenterRequestInfo.getServerCoreCount());
					radCenter.setServerStorage(radCenterRequestInfo.getServerStorage());
					radCenter.setServerMonthlyCharges(radCenterRequestInfo.getServerMonthlyCharges());
					radCenter.setFileName("tests.png");
					radCenter.setFilePath("/apps/test/");
					radCenter.setCreatedIpAddress("000.000");
					radCenter.setModifiedIpAddress("000.000");
					
					String str = "sampleFile";
					/*byte[] byteArr = str.getBytes();
					radCenter.setPurchaseOrderCopy(byteArr);*/					
				}
 				
 				radCenter = radCenterService.saveOrUpdateRadCenter(radCenter);
 				if(radCenter != null){
 					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					radCenterResponseInfo.setHeaderData(headerData);
 					if(isNewMode) {
  						radCenterInfo.setMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" Created Successfully");
 					} else {
 						radCenterInfo.setMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" Modified Successfully");
 					}
 					radCenterInfo.setRadCenterId(radCenter.getRadCenterId());
 					radCenterInfo.setRadCenterName(radCenter.getRadCenterName());
 					radCenterResponseInfo.setCenterInfo(radCenterInfo);
 				} else {
 					ErrorData errorData = new ErrorData();
 					errorData.setErrorCode(AppConstants.ERROR_RADCENTER_SAVE);
 					errorData.setErrorMessage(messageResourceHelper.getMsgRadcenSaveErr());
 					radCenterResponseInfo.setErrorData(errorData);
 					
 				}
 				System.out.println("radCenter Created or Updated............");
 				
			}
 			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<RadCenterResponseInfo>(radCenterResponseInfo, HttpStatus.OK);
	}

}
