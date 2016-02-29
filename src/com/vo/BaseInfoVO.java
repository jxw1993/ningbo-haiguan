package com.vo;
/**
 * 设备基本信息实体类
 * 资产管理系统中间件
 * */
public class BaseInfoVO {
	private int id;//设备ID
	private String brand;//品牌名称
	private String type_id;//类型id
	private String type_name;//类型名称
	private String series_no;//序列号
	private String model_no;//型号
	private String b_date;//购买时间
	private String b_company;//购买单位
	private String b_price;//购买价格
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
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getSeries_no() {
		return series_no;
	}
	public void setSeries_no(String series_no) {
		this.series_no = series_no;
	}
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_company() {
		return b_company;
	}
	public void setB_company(String b_company) {
		this.b_company = b_company;
	}
	public String getB_price() {
		return b_price;
	}
	public void setB_price(String b_price) {
		this.b_price = b_price;
	}
	
}
