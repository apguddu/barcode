package com.mnptech.bcgen.job;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.mnptech.bcgen.dao.SpringMongoConfig;
import com.mnptech.bcgen.model.ProductDetails;
import com.mnptech.bcgen.service.QueueWriterService;

public class PriceSystemReaderQuartzTask {

	MongoOperations mongoOperation = null;
	
	@Autowired
	QueueWriterService queueServiceImpl;
	
	public void initJob(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}
	
	public void readPrice() throws JMSException{
		initJob();
		Query searchProductQuery = new Query();
		List<ProductDetails> productList = (ArrayList<ProductDetails>) mongoOperation.find(searchProductQuery, ProductDetails.class);
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
		QueueWriterService queueService = (QueueWriterService) ctx.getBean("queueServiceImpl");
		queueService.putPriceMessageToQueue("Test message");
		//queueServiceImpl.putPriceMessageToQueue("Test123");
		System.out.println(productList);
	}
	
	public static void main(String args[]) throws JMSException{
		new PriceSystemReaderQuartzTask().readPrice();
	}
	
}
