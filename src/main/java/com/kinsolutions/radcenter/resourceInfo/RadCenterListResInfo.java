package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;
import java.util.List;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;

public class RadCenterListResInfo  implements Serializable { 
	
	private HeaderData headerData;
 	private List<RadCenterInfo> RadCenterInfoList;
	private ErrorData errorData;
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}
	public List<RadCenterInfo> getRadCenterInfoList() {
		return RadCenterInfoList;
	}
	public void setRadCenterInfoList(List<RadCenterInfo> radCenterInfoList) {
		RadCenterInfoList = radCenterInfoList;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}
 
	 

}
