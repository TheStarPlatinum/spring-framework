package com.ydx.anno.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

@Aspect
public class AspectLog {

	@Pointcut("execution(public int  com.ydx.anno.bean.BeanForAop.calculate(..))")
	public void pointCute(){
		System.out.println("@pointCute");
	}

	@Before("pointCute()")
	public void before(){
		System.out.println("@Before");
	}

	@After("pointCute()")
	public void after(){
		System.out.println("@After");
	}

}
