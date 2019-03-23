package com.qksoft.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {
	
	//处理数据库事务的  提交事务
	public static void commit(Connection conn)
	{
		if(null!=conn)
		{
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	//事务的回滚
	public static void rollback(Connection conn)
	{
		if(null!=conn)
		{
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//事务的开始
	public static void begin(Connection conn)
		{
			if(null!=conn)
			{
				try {
					conn.setAutoCommit(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	
	
	 
	/**
	 * 通用的增删改的方法
	 * @param sql
	 * @param param
	 */
	public static int commonUpdate(String sql,Object... param)
	{
		Connection conn=null;
		
		int rows=0;
		
		PreparedStatement preparedStatement=null;
		
		try {
		 conn=JdbcUtil.getConnection();
		 preparedStatement=conn.prepareStatement(sql);
		 
		 for (int i = 0; i < param.length; i++) 
		 {
			 preparedStatement.setObject(i+1, param[i]);
		 }
		 
		 rows= preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JdbcUtil.closeResources(conn, preparedStatement, null);
		}
		return rows;
	}
	
	 
	
	/**
	 * 获取连接的方法
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception
	{
		Properties properties=new Properties();
		//速度快的方式
		//new fileinputStream();
		InputStream is=JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//jdbc文件 内容 以流的方法加载到properties文件中 ing     alias  alies
		properties.load(is);
		String driver=properties.getProperty("driver");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		String url=properties.getProperty("jdbcUrl");
		//System.out.println(driver+"password"+password);
		Class.forName(driver);
		
		return DriverManager.getConnection(url, username, password);
		
	}
	/**
	 * 通用的关闭资源的方法
	 * @param conn
	 * @param statement
	 * @param resultSet
	 */
	public static void closeResources(Connection conn,Statement statement,ResultSet resultSet)
	{
		if(null!=conn)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=statement)
		{
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(null!=resultSet)
		{
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		
	}


	
	
	 
	

}
