package com.vos;

import oracle.sql.CLOB;

public class MaintainVo {

	private int mID;//维护ID
	private String usefor;//使用权
	private String owner;//所有权
	private String status;
	private String location;
	private String ip;
	private String configFile;
	private String remark;
	private int dID;//设备id
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getUsefor() {
		return usefor;
	}
	public void setUsefor(String usefor) {
		this.usefor = usefor;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getConfigFile() {
		return configFile;
	}
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getdID() {
		return dID;
	}
	public void setdID(int dID) {
		this.dID = dID;
	}
}
