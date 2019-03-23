package com.qksoft.main;

import java.util.Scanner;

public class ClassMan {
	
		public void Menu() {

	        System.out.println("***************");
	        System.out.println("*欢迎来到新闻管理系统 *");
	        System.out.println("*1：用户管理                    *");
	        System.out.println("*2：类别管理                    *");
	        System.out.println("*3：文章管理                    *");
	        System.out.println("*4：退出系统                    *");
	        System.out.println("***************");
	        
	        System.out.println("您想选择的操作是：");
	        Scanner scchoice=new Scanner(System.in);
	        int choice =scchoice.nextInt();
	        
	        switch(choice){
	        //用户管理
	        case 1:
	        	UserMan u1=new UserMan();
	        	u1.UserManMenu();
	            break;
	        //类别管理
	        case 2:
	        	CateMan c1= new CateMan();
	        	c1.CateMan();
	           
	            break;
	        //文章管理
	        case 3:
	        	EssayMan e1 =new EssayMan();
	        	e1.EssayMan();
	            
	            break;
	        //退出系统
	        case 4:
	        	Login l1 =new Login();
	        	l1.Login();
	            
	            break;
	        default:
	            System.out.println("您输入的数字有误，请重新输入：");
	            break;
	        }


	}
		
		}


