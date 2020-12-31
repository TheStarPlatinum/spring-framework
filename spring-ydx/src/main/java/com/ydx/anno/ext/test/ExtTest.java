package com.ydx.anno.ext.test;

import com.ydx.anno.ext.config.BeanFactoryPostProcessorConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {

	@Test
	public void beanFactoryPostProcessorTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);



	}
}
