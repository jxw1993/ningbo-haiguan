package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.vos.ConfigType;
import com.vos.Device;
import com.vos.DeviceType;
import com.vos.MaintainVo;
import com.vos.PortInfoVo;

public interface DeviceService {

	public String getAllUser();
	public void addDevice(Map<String,Object> map) throws SQLException;
	public List<Device> getAllDevice() throws SQLException; 
	public int getAllDevice(int typeName) throws SQLException;
	public int checkIfExists(int id) throws SQLException;
	public void updateDevice(Device device,int id) throws SQLException;
	public void deleteDevice(int id) throws SQLException;
	public List<Device> getDeviceByPager(int firstRow,int pageSize) throws SQLException;
	public List<Device> getDeviceByPager(int firstRow,int pageSize,int typeId, int selfId) throws SQLException;
	public Map<String,Object> queryMaintainDetailById(int id) throws SQLException;
	public void updateMaintainInfo(Map<String,Object> map) throws SQLException;
	public String getFilePathById(int id) throws SQLException;
	public List<DeviceType> getDeviceType() throws SQLException;
	public List getMaintainCompany() throws SQLException;
	public Device getDeviceByNFC(String seriesNo) throws SQLException;
	public int getPortNumber(int id) throws SQLException;
	public List<PortInfoVo> getPortInfo(int id,int portNum) throws SQLException;
	public int updatePortInfo(PortInfoVo vo)throws SQLException;
	public List<ConfigType> getConfigType() throws SQLException;
}
