package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RadCenterRequestInfo implements Serializable {
	
    private long radCenterId;  
	private String radCenterName;
	private long userId;
 	private Date radCenterDate;
	private BigDecimal securityDeposit;
	private BigDecimal deploymentFee;
	private int siteCount;
	private int radiologistCount;
	private int modalityCount;
	private byte[] purchaseOrderCopy;
	private char modeOfCharge;
	private int ctcharge;
	private BigDecimal mriCharge;
	private BigDecimal xRayCrCharge;
	private BigDecimal mammogramcharge;
	private int serverRam;
	private int serverCoreCount;
	private int serverStorage;
	private BigDecimal serverMonthlyCharges;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getRadCenterDate() {
		return radCenterDate;
	}
	public void setRadCenterDate(Date radCenterDate) {
		this.radCenterDate = radCenterDate;
	}
	public BigDecimal getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(BigDecimal securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public BigDecimal getDeploymentFee() {
		return deploymentFee;
	}
	public void setDeploymentFee(BigDecimal deploymentFee) {
		this.deploymentFee = deploymentFee;
	}
	public int getSiteCount() {
		return siteCount;
	}
	public void setSiteCount(int siteCount) {
		this.siteCount = siteCount;
	}
	public int getRadiologistCount() {
		return radiologistCount;
	}
	public void setRadiologistCount(int radiologistCount) {
		this.radiologistCount = radiologistCount;
	}
	public int getModalityCount() {
		return modalityCount;
	}
	public void setModalityCount(int modalityCount) {
		this.modalityCount = modalityCount;
	}
	public byte[] getPurchaseOrderCopy() {
		return purchaseOrderCopy;
	}
	public void setPurchaseOrderCopy(byte[] purchaseOrderCopy) {
		this.purchaseOrderCopy = purchaseOrderCopy;
	}
	public char getModeOfCharge() {
		return modeOfCharge;
	}
	public void setModeOfCharge(char modeOfCharge) {
		this.modeOfCharge = modeOfCharge;
	}
	public int getCtcharge() {
		return ctcharge;
	}
	public void setCtcharge(int ctcharge) {
		this.ctcharge = ctcharge;
	}
	public BigDecimal getMriCharge() {
		return mriCharge;
	}
	public void setMriCharge(BigDecimal mriCharge) {
		this.mriCharge = mriCharge;
	}
	public BigDecimal getxRayCrCharge() {
		return xRayCrCharge;
	}
	public void setxRayCrCharge(BigDecimal xRayCrCharge) {
		this.xRayCrCharge = xRayCrCharge;
	}
	public BigDecimal getMammogramcharge() {
		return mammogramcharge;
	}
	public void setMammogramcharge(BigDecimal mammogramcharge) {
		this.mammogramcharge = mammogramcharge;
	}
	public int getServerRam() {
		return serverRam;
	}
	public void setServerRam(int serverRam) {
		this.serverRam = serverRam;
	}
	public int getServerCoreCount() {
		return serverCoreCount;
	}
	public void setServerCoreCount(int serverCoreCount) {
		this.serverCoreCount = serverCoreCount;
	}
	public int getServerStorage() {
		return serverStorage;
	}
	public void setServerStorage(int serverStorage) {
		this.serverStorage = serverStorage;
	}
	public BigDecimal getServerMonthlyCharges() {
		return serverMonthlyCharges;
	}
	public void setServerMonthlyCharges(BigDecimal serverMonthlyCharges) {
		this.serverMonthlyCharges = serverMonthlyCharges;
	}
	 

}
