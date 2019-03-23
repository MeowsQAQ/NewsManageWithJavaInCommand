package com.qksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	public static Connection getConnnection() {
		  Connection conn = null;
		  @SuppressWarnings("unused")
		Statement stmt = null;
		  @SuppressWarnings("unused")
		ResultSet rs = null;
		  String url = null;
		  String user = null;
		  String password = null;
		  @SuppressWarnings("unused")
		String sql = null;
		try {
	
			Class.forName("com.mysql.jdbc.Driver"); //加载mysq驱动
			  } catch (ClassNotFoundException e) {
			   System.out.println("驱动加载错误");
			   e.printStackTrace();//打印出错详细信息
			  }
			  try {
			   url = 
			    "jdbc:mysql://127.0.0.1:3306/newsdb?seUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
			   user = "root";
			   password = "123";
			   conn = DriverManager.getConnection(url,user,password);
			   System.out.println("数据库已连接！！！");
			  } catch (SQLException e) {
			   System.out.println("数据库链接错误");
			   e.printStackTrace();
			  }
		
		return conn;
	}

	public PreparedStatement prepareStatement(String sqlInsert) {
		// TODO Auto-generated method stub
		return null;
	}


}
