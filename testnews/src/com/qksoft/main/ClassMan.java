package com.qksoft.main;

import java.util.Scanner;

public class ClassMan {
	
		public void Menu() {

	        System.out.println("***************");
	        System.out.println("*��ӭ�������Ź���ϵͳ *");
	        System.out.println("*1���û�����                    *");
	        System.out.println("*2��������                    *");
	        System.out.println("*3�����¹���                    *");
	        System.out.println("*4���˳�ϵͳ                    *");
	        System.out.println("***************");
	        
	        System.out.println("����ѡ��Ĳ����ǣ�");
	        Scanner scchoice=new Scanner(System.in);
	        int choice =scchoice.nextInt();
	        
	        switch(choice){
	        //�û�����
	        case 1:
	        	UserMan u1=new UserMan();
	        	u1.UserManMenu();
	            break;
	        //������
	        case 2:
	        	CateMan c1= new CateMan();
	        	c1.CateMan();
	           
	            break;
	        //���¹���
	        case 3:
	        	EssayMan e1 =new EssayMan();
	        	e1.EssayMan();
	            
	            break;
	        //�˳�ϵͳ
	        case 4:
	        	Login l1 =new Login();
	        	l1.Login();
	            
	            break;
	        default:
	            System.out.println("������������������������룺");
	            break;
	        }


	}
		
		}


