package com.mybatis.service;

import java.util.List;

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

	public int insertUser(User user) {
		int r = userDao.insertUser(user);
		return r;
	}
	
	// 修改用户信息
	public int updateUser(User user) {
		int r = userDao.updateUser(user);
		return r;
	}
	
	public int deleteUser(int id) {
		int r = userDao.deleteUser(id);
		return r;
	}
	
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	
	public List<User> findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
}
