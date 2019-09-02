package com.kinsolutions.login.resourceinfo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;

@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class LoginResponse implements Serializable {
	
	private HeaderData headerData;
	private LoginInfoResource loginInfoData;
	private ErrorData errorData;
	
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}	 
	public LoginInfoResource getLoginInfoData() {
		return loginInfoData;
	}
	public void setLoginInfoData(LoginInfoResource loginInfoData) {
		this.loginInfoData = loginInfoData;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}

}
