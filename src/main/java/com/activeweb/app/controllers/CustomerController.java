package com.activeweb.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activeweb.app.beans.Customer;
import com.activeweb.app.dao.CustomerDAOSpringImpl;
import com.activeweb.app.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerDAOSpringImpl CustomerDAOSpringImpl;

	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public com.activeweb.app.model.Customer getCustomerInformation(HttpServletRequest request) {

		HttpSession session = request.getSession();

		session.setAttribute("Customername", "Mark");

		return CustomerDAOSpringImpl.getCustomerInfo(1);

	}

	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public String getOrderInformation(HttpServletRequest request) {

		HttpSession session = request.getSession();

		customerService.persistCustomer(null);

		return "The order is for customer.." + session.getAttribute("Customername");

	}

}
