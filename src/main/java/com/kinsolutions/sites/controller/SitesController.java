package com.kinsolutions.sites.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;
import com.kinsolutions.baseinfo.ObjectInfo;
import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.Sites;
import com.kinsolutions.sites.resourceinfo.SiteCrMdReqInfo;
import com.kinsolutions.sites.resourceinfo.SiteCrMdResInfo;
import com.kinsolutions.sites.resourceinfo.SiteInfo;
import com.kinsolutions.sites.resourceinfo.SiteListResInfo;
import com.kinsolutions.sites.resourceinfo.SiteResInfo;
import com.kinsolutions.sites.service.SitesService;
import com.kinsolutions.utils.MessageResourceHelper;

@RestController
@RequestMapping("/Sites")
public class SitesController {
	
	@Autowired
	private SitesService sitesService;
	
	@Autowired
	private MessageResourceHelper messageResourceHelper;
	
	@RequestMapping(value = "/saveOrUpdateSite", method = RequestMethod.POST)
	public ResponseEntity<SiteCrMdResInfo> saveOrUpdateSites(@RequestBody SiteCrMdReqInfo sitesCrMdReqInfo) {
		SiteCrMdResInfo siteCrMdResInfo = new SiteCrMdResInfo();
		Sites sites = null;
		ObjectInfo objectInfo = new ObjectInfo();
 		HeaderData headerData = new HeaderData();
		boolean isNewMode = true;
		try {
			if(sitesCrMdReqInfo != null){
 				if(sitesCrMdReqInfo.getSiteId() != null && sitesCrMdReqInfo.getSiteId() != null && new Integer(sitesCrMdReqInfo.getSiteId()) > 0){
					//Update Object
 					sites = sitesService.getSiteBySiteId(sitesCrMdReqInfo.getSiteId());
 					
 					if(sites != null){
 						sites.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
 						sites.setSiteCode(sitesCrMdReqInfo.getSiteCode());
 						sites.setSiteName(sitesCrMdReqInfo.getSiteName());
 						sites.setSiteAddress(sitesCrMdReqInfo.getSiteAddress());
 						sites.setSitePincode(sitesCrMdReqInfo.getPincode());
 						sites.setMemberShipType(sitesCrMdReqInfo.getMembershipCode());
 						sites.setCreatedIpAddress("000.000");
 						sites.setModifiedIpAddress("000.000"); 						
 						isNewMode = false;
 					}
 				} else {
 					//Create Object
 					sites = new Sites();
 					sites.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
					sites.setSiteCode(sitesCrMdReqInfo.getSiteCode());
					sites.setSiteName(sitesCrMdReqInfo.getSiteName());
					sites.setSiteAddress(sitesCrMdReqInfo.getSiteAddress());
					sites.setSitePincode(sitesCrMdReqInfo.getPincode());
					sites.setMemberShipType(sitesCrMdReqInfo.getMembershipCode());
					sites.setCreatedIpAddress("000.000");
					sites.setModifiedIpAddress("000.000"); 	
 				}
 				
 				sites = sitesService.saveOrUpdateSites(sites);
 				if(sites != null){
 					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					siteCrMdResInfo.setHeaderData(headerData);
 					objectInfo.setObjectId(sites.getSiteId());
 					if(isNewMode) {
 						objectInfo.setActionType(AppConstants.OJB_ACTION_CREATE);
 						objectInfo.setObjectStatusMessage("Site " + ( (sites != null ) ? sites.getSiteName() : "") +" Created Successfully");
 					} else {
 						objectInfo.setActionType(AppConstants.OJB_ACTION_UPDATE);
 						objectInfo.setObjectStatusMessage("Site " + ( (sites != null ) ? sites.getSiteName() : "") +" Modified Successfully");
 					}
 					objectInfo.setObjectName(sites.getSiteName());
 					objectInfo.setObjectType(AppConstants.OJB_SITES_TYPENAME);
 					siteCrMdResInfo.setObjectInfo(objectInfo);
 				} else {
 					ErrorData errorData = new ErrorData();
 					errorData.setErrorCode(AppConstants.ERROR_SITE_SAVE);
 					errorData.setErrorMessage(messageResourceHelper.getMsgSiteSaveErr());
 					siteCrMdResInfo.setErrorData(errorData);
 					
 				}
 				System.out.println("Site Created or Updated............");
 				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SiteCrMdResInfo>(siteCrMdResInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/activateDeactivateSite/{siteId}/{activationFlag}", method = RequestMethod.GET)
	public ResponseEntity<SiteCrMdResInfo> activateDeactivateSite(@PathVariable Integer siteId,@PathVariable int activationFlag) {
		Sites sites = null;
		SiteCrMdResInfo siteCrMdResInfo = new SiteCrMdResInfo();
		HeaderData headerData = new HeaderData();
		ObjectInfo objectInfo = new ObjectInfo();
		try {
			if(siteId != null && siteId > 0){
				sites =  sitesService.getSiteBySiteId(siteId);
				ErrorData errorData = new ErrorData();
				if(sites != null && sites.getPrivilegeCd() != AppConstants.PRIVILEGECD_STATUS_DELETED){					
					if(activationFlag == AppConstants.ENTITY_ACTIVATE_FLAG){
						sites.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
					} else {
						sites.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_INACTIVE);
					}
					sites = sitesService.saveOrUpdateSites(sites);
					
					if(sites != null){
						headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
						headerData.setResponseDataCount(1);
						siteCrMdResInfo.setHeaderData(headerData);
						objectInfo.setObjectId(sites.getSiteId());
						objectInfo.setActionType(AppConstants.OJB_ACTION_UPDATE);
						objectInfo.setObjectType(AppConstants.OJB_SITES_TYPENAME);
						objectInfo.setObjectName(sites.getSiteName());
						if(sites.getPrivilegeCd() == AppConstants.PRIVILEGECD_STATUS_ACTIVE){ 						
							objectInfo.setObjectStatusMessage("Site " + ( (sites != null ) ? sites.getSiteName() : "") +" Activated Successfully");
						} else{
							objectInfo.setObjectStatusMessage("Site " + ( (sites != null ) ? sites.getSiteName() : "") +" DeActivated Successfully");
						}
						siteCrMdResInfo.setObjectInfo(objectInfo);
					}  else {
						errorData.setErrorCode(AppConstants.ERROR_SITE_SAVE);
						errorData.setErrorMessage(messageResourceHelper.getMsgSiteDeactivateErr());
						siteCrMdResInfo.setErrorData(errorData);
						
					}
				} else {
					errorData.setErrorCode(AppConstants.ERROR_SITE_SAVE);
					errorData.setErrorMessage(messageResourceHelper.getMsgSiteDeactivateErr());
					siteCrMdResInfo.setErrorData(errorData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SiteCrMdResInfo>(siteCrMdResInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteSite/{siteId}/", method = RequestMethod.GET)
	public ResponseEntity<SiteCrMdResInfo> deleteSite(@PathVariable Integer siteId) {
		Sites site = null;
		SiteCrMdResInfo siteCrMdResInfo = new SiteCrMdResInfo();
		HeaderData headerData = new HeaderData();
		ObjectInfo objectInfo = new ObjectInfo();
		try {
			if(siteId != null && siteId > 0){
				site =  sitesService.getSiteBySiteId(siteId);
				site.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_DELETED);
				site = sitesService.saveOrUpdateSites(site);
				
				if(site != null){
					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					siteCrMdResInfo.setHeaderData(headerData);
 					objectInfo.setObjectId(site.getSiteId());
 					objectInfo.setActionType(AppConstants.OJB_ACTION_DELETE);
 					objectInfo.setObjectType(AppConstants.OJB_SITES_TYPENAME);
 					objectInfo.setObjectName(site.getSiteName());
 					if(site.getPrivilegeCd() == AppConstants.PRIVILEGECD_STATUS_DELETED){ 						
 						objectInfo.setObjectStatusMessage("Site " + ( (site != null ) ? site.getSiteName() : "") +" Deleted Successfully");
 					} 
 					siteCrMdResInfo.setObjectInfo(objectInfo);
				}  else {
 					ErrorData errorData = new ErrorData();
 					errorData.setErrorCode(AppConstants.ERROR_SITE_DELETED);
 					errorData.setErrorMessage(messageResourceHelper.getMsgSiteDeleteErr());
 					siteCrMdResInfo.setErrorData(errorData);
 					
 				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SiteCrMdResInfo>(siteCrMdResInfo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getSiteBySiteId/{siteId}/", method = RequestMethod.GET)
	public ResponseEntity<SiteResInfo> getSiteBySiteId(@PathVariable Integer siteId) {
		Sites site = null;
		SiteResInfo siteResInfo = new SiteResInfo();
		SiteInfo siteInfo = new SiteInfo();
		HeaderData headerData = new HeaderData();
 		
		try {
			if(siteId != null && siteId > 0){
				site =  sitesService.getSiteBySiteId(siteId);
				
				if(site != null){
					headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
 					headerData.setResponseDataCount(1);
 					siteResInfo.setHeaderData(headerData);
 					 
 					siteInfo.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
 					siteInfo.setSiteCode(site.getSiteCode());
 					siteInfo.setSiteName(site.getSiteName());
 					siteInfo.setSiteAddress(site.getSiteAddress());
 					siteInfo.setSitePincode(site.getSitePincode());
 					siteInfo.setMemberShipType(site.getMemberShipType());
 					
  					siteResInfo.setSiteInfo(siteInfo);
				}  else {
 					ErrorData errorData = new ErrorData();
 					errorData.setErrorCode(AppConstants.ERROR_SITE_READ);
 					errorData.setErrorMessage(messageResourceHelper.getMsgSiteReadErr());
 					siteResInfo.setErrorData(errorData);
  				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SiteResInfo>(siteResInfo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getAllSites", method = RequestMethod.GET)
	public ResponseEntity<SiteListResInfo> getAllSites() {
		SiteListResInfo siteListResInfoObj =  new SiteListResInfo();
		SiteInfo siteInfo = null;
		List<SiteInfo> sitesInfoList = new ArrayList<SiteInfo>();
		HeaderData headerData = new HeaderData();
		
		try {
			List<Sites> sitesList = sitesService.getAllSites();
			
			if(sitesList != null && sitesList.size() > 0){
				siteListResInfoObj =  new SiteListResInfo();
				headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
				headerData.setResponseDataCount(sitesList.size());
				siteListResInfoObj.setHeaderData(headerData);
				
				for (Sites site : sitesList) {
					siteInfo =  new SiteInfo();
					siteInfo.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
					siteInfo.setSiteCode(site.getSiteCode());
					siteInfo.setSiteName(site.getSiteName());
					siteInfo.setSiteAddress(site.getSiteAddress());
					siteInfo.setSitePincode(site.getSitePincode());
					siteInfo.setMemberShipType(site.getMemberShipType());
					 
					sitesInfoList.add(siteInfo);
				}
				siteListResInfoObj.setSiteInfoList(sitesInfoList);
			} else{
				ErrorData errorData = new ErrorData();
				errorData.setErrorCode(AppConstants.ERROR_SITE_NOTFOUND);
				errorData.setErrorMessage(messageResourceHelper.getMsgDataNotFound());
				siteListResInfoObj.setErrorData(errorData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<SiteListResInfo>(siteListResInfoObj, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getSiteBySiteInfo/siteName/{siteName}/membershiptype/{memberShiptype}/privilegeCd/{privilegeCd}", method = RequestMethod.GET)
	public ResponseEntity<SiteListResInfo> getSitesBySiteInfo(@PathVariable String siteName,@PathVariable String memberShiptype,@PathVariable int privilegeCd) {
		SiteListResInfo siteListResInfoObj = new SiteListResInfo();;
		SiteInfo siteInfo = null;
		List<SiteInfo> sitesInfoList = new ArrayList<SiteInfo>();
		HeaderData headerData = new HeaderData();
		
		try {
			List<Sites> sitesList = sitesService.getSiteBySiteInfo(siteName, memberShiptype, privilegeCd);
			
			if(sitesList != null && sitesList.size() > 0){
				headerData.setResponseCode(AppConstants.SUCCESS_RESONSE_CODE);
				headerData.setResponseDataCount(sitesList.size());
				siteListResInfoObj.setHeaderData(headerData);
				
				for (Sites site : sitesList) {
					siteInfo =  new SiteInfo();
					siteInfo.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
					siteInfo.setSiteCode(site.getSiteCode());
					siteInfo.setSiteName(site.getSiteName());
					siteInfo.setSiteAddress(site.getSiteAddress());
					siteInfo.setSitePincode(site.getSitePincode());
					siteInfo.setMemberShipType(site.getMemberShipType());
					 
					sitesInfoList.add(siteInfo);
				}
				siteListResInfoObj.setSiteInfoList(sitesInfoList);
			} else{
				ErrorData errorData = new ErrorData();
				errorData.setErrorCode(AppConstants.ERROR_SITE_NOTFOUND);
				errorData.setErrorMessage(messageResourceHelper.getMsgDataNotFound());
				siteListResInfoObj.setErrorData(errorData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<SiteListResInfo>(siteListResInfoObj, HttpStatus.OK);
		
	}

}
