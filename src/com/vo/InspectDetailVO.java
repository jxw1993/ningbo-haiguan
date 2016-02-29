package com.vo;
/**
 * 设备巡检详细实体类
 * 资产管理系统中间件
 * */
public class InspectDetailVO {
	private String id;//巡检记录ID
	private String device_id;//巡检设备ID
	private String content_id;//巡检内容ID
	private String content_result;//单条内容巡检结果；1：正常；2：异常
	private String check_result;//巡检最终结果
	private String check_else;//异常问题记录，巡检定义表中没有的问题
	private String check_person;//巡检最终结果
	private String check_time;//巡检时间
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
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getContent_result() {
		return content_result;
	}
	public void setContent_result(String content_result) {
		this.content_result = content_result;
	}
	public String getCheck_result() {
		return check_result;
	}
	public void setCheck_result(String check_result) {
		this.check_result = check_result;
	}
	public String getCheck_else() {
		return check_else;
	}
	public void setCheck_else(String check_else) {
		this.check_else = check_else;
	}
	public String getCheck_person() {
		return check_person;
	}
	public void setCheck_person(String check_person) {
		this.check_person = check_person;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	
}
