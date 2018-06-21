package com.activeweb.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.activeweb.app.model.Customer;

@Repository
public class CustomerDAOHibImpl implements CustomerDAO {

	@Override
	public Customer getCustomerInfo(Integer id) {

		final Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		final SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		final Session session = sessionFactory.openSession();

		Transaction tx = session.getTransaction();

		tx.begin();

		session.get(Customer.class, id);

		tx.commit();

		return null;
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

	public static void main(String args[]) {
		CustomerDAOHibImpl cdi = new CustomerDAOHibImpl();
		cdi.getCustomerInfo(10);
	}

}
