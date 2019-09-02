package com.kinsolutions.login.resourceinfo;

import java.io.Serializable;

public class LoginInfoResource implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private String userName;
	private long roleId;
	private String roleName;
	private String emailId;
	private String password;
 	private String address;
 	private String radCenterName;
 	private String radCenterStatus;
 	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRadCenterName() {
		return radCenterName;
	}
	public void setRadCenterName(String radCenterName) {
		this.radCenterName = radCenterName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRadCenterStatus() {
		return radCenterStatus;
	}
	public void setRadCenterStatus(String radCenterStatus) {
		this.radCenterStatus = radCenterStatus;
	}
	 
	

}
