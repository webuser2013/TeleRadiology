package com.kinsolutions.radcenter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;
import com.kinsolutions.baseinfo.ObjectInfo;
import com.kinsolutions.common.Service.FileStorageService;
import com.kinsolutions.common.validator.FileValidator;
import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.RadCenter;
import com.kinsolutions.model.Users;
import com.kinsolutions.radcenter.resourceInfo.RadCenterCrMdReqInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterCrMdResInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterListResInfo;
import com.kinsolutions.radcenter.resourceInfo.RadCenterResInfo;
import com.kinsolutions.radcenter.service.RadCenterService;
import com.kinsolutions.users.resourceInfo.UsersInfo;
import com.kinsolutions.users.resourceInfo.UsersResInfo;
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
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@Autowired
    private FileValidator fileValidator;
	
	
	@RequestMapping(value = "/saveOrUpdateRadCenter", method = RequestMethod.POST)
	public ResponseEntity<RadCenterCrMdResInfo> saveOrUpdateRadCenter(@RequestBody RadCenterCrMdReqInfo radCenterCrMdReqInfo) {
		RadCenterCrMdResInfo radCenterResponseInfo = new RadCenterCrMdResInfo();
		RadCenter radCenter = null;
		ObjectInfo objectInfo = new ObjectInfo();
		Users users = null;
 		HeaderData headerData = new HeaderData();
		boolean isNewMode = true;
		try {
			
			if(radCenterCrMdReqInfo != null){
 				if(radCenterCrMdReqInfo.getRadCenterId() != null && radCenterCrMdReqInfo.getRadCenterId() != null && new Integer(radCenterCrMdReqInfo.getRadCenterId()) > 0){
					//Update Object
					radCenter = radCenterService.getRadCenterByRadCenterId(new Integer(radCenterCrMdReqInfo.getRadCenterId()));
					if(radCenter != null) {
						radCenter.setRadCenterName(radCenterCrMdReqInfo.getRadCenterName());
						users = userService.getUserByUserId(radCenterCrMdReqInfo.getUserId());
						if(users != null){						
							radCenter.setUsers(users);
						}	
						radCenter.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
						radCenter.setSecurityDeposit(radCenterCrMdReqInfo.getSecurityDeposit());
						radCenter.setDeploymentFee(radCenterCrMdReqInfo.getDeploymentFee());
						if(radCenterCrMdReqInfo.getSiteCount() != null){							
							radCenter.setSiteCount(new Integer(radCenterCrMdReqInfo.getSiteCount()));
						}
						if(radCenterCrMdReqInfo.getRadiologistCount() != null){							
							radCenter.setRadiologistCount(new Integer(radCenterCrMdReqInfo.getRadiologistCount()));
						}
						if(radCenterCrMdReqInfo.getModalityCount() != null){
							radCenter.setModalityCount(new Integer(radCenterCrMdReqInfo.getModalityCount()));
						}
						radCenter.setModeOfCharge(radCenterCrMdReqInfo.getModeOfCharge());
						radCenter.setCtcharge(radCenterCrMdReqInfo.getCtcharge());
						radCenter.setMriCharge(radCenterCrMdReqInfo.getMriCharge());
						radCenter.setxRayCrCharge(radCenterCrMdReqInfo.getxRayCrCharge());
						radCenter.setMammogramCharge(radCenterCrMdReqInfo.getMammogramcharge());
						radCenter.setServerRam(radCenterCrMdReqInfo.getServerRam());
						radCenter.setServerCoreCount(radCenterCrMdReqInfo.getServerCoreCount());
						radCenter.setServerStorage(radCenterCrMdReqInfo.getServerStorage());
						radCenter.setServerMonthlyCharges(radCenterCrMdReqInfo.getServerMonthlyCharges());
 						radCenter.setCreatedIpAddress("000.000");
						radCenter.setModifiedIpAddress("000.000");
						isNewMode = false;
					}
					
				} else {
					//Create Object
					radCenter = new RadCenter();
					radCenter.setRadCenterName(radCenterCrMdReqInfo.getRadCenterName());
					System.out.println("radCenterCrMdReqInfo.getRadCenterId()>>>>>>>>"+radCenterCrMdReqInfo.getUserId());
 					users = userService.getUserByUserId(new Integer(radCenterCrMdReqInfo.getUserId()));
					if(users != null){						
						radCenter.setUsers(users);
					}	
					radCenter.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
					radCenter.setSecurityDeposit(radCenterCrMdReqInfo.getSecurityDeposit());
					radCenter.setDeploymentFee(radCenterCrMdReqInfo.getDeploymentFee());
					if(radCenterCrMdReqInfo.getSiteCount() != null){							
						radCenter.setSiteCount(new Integer(radCenterCrMdReqInfo.getSiteCount()));
					}
					if(radCenterCrMdReqInfo.getRadiologistCount() != null){							
						radCenter.setRadiologistCount(new Integer(radCenterCrMdReqInfo.getRadiologistCount()));
					}
					if(radCenterCrMdReqInfo.getModalityCount() != null){
						radCenter.setModalityCount(new Integer(radCenterCrMdReqInfo.getModalityCount()));
					}
					radCenter.setModeOfCharge(radCenterCrMdReqInfo.getModeOfCharge());
					radCenter.setCtcharge(radCenterCrMdReqInfo.getCtcharge());
					radCenter.setMriCharge(radCenterCrMdReqInfo.getMriCharge());
					radCenter.setxRayCrCharge(radCenterCrMdReqInfo.getxRayCrCharge());
					radCenter.setMammogramCharge(radCenterCrMdReqInfo.getMammogramcharge());
					radCenter.setServerRam(radCenterCrMdReqInfo.getServerRam());
					radCenter.setServerCoreCount(radCenterCrMdReqInfo.getServerCoreCount());
					radCenter.setServerStorage(radCenterCrMdReqInfo.getServerStorage());
					radCenter.setServerMonthlyCharges(radCenterCrMdReqInfo.getServerMonthlyCharges());					
					radCenter.setCreatedIpAddress("000.000");
					radCenter.setModifiedIpAddress("000.000");
									
				}
 				
 				radCenter = radCenterService.saveOrUpdateRadCenter(radCenter);
 				if(radCenter != null){
 					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					radCenterResponseInfo.setHeaderData(headerData);
 					objectInfo.setObjectId(radCenter.getRadCenterId());
 					if(isNewMode) {
 						objectInfo.setActionType(AppConstants.OJB_ACTION_CREATE);
 						objectInfo.setObjectStatusMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" Created Successfully");
 					} else {
 						objectInfo.setActionType(AppConstants.OJB_ACTION_UPDATE);
 						objectInfo.setObjectStatusMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" Modified Successfully");
 					}
 					objectInfo.setObjectName(radCenter.getRadCenterName());
 					objectInfo.setObjectType(AppConstants.OJB_RADCENTER_TYPENAME);
 					radCenterResponseInfo.setObjectInfo(objectInfo);
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
		
		return new ResponseEntity<RadCenterCrMdResInfo>(radCenterResponseInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/uploadPurchaseOrder/{radCenterId}/{radCenterName}", method = RequestMethod.POST)
	public ResponseEntity<RadCenterCrMdResInfo> uploadPurchaseOrder(@RequestParam("file") MultipartFile file,@PathVariable Integer radCenterId,@PathVariable String radCenterName) {
 		RadCenterCrMdResInfo radCenterCrMdResInfo= new RadCenterCrMdResInfo();
		ObjectInfo objectInfo = new ObjectInfo();		
 		HeaderData headerData = new HeaderData();
 		try {
			System.out.println("uploadPurchaseOrder>>>>>>>>>>>>>>>>>>>");
			 if(file != null){
				 
				 boolean isPdfFile = fileValidator.isPdfFileFormat(file);
				 if(isPdfFile){
					 boolean isFileSizeExceed = fileValidator.isFileSizeExceed(file);
					 if(!isFileSizeExceed){
						 String uploadPath = AppConstants.FILE_UPD_BASEPATH+AppConstants.RADCENTER_PO_FILEPATH+"RadCen-"+radCenterId+"//";
						 System.out.println("uploadPath>>>>>"+uploadPath);
						 String fileName = fileStorageService.storeFile(file,uploadPath);
						 System.out.println("Uploaded File ......."+fileName);
						 
						 headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
	 					 headerData.setResponseDataCount(1);
	 					 radCenterCrMdResInfo.setHeaderData(headerData);
	 					 objectInfo.setObjectId(radCenterId);
	 					 objectInfo.setObjectType(AppConstants.OJB_RADCENTER_TYPENAME);
	 					 objectInfo.setObjectName(fileName);
	 					 objectInfo.setActionType(AppConstants.OJB_ACTION_UPLOAD);
	 					 objectInfo.setObjectStatusMessage(messageResourceHelper.getMsgRadCenUpdPurchaseOrder());
	 					 radCenterCrMdResInfo.setObjectInfo(objectInfo);
	 					 
	 					RadCenter radCenter = radCenterService.getRadCenterByRadCenterId(radCenterId);
	 					
	 					if(radCenter != null){
	 						String fileFullPath = uploadPath+fileName;
	 						System.out.println("fileFullPath?>>>>>>>>"+fileFullPath);
	 						byte[] fileObjInBytes = AppHelper.getFileObject(fileFullPath);
	 						System.out.println("fileObjInBytes...passed.");
	 						radCenter.setPurchaseOrderCopy(fileObjInBytes);
	 						System.out.println("fileNam>>>>>"+fileName+" uploadPath>>>>"+uploadPath);
	 						radCenter.setFileName(fileName);
	 						radCenter.setFilePath(uploadPath);
	 						radCenterService.saveOrUpdateRadCenter(radCenter);
	 						System.out.println("Radcenter PO object Updated Successfully.....");
	 					}
	 					
					 } else {
						ErrorData errorData = new ErrorData();
						errorData.setErrorCode(AppConstants.ERROR_RADCENTER_UPDPOSIZE);
						errorData.setErrorMessage(messageResourceHelper.getMsgRadcenUpdPurchaseOrderSizEerr());
						radCenterCrMdResInfo.setErrorData(errorData);
					 }
					 
				 } else {
					ErrorData errorData = new ErrorData();
					errorData.setErrorCode(AppConstants.ERROR_RADCENTER_UPDPO);
					errorData.setErrorMessage(messageResourceHelper.getMsgRadcenUpdPurChaseOrderErr());
					radCenterCrMdResInfo.setErrorData(errorData);
				 }
				 
			 } else {
				ErrorData errorData = new ErrorData();
				errorData.setErrorCode(AppConstants.ERROR_RADCENTER_UPDPO);
				errorData.setErrorMessage(messageResourceHelper.getMsgRadcenUpdPurChaseOrderErr());
				radCenterCrMdResInfo.setErrorData(errorData);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<RadCenterCrMdResInfo>(radCenterCrMdResInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/downloadPurchaseOrder/{radCenterId}/", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadPurchaseOrder(@PathVariable Integer radCenterId) {
		RadCenter radCenter = null;
 		HttpHeaders header = new HttpHeaders();
		long purchaseOrderFilesize = 0;
		InputStreamResource resource = null;
		try {
			System.out.println("downloadPurchaseOrder>>>>>>>>>>");
			radCenter =  radCenterService.getRadCenterByRadCenterId(radCenterId);
			if(radCenter != null){
				 System.out.println("radCenter.getFilePath()>>>>>>>>>>"+radCenter.getFilePath()+" >>>radCenter.getFileName()>>>>"+radCenter.getFileName());
				 String purchaseOrderFilePath = null;
				 if(radCenter.getFilePath() != null && radCenter.getFileName() != null){
					 purchaseOrderFilePath = radCenter.getFilePath().trim()+radCenter.getFileName().trim();
				 }
				 System.out.println("purchaseOrderFilePath>>>>>>>>>>"+purchaseOrderFilePath);
				 if(purchaseOrderFilePath != null){					 
					 File purchaseOrderFile = new File(purchaseOrderFilePath); 
					 resource = new InputStreamResource(new FileInputStream(purchaseOrderFile));
					 purchaseOrderFilesize = purchaseOrderFile.length();
					 header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+radCenter.getFileName());
					 header.add("Cache-Control", "no-cache, no-store, must-revalidate");
					 header.add("Pragma", "no-cache");
					 header.add("Expires", "0");
				 }
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println("Download.........");
		return ResponseEntity.ok().headers(header).contentLength(purchaseOrderFilesize).contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}
	
	
	@RequestMapping(value = "/activateDeactivateRadCenter/{radCenterId}/{activationFlag}", method = RequestMethod.GET)
	public ResponseEntity<RadCenterCrMdResInfo> activateDeactivateRadCenter(@PathVariable Integer radCenterId,@PathVariable int activationFlag) {
		RadCenter radCenter = null;
		RadCenterCrMdResInfo radCenterResponseInfo = new RadCenterCrMdResInfo();
		HeaderData headerData = new HeaderData();
		ObjectInfo objectInfo = new ObjectInfo();
		try {
			if(radCenterId != null && radCenterId > 0){
				radCenter =  radCenterService.getRadCenterByRadCenterId(radCenterId);
				ErrorData errorData = new ErrorData();
				if(radCenter != null && radCenter.getPrivilegeCd() != AppConstants.PRIVILEGECD_STATUS_DELETED){					
					if(activationFlag == AppConstants.ENTITY_ACTIVATE_FLAG){
						radCenter.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
					} else {
						radCenter.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_INACTIVE);
					}
					radCenter = radCenterService.saveOrUpdateRadCenter(radCenter);
					
					if(radCenter != null){
						headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
						headerData.setResponseDataCount(1);
						radCenterResponseInfo.setHeaderData(headerData);
						objectInfo.setObjectId(radCenter.getRadCenterId());
						objectInfo.setActionType(AppConstants.OJB_ACTION_UPDATE);
						objectInfo.setObjectType(AppConstants.OJB_RADCENTER_TYPENAME);
						objectInfo.setObjectName(radCenter.getRadCenterName());
						if(radCenter.getPrivilegeCd() == AppConstants.PRIVILEGECD_STATUS_ACTIVE){ 						
							objectInfo.setObjectStatusMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" Activated Successfully");
						} else{
							objectInfo.setObjectStatusMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" DeActivated Successfully");
						}
						radCenterResponseInfo.setObjectInfo(objectInfo);
					}  else {
						errorData.setErrorCode(AppConstants.ERROR_RADCENTER_SAVE);
						errorData.setErrorMessage(messageResourceHelper.getMsgRadcenDeactivateErr());
						radCenterResponseInfo.setErrorData(errorData);
						
					}
				} else {
					errorData.setErrorCode(AppConstants.ERROR_RADCENTER_SAVE);
					errorData.setErrorMessage(messageResourceHelper.getMsgRadcenDeactivateErr());
					radCenterResponseInfo.setErrorData(errorData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<RadCenterCrMdResInfo>(radCenterResponseInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteRadCenter/{radCenterId}/", method = RequestMethod.GET)
	public ResponseEntity<RadCenterCrMdResInfo> deleteRadCenter(@PathVariable Integer radCenterId) {
		RadCenter radCenter = null;
		RadCenterCrMdResInfo radCenterResponseInfo = new RadCenterCrMdResInfo();
		HeaderData headerData = new HeaderData();
		ObjectInfo objectInfo = new ObjectInfo();
		try {
			if(radCenterId != null && radCenterId > 0){
				radCenter =  radCenterService.getRadCenterByRadCenterId(radCenterId);
				radCenter.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_DELETED);
				radCenter = radCenterService.saveOrUpdateRadCenter(radCenter);
				
				if(radCenter != null){
					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					radCenterResponseInfo.setHeaderData(headerData);
 					objectInfo.setObjectId(radCenter.getRadCenterId());
 					objectInfo.setActionType(AppConstants.OJB_ACTION_DELETE);
 					objectInfo.setObjectType(AppConstants.OJB_RADCENTER_TYPENAME);
 					objectInfo.setObjectName(radCenter.getRadCenterName());
 					if(radCenter.getPrivilegeCd() == AppConstants.PRIVILEGECD_STATUS_DELETED){ 						
 						objectInfo.setObjectStatusMessage("RadCenter " + ( (radCenter != null ) ? radCenter.getRadCenterName() : "") +" Deleted Successfully");
 					} 
 					radCenterResponseInfo.setObjectInfo(objectInfo);
				}  else {
 					ErrorData errorData = new ErrorData();
 					errorData.setErrorCode(AppConstants.ERROR_RADCEN_DELETED);
 					errorData.setErrorMessage(messageResourceHelper.getMsgRadcenDeleteErr());
 					radCenterResponseInfo.setErrorData(errorData);
 					
 				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<RadCenterCrMdResInfo>(radCenterResponseInfo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getRadCenterByRadCenterId/{radCenterId}/", method = RequestMethod.GET)
	public ResponseEntity<RadCenterResInfo> getRadCenterByRadCenterId(@PathVariable Integer radCenterId) {
		RadCenter radCenter = null;
		RadCenterResInfo radCenterResInfo = new RadCenterResInfo();
		RadCenterInfo radCenterInfo = new RadCenterInfo();
		HeaderData headerData = new HeaderData();
 		
		try {
			if(radCenterId != null && radCenterId > 0){
				radCenter =  radCenterService.getRadCenterByRadCenterId(radCenterId);
				
				if(radCenter != null){
					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					radCenterResInfo.setHeaderData(headerData);
 					 
 					radCenterInfo.setRadCenterId(radCenter.getRadCenterId());
 					radCenterInfo.setRadCenterName(radCenter.getRadCenterName());
 					if(radCenter.getUsers() != null){						
 						radCenterInfo.setUserId(radCenter.getUsers().getUserId());
 						radCenterInfo.setUsername(radCenter.getUsers().getName());
					}	
 					radCenterInfo.setPrivilegeCd(radCenter.getPrivilegeCd());
 					radCenterInfo.setSecurityDeposit(radCenter.getSecurityDeposit());
 					radCenterInfo.setDeploymentFee(radCenter.getDeploymentFee());
 					radCenterInfo.setSiteCount(radCenter.getSiteCount());
 					radCenterInfo.setRadiologistCount(radCenter.getRadiologistCount());
 					radCenterInfo.setModalityCount(radCenter.getModalityCount());
 					radCenterInfo.setModeOfCharge(radCenter.getModeOfCharge());
 					radCenterInfo.setCtcharge(radCenter.getCtcharge());
 					radCenterInfo.setMriCharge(radCenter.getMriCharge());
 					radCenterInfo.setxRayCrCharge(radCenter.getxRayCrCharge());
					radCenterInfo.setMammogramCharge(radCenter.getMammogramCharge());
					radCenterInfo.setServerRam(radCenter.getServerRam());
					radCenterInfo.setServerCoreCount(radCenter.getServerCoreCount());
					radCenterInfo.setServerStorage(radCenter.getServerStorage());
					radCenterInfo.setServerMonthlyCharges(radCenter.getServerMonthlyCharges());
					radCenterInfo.setFileName("tests.png");
					radCenterInfo.setFilePath("/apps/test/");
					radCenterInfo.setCreatedIpAddress("000.000");
					radCenterInfo.setModifiedIpAddress("000.000");
 					
  					radCenterResInfo.setRadCenterInfo(radCenterInfo);
				}  else {
 					ErrorData errorData = new ErrorData();
 					errorData.setErrorCode(AppConstants.ERROR_RADCENTER_READ);
 					errorData.setErrorMessage(messageResourceHelper.getMsgRadcenReadErr());
 					radCenterResInfo.setErrorData(errorData);
  				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<RadCenterResInfo>(radCenterResInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllUsers/{loggedInUserId}/", method = RequestMethod.GET)
	public ResponseEntity<UsersResInfo> getAllUsers(@PathVariable Integer loggedInUserId) {
 		UsersResInfo usersResInfo = new UsersResInfo();
		HeaderData headerData = new HeaderData();
 		List<Users> usersList = new ArrayList<Users>(); 
 		List<UsersInfo> usersInfoList = new ArrayList<UsersInfo>();
 		try {
			if(loggedInUserId != null && loggedInUserId > 0){
				Users users = userService.getAllUsers(loggedInUserId);
				if(users != null) {	
					
					if(users.getPrivilegeCd() != AppConstants.PRIVILEGECD_STATUS_DELETED) {						
						usersList = userService.getAllActiveInActiveExceptLoggedInUsers(loggedInUserId);
						if(usersList != null && usersList.size() > 0){
							headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
							headerData.setResponseDataCount(usersList.size());
							usersResInfo.setHeaderData(headerData);
							
							for (int i = 0; i < usersList.size(); i++) {
								UsersInfo usersInfo = new UsersInfo();
								usersInfo.setUserId(usersList.get(i).getUserId());
								usersInfo.setName(usersList.get(i).getName());
								usersInfo.setAddress(usersList.get(i).getAddress());
								usersInfo.setEmailId(usersList.get(i).getEmailId());
								usersInfo.setMobileNumber(usersList.get(i).getMobileNumber());
								usersInfo.setAlternativeNumber(usersList.get(i).getAlternativeMobileNumber());
								usersInfo.setPincode(usersList.get(i).getPincode());
								usersInfoList.add(usersInfo);
							}
							usersResInfo.setUsersInfoList(usersInfoList);
						} else{
							ErrorData errorData = new ErrorData();
							errorData.setErrorCode(AppConstants.ERROR_USER_DELETED);
							errorData.setErrorMessage(messageResourceHelper.getMsgUserDeleted());
							usersResInfo.setErrorData(errorData);
						}
					} else{
						ErrorData errorData = new ErrorData();
						errorData.setErrorCode(AppConstants.ERROR_USER_DELETED);
						errorData.setErrorMessage(messageResourceHelper.getMsgUserDeleted());
						usersResInfo.setErrorData(errorData);
					}
				} else {
 					ErrorData errorData = new ErrorData();
					errorData.setErrorCode(AppConstants.ERROR_USER_NOTFOUND);
					errorData.setErrorMessage(messageResourceHelper.getMsgUserNotFound());
					usersResInfo.setErrorData(errorData);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UsersResInfo>(usersResInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllRadCenter", method = RequestMethod.GET)
	public ResponseEntity<RadCenterListResInfo> getAllRadCenter() {
		RadCenterListResInfo radCenterListResInfoObj =  new RadCenterListResInfo();;
		RadCenterInfo radCenterInfo = null;
		List<RadCenterInfo> radCenterInfoList = new ArrayList<RadCenterInfo>();
		HeaderData headerData = new HeaderData();
		
		try {
			List<RadCenter> radCentersDetailList = radCenterService.getAllRadCenter();
			
			if(radCentersDetailList != null && radCentersDetailList.size() > 0){
				radCenterListResInfoObj =  new RadCenterListResInfo();
				headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
				headerData.setResponseDataCount(radCentersDetailList.size());
				radCenterListResInfoObj.setHeaderData(headerData);
				
				for (RadCenter radCenter : radCentersDetailList) {
					radCenterInfo =  new RadCenterInfo();
					
					radCenterInfo.setRadCenterId(radCenter.getRadCenterId());
					radCenterInfo.setRadCenterName(radCenter.getRadCenterName());
					if(radCenter.getUsers() != null){						
						radCenterInfo.setUserId(radCenter.getUsers().getUserId());
						radCenterInfo.setUsername(radCenter.getUsers().getName());
					}	
					radCenterInfo.setPrivilegeCd(radCenter.getPrivilegeCd());
					radCenterInfo.setSecurityDeposit(radCenter.getSecurityDeposit());
					radCenterInfo.setDeploymentFee(radCenter.getDeploymentFee());
					radCenterInfo.setSiteCount(radCenter.getSiteCount());
					radCenterInfo.setRadiologistCount(radCenter.getRadiologistCount());
					radCenterInfo.setModalityCount(radCenter.getModalityCount());
					radCenterInfo.setModeOfCharge(radCenter.getModeOfCharge());
					radCenterInfo.setCtcharge(radCenter.getCtcharge());
					radCenterInfo.setMriCharge(radCenter.getMriCharge());
					radCenterInfo.setxRayCrCharge(radCenter.getxRayCrCharge());
					radCenterInfo.setMammogramCharge(radCenter.getMammogramCharge());
					radCenterInfo.setServerRam(radCenter.getServerRam());
					radCenterInfo.setServerCoreCount(radCenter.getServerCoreCount());
					radCenterInfo.setServerStorage(radCenter.getServerStorage());
					radCenterInfo.setServerMonthlyCharges(radCenter.getServerMonthlyCharges());
					radCenterInfo.setFileName("tests.png");
					radCenterInfo.setFilePath("/apps/test/");
					radCenterInfo.setCreatedIpAddress("000.000");
					radCenterInfo.setModifiedIpAddress("000.000");
					radCenterInfoList.add(radCenterInfo);
				}
				radCenterListResInfoObj.setRadCenterInfoList(radCenterInfoList);
			} else{
				ErrorData errorData = new ErrorData();
				errorData.setErrorCode(AppConstants.ERROR_RADCENTER_NOTFOUND);
				errorData.setErrorMessage(messageResourceHelper.getMsgDataNotFound());
				radCenterListResInfoObj.setErrorData(errorData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<RadCenterListResInfo>(radCenterListResInfoObj, HttpStatus.OK);
		
	}
}
