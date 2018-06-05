package com.activeweb.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	
	@RequestMapping(value = "/customerInfo", method = RequestMethod.POST)
	public String getCustomerInformation() {
		
		return "My first customer..";

	}
	
}
