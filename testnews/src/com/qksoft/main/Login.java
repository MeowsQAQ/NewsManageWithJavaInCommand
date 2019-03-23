package com.qksoft.main;

import java.util.Scanner;
import com.qksoft.entity.User;
import com.qksoft.service.UserService;
import com.qksoft.service.impl.UserServiceImpl;
import com.qksoft.util.DBConn;




public class Login {
	DBConn con = new DBConn();
	public void Login() {
	ClassMan m1 = new ClassMan();
	Login  l1 =new Login();
	
	System.out.println("欢迎登陆新闻发布系统");
	
	
	System.out.println("请输入用户名");
	Scanner scanner=new Scanner(System.in);
	String username=scanner.next();
	System.out.println("请输入密码");
	String password=scanner.next();
	
	User user =new User();
	UserService userservice =new UserServiceImpl();
	if(userservice.search(user).getpassword().equals(password))
		{System.out.print(username+"欢迎登陆");
		m1.Menu();}
	else {
		System.out.println("登陆失败");
		l1.Login();
	}

	
	
	
	
	/*
		//根据账号id得到账户详细信息
		String sqlInsert = "select * from  user where username=? and password =?";
		User account =null;
		account=null;
		PreparedStatement pst=null;
		try {
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1,username);
			pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				account= new User();
				account.setId(rs.getInt(1));
				account.setUsername(rs.getString(2));
				account.setpassword(rs.getString(3));
				System.out.print(rs.getInt(1)+"欢迎");
				m1.Menu();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
		*/
	
	
	




/*	if(!username.equals("m")){

		System.out.println("用户名非法。");
		l1.Login();
		

		}else if(!password.equals("123")){

		System.out.println("登陆密码错误。");
		l1.Login();

		}else{
		
		m1.Menu();}}*/
	
	

	
}}

	




