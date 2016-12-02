package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.vos.Check;
import com.vos.CheckError;
import com.vos.CheckInfo;
import com.vos.CheckInfoSerach;
import com.vos.CheckTask;
import com.vos.CheckTaskSearch;
import com.vos.CheckTaskVo;
import com.vos.Config;
import com.vos.Device;
import com.vos.DeviceSearchVo;
import com.vos.DeviceType;
import com.vos.Maintain;
import com.vos.Port;
import com.vos.PortVo;
import com.vos.User;

public interface DeviceService {

	public List<User> getAllCustomer(String search,int offset, int limit,User user)throws SQLException;
	public int getAllCustomerCount(User user)throws SQLException;
	public void addCustomer(User user)throws SQLException;
	public void deleteCustomer(int customer_id)throws SQLException;
//	public List<User> checkCustomerName(String data);
	public void updateCustomer(User user)throws SQLException;
	//customer device check
	public List<CheckTask>getDeviceTask(String customer_id) throws SQLException;
	public List<Check>getDeviceRecord(String customer_id) throws SQLException;
	public List<CheckError>getDeviceError(String customer_id) throws SQLException;
	//device
	public List<Device> getAllDevice(String search,int offset,int limit,Device device)throws SQLException;
	public int getAllDeviceCount(Device device)throws SQLException;
	public int addDevice(Map<String, Object> map) throws SQLException;
	public void deleteDevice(int customer_id) throws SQLException;
	public void updateDevice(Map<String,Object> map) throws SQLException;
	public List<DeviceType> getDeviceType() throws SQLException;
	public List<DeviceType> getCustomerName() throws SQLException;
	public List<DeviceType> getCompanyName() throws SQLException;
	public String getFilePathById(int device_id) throws SQLException;
	public String getConfigFileExplain(int device_id) throws SQLException;
	public String getSeriesNoById(int device_id) throws SQLException;
	//maintain
	public List<Maintain> getAllMaintain(String search,int offset,int limit,Maintain maintain)throws SQLException;
	public int getAllMaintainCount(Maintain maintain)throws SQLException;
	//port
	public List<Port> getAllPort(String search,int offset,int limit,Port port)throws SQLException;
	public int getAllPortCount(Port port)throws SQLException;
	public void deletePort(int id)throws SQLException;
	public void addDevicePort(Port port)throws SQLException;
	public void updatePort(Port port)throws SQLException;
	public String getPortType(String string) throws SQLException;
	public List<PortVo> getPortBrand() throws SQLException;
	public List<PortVo> getNextBrand() throws SQLException;
	//config
	public List<Config> getAllConfig(String search,int offset,int limit,Config config)throws SQLException;
	public int getAllConfigCount(Config config)throws SQLException;
	public void addConfig(Config config)throws SQLException;	
	public void deleteConfig(int change_id)throws SQLException;
	public void updateConfig(Config config)throws SQLException;
	public List<DeviceSearchVo> getDeviceBrand() throws SQLException;
	public List<DeviceType> getOperator() throws SQLException;
	//user
	public List<User> getAllUser(String search,int offset, int limit,User user)throws SQLException;
	public int getAllUserCount(User user)throws SQLException;
	public void addUser(User user)throws SQLException;
	public void deleteUser(int customer_id)throws SQLException;
	public void updateUser(User user)throws SQLException;
	//check
	public List<Check> getAllCheck(String search,int offset, int limit,Check check)throws SQLException;
	public int getAllCheckCount(Check check)throws SQLException;
	public List<CheckInfo> getAllCheckInfo(String search,int offset, int limit,CheckInfo checkInfo)throws SQLException;
	public int getAllCheckInfoCount(CheckInfo checkInfo)throws SQLException;
	public void addCheckInfo(CheckInfo checkInfo)throws SQLException;
	public void deleteCheckInfo(int content_id)throws SQLException;
	public void updatecheckinfo(CheckInfo checkInfo)throws SQLException;
	public List<CheckTask> getAllCheckTask(String search,int offset, int limit,CheckTask checkTask)throws SQLException;
	public int getAllCheckTaskCount(CheckTask checkTask)throws SQLException;
	public void addCheckTask(CheckTask checkTask)throws SQLException;
	public void deleteCheckTask(int plan_id)throws SQLException;
	public void updatechecktask(CheckTask checkTask)throws SQLException;
	public List<DeviceType> getCustomer() throws SQLException;
	public List<CheckTaskVo>getDevice(String customer_id) throws SQLException;
	public List<CheckInfoSerach>getcheckinfo(String plan_id) throws SQLException;
	public List<CheckInfoSerach>getCheckdInfoId(String op1) throws SQLException;
	public List<CheckTaskSearch>getDeviceIdAndCustomerId(String op1) throws SQLException;
	public void addCheckRecord(Check check)throws SQLException;
	public void addCheckhandle(Check check)throws SQLException;	
	public List<CheckError> getAllCheckError(String search,int offset, int limit,CheckError checkError)throws SQLException;
	public int getAllCheckErrorCount(CheckError checkError)throws SQLException;
	public List<CheckTask>getCheckTask(String name) throws SQLException;
	public List<Check>getcheckrecord(String name) throws SQLException;
	public List<CheckError>getcheckerror(String name) throws SQLException;
	public Device getdevice(String data) throws SQLException;
}
