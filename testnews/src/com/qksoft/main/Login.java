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
	
	System.out.println("��ӭ��½���ŷ���ϵͳ");
	
	
	System.out.println("�������û���");
	Scanner scanner=new Scanner(System.in);
	String username=scanner.next();
	System.out.println("����������");
	String password=scanner.next();
	
	User user =new User();
	UserService userservice =new UserServiceImpl();
	if(userservice.search(user).getpassword().equals(password))
		{System.out.print(username+"��ӭ��½");
		m1.Menu();}
	else {
		System.out.println("��½ʧ��");
		l1.Login();
	}

	
	
	
	
	/*
		//�����˺�id�õ��˻���ϸ��Ϣ
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
				System.out.print(rs.getInt(1)+"��ӭ");
				m1.Menu();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
		*/
	
	
	




/*	if(!username.equals("m")){

		System.out.println("�û����Ƿ���");
		l1.Login();
		

		}else if(!password.equals("123")){

		System.out.println("��½�������");
		l1.Login();

		}else{
		
		m1.Menu();}}*/
	
	

	
}}

	




