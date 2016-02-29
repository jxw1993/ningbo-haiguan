package com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.vos.ConfigType;
import com.vos.Device;
import com.vos.DeviceSearchVo;
import com.vos.IndicatorVO;
import com.vos.PortInfoVo;

public interface JiangBeiDao {

	public List<IndicatorVO> getIndicator() throws SQLException;
	
}
