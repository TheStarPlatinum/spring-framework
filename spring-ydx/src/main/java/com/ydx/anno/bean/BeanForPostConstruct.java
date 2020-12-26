package com.ydx.anno.bean;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class BeanForPostConstruct {


	public BeanForPostConstruct(){
		System.out.println("BeanForPostConstruct Construct-Method");
	}

	@PostConstruct
	public void init(){
		System.out.println("BeanForPostConstruct PostConstruct-Method");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("BeanForPostConstruct PreDestroy-Method");
	}

}
