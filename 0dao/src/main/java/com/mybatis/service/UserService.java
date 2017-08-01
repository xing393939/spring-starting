package com.mybatis.service;

import com.mybatis.dao.IUserDao;
import com.mybatis.entity.User;

public class UserService {

	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	// 修改用户信息
	public void updateUser(User user) {
		userDao.updateUser(user);
		int a = 1 / 0;
	}
}
