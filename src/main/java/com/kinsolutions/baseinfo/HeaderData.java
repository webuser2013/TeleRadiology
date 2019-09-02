package com.kinsolutions.baseinfo;

import java.io.Serializable;

public class HeaderData implements Serializable { 
	
	private String sessionId;
	private int responseCode;
	private int responseDataCount;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public int getResponseDataCount() {
		return responseDataCount;
	}
	public void setResponseDataCount(int responseDataCount) {
		this.responseDataCount = responseDataCount;
	}
	
	

}
