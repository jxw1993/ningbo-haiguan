package com.service;

import java.sql.SQLException;

import com.vos.User;

public interface UserLoginService {

	public User validateUser(User user) throws SQLException;
}
