package com.qksoft.main;

import java.util.Scanner;

public class CateMan {
	ClassMan m1 = new ClassMan();
	public void CateMan() {
		System.out.println("***************");
        System.out.println("*欢迎来到类别管理系统 *");
        System.out.println("*1：增加类别                          *");
        System.out.println("*2：删除类别                          *");
        System.out.println("*3：修改类别权重                   *");
        System.out.println("*4：返回主页                    	  *");
        System.out.println("***************");
        
        System.out.println("您想选择的操作是：");
        Scanner usrchoice=new Scanner(System.in);
        int choice =usrchoice.nextInt();
        switch(choice){
        //用户管理
        case 1:
           
            break;
        //类别管理
        case 2:
           
            break;
        //文章管理
        case 3:
            
            break;
        //退出系统
        case 4:
        	
        	m1.Menu();
            
            break;
        default:
            System.out.println("您输入的数字有误，请重新输入：");
            break;
        }
		
		
		
		
	}

}
