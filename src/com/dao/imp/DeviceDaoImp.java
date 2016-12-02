package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.DeviceDao;
import com.ibatis.sqlmap.client.SqlMapClient;
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

public class DeviceDaoImp implements DeviceDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllCustomer(String search,int offset,int limit,User user) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<User> list = new ArrayList<User>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			/*if (search.equals("all")||search.equals("")) {
				list = sqlMapClient.queryForList("getAllCustomer",map);
			}else {
				list = sqlMapClient.queryForList("getAllCustomerList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllCustomer",map);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllCustomerCount(User user) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllCustomerCount",user);
		return in;
	}

	@Override
	public void addCustomer(User user) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addCustomer",user);
	}

	@Override
	public void deleteCustomer(int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("deleteCustomer",customer_id);
	}

	@Override
	public void updateCustomer(User user) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updateCustomer",user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckTask> getDeviceTask(String customer_id) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer_id", customer_id);
		List<CheckTask> list = new ArrayList<CheckTask>();
		list = sqlMapClient.queryForList("getDeviceTask",map);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Check> getDeviceRecord(String customer_id) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer_id", customer_id);
		List<Check> list = new ArrayList<Check>();
		list = sqlMapClient.queryForList("getDeviceRecord",map);
		for(Check in :list){
			if (in.getContent_result().equals("1")) {
				in.setContent_result("正常");
			}
			if (in.getContent_result().equals("2")) {
				in.setContent_result("不正常");
			}
			if(in.getCheck_result().equals("1")){
				in.setCheck_result("运行正常");
			}
			if(in.getCheck_result().equals("2")){
				in.setCheck_result("运行出错");
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CheckError> getDeviceError(String customer_id) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer_id", customer_id);
		List<CheckError> list = new ArrayList<CheckError>();
		list = sqlMapClient.queryForList("getDeviceError",map);
		for(CheckError in :list){
			if (in.getHandle_result().equals("1")) {
				in.setHandle_result("已恢复");
				in.setStatus("已处理");
			}else {
				in.setHandle_result("未处理");
				in.setStatus("未处理");
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> getAllDevice(String search, int offset, int limit, Device device) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Device> list = new ArrayList<Device>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			/*if (search.equals("all")||search.equals("")) {
				list = sqlMapClient.queryForList("getAllDevice",map);
			}else {
				list = sqlMapClient.queryForList("getAllDeviceList",map);
			}*/
			
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllDevice",map);
			for(Device in :list){
				if(in.getStatus().equals("1")){
					in.setStatus("使用中");
				}
				if(in.getStatus().equals("2")){
					in.setStatus("未使用");
				}
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllDeviceCount(Device device) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllDeviceCount",device);
		return in;
	}

	@Override
	public int addDevice(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient .insert("addDevice",map);
		return in;
	}
	
	@Override
	public void deleteDevice(int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		try{
		sqlMapClient.delete("deleteDevice",customer_id);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateDevice(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updateDevice",map);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceType> getDeviceType() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceType> list = null;
		list = sqlMapClient.queryForList("getDeviceType");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceType> getCustomerName() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceType> list = null;
		list = sqlMapClient.queryForList("getCustomerName");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceType> getCompanyName() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceType> list = null;
		list = sqlMapClient.queryForList("getCompanyName");
		return list;
	}

	@Override
	public String getFilePathById(int device_id) throws SQLException {
		// TODO Auto-generated method stub
		String filePath = null;
		filePath = (String) sqlMapClient.queryForObject("getFilePathById",device_id);				
		return filePath;
	}

	@Override
	public String getConfigFileExplain(int device_id) throws SQLException {
		// TODO Auto-generated method stub
		String filePath = null;
		filePath = (String) sqlMapClient.queryForObject("getConfigFileExplain",device_id);				
		return filePath;
	}
	
	@Override
	public String getSeriesNoById(int device_id) throws SQLException {
		// TODO Auto-generated method stub
		String series_no = null;
		series_no = (String) sqlMapClient.queryForObject("getSeriesNoById",device_id);				
		return series_no;
	}
	
	//maintain
	@SuppressWarnings("unchecked")
	@Override
	public List<Maintain> getAllMaintain(String search, int offset, int limit, Maintain maintain) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Maintain> list = new ArrayList<Maintain>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			/*if (search.equals("all")||search.equals("")) {
			}else {
				list = sqlMapClient.queryForList("getAllMaintainList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				if (search.equals("使用中")) {
					search="1";
				}
				if(search.equals("未使用")){
					search="2";
				}
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllMaintain",map);
			for(Maintain in :list){
				if(in.getStatus().equals("1")){
					in.setStatus("使用中");
				}
				if(in.getStatus().equals("2")){
					in.setStatus("未使用");
				}
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllMaintainCount(Maintain maintain) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllMaintainCount",maintain);
		return in;
	}
	
	//port
	@SuppressWarnings("unchecked")
	@Override
	public List<Port> getAllPort(String search, int offset, int limit, Port port) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Port> list = new ArrayList<Port>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			map.put("search",search);
			if (search.equals("all")||search.equals("")) {
				list = sqlMapClient.queryForList("getAllPort",map);
			}else {
				list = sqlMapClient.queryForList("getAllPortList",map);
			}
			/*if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllPort",map);*/
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllPortCount(Port port) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllPortCount",port);
		return in;
	}
	
	@Override
	public void addDevicePort(Port port) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addDevicePort", port);
	}
	
	@Override
	public void deletePort(int id) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("deletePort",id);
	}
	
	@Override
	public void updatePort(Port port) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updatePort",port);
	}
	
	public String getPortType(String string) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("next_id", string);
		PortVo portVo = new PortVo();
		portVo = (PortVo) sqlMapClient.queryForObject("getPortType",map);
		String op = (portVo.getBrand()+portVo.getModel_no());
		return op;
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<PortVo> getPortBrand() throws SQLException {
		// TODO Auto-generated method stub
		List<PortVo> list = null;
		list = sqlMapClient.queryForList("getPortBrand");
		for(PortVo in :list){
			in.setReplace(in.getBrand()+in.getModel_no());
		}
		return list;
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<PortVo> getNextBrand() throws SQLException {
		// TODO Auto-generated method stub
		List<PortVo> list = null;
		list = sqlMapClient.queryForList("getPortBrand");
		for(PortVo in :list){
			in.setReplace(in.getBrand()+in.getModel_no());
		}
		return list;
	}
	
	//config
	@SuppressWarnings("unchecked")
	@Override
	public List<Config> getAllConfig(String search, int offset, int limit, Config config) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Config> list = new ArrayList<Config>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
		/*	if (search.equals("all")||search.equals("")) {
			}else {
				list = sqlMapClient.queryForList("getAllConfigList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllConfig",map);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllConfigCount(Config config ) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllConfigCount",config);
		return in;
	}
	
	@Override
	public void addConfig(Config config) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addConfig",config);
	}

	@Override
	public void deleteConfig(int change_id) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("deleteConfig",change_id);
	}

	@Override
	public void updateConfig(Config config) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updateConfig",config);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceSearchVo> getDeviceBrand() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceSearchVo> list = null;
		list = sqlMapClient.queryForList("getDeviceBrand");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceType> getOperator() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceType> list = null;
		list = sqlMapClient.queryForList("getOperator");
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser(String search,int offset,int limit,User user) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<User> list = new ArrayList<User>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			/*if (search.equals("all")||search.equals("")) {
			}else {
				list = sqlMapClient.queryForList("getAllUserList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllUser",map);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllUserCount(User user) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllUserCount",user);
		return in;
	}

	@Override
	public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient .insert("addUser",user);
	}

	@Override
	public void deleteUser(int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("deleteUser",customer_id);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updateUser",user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Check> getAllCheck(String search, int offset, int limit, Check check) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Check> list = new ArrayList<Check>();
			map.put("search", search);
			map.put("firstRow", offset);
			map.put("pageSize", limit);
		/*	if (search.equals("all")||search.equals("")) {
			}else {
				list = sqlMapClient.queryForList("getAllCheckList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllCheck",map);
			for(Check in :list){
				if (in.getContent_result().equals("1")) {
					in.setContent_result("正常");
				}
				if (in.getContent_result().equals("2")) {
					in.setContent_result("不正常");
				}
				if(in.getCheck_result().equals("1")){
					in.setCheck_result("运行正常");
				}
				if(in.getCheck_result().equals("2")){
					in.setCheck_result("运行出错");
				}
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllCheckCount(Check check) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllCheckCount",check);
		return in;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckInfo> getAllCheckInfo(String search, int offset, int limit, CheckInfo checkInfo)
			throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<CheckInfo> list = new ArrayList<CheckInfo>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			/*if (search.equals("all")||search.equals("")) {
			}else {
				list = sqlMapClient.queryForList("getAllCheckInfoList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllCheckInfo",map);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllCheckInfoCount(CheckInfo checkInfo) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllCheckInfoCount",checkInfo);
		return in;
	}

	@Override
	public void addCheckInfo(CheckInfo checkInfo) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addCheckInfo",checkInfo);
	}

	@Override
	public void deleteCheckInfo(int content_id) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("deleteCheckInfo",content_id);
	}
	

	@Override
	public void updatecheckinfo(CheckInfo checkInfo) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updatecheckinfo",checkInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckTask> getAllCheckTask(String search, int offset, int limit, CheckTask checkTask)
			throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<CheckTask> list = new ArrayList<CheckTask>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
			/*if (search.equals("all")||search.equals(" ")) {
			}else {
				list = sqlMapClient.queryForList("getAllCheckTaskList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllCheckTask",map);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllCheckTaskCount(CheckTask checkTask) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllCheckTaskCount",checkTask);
		return in;
	}
	
	@Override
	public void addCheckTask(CheckTask checkTask) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addCheckTask",checkTask);
	}

	@Override
	public void deleteCheckTask(int plan_id) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("deleteCheckTask",plan_id);
	}
	
	@Override
	public void updatechecktask(CheckTask checkTask) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updatechecktask",checkTask);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceType> getCustomer() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceType> list = null;
		list = sqlMapClient.queryForList("getCustomer");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckTaskVo> getDevice(String customer_id) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer", customer_id);
		List<CheckTaskVo> list = new ArrayList<CheckTaskVo>();
		list = sqlMapClient.queryForList("getDevice",map);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CheckInfoSerach> getcheckinfo(String plan_id) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("plan_id", plan_id);
		List<CheckInfoSerach> list = new ArrayList<CheckInfoSerach>();
		list = sqlMapClient.queryForList("getcheckinfo",map);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CheckInfoSerach> getCheckdInfoId(String op1) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("plan_id", op1);
		List<CheckInfoSerach> list = new ArrayList<CheckInfoSerach>();
		list = sqlMapClient.queryForList("getCheckdInfoId",map);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CheckTaskSearch> getDeviceIdAndCustomerId(String op1) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("plan_id", op1);
		List<CheckTaskSearch> list = new ArrayList<CheckTaskSearch>();
		list = sqlMapClient.queryForList("getDeviceIdAndCustomerId",map);
		return list;
	}
	
	@Override
	public void addCheckRecord(Check check) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addCheckRecord",check);
	}
	
	@Override
	public void addCheckhandle(Check check) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addCheckhandle",check);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CheckError> getAllCheckError(String search, int offset, int limit, CheckError checkError) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<CheckError> list = new ArrayList<CheckError>();
			map.put("firstRow", offset);
			map.put("pageSize", limit);
		/*	if (search.equals("all")||search.equals("")) {
			}else {
				list = sqlMapClient.queryForList("getAllCheckErrortList",map);
			}*/
			if (search.equals("all")||search.equals("")) {
			}else {
				if (search.equals("未处理")) {
					map.put("result",2);
				}else if (search.equals("已恢复")) {
					map.put("result",1);
				}
				map.put("search",search);
			}
			list = sqlMapClient.queryForList("getAllCheckError",map);
			for(CheckError in :list){
				if (in.getHandle_result().equals("1")) {
					in.setHandle_result("已恢复");
					in.setStatus("已处理");
				}
				if (in.getHandle_result().equals("2")) {
					in.setHandle_result("未处理");
					in.setStatus("未处理");
				}
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getAllCheckErrorCount(CheckError checkError) throws SQLException {
		// TODO Auto-generated method stub
		int in = (Integer) sqlMapClient.queryForObject("getAllCheckErrorCount",checkError);
		return in;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckTask> getCheckTask(String name) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("optation", name);
		List<CheckTask> list = new ArrayList<CheckTask>();
		list = sqlMapClient.queryForList("getCheckTask",map);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Check> getcheckrecord(String name) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("optation", name);
		List<Check> list = new ArrayList<Check>();
		list = sqlMapClient.queryForList("getcheckrecord",map);
		for(Check in :list){
			if (in.getContent_result().equals("1")) {
				in.setContent_result("正常");
			}
			if (in.getContent_result().equals("2")) {
				in.setContent_result("不正常");
			}
			if(in.getCheck_result().equals("1")){
				in.setCheck_result("运行正常");
			}
			if(in.getCheck_result().equals("2")){
				in.setCheck_result("运行出错");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckError> getcheckerror(String name) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("optation", name);
		List<CheckError> list = new ArrayList<CheckError>();
		list = sqlMapClient.queryForList("getcheckerror",map);
		for(CheckError in :list){
			if (in.getHandle_result().equals("1")) {
				in.setHandle_result("已恢复");
				in.setStatus("已处理");
			}else {
				in.setHandle_result("未处理");
				in.setStatus("未处理");
			}
		}
		return list;
	}
	
	public Device getdevice(String data) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("device_id", data);
		Device device = new Device();
		device = (Device) sqlMapClient.queryForObject("getdevice",map);
		if (device.getStatus().equals("1")) {
			device.setStatus("使用中");
		}else {
			device.setStatus("未使用");
		}
		return device;
	}
	
}
