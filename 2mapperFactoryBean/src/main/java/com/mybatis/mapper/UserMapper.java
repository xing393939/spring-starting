package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.entity.User;

public interface UserMapper {
	// 根据id查询用户信息
	@Select("select * from user where id = #{id}")
	public User findUserById(@Param("id") int id);

	// 添加用户信息
	@Insert("insert into user(userName,userAge,userAddress)values(#{username},#{birthday},#{address})")
	public int insertUser(User user);

	// 删除用户信息
	@Delete("delete from user where id=#{id}")
	public int deleteUserById(@Param("id") int id);

	// 修改用户信息
	@Update("update user set userName=#{username},userAge=#{birthday},userAddress=#{address} where id=#{id}")
	public int updateUser(User user);
	
	@Select("select * from user where userName like '%${value}%'")
	public List<User> findUserByUsername(@Param("value") String username);
}