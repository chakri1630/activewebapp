package com.activeweb.app.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.activeweb.app.model.Customer;

@Repository
public class CustomerDAOJDBCImpl implements CustomerDAO {

	Logger logger = LoggerFactory.getLogger(CustomerDAOJDBCImpl.class);

	@Override
	public Customer getCustomerInfo(Integer id) {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://localhost:5432/";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "postgres");

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, props);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from customer where id=10 and name=" + "'Hari'");

			PreparedStatement pst = conn.prepareStatement("select * from customer where id=?");
			pst.setInt(1, 10);
			ResultSet rs1 = pst.executeQuery();

			while (rs1.next()) {
				System.out.println("Name from prepared statement query is ..." + rs1.getString("name"));
			}

			while (rs.next()) {
				Customer cs = new Customer();

				cs.setName(rs.getString("name"));
				cs.setAddress(rs.getString("address"));

				System.out.println(rs.getString("name"));
			}

		} catch (SQLException e) {
			logger.error("Exception occured..." + e.getMessage());
		}

		return null;
	}

	@Override
	public boolean persistCustomer(Customer customer) {

		try {
			Context ctx = new InitialContext();

			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/postgres");

			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("insert into customer values(1, 'Mark', 'Dallas')");

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]) {
		CustomerDAOJDBCImpl cdi = new CustomerDAOJDBCImpl();
		cdi.getCustomerInfo(10);
	}

}
