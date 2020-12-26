package com.ydx.anno.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class BeanForInitializer implements InitializingBean, DisposableBean {


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanForInitializer afterProperTiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("BeanForInitializer destroy");
	}

	public BeanForInitializer(){
		System.out.println("BeanForInitializer constructor");
	}


}
