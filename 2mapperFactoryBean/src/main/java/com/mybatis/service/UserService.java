package com.mybatis.service;

import java.util.List;

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
	public int updateUser(User user) {
		int r = userMapper.updateUser(user);
		return r;
	}
	
	public int insertUser(User user) {
		int r = userMapper.insertUser(user);
		return r;
	}
	
	public int deleteUserById(int id) {
		return userMapper.deleteUserById(id);
	}

	// 修改用户信息
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}
	
	public List<User> findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
}
