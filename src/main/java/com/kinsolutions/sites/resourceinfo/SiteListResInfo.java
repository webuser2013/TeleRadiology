package com.kinsolutions.sites.resourceinfo;

import java.io.Serializable;
import java.util.List;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;

public class SiteListResInfo  implements Serializable { 
	
	private HeaderData headerData;
 	private List<SiteInfo> siteInfoList;
	private ErrorData errorData;
	
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}
	public List<SiteInfo> getSiteInfoList() {
		return siteInfoList;
	}
	public void setSiteInfoList(List<SiteInfo> siteInfoList) {
		this.siteInfoList = siteInfoList;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}
		

}
