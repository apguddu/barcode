package com.mnptech.bcgen.service;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class QueueWriterServiceImpl implements QueueWriterService {

	@Override
	public void putPriceMessageToQueue(String message) throws JMSException {
		queueConnection();		
	}
	
	private static void queueConnection(){
		
		try{
			
			 ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			 
	         // Create a Connection
	         Connection connection = connectionFactory.createConnection();
	         connection.start();

	         // Create a Session
	         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	         
	         Destination destination = new ActiveMQQueue("BarcodeQueue");
	         
	         // Create a MessageProducer from the Session to the Topic or Queue
	         MessageProducer producer = session.createProducer(destination);
	         producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

	         // Create a messages
	         String text = "Hello world! From me ";
	         TextMessage message = session.createTextMessage(text);

	         // Tell the producer to send the message
	         producer.send(message);
	         System.out.println(message.getJMSMessageID());
	         System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
	         
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
         
	}

}
