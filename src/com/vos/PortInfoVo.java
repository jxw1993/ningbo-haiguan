package com.vos;

public class PortInfoVo {

	private int id;
	private int sPort;
	private String sName;
	private String sNo;
	private int nPort;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getsPort() {
		return sPort;
	}
	public void setsPort(int sPort) {
		this.sPort = sPort;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public int getnPort() {
		return nPort;
	}
	public void setnPort(int nPort) {
		this.nPort = nPort;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getnNo() {
		return nNo;
	}
	public void setnNo(String nNo) {
		this.nNo = nNo;
	}
	public String getIsVailable() {
		return isVailable;
	}
	public void setIsVailable(String isVailable) {
		this.isVailable = isVailable;
	}
	private String nName;
	private String nNo;
	private String isVailable;
	private String newOrUpdate;
	private int result;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getNewOrUpdate() {
		return newOrUpdate;
	}
	public void setNewOrUpdate(String newOrUpdate) {
		this.newOrUpdate = newOrUpdate;
	}
}
