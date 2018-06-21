package com.activeweb.app.dao;

import java.util.List;

import com.activeweb.app.model.Customer;

public interface CustomerDAO {

	public Customer getCustomerInfo(Integer id);

	public boolean persistCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();

}
