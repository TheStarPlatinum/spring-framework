package com.ydx.anno.test;


import com.ydx.anno.bean.BeanForAop;
import com.ydx.anno.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

	@Test
	public void aopTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

		BeanForAop beanForAop = (BeanForAop) ac.getBean("beanForAop");

		beanForAop.calculate(1,1);
	}
}
