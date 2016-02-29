package com.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.dao.JiangBeiDao;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.vos.IndicatorVO;

public class JiangBeiDaoImp implements JiangBeiDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public List<IndicatorVO> getIndicator()
			throws SQLException {
		List<IndicatorVO> list = null;
		list = sqlMapClient.queryForList("getIndicatorList");
		return list;
	}

}
