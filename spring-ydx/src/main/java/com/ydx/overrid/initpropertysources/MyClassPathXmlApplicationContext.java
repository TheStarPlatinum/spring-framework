package com.ydx.overrid.initpropertysources;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	MyClassPathXmlApplicationContext(String ... configLocations){
		super(configLocations);
	}

	@Override
	protected void initPropertySources(){
		getEnvironment().setRequiredProperties("VAR");
	}
}
