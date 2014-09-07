package com.creacodetive.api.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.ibatis.session.SqlSession;

import com.creacodetive.mappers.UserMapper;
import com.creacodetive.model.User;
import com.creacodetive.utils.MyBatisUtil;

/**
 * RESTEasy Users Service
 * 
 * @author Daniel I. Khan Ramiro (di.khan.r@gmail.com)
 */
@Path("/users")
public class UserService {

	/**
	 * @param user
	 */
	@PUT
	@Consumes("application/json")
	public void insertUser(User user) 
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@GET
	@Produces("application/json")
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") Integer userId) 
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserById(userId);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * @return
	 */
	@GET
	@Produces
	public List<User> getAllUsers() 
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getAllUsers();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * @param userId
	 * @param user
	 */
	@POST
	@Consumes("application/json")
	@Path("/{userId}") //@NotNull @NotEmpty
	public void updateUser(@PathParam("userId") Integer userId, User user) 
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			user.setUserId(userId);
			userMapper.updateUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * @param userId
	 */
	@DELETE
	@Consumes("application/json")
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") Integer userId) 
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteUser(userId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

}
