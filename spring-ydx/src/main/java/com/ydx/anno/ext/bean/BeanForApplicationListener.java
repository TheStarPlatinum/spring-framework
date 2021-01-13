package com.ydx.anno.ext.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BeanForApplicationListener implements ApplicationListener {

	/**
	 * 当容器中发布事件后 方法触发
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("invoke BeanForApplicationListener onApplicationEvent " + event.toString());
	}
}
