package com.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dao.IRMSDao;
import com.ibatis.sqlmap.client.SqlMapClient;
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

public class IRMSDaoImp implements IRMSDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public UserVO getUserInfo(Map<String,Object> map)
			throws SQLException {
		UserVO vo = null;
		vo = (UserVO) sqlMapClient.queryForObject("getUserInfo",map);
		return vo;
	}
	
	@Override
	public BaseInfoVO getBaseInfo(Map<String,Object> map)
			throws SQLException {
		BaseInfoVO vo = null;
		vo = (BaseInfoVO) sqlMapClient.queryForObject("getBaseInfo",map);
		return vo;
	}
	
	@Override
	public CheckInfoVO getCheckInfo(Map<String,Object> map)
			throws SQLException {
		CheckInfoVO vo = null;
		vo = (CheckInfoVO) sqlMapClient.queryForObject("getCheckInfo",map);
		return vo;
	}
	
	@Override
	public List<PortItemVO> getPortList(Map<String,Object> map)
			throws SQLException {
		List<PortItemVO> list = new ArrayList<PortItemVO>();
		list = sqlMapClient.queryForList("getPortList",map);
		return list;
	}
	
	@Override
	public PortDetailVO getPortDetail(Map<String,Object> map)
			throws SQLException {
		PortDetailVO vo = null;
		vo = (PortDetailVO) sqlMapClient.queryForObject("getPortDetail",map);
		return vo;
	}
	
	@Override
	public List<PortTypeVO> getPortType(Map<String,Object> map)
			throws SQLException {
		List<PortTypeVO> list = new ArrayList<PortTypeVO>();
		list = sqlMapClient.queryForList("getPortType",map);
		return list;
	}
	
	@Override
	public List<PortTypeVO> getPortNumber(Map<String,Object> map)
			throws SQLException {
		List<PortTypeVO> list = new ArrayList<PortTypeVO>();
		list = sqlMapClient.queryForList("getPortNumber",map);
		return list;
	}
	
	@Override
	public boolean updatePortInfo(Map<String,Object> map) throws SQLException {
		int rows=-1;
		rows = sqlMapClient.update("updatePortAppInfo",map);
		if(rows == -1){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public boolean emptyPortInfo(Map<String,Object> map) throws SQLException {
		int rows=-1;
		rows = sqlMapClient.update("emptyPortInfo",map);
		if(rows == -1){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public List<SetupItemVO> getSetupList(Map<String,Object> map)
			throws SQLException {
		List<SetupItemVO> list = new ArrayList<SetupItemVO>();
		list = sqlMapClient.queryForList("getSetupList",map);
		return list;
	}
	
	@Override
	public SetupDetailVO getSetupDetail(Map<String,Object> map)
			throws SQLException {
		SetupDetailVO vo = null;
		vo = (SetupDetailVO) sqlMapClient.queryForObject("getSetupDetail",map);
		return vo;
	}
	
	@Override
	public List<InspectItemVO> getInspectList(Map<String,Object> map)
			throws SQLException {
		List<InspectItemVO> list = new ArrayList<InspectItemVO>();
		list = sqlMapClient.queryForList("getInspectList",map);
		return list;
	}
	
	@Override
	public boolean addInspect(List<InspectDetailVO> inspectList) throws SQLException {
		Object result = null;
		result = (Integer)sqlMapClient.insert("addInspect",inspectList);//返回值为NULL时插入成功，不为NULL时插入失败
		if(result != null){
			return false;
		}else{
			return true;
		}
	}

}
