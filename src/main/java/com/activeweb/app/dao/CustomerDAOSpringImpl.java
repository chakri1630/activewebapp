package com.activeweb.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.activeweb.app.model.Customer;
import com.activeweb.app.rowmapper.CustomerMapper;

@Repository
public class CustomerDAOSpringImpl implements CustomerDAO {
	
	@Autowired
	DriverManagerDataSource dataSource;

	@Override
	public Customer getCustomerInfo(Integer id) {

		String sql = "select * from customer";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Customer> customers = jdbcTemplate.query(sql, new Object[]
		{ id }, new CustomerMapper());

		Customer customer = customers.get(0);
		
		System.out.println("Customer..."+customer);
		
		return customer;
		
		
	}

	@Override
	public boolean persistCustomer(Customer customer) {

		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
