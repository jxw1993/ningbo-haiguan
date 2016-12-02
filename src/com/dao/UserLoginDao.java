package com.dao;

import java.sql.SQLException;

import com.vos.User;

public interface UserLoginDao {

	public User validateUser(User user) throws SQLException;
}
