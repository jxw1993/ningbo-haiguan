package com.vos;

import java.util.Date;

public class Device {

	private int id;
	private String brand;
	private String type;//设备类型
	private String seriesNo;//序列号 
	private String bDate;//购买时间
	private String bCompany;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public long getContractNo() {
		return contractNo;
	}
	public void setContractNo(long contractNo) {
		this.contractNo = contractNo;
	}
	private float bPrice;
	private String guaranteeDate;
	private String expireDate;
	private String company; //维护单位
	private String contract;
	private long contractNo;
	private String loginName;//登录账号密码..
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSeriesNo() {
		return seriesNo;
	}
	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public String getbCompany() {
		return bCompany;
	}
	public void setbCompany(String bCompany) {
		this.bCompany = bCompany;
	}
	public float getbPrice() {
		return bPrice;
	}
	public void setbPrice(float bPrice) {
		this.bPrice = bPrice;
	}
	public String getGuaranteeDate() {
		return guaranteeDate;
	}
	public void setGuaranteeDate(String guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	public String getConfigFilePath() {
		return configFilePath;
	}
	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	private String loginPwd;
	private String location;//存放位置
	private int portNumber;//端口数量
	private String configFilePath;
	private String modelNo; //型号
	

}
