package com.activeweb.app.service;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class OrderProcessingServiceImpl {

	public void processOrders() throws JMSException {

		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		// Create a Connection
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// Create a Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create the destination (Topic or Queue)
		Destination destination = session.createQueue("activeweb.order.queue");

		// Create a MessageProducer from the Session to the Topic or Queue
		MessageConsumer consumer = session.createConsumer(destination);

		TextMessage message = (TextMessage) consumer.receive();

		System.out.println("The message data is..." + message.getJMSCorrelationID()+"message is.."+message.getText());
		
		// Clean up
		session.close();
		connection.close();

	}

	public static void main(String args[]) {
		OrderProcessingServiceImpl opsi = new OrderProcessingServiceImpl();
		try {
			opsi.processOrders();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
