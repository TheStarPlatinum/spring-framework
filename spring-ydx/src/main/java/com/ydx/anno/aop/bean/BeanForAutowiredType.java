package com.ydx.anno.aop.bean;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class BeanForAutowiredType {


	private BeanByCompent beanByCompent;


	public BeanByCompent getBeanByCompent() {
		return beanByCompent;
	}

	@Autowired
	//标注在方法上 spring容器创建当前对象会调用方法 完成赋值
	//方法使用的参数 自定义类型的值从ioc容器中获取
	public void setBeanByCompent(BeanByCompent beanByCompent) {
		this.beanByCompent = beanByCompent;
	}

	@Override
	public String toString() {
		return "BeanForAutowiredType{" +
				"beanByCompent=" + beanByCompent +
				'}';
	}

	public BeanForAutowiredType(BeanByCompent beanByCompent) {
		System.out.println("BeanForAutowiredType AllArgs-Construct");
		this.beanByCompent = beanByCompent;
	}
}
