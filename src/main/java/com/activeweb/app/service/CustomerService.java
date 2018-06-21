package com.activeweb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activeweb.app.beans.Customer;
import com.activeweb.app.dao.CustomerDAOHibImpl;
import com.activeweb.app.dao.CustomerDAOJDBCImpl;

@Service
public class CustomerService {

	@Autowired
	CustomerDAOJDBCImpl customerDAOImpl;

	@Autowired
	CustomerDAOHibImpl customerHibDAOImpl;

	public boolean persistCustomer(Customer customer) {

		com.activeweb.app.model.Customer customerDB = new com.activeweb.app.model.Customer();

		return customerDAOImpl.persistCustomer(customerDB);
	}

	public Customer getCustomer() {

		com.activeweb.app.model.Customer customerDB = customerHibDAOImpl.getCustomerInfo(1);

		Customer customer = new Customer();
		customer.setId(customerDB.getId());
		customer.setName(customerDB.getName());
		customer.setAddress(customerDB.getAddress());

		return customer;
	}

}
