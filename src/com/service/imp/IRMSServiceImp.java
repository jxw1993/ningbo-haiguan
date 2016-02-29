package com.service.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dao.IRMSDao;
import com.service.IRMSService;
import com.vo.BaseInfoVO;
import com.vo.CheckInfoVO;
import com.vo.InspectDetailVO;
import com.vo.InspectItemVO;
import com.vo.PortDetailVO;
import com.vo.PortItemVO;
import com.vo.PortTypeVO;
import com.vo.SetupDetailVO;
import com.vo.SetupItemVO;
import com.vo.UserVO;

public class IRMSServiceImp implements IRMSService {

	private IRMSDao irmsDao;

	public IRMSDao getIrmsDao() {
		return irmsDao;
	}

	public void setIrmsDao(IRMSDao irmsDao) {
		this.irmsDao = irmsDao;
	}

	@Override
	public UserVO getUserInfo(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getUserInfo(map); 
	}
	
	@Override
	public BaseInfoVO getBaseInfo(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getBaseInfo(map); 
	}
	
	@Override
	public CheckInfoVO getCheckInfo(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getCheckInfo(map); 
	}
	
	@Override
	public List<PortItemVO> getPortList(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getPortList(map); 
	}
	
	@Override
	public PortDetailVO getPortDetail(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getPortDetail(map); 
	}
	
	@Override
	public List<PortTypeVO> getPortType(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getPortType(map); 
	}
	
	@Override
	public List<PortTypeVO> getPortNumber(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getPortNumber(map); 
	}
	
	@Override
	public boolean updatePortInfo(Map<String,Object> oldMap,Map<String,Object> newMap,Map<String,Object> baseMap,Map<String,Object> nextMap) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		if(!oldMap.isEmpty()){
			result = irmsDao.emptyPortInfo(oldMap);
		}
		if(!newMap.isEmpty()){
			result = irmsDao.emptyPortInfo(newMap);
		}
		result = irmsDao.updatePortInfo(baseMap);
		result = irmsDao.updatePortInfo(nextMap);
		return  result;
	}
	
	@Override
	public List<SetupItemVO> getSetupList(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getSetupList(map); 
	}
	
	@Override
	public SetupDetailVO getSetupDetail(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getSetupDetail(map); 
	}
	
	@Override
	public List<InspectItemVO> getInspectList(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return irmsDao.getInspectList(map); 
	}
	
	@Override
	public boolean addInspect(List<InspectDetailVO> inspectList) throws SQLException {
		boolean result = false;
		result = irmsDao.addInspect(inspectList);
		return  result;
	}


}
