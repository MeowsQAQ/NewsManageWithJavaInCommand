package com.qksoft.service.impl;

import com.qksoft.dao.CustomerDao;
import com.qksoft.dao.CustomerDaoImpl;
import com.qksoft.entity.Customer;
import com.qksoft.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao=new CustomerDaoImpl();
	@Override
	public long addCustomer(Customer customer) {
		String sql="insert into customers(name,email) values(?,?)";
		 
		return customerDao.insert(sql, customer.getCustomerName(),customer.getEmail());
	}
	public Customer search(Customer customer) {
		String sql="select username,password from user where username=?";
		return customerDao.query(sql, customer.getCustomerName());
	}
	

}
