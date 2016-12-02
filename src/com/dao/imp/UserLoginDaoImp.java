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

	public User validateUser(User user) throws SQLException {
		return (User) sqlMapClient.queryForObject("validateUser",user);
	}
}
