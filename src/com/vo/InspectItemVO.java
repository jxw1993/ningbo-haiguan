package com.vo;
/**
 * 设备巡检内容item实体类
 * 资产管理系统中间件
 * */
public class InspectItemVO {
	private String content_id;//巡检内容ID
	private String type_id;//设备类型ID
	private String check_content;//巡检内容
	private String check_method;//巡检方法
	private String content_result;//巡检结果
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getCheck_content() {
		return check_content;
	}
	public void setCheck_content(String check_content) {
		this.check_content = check_content;
	}
	public String getCheck_method() {
		return check_method;
	}
	public void setCheck_method(String check_method) {
		this.check_method = check_method;
	}
	public String getContent_result() {
		return content_result;
	}
	public void setContent_result(String content_result) {
		this.content_result = content_result;
	}
	
}
