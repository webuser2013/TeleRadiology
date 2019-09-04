package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;

public class RadCenterInfo implements Serializable {
	
	private long radCenterId;
	private String radCenterName;
	private String message;
	
	public long getRadCenterId() {
		return radCenterId;
	}
	public void setRadCenterId(long radCenterId) {
		this.radCenterId = radCenterId;
	}
	public String getRadCenterName() {
		return radCenterName;
	}
	public void setRadCenterName(String radCenterName) {
		this.radCenterName = radCenterName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
