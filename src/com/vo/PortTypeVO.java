package com.vo;
/**
 * 端口之设备类型下拉选择实体类
 * 资产管理系统中间件
 * */
public class PortTypeVO {
	private int id;//设备ID
	private String location;//存放位置
	private String series_no;//序列号
	private String brand;//品牌名称
	private String model_no;//型号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSeries_no() {
		return series_no;
	}
	public void setSeries_no(String series_no) {
		this.series_no = series_no;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	
}
