package com.qksoft.main;

import java.util.Scanner;

public class UserMan {
	ClassMan m1 = new ClassMan();
			public void UserManMenu() {
				System.out.println("***************");
		        System.out.println("*��ӭ�����û�����ϵͳ *");
		        System.out.println("*1���鿴�û���Ϣ                   *");
		        System.out.println("*2���޸��û�                          *");
		        System.out.println("*3�� ɾ���û�                         *");
		        System.out.println("*4��������ҳ                    	  *");
		        System.out.println("***************");
		        
		        System.out.println("����ѡ��Ĳ����ǣ�");
		        Scanner usrchoice=new Scanner(System.in);
		        int choice =usrchoice.nextInt();
		        switch(choice){
		        //�û�����
		        case 1:
		           
		            break;
		        //������
		        case 2:
		           
		            break;
		        //���¹���
		        case 3:
		            
		            break;
		        //�˳�ϵͳ
		        case 4:
		        	
		        	m1.Menu();
		            
		            break;
		        default:
		            System.out.println("������������������������룺");
		            break;
		        }}
			
}
