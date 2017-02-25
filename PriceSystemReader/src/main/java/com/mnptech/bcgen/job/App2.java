package com.mnptech.bcgen.job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("SpringQuartz.xml");

	}
}