package com.service.imp;

import java.sql.SQLException;

import com.dao.UserLoginDao;
import com.service.UserLoginService;
import com.vos.User;

public class UserLoginServiceImp implements UserLoginService {

	private UserLoginDao userLoginDao;

	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	@Override
	public User validateUser(User user) throws SQLException {
		
		return userLoginDao.validateUser(user);
	}


}
