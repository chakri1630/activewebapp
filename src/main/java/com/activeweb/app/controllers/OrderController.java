package com.activeweb.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activeweb.app.beans.Order;

@RestController
public class OrderController {

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> getOrders() {

		Order order1 = new Order();
		Order order2 = new Order();

		List<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);

		return orders;

	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public List<Order> getOrdersByDate(Date date) {

		Order order1 = new Order();
		Order order2 = new Order();

		List<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);

		return orders;

	}
	
}
