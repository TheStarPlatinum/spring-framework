package com.ydx.anno.ext.test;

import com.ydx.anno.ext.config.BeanFactoryPostProcessorConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {

	@Test
	public void beanFactoryPostProcessorTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);

		ac.publishEvent(new ApplicationEvent("容器发布事件") {
		});
		ac.close();


	}
}
