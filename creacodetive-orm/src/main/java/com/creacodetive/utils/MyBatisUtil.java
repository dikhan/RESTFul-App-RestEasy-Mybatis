package com.creacodetive.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Utils in charge of creating the SqlSessionFactory object.
 * 
 * @author Daniel I. Khan Ramiro (di.khan.r@gmail.com)
 */
public class MyBatisUtil {

	 private static SqlSessionFactory factory;

	 private MyBatisUtil() {
	 }

	 static
	 {
	  Reader reader = null;
	  try {
	   reader = Resources.getResourceAsReader("mybatis-config.xml");
	  } catch (IOException e) {
	   throw new RuntimeException(e.getMessage());
	  }
	  factory = new SqlSessionFactoryBuilder().build(reader);
	 }

	 public static SqlSessionFactory getSqlSessionFactory() 
	 {
	  return factory;
	 }
	
}