package com.mybatis.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mybatis.dao.IUserDao;
import com.mybatis.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {

	// SqlSessionDaoSupport中包含了sqlSessionFactory，并进行了一些简单的封装
	// private SqlSessionFactory sqlSessionFactory;

	@Override
	public User findUserById(int id) {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("user.findUserById", id);
		return user;
	}
	
	@Override
	public List<User> findUserByUsername(String username) {
		SqlSession sqlSession = this.getSqlSession();
		List<User> users = sqlSession.selectList("user.findUserByUsername", username);
		return users;
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		// 执行插入操作
		int r = sqlSession.insert("user.insertUser", user);
		return r;
	}

	@Override
	public int deleteUser(int id) {
		SqlSession sqlSession = this.getSqlSession();
		// 执行插入操作
		int r = sqlSession.delete("user.deleteUserById", id);
		return r;
	}

	@Override
	public int updateUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		// 执行插入操作
		int r = sqlSession.update("user.updateUser", user);
		return r;
	}

}