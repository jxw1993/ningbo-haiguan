package com.vos;

public class Maintain {

	// 外键关联对象
	private int customert_id;
	private String full_name;// 设备隶属单位
	private int type_id;
	private String name;// 设备类型
	private int company_id;
	private String company_name; // 维护单位
	private String contract_person; // 联系人
	private String contract_no; // 联系方式
	private String address; // 联系地址
	// 主表内容
	private int device_id;
	private String brand;
	private String model_no;
	private String guarantee_date;
	private String expired_date;
	private String login_name;// 登录账号密码..
	private String login_pwd;
	private String location;// 存放位置
	private String port_number;// 端口数量
	private String status;
	private String disable_date;
	private String life_cycle;
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	public int getCustomert_id() {
		return customert_id;
	}
	public void setCustomert_id(int customert_id) {
		this.customert_id = customert_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getContract_person() {
		return contract_person;
	}
	public void setContract_person(String contract_person) {
		this.contract_person = contract_person;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getGuarantee_date() {
		return guarantee_date;
	}
	public void setGuarantee_date(String guarantee_date) {
		this.guarantee_date = guarantee_date;
	}
	public String getExpired_date() {
		return expired_date;
	}
	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPort_number() {
		return port_number;
	}
	public void setPort_number(String port_number) {
		this.port_number = port_number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDisable_date() {
		return disable_date;
	}
	public void setDisable_date(String disable_date) {
		this.disable_date = disable_date;
	}
	public String getLife_cycle() {
		return life_cycle;
	}
	public void setLife_cycle(String life_cycle) {
		this.life_cycle = life_cycle;
	}
	
}
