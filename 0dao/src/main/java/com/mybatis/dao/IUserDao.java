package com.mybatis.dao;

import com.mybatis.entity.User;

public interface IUserDao {
	// 根据id查询用户信息
	public User findUserById(int id);

	// 添加用户信息
	public void insertUser(User user);

	// 删除用户信息
	public void deleteUser(int id);

	// 修改用户信息
	public void updateUser(User user);
}