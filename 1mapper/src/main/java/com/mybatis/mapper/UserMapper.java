package com.mybatis.mapper;

import java.util.List;

import com.mybatis.entity.User;

public interface UserMapper {
	// 根据id查询用户信息
	public User findUserById(int id);

	// 添加用户信息
	public int insertUser(User user);

	// 删除用户信息
	public int deleteUserById(int id);

	// 修改用户信息
	public int updateUser(User user);
	
	public List<User> findUserByUsername(String username);
}