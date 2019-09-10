package com.kinsolutions.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:message.properties")
public class MessageResourceHelper {

	@Value("${msg.data.notfound}")
	public String msgDataNotFound;
	
	@Value("${msg.manddata.notfound}")
	public String msgMandDataNotFound;
	
	@Value("${msg.user.inactive}")
	public String msgUserInactive;
	
	@Value("${msg.user.deleted}")
	public String msgUserDeleted;
	
	@Value("${msg.radcen.inactive}")
	public String msgRadCenInactive;
	
	@Value("${msg.radcen.deleted}")
	public String msgRadCenDeleted;
	
	@Value("${msg.radcen.create}")
	public String msgRadcenCreate;
	
	@Value("${msg.radcen.modify}")
	public String msgRadcenModify;
	
	@Value("${msg.radcen.saveerr}")
	public String msgRadcenSaveErr;
	
	@Value("${msg.radcen.activateerr}")
	public String msgRadcenActivateErr;
	
	@Value("${msg.radcen.deactivateerr}")
	public String msgRadcenDeactivateErr;
		
	@Value("${msg.radcen.deleteerr}")
	public String msgRadcenDeleteErr;
	
	@Value("${msg.radcen.readerr}")
	public String msgRadcenReadErr;	
	
	@Value("${msg.user.notfound}")
	public String msgUserNotFound;
		
	@Value("${msg.radcen.updpoerr}")
	public String msgRadcenUpdPurChaseOrderErr;
	
	@Value("${msg.radcen.updposizeerr}")
	public String msgRadcenUpdPurchaseOrderSizEerr;	
	
	@Value("${msg.radcen.updpo}")
	public String msgRadCenUpdPurchaseOrder;

	public String getMsgDataNotFound() {
		return msgDataNotFound;
	}

	public void setMsgDataNotFound(String msgDataNotFound) {
		this.msgDataNotFound = msgDataNotFound;
	}

	public String getMsgMandDataNotFound() {
		return msgMandDataNotFound;
	}

	public void setMsgMandDataNotFound(String msgMandDataNotFound) {
		this.msgMandDataNotFound = msgMandDataNotFound;
	}

	public String getMsgUserInactive() {
		return msgUserInactive;
	}

	public void setMsgUserInactive(String msgUserInactive) {
		this.msgUserInactive = msgUserInactive;
	}

	public String getMsgUserDeleted() {
		return msgUserDeleted;
	}

	public void setMsgUserDeleted(String msgUserDeleted) {
		this.msgUserDeleted = msgUserDeleted;
	}

	public String getMsgRadCenInactive() {
		return msgRadCenInactive;
	}

	public void setMsgRadCenInactive(String msgRadCenInactive) {
		this.msgRadCenInactive = msgRadCenInactive;
	}

	public String getMsgRadCenDeleted() {
		return msgRadCenDeleted;
	}

	public void setMsgRadCenDeleted(String msgRadCenDeleted) {
		this.msgRadCenDeleted = msgRadCenDeleted;
	}

	public String getMsgRadcenCreate() {
		return msgRadcenCreate;
	}

	public void setMsgRadcenCreate(String msgRadcenCreate) {
		this.msgRadcenCreate = msgRadcenCreate;
	}

	public String getMsgRadcenModify() {
		return msgRadcenModify;
	}

	public void setMsgRadcenModify(String msgRadcenModify) {
		this.msgRadcenModify = msgRadcenModify;
	}

	public String getMsgRadcenSaveErr() {
		return msgRadcenSaveErr;
	}

	public void setMsgRadcenSaveErr(String msgRadcenSaveErr) {
		this.msgRadcenSaveErr = msgRadcenSaveErr;
	}

	public String getMsgRadcenActivateErr() {
		return msgRadcenActivateErr;
	}

	public void setMsgRadcenActivateErr(String msgRadcenActivateErr) {
		this.msgRadcenActivateErr = msgRadcenActivateErr;
	}

	public String getMsgRadcenDeactivateErr() {
		return msgRadcenDeactivateErr;
	}

	public void setMsgRadcenDeactivateErr(String msgRadcenDeactivateErr) {
		this.msgRadcenDeactivateErr = msgRadcenDeactivateErr;
	}

	public String getMsgRadcenDeleteErr() {
		return msgRadcenDeleteErr;
	}

	public void setMsgRadcenDeleteErr(String msgRadcenDeleteErr) {
		this.msgRadcenDeleteErr = msgRadcenDeleteErr;
	}

	public String getMsgRadcenReadErr() {
		return msgRadcenReadErr;
	}

	public void setMsgRadcenReadErr(String msgRadcenReadErr) {
		this.msgRadcenReadErr = msgRadcenReadErr;
	}

	public String getMsgUserNotFound() {
		return msgUserNotFound;
	}

	public void setMsgUserNotFound(String msgUserNotFound) {
		this.msgUserNotFound = msgUserNotFound;
	}

	public String getMsgRadcenUpdPurChaseOrderErr() {
		return msgRadcenUpdPurChaseOrderErr;
	}

	public void setMsgRadcenUpdPurChaseOrderErr(String msgRadcenUpdPurChaseOrderErr) {
		this.msgRadcenUpdPurChaseOrderErr = msgRadcenUpdPurChaseOrderErr;
	}

	public String getMsgRadcenUpdPurchaseOrderSizEerr() {
		return msgRadcenUpdPurchaseOrderSizEerr;
	}

	public void setMsgRadcenUpdPurchaseOrderSizEerr(String msgRadcenUpdPurchaseOrderSizEerr) {
		this.msgRadcenUpdPurchaseOrderSizEerr = msgRadcenUpdPurchaseOrderSizEerr;
	}

	public String getMsgRadCenUpdPurchaseOrder() {
		return msgRadCenUpdPurchaseOrder;
	}

	public void setMsgRadCenUpdPurchaseOrder(String msgRadCenUpdPurchaseOrder) {
		this.msgRadCenUpdPurchaseOrder = msgRadCenUpdPurchaseOrder;
	}

	 

	

}
