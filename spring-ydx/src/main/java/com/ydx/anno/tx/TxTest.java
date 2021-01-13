package com.ydx.anno.tx;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

	@Test
	public void TxTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
		UserService userService = ac.getBean(UserService.class);
		int insert = userService.insert();

		System.out.println(insert);
	}


}
