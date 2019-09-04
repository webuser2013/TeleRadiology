package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;

@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class RadCenterResponseInfo implements Serializable {
	
	private HeaderData headerData;
	private RadCenterInfo centerInfo;
	private ErrorData errorData;
	
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}
	public RadCenterInfo getCenterInfo() {
		return centerInfo;
	}
	public void setCenterInfo(RadCenterInfo centerInfo) {
		this.centerInfo = centerInfo;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}

}
