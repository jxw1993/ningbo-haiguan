package com.service.imp;

import java.sql.SQLException;
import java.util.List;

import com.dao.JiangBeiDao;
import com.service.JiangBeiService;
import com.vos.IndicatorVO;

public class JiangBeiServiceImp implements JiangBeiService {

	private JiangBeiDao jiangBeiDao;

	public JiangBeiDao getJiangBeiDao() {
		return jiangBeiDao;
	}

	public void setJiangBeiDao(JiangBeiDao jiangBeiDao) {
		this.jiangBeiDao = jiangBeiDao;
	}

	@Override
	public List<IndicatorVO> getIndicator() throws SQLException {
		// TODO Auto-generated method stub
		return jiangBeiDao.getIndicator(); 
	}

}
