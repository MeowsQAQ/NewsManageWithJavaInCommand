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
	
			Class.forName("com.mysql.jdbc.Driver"); //����mysq����
			  } catch (ClassNotFoundException e) {
			   System.out.println("�������ش���");
			   e.printStackTrace();//��ӡ������ϸ��Ϣ
			  }
			  try {
			   url = 
			    "jdbc:mysql://127.0.0.1:3306/newsdb?seUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
			   user = "root";
			   password = "123";
			   conn = DriverManager.getConnection(url,user,password);
			   System.out.println("���ݿ������ӣ�����");
			  } catch (SQLException e) {
			   System.out.println("���ݿ����Ӵ���");
			   e.printStackTrace();
			  }
		
		return conn;
	}

	public PreparedStatement prepareStatement(String sqlInsert) {
		// TODO Auto-generated method stub
		return null;
	}


}
