package com.kinsolutions.login.controller;

import javax.servlet.http.HttpSession;

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
import com.kinsolutions.login.resourceinfo.LoginInfoResource;
import com.kinsolutions.login.resourceinfo.LoginResponse;
import com.kinsolutions.login.service.LoginService;
import com.kinsolutions.model.RadCenter;
import com.kinsolutions.model.Users;
import com.kinsolutions.radcenter.service.RadCenterService;
import com.kinsolutions.utils.MessageResourceHelper;
import com.kinsolutions.utils.PasswordHashing;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
		
	@Autowired
	private RadCenterService radCenterService;
 		
	@Autowired
	private MessageResourceHelper messageResourceHelper;
	
 	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> authenticateUserLogin(@RequestBody LoginInfoResource loginInfoResource,HttpSession session) {
		LoginResponse loginResponse =  new LoginResponse();
		HeaderData headerData = new HeaderData();
		boolean isUserAuth = false;
		int responseCode = 0;
		int responseDataCount = 0;
		int businessErrCode = 0;
		String businessErrMsg = "";
		
 		try {
			System.out.println("authenticateUserLogin method Called.........");
			
			if(loginInfoResource != null && loginInfoResource.getReferenceName() != null && loginInfoResource.getPassword() != null) {
				
				String referenceName = loginInfoResource.getReferenceName();
				String password = loginInfoResource.getPassword();
				String encPwd = PasswordHashing.getEnryptedPassword(password);
 				Users users = loginService.authenticateUser(referenceName,encPwd);
				
				if(users != null){			
					System.out.println("users not null.........");
					
					Integer radCenterId = users.getRadCenterId();
					if(radCenterId != null && radCenterId > 0){
						RadCenter radCenter = radCenterService.getRadCenterByRadCenterId(radCenterId);
						
						if(radCenter != null && radCenter.getPrivilegeCd() != AppConstants.PRIVILEGECD_STATUS_ACTIVE ){
							System.out.println("Radcenter is Inactive State....");
							if(radCenter.getPrivilegeCd() == AppConstants.PRIVILEGECD_STATUS_INACTIVE) {
								responseCode = AppConstants.SUCCESS_RESONSE_CODE;
								businessErrCode = AppConstants.ERROR_RADCEN_INACTIVE;
								businessErrMsg = messageResourceHelper.getMsgRadCenInactive();							
							} else if(radCenter.getPrivilegeCd() == AppConstants.PRIVILEGECD_STATUS_DELETED) {
								responseCode = AppConstants.SUCCESS_RESONSE_CODE;
								businessErrCode = AppConstants.ERROR_RADCEN_DELETED;
								businessErrMsg = messageResourceHelper.getMsgRadCenDeleted();	
							}
						} else {
							
							isUserAuth = true;
							headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
							headerData.setResponseDataCount(1);
							headerData.setSessionId(session.getId());
							loginResponse.setHeaderData(headerData);
							
							loginInfoResource.setName(users.getName().trim());
							loginInfoResource.setUserName(users.getUsername());
							loginInfoResource.setEmailId(users.getEmailId());
							loginInfoResource.setUserId(users.getUserId());
							loginInfoResource.setEmailId(users.getEmailId().trim());
							loginInfoResource.setRoleName(users.getRoles().getRoleName().trim());
							loginInfoResource.setRoleId(users.getRoles().getRoleId());
 							loginInfoResource.setAddress(users.getAddress().trim());
							if(radCenter != null) {
								loginInfoResource.setRadCenterName(radCenter.getRadCenterName().trim());
								loginInfoResource.setRadCenterStatus(""+radCenter.getPrivilegeCd());
							}
							loginResponse.setLoginInfoData(loginInfoResource);
						}
					} else {
						// If radCenterId = -1 then it is PACS Admin else  radCenterId = 0 then PACS Accountant
 						 
						isUserAuth = true;
						headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
						headerData.setResponseDataCount(1);
						headerData.setSessionId(session.getId());
						loginResponse.setHeaderData(headerData);
						
						loginInfoResource.setName(users.getName().trim());
						loginInfoResource.setUserId(users.getUserId());
						loginInfoResource.setEmailId(users.getEmailId().trim());
						loginInfoResource.setRoleName(users.getRoles().getRoleName().trim());
						loginInfoResource.setRoleId(users.getRoles().getRoleId());
						loginInfoResource.setUserName(users.getUsername().trim());
						loginInfoResource.setAddress(users.getAddress().trim());
						loginInfoResource.setRadCenterId(radCenterId);
						loginInfoResource.setRadCenterName(null);
						loginInfoResource.setRadCenterStatus(null);
 						loginResponse.setLoginInfoData(loginInfoResource);
					}
						
				} else {
					responseCode = AppConstants.SUCCESS_RESONSE_CODE;
					businessErrCode = AppConstants.ERROR_DATA_NOTFOUND;
					businessErrMsg = messageResourceHelper.getMsgDataNotFound();
				}
			} else {
				responseCode = AppConstants.SUCCESS_RESONSE_CODE;
				businessErrCode = AppConstants.ERROR_MNDDATA_NOT_FOUND;
				businessErrMsg = messageResourceHelper.getMsgMandDataNotFound();
 			}
			
			if(!isUserAuth){
				headerData.setResponseCode(responseCode);
				headerData.setResponseDataCount(responseDataCount);
				headerData.setSessionId(session.getId());
				loginResponse.setHeaderData(headerData);
				
				ErrorData errorData = new ErrorData();
				errorData.setErrorCode(businessErrCode);
				errorData.setErrorMessage(businessErrMsg);
				loginResponse.setErrorData(errorData);
			}
			
		} catch (Exception e) {
 			e.printStackTrace();
		}
 		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
 	}
	
	

}
