package com.ydx.anno.aop.bean;

public class BeanForInitMethod {

	public void init(){
		System.out.println("BeanForInitMethod init");
	}

	public void destroy(){
		System.out.println("BeanForInitMethod destroy");
	}
}
