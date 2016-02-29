package com.vo;
/**
 * 设备端口详细信息实体类
 * 资产管理系统中间件
 * */
public class PortDetailVO {
	private int id;//端口ID
	private String self_id;//设备ID
	private String s_port;//端口号
	private String s_type;//设备类型
	private String next_id;//下一个设备ID
	private String n_port;//下一个端口号
	private String n_type;//下一个设备类型
	private String is_available;//是否可用
	private String s_postion; //设备位置
	private String n_postion; //下一个设备位置
	private String s_seriesNo; //设备序列号
	private String n_seriesNo; //下一个设备序列号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSelf_id() {
		return self_id;
	}
	public void setSelf_id(String self_id) {
		this.self_id = self_id;
	}
	public String getS_port() {
		return s_port;
	}
	public void setS_port(String s_port) {
		this.s_port = s_port;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public String getNext_id() {
		return next_id;
	}
	public void setNext_id(String next_id) {
		this.next_id = next_id;
	}
	public String getN_port() {
		return n_port;
	}
	public void setN_port(String n_port) {
		this.n_port = n_port;
	}
	public String getN_type() {
		return n_type;
	}
	public void setN_type(String n_type) {
		this.n_type = n_type;
	}
	public String getIs_available() {
		return is_available;
	}
	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}
	public String getS_postion() {
		return s_postion;
	}
	public void setS_postion(String s_postion) {
		this.s_postion = s_postion;
	}
	public String getN_postion() {
		return n_postion;
	}
	public void setN_postion(String n_postion) {
		this.n_postion = n_postion;
	}
	public String getS_seriesNo() {
		return s_seriesNo;
	}
	public void setS_seriesNo(String s_seriesNo) {
		this.s_seriesNo = s_seriesNo;
	}
	public String getN_seriesNo() {
		return n_seriesNo;
	}
	public void setN_seriesNo(String n_seriesNo) {
		this.n_seriesNo = n_seriesNo;
	}
	
}
