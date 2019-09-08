package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;

public class RadCenterResInfo  implements Serializable { 
 
	private HeaderData headerData;
 	private RadCenterInfo radCenterInfo;
	private ErrorData errorData;
	
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}
	public RadCenterInfo getRadCenterInfo() {
		return radCenterInfo;
	}
	public void setRadCenterInfo(RadCenterInfo radCenterInfo) {
		this.radCenterInfo = radCenterInfo;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}
	
	 
	
}
