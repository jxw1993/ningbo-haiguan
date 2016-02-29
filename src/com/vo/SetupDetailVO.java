package com.vo;
/**
 * 设备配置详细信息实体类
 * 资产管理系统中间件
 * */
public class SetupDetailVO {
	private String id;//配置信息ID
	private String device_id;//设备ID
	private String reason;//配置修改原因
	private String detail;//配置修改详细
	private String type;//配置修改类型
	private String change_date;//配置修改时间
	private String operator;//修改人员
	private String config_file_path;//配置文件路径
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getChange_date() {
		return change_date;
	}
	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getConfig_file_path() {
		return config_file_path;
	}
	public void setConfig_file_path(String config_file_path) {
		this.config_file_path = config_file_path;
	}
	
}
