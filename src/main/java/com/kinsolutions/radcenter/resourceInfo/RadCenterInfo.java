package com.kinsolutions.radcenter.resourceInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kinsolutions.model.Users;

public class RadCenterInfo implements Serializable {

	private Integer radCenterId;
	private String radCenterName;
	private Integer userId;
	private String username;
	private int privilegeCd;
	private Date radCenterDate;
	private BigDecimal securityDeposit;
	private BigDecimal deploymentFee;
	private Integer siteCount;
	private Integer radiologistCount;
	private Integer modalityCount;
	private String modeOfCharge;
	private BigDecimal ctcharge;
	private BigDecimal mriCharge;
	private BigDecimal xRayCrCharge;
	private BigDecimal mammogramCharge;
	private String serverRam;
	private String serverCoreCount;
	private String serverStorage;
	private BigDecimal serverMonthlyCharges;
	private Date createdDate;
	private Date modifiedDate;
	private String createdIpAddress;
	private String modifiedIpAddress;
	private String fileName;
	private String filePath;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPrivilegeCd() {
		return privilegeCd;
	}
	public void setPrivilegeCd(int privilegeCd) {
		this.privilegeCd = privilegeCd;
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
	public BigDecimal getMammogramCharge() {
		return mammogramCharge;
	}
	public void setMammogramCharge(BigDecimal mammogramCharge) {
		this.mammogramCharge = mammogramCharge;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedIpAddress() {
		return createdIpAddress;
	}
	public void setCreatedIpAddress(String createdIpAddress) {
		this.createdIpAddress = createdIpAddress;
	}
	public String getModifiedIpAddress() {
		return modifiedIpAddress;
	}
	public void setModifiedIpAddress(String modifiedIpAddress) {
		this.modifiedIpAddress = modifiedIpAddress;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	}
