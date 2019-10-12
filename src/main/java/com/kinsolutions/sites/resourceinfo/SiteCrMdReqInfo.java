package com.kinsolutions.sites.resourceinfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SiteCrMdReqInfo implements Serializable {
	
    private Integer siteId;  
	private String siteCode;
	private String siteName;
	private Integer pincode;
	private String membershipCode;
	private String siteAddress;
	
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getMembershipCode() {
		return membershipCode;
	}
	public void setMembershipCode(String membershipCode) {
		this.membershipCode = membershipCode;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
}
