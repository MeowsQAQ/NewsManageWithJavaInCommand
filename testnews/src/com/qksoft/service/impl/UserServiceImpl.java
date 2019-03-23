package com.qksoft.service.impl;

import com.qksoft.dao.UserDao;
import com.qksoft.dao.UserDaoImpl;
import com.qksoft.entity.User;
import com.qksoft.service.UserService;

public class UserServiceImpl implements UserService{
	
	
		private UserDao userDao=new UserDaoImpl();
		
		@Override
		public int addUser(User user) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public User search(User user) {
			String sql="select username,password from user where username=?";
			return userDao.query(sql, user.getUsername());
		
	}
}
