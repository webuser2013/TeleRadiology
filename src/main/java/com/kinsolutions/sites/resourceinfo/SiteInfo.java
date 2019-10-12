package com.kinsolutions.sites.resourceinfo;

import java.io.Serializable;
import java.util.Date;

public class SiteInfo implements Serializable {

	private Integer siteId;  
    private String siteCode;
	private String siteName;
	private String siteAddress;
	private Integer sitePincode;
	private String memberShipType;
	private int privilegeCd;	
	
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
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public Integer getSitePincode() {
		return sitePincode;
	}
	public void setSitePincode(Integer sitePincode) {
		this.sitePincode = sitePincode;
	}
	public String getMemberShipType() {
		return memberShipType;
	}
	public void setMemberShipType(String memberShipType) {
		this.memberShipType = memberShipType;
	}
	public int getPrivilegeCd() {
		return privilegeCd;
	}
	public void setPrivilegeCd(int privilegeCd) {
		this.privilegeCd = privilegeCd;
	}
	
}
