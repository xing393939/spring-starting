package com.mybatis.daoimpl;

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
	public void insertUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		// 执行插入操作
		sqlSession.insert("user.insertUser", user);

	}

	@Override
	public void deleteUser(int id) {
		SqlSession sqlSession = this.getSqlSession();
		// 执行插入操作
		sqlSession.delete("user.deleteUserById", id);

	}

	@Override
	public void updateUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		// 执行插入操作
		sqlSession.update("user.updateUser", user);
	}

}