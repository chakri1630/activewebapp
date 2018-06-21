package com.activeweb.app.service;

import javax.jms.JMSException;

import com.activeweb.app.beans.Order;

public interface OrderMessagingService {

	public void publishOrders(Order order) throws JMSException;
	
}
