package com.dao.imp;

import java.sql.SQLException;

import com.dao.UserLoginDao;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.vos.User;

public class UserLoginDaoImp implements UserLoginDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public int validateUser(User user) {
		try {
			sqlMapClient.queryForObject("validateUser",user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user.getIsValid();
	}
}
