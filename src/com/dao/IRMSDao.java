package com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

public interface IRMSDao {

	public UserVO getUserInfo(Map<String,Object> map) throws SQLException;
	
	public BaseInfoVO getBaseInfo(Map<String,Object> map) throws SQLException;
	
	public CheckInfoVO getCheckInfo(Map<String,Object> map) throws SQLException;
	
	public List<PortItemVO> getPortList(Map<String,Object> map) throws SQLException;
	
	public PortDetailVO getPortDetail(Map<String,Object> map) throws SQLException;
	
	public List<PortTypeVO> getPortType(Map<String,Object> map) throws SQLException;
	
	public List<PortTypeVO> getPortNumber(Map<String,Object> map) throws SQLException;
	
	public boolean updatePortInfo(Map<String,Object> map) throws SQLException;
	
	public boolean emptyPortInfo(Map<String,Object> map) throws SQLException;
	
	public List<SetupItemVO> getSetupList(Map<String,Object> map) throws SQLException;
	
	public SetupDetailVO getSetupDetail(Map<String,Object> map) throws SQLException;
	
	public List<InspectItemVO> getInspectList(Map<String,Object> map) throws SQLException;
	
	public boolean addInspect(List<InspectDetailVO> inspectList) throws SQLException;
	
	
}
