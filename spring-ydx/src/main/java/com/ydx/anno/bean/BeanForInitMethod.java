package com.ydx.anno.bean;

import org.springframework.stereotype.Component;

public class BeanForInitMethod {

	public void init(){
		System.out.println("BeanForInitMethod init");
	}

	public void destroy(){
		System.out.println("BeanForInitMethod destroy");
	}
}
