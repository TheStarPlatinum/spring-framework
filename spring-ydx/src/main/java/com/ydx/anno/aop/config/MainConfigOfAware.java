package com.ydx.anno.aop.config;

import com.ydx.anno.aop.bean.BeanForAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfigOfAware {


	@Bean
	public BeanForAware beanForAware(){
		System.out.println("bean for aware ");
		return new BeanForAware();
	}
}
