package com.kinsolutions.users.resourceInfo;

import java.io.Serializable;
import java.util.List;

import com.kinsolutions.baseinfo.ErrorData;
import com.kinsolutions.baseinfo.HeaderData;

public class UsersResInfo  implements Serializable { 
	
	private HeaderData headerData;
 	private List<UsersInfo> usersInfoList;
	private ErrorData errorData;
	
	public HeaderData getHeaderData() {
		return headerData;
	}
	public void setHeaderData(HeaderData headerData) {
		this.headerData = headerData;
	}
	public List<UsersInfo> getUsersInfoList() {
		return usersInfoList;
	}
	public void setUsersInfoList(List<UsersInfo> usersInfoList) {
		this.usersInfoList = usersInfoList;
	}
	public ErrorData getErrorData() {
		return errorData;
	}
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}
	
	 
	 

}
