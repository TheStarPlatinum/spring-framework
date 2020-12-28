package com.ydx.anno.config;


import com.ydx.anno.aop.AspectLog;
import com.ydx.anno.bean.BeanForAop;
import org.junit.Before;
import org.springframework.aop.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {

	@Bean
	public BeanForAop beanForAop(){
		return new BeanForAop();
	}

	@Bean
	public AspectLog aspect(){
		return new AspectLog();
	}


}
