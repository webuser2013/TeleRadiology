package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RadCenterCrMdReqInfo implements Serializable {
	
    private Integer radCenterId;  
	private String radCenterName;
	private Integer userId;
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
 	private Date radCenterDate;
	private BigDecimal securityDeposit;
	private BigDecimal deploymentFee;
	private Integer siteCount;
	private Integer radiologistCount;
	private Integer modalityCount;
	private byte[] purchaseOrderCopy;
	private String modeOfCharge;
	private BigDecimal ctcharge;
	private BigDecimal mriCharge;
	private BigDecimal xRayCrCharge;
	private BigDecimal mammogramcharge;
	private String serverRam;
	private String serverCoreCount;
	private String serverStorage;
	private BigDecimal serverMonthlyCharges;
	//private	MultipartFile purchaseOrderFile;
	private String serviceType;
	private BigDecimal modalityCharge;
	private String addressData;
	
	public Integer getRadCenterId() {
		return radCenterId;
	}
	public void setRadCenterId(Integer radCenterId) {
		this.radCenterId = radCenterId;
	}
	public String getRadCenterName() {
		return radCenterName;
	}
	public void setRadCenterName(String radCenterName) {
		this.radCenterName = radCenterName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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
	public Integer getSiteCount() {
		return siteCount;
	}
	public void setSiteCount(Integer siteCount) {
		this.siteCount = siteCount;
	}
	public Integer getRadiologistCount() {
		return radiologistCount;
	}
	public void setRadiologistCount(Integer radiologistCount) {
		this.radiologistCount = radiologistCount;
	}
	public Integer getModalityCount() {
		return modalityCount;
	}
	public void setModalityCount(Integer modalityCount) {
		this.modalityCount = modalityCount;
	}
	public byte[] getPurchaseOrderCopy() {
		return purchaseOrderCopy;
	}
	public void setPurchaseOrderCopy(byte[] purchaseOrderCopy) {
		this.purchaseOrderCopy = purchaseOrderCopy;
	}
	public String getModeOfCharge() {
		return modeOfCharge;
	}
	public void setModeOfCharge(String modeOfCharge) {
		this.modeOfCharge = modeOfCharge;
	}
	public BigDecimal getCtcharge() {
		return ctcharge;
	}
	public void setCtcharge(BigDecimal ctcharge) {
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
	public String getServerRam() {
		return serverRam;
	}
	public void setServerRam(String serverRam) {
		this.serverRam = serverRam;
	}
	public String getServerCoreCount() {
		return serverCoreCount;
	}
	public void setServerCoreCount(String serverCoreCount) {
		this.serverCoreCount = serverCoreCount;
	}
	public String getServerStorage() {
		return serverStorage;
	}
	public void setServerStorage(String serverStorage) {
		this.serverStorage = serverStorage;
	}
	public BigDecimal getServerMonthlyCharges() {
		return serverMonthlyCharges;
	}
	public void setServerMonthlyCharges(BigDecimal serverMonthlyCharges) {
		this.serverMonthlyCharges = serverMonthlyCharges;
	}
	/*public MultipartFile getPurchaseOrderFile() {
		return purchaseOrderFile;
	}
	public void setPurchaseOrderFile(MultipartFile purchaseOrderFile) {
		this.purchaseOrderFile = purchaseOrderFile;
	}*/
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public BigDecimal getModalityCharge() {
		return modalityCharge;
	}
	public String getAddressData() {
		return addressData;
	}
	public void setModalityCharge(BigDecimal modalityCharge) {
		this.modalityCharge = modalityCharge;
	}
	public void setAddressData(String addressData) {
		this.addressData = addressData;
	}

}
