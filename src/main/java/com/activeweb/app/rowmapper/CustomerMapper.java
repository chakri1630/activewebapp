package com.activeweb.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.activeweb.app.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer customer = new Customer();

		customer.setName(rs.getString("name"));
		customer.setId(rs.getInt("id"));
		customer.setAddress(rs.getString("address"));

		return customer;
	}

}
