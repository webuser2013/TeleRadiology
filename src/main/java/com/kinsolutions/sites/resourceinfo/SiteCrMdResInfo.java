package com.kinsolutions.sites.resourceinfo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;
import com.kinsolutions.baseinfo.ObjectInfo;

@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class SiteCrMdResInfo implements Serializable {
	
	private HeaderData headerData;
	private ObjectInfo objectInfo;
	private ErrorData errorData;
	
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}
	public ObjectInfo getObjectInfo() {
		return objectInfo;
	}
	public void setObjectInfo(ObjectInfo centerInfo) {
		this.objectInfo = centerInfo;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}

}
