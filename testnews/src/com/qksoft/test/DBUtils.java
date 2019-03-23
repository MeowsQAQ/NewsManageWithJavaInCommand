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
		// ��̬�����   ��ֻҪ���أ�ֱ��ִ��     
		 // ���ǽ������ļ����أ�
		static{
			ResourceBundle rb  = ResourceBundle.getBundle("dbinfo");
			// ���и�ֵ������
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
		
		
		// ��������������    // yi :�õ����ӵķ���
		public static Connection getConnection() throws Exception{
			
			return  (Connection) DriverManager.getConnection(url,user,password);
				
			
		}
		// �� �� �ر���Դ
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



