package com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.vos.ConfigType;
import com.vos.Device;
import com.vos.DeviceSearchVo;
import com.vos.MaintainVo;
import com.vos.PortInfoVo;

public interface DeviceDao {

	public String getAllUser();
	
	public void addDevice(Map<String,Object> map) throws SQLException;
	
	public int getAllDevice(DeviceSearchVo d) throws SQLException;
	
	public int getAllDevice(int typeId) throws SQLException;
	
	public int checkIfExists(int id) throws SQLException;
	
	public void updateDevice(Device device,int id) throws SQLException;
	
	public void deleteDevice(int id) throws SQLException;
	
	public List<Device> getDeviceByPager(int firstRow,int pageSize,DeviceSearchVo d) throws SQLException;
	
	public List<Device> getDeviceByPager(int firstRow,int pageSize,int typeId, int selfId) throws SQLException;
	
	public Map<String, Object> queryMaintainDetailById(int id) throws SQLException;
	
	public void updateMaintainInfo(Map<String,Object> map) throws SQLException;
	
	public String getFilePathById(int id) throws SQLException;
	
	public List getDeciveType() throws SQLException;
	
	public List getMaintainCompany() throws SQLException;
	
	public Device getDeviceByNFC(String seriesNo) throws SQLException;
	
	public int getPortNumber(int id) throws SQLException;
	
	public List<PortInfoVo> getPortInfo(int id, int portNum) throws SQLException;
	
	public int updatePortInfo(PortInfoVo vo)throws SQLException;
	
	public List<ConfigType> getConfigType() throws SQLException;
	
}
