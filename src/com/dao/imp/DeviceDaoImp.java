package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.DeviceDao;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.vos.ConfigType;
import com.vos.Device;
import com.vos.DeviceSearchVo;
import com.vos.DeviceType;
import com.vos.MaintainCompanyVo;
import com.vos.MaintainVo;
import com.vos.PortInfoVo;

public class DeviceDaoImp implements DeviceDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public String getAllUser() {
		
		return "hello";
	}

	public void addDevice(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		//try {
			sqlMapClient.insert("addDevice",map);
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}

	@Override
	public int getAllDevice(DeviceSearchVo d) throws SQLException {
		List<Device> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("count", null);
		map.put("brand", d.getBrand());
		map.put("bStartDate", d.getbStartDate());
		map.put("bEndDate", d.getbEndDate());
		list = sqlMapClient.queryForList("getAllDeviceBySearch",map);
		return (Integer) map.get("count");
	}

	@Override
	public int checkIfExists(int id) throws SQLException {
		int i = 0;
		i = (Integer) sqlMapClient.queryForObject("checkIfExists",id);
		return i;
	}

	@Override
	public void updateDevice(Device device,int id) throws SQLException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("device", device);
		map.put("id", id);
		sqlMapClient.update("updateDevice",map);
	}

	@Override
	public void deleteDevice(int id) throws SQLException {
		// TODO Auto-generated method stub
		try{
		sqlMapClient.delete("deleteDevice",id);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Device> getDeviceByPager(int firstRow, int pageSize, DeviceSearchVo d)
			throws SQLException {
		List<Device> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		int endRow = pageSize+firstRow;
		map.put("beginRow", firstRow);
		map.put("endRow", endRow);
		map.put("brand", d.getBrand());
		map.put("bStartDate", d.getbStartDate());
		map.put("bEndDate", d.getbEndDate());
		sqlMapClient.queryForList("queryBySearch",map);
		return (List<Device>) map.get("list");
	}

	@Override
	public Map<String,Object> queryMaintainDetailById(int id) throws SQLException {
		// TODO Auto-generated method stub
		MaintainVo mvo = null;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		mvo = (MaintainVo) sqlMapClient.queryForObject("queryMaintainDetailById",map);
		map.put("mvo", mvo);
		return map;
	}

	@Override
	public void updateMaintainInfo(Map<String,Object> map) throws SQLException {

		sqlMapClient.update("updateMaintainInfo", map);
		
	}

	@Override
	public String getFilePathById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String filePath = null;
		filePath = (String) sqlMapClient.queryForObject("getFilePathById",id);				
		return filePath;
	}

	@Override
	public List<DeviceType> getDeciveType() throws SQLException {
		// TODO Auto-generated method stub
		List<DeviceType> list = null;
		list = sqlMapClient.queryForList("getDeviceType");
		return list;
	}

	@Override
	public List<MaintainCompanyVo> getMaintainCompany() throws SQLException {
		List<MaintainCompanyVo> list = null;
		list = sqlMapClient.queryForList("getCompany");
		return list;
	}

	@Override
	public Device getDeviceByNFC(String seriesNo) throws SQLException {
		Device device = null;
		device = (Device) sqlMapClient.queryForObject("getDeviceByNFC",seriesNo);
		return device;
	}

	@Override
	public int getPortNumber(int id) throws SQLException {
		// TODO Auto-generated method stub
		int portNum = 0;
		portNum = (Integer) sqlMapClient.queryForObject("getPortNumber",id);
		return portNum;
	}

	@Override
	public List<PortInfoVo> getPortInfo(int id, int portNum)
			throws SQLException {
		Map<String,Object> map = new HashMap<String, Object>();
		List<PortInfoVo> list = new ArrayList<PortInfoVo>();
		String sNo = null;
		String sName = null;
		String nNo = null;
		String nName = null;
		int nPort = 0;
		map.put("id", id);
		map.put("portNum",portNum);
		map.put("sNo",sNo);
		map.put("sName",sName);
		map.put("nNo",nNo);
		map.put("nPort",nPort);
		map.put("nName",nName);
		//map.put("vo", vo);
		sqlMapClient.queryForObject("getPortInfo",map);
		PortInfoVo vo = new PortInfoVo();
		vo.setsPort(portNum);
		vo.setsName(map.get("sName").toString());
		vo.setsNo(map.get("sNo").toString());
		vo.setnName(map.get("nName").toString());
		vo.setnNo(map.get("nNo").toString());
		vo.setnPort(Integer.parseInt(map.get("nPort").toString()));
		list.add(vo);
		return list;
	}

	@Override
	public List<Device> getDeviceByPager(int firstRow, int pageSize,
			int typeId, int selfId) throws SQLException {
		List<Device> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		int endRow = pageSize+firstRow;
		map.put("beginRow", firstRow);
		map.put("endRow", endRow);
		map.put("typeId", typeId);
		map.put("selfId", selfId);
		list = sqlMapClient.queryForList("getDeviceByPager2",map);
		return list;
	}

	@Override
	public int getAllDevice(int typeId) throws SQLException {
		int count = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("typeId", typeId);
		count = (Integer) sqlMapClient.queryForObject("getAllDeviceByType",map);
		return count;
	}

	@Override
	public int updatePortInfo(PortInfoVo vo) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("updatePortInfo",vo);
		return vo.getResult();
	}

	@Override
	public List<ConfigType> getConfigType() throws SQLException {
		// TODO Auto-generated method stub
		List<ConfigType> list = null;
		list = sqlMapClient.queryForList("getConfigType");
		return list;
	}



}
