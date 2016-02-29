package com.vos;
/**
 * 指标实体类
 * */
public class IndicatorVO {
	private int indicator_id;
	private String name;//指标名称
	private int level_id;//等级
	private int type_id;//类型
	private String indicator_desc;//指标解释
	private String unit;//单位
	private int platform_id;//平台类型
	private String status;//状态
	private double value;//绝对量 
	private double percent;//同比增长
	public int getIndicator_id() {
		return indicator_id;
	}
	public void setIndicator_id(int indicator_id) {
		this.indicator_id = indicator_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getIndicator_desc() {
		return indicator_desc;
	}
	public void setIndicator_desc(String indicator_desc) {
		this.indicator_desc = indicator_desc;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPlatform_id() {
		return platform_id;
	}
	public void setPlatform_id(int platform_id) {
		this.platform_id = platform_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
}
