package com.mybatis.service;

import org.springframework.transaction.PlatformTransactionManager;

import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;

public class UserService {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		PlatformTransactionManager manager;
		this.userMapper = userMapper;
	}

	// 修改用户信息
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	// 修改用户信息
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}
}
