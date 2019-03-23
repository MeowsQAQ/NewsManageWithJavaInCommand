package com.qksoft.test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtils {

 
		private static String DriverClass;
		private static String url;
		private static String user;
		private static String password;
		// 静态代码块   类只要加载，直接执行     
		 // 就是将配置文件加载；
		static{
			ResourceBundle rb  = ResourceBundle.getBundle("dbinfo");
			// 进行赋值操作；
			DriverClass   = rb.getString("DriverClass");
			url  = rb.getString("url");
			user = rb.getString("user");
			password = rb.getString("password");
			try {
				Class.forName(DriverClass);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// 创建两个方法：    // yi :得到连接的方法
		public static Connection getConnection() throws Exception{
			
			return  (Connection) DriverManager.getConnection(url,user,password);
				
			
		}
		// 二 ： 关闭资源
		public static void closeAll(ResultSet rs,PreparedStatement stmt,java.sql.Connection conn)
		{
			if(rs!=null)
			{
				try{
					rs.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
 
			if(stmt!=null)
			{
				try{
					stmt.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
 
			if(conn!=null)
			{
				try{
					conn.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		
		
		
	}



