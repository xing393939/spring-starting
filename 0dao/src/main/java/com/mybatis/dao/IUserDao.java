package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.User;

public interface IUserDao {
	// 根据id查询用户信息
	public User findUserById(int id);
	
	public List<User> findUserByUsername(String username);

	// 添加用户信息
	public int insertUser(User user);

	// 删除用户信息
	public int deleteUser(int id);

	// 修改用户信息
	public int updateUser(User user);
}