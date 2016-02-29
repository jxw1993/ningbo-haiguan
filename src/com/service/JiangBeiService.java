package com.service;

import java.sql.SQLException;
import java.util.List;

import com.vos.IndicatorVO;

public interface JiangBeiService {

	public List<IndicatorVO> getIndicator() throws SQLException;
}
