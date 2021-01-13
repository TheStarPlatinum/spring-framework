package com.ydx.anno;

import com.ydx.anno.aop.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
		ac.getBean("person");
		ac.getBean("person");
	}
}
