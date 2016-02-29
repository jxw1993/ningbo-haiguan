package com.vo;
/**
 * 设备维护信息实体类
 * 资产管理系统中间件
 * */
public class CheckInfoVO {
	private int id;//设备ID
	private String guarantee_date;//质保期
	private String expired_date;//报废期
	private String company_name;//维护单位
	private String login_name;//登录账户
	private String login_pwd;//登录密码
	private String location;//存放位置
	private String port_number;//端口个数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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
	
}
