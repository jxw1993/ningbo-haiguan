package com.service.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dao.DeviceDao;
import com.service.DeviceService;
import com.vos.ConfigType;
import com.vos.Device;
import com.vos.DeviceSearchVo;
import com.vos.DeviceType;
import com.vos.MaintainCompanyVo;
import com.vos.MaintainVo;
import com.vos.PortInfoVo;

public class DeviceServiceImp implements DeviceService {

	private DeviceDao deviceDao;

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}

	@Override
	public String getAllUser() {
		// TODO Auto-generated method stub
		return deviceDao.getAllUser();
	}

	@Override
	public void addDevice(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.addDevice(map);
	}

	@Override
	public int getAllDevice(DeviceSearchVo d) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllDevice(d);
	}

	@Override
	public int checkIfExists(int id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.checkIfExists(id);
	}

	@Override
	public void updateDevice(Device device, int id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updateDevice(device,id);
	}

	@Override
	public void deleteDevice(int id) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.deleteDevice(id);
	}

	@Override
	public List<Device> getDeviceByPager(int firstRow,int pageSize, DeviceSearchVo d) throws SQLException {
		// TODO Auto-generated method stub
		
		return deviceDao.getDeviceByPager(firstRow, pageSize,d);
	}

	@Override
	public Map<String,Object> queryMaintainDetailById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.queryMaintainDetailById(id);
	}

	@Override
	public void updateMaintainInfo(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		deviceDao.updateMaintainInfo(map);
		
	}

	@Override
	public String getFilePathById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getFilePathById(id);
	}

	@Override
	public List<DeviceType> getDeviceType() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getDeciveType();
	}

	@Override
	public List<MaintainCompanyVo> getMaintainCompany() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getMaintainCompany();
	}

	@Override
	public Device getDeviceByNFC(String seriesNo) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceByNFC(seriesNo);
	}

	@Override
	public int getPortNumber(int id) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getPortNumber(id);
	}

	@Override
	public List<PortInfoVo> getPortInfo(int id, int portNum)
			throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getPortInfo(id, portNum);
	}

	@Override
	public List<Device> getDeviceByPager(int firstRow, int pageSize,
			int typeId, int selfId) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceByPager(firstRow, pageSize,typeId,selfId);
	}

	@Override
	public int getAllDevice(int typeName) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getAllDevice(typeName);
	}

	@Override
	public int updatePortInfo(PortInfoVo vo) throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.updatePortInfo(vo);
	}

	@Override
	public List<ConfigType> getConfigType() throws SQLException {
		// TODO Auto-generated method stub
		return deviceDao.getConfigType();
	}
}
