package com.service.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dao.DeviceDao;
import com.service.DeviceService;
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

public class DeviceServiceImp implements DeviceService {

	private DeviceDao deviceDao;

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}

	@Override
	public List<User> getAllCustomer(String search,int offset, int limit, User user) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCustomer(search,offset,limit,user);
	}
	
	@Override
	public int getAllCustomerCount(User user) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCustomerCount(user);
	}

	@Override
	public void addCustomer(User user) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addCustomer(user);
	}

	@Override
	public void deleteCustomer(int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteCustomer(customer_id);
	}

	@Override
	public void updateCustomer(User user) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updateCustomer(user);
	}
	
	@Override
	public  List<CheckTask> getDeviceTask(String customer_id) throws SQLException{
		return deviceDao.getDeviceTask(customer_id);
	}
	
	@Override
	public  List<Check> getDeviceRecord(String customer_id) throws SQLException{
		return deviceDao.getDeviceRecord(customer_id);
	}

	@Override
	public  List<CheckError> getDeviceError(String customer_id) throws SQLException{
		return deviceDao.getDeviceError(customer_id);
	}
//	@Override
//	public List<User> checkCustomerName(String data) {
//		// TODO Auto-generated method stub
//		return deviceDao.checkCustomerName(data);
//	}

	
	@Override
	public List<Device> getAllDevice(String search, int offset, int limit, Device device) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllDevice(search, offset, limit, device);
	}
	
	@Override
	public int getAllDeviceCount(Device device) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllDeviceCount(device);
	}

	@Override
	public int addDevice(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.addDevice(map);
	}
	
	@Override
	public void deleteDevice(int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteDevice(customer_id);
	}
	
	@Override
	public void updateDevice(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updateDevice(map);
	}
	
	@Override
	public List<DeviceType> getDeviceType() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceType();
	}
	
	@Override
	public List<DeviceType> getCustomerName() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getCustomerName();
	}

	@Override
	public List<DeviceType> getCompanyName() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getCompanyName();
	}
	
	@Override
	public String getFilePathById(int device_id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getFilePathById(device_id);
	}
	
	@Override
	public String getConfigFileExplain(int device_id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getConfigFileExplain(device_id);
	}

	@Override
	public String getSeriesNoById(int device_id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getSeriesNoById(device_id);
	}
	
	//miantain
	@Override
	public List<Maintain> getAllMaintain(String search, int offset, int limit, Maintain maintain) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllMaintain(search, offset, limit, maintain);
	}
	
	@Override
	public int getAllMaintainCount(Maintain maintain) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllMaintainCount(maintain);
	}
	
	//port
	@Override
	public List<Port> getAllPort(String search, int offset, int limit, Port port) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllPort(search, offset, limit, port);
	}
	
	@Override
	public int getAllPortCount(Port port) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllPortCount(port);
	}
	
	@Override
	public void addDevicePort(Port port) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addDevicePort(port);
	}
	
	@Override
	public void deletePort(int id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deletePort(id);
	}
	
	@Override
	public void updatePort(Port port) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updatePort(port);
	}
	
	@Override
	public String getPortType(String string) throws SQLException{
		return deviceDao.getPortType(string);
	}
	
	@Override
	public List<PortVo> getPortBrand() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getPortBrand();
	}
	
	@Override
	public List<PortVo> getNextBrand() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getNextBrand();
	}
	
	//config
	@Override
	public List<Config> getAllConfig(String search, int offset, int limit, Config config) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllConfig(search, offset, limit, config);
	}
	
	@Override
	public int getAllConfigCount(Config config) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllConfigCount(config);
	}
	
	@Override
	public void addConfig(Config config) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addConfig(config);
	}

	@Override
	public void deleteConfig(int change_id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteConfig(change_id);
	}

	@Override
	public void updateConfig(Config config) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updateConfig(config);
	}
	
	@Override
	public List<DeviceSearchVo> getDeviceBrand() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceBrand();
	}
	
	@Override
	public List<DeviceType> getOperator() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getOperator();
	}

	//user
	@Override
	public List<User> getAllUser(String search,int offset, int limit, User user) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllUser(search,offset,limit,user);
	}
	
	@Override
	public int getAllUserCount(User user) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllUserCount(user);
	}

	@Override
	public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addUser(user);
	}

	@Override
	public void deleteUser(int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteUser(customer_id);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updateUser(user);
	}

	@Override
	public List<Check> getAllCheck(String search, int offset, int limit, Check check) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheck(search,offset,limit,check);
	}

	@Override
	public int getAllCheckCount(Check check) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckCount(check);
	}

	@Override
	public List<CheckInfo> getAllCheckInfo(String search, int offset, int limit, CheckInfo checkInfo)
			throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckInfo(search, offset, limit, checkInfo);
	}

	@Override
	public int getAllCheckInfoCount(CheckInfo checkInfo) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckInfoCount(checkInfo);
	}

	@Override
	public void addCheckInfo(CheckInfo checkInfo) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addCheckInfo(checkInfo);
	}
	
	@Override
	public void deleteCheckInfo(int content_id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteCheckInfo(content_id);
	}
	
	@Override
	public void updatecheckinfo(CheckInfo checkInfo) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updatecheckinfo(checkInfo);
	}
	
	@Override
	public List<CheckTask> getAllCheckTask(String search, int offset, int limit, CheckTask checkTask)
			throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckTask(search, offset, limit, checkTask);
	}

	@Override
	public int getAllCheckTaskCount(CheckTask checkTask) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckTaskCount(checkTask);
	}
	
	@Override
	public void addCheckTask(CheckTask checkTask) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addCheckTask(checkTask);
	}
	
	@Override
	public void deleteCheckTask(int plan_id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteCheckTask(plan_id);
	}
	

	@Override
	public void updatechecktask(CheckTask checkTask) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updatechecktask(checkTask);
	}
	
	@Override
	public List<DeviceType> getCustomer() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getCustomer();
	}
	
	@Override
	public  List<CheckTaskVo> getDevice(String customer_id) throws SQLException{
		return deviceDao.getDevice(customer_id);
	}
	
	@Override
	public  List<CheckInfoSerach> getcheckinfo(String plan_id) throws SQLException{
		return deviceDao.getcheckinfo(plan_id);
	}

	@Override
	public  List<CheckInfoSerach> getCheckdInfoId(String op1) throws SQLException{
		return deviceDao.getcheckinfo(op1);
	}
	
	@Override
	public  List<CheckTaskSearch> getDeviceIdAndCustomerId(String op1) throws SQLException{
		return deviceDao.getDeviceIdAndCustomerId(op1);
	}
	
	@Override
	public void addCheckRecord(Check check) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addCheckRecord(check);
	}
	
	@Override
	public void addCheckhandle(Check check) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addCheckhandle(check);
	}
	
	@Override
	public List<CheckError> getAllCheckError(String search, int offset, int limit, CheckError checkError)
			throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckError(search, offset, limit, checkError);
	}

	@Override
	public int getAllCheckErrorCount(CheckError checkError) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllCheckErrorCount(checkError);
	}

	@Override
	public List<CheckTask> getCheckTask(String name) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getCheckTask(name);
	}

	@Override
	public List<Check> getcheckrecord(String name) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getcheckrecord(name);
	}
	
	@Override
	public List<CheckError> getcheckerror(String name) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getcheckerror(name);
	}
	
	@Override
	public Device getdevice(String data) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getdevice(data);
	}
	
}
