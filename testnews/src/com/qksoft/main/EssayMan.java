package com.qksoft.main;

import java.util.Scanner;

public class EssayMan {
	ClassMan m1 = new ClassMan();
	public void EssayMan() {
		System.out.println("***************");
        System.out.println("*��ӭ�������¹���ϵͳ *");
        System.out.println("*1���������                        *");
        System.out.println("*2���޸�����                          *");
        System.out.println("*3�� ɾ������                         *");
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
        }
		
		
		
		
	}

}
