package com.ydx.anno.bean;


public class BeanForAop {

	public int calculate(int a,int b){
		System.out.println("invoke calculate");
		return a/b;
	}

}
