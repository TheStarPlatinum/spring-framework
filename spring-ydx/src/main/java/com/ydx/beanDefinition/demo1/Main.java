package com.ydx.beanDefinition.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		/*
		 * 子BeanDefinition会从父BeanDefinition中继承没有的属性
		 * 这个过程中，子BeanDefinition中已经存在的属性不会被父BeanDefinition中所覆盖
		 */
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("Demo1.xml");
		DerivedTestBean derivedTestBean = (DerivedTestBean) cc.getBean("child");
		System.out.println("derivedTestBean的name = " + derivedTestBean.getName());
		System.out.println("derivedTestBean的age = " + derivedTestBean.getAge());

//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//		ac.getBean("");
//		ac.register();
	}
}
