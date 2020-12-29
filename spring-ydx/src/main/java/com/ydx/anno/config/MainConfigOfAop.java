package com.ydx.anno.config;


import com.ydx.anno.aop.AspectLog;
import com.ydx.anno.bean.BeanForAop;
import org.junit.Before;
import org.springframework.aop.Pointcut;
import org.springframework.context.annotation.*;

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


	/**
	 * 1.@EnableAspectJAutoProxy
	 * 		->@Import(AspectJAutoProxyRegistrar.class)
	 *		给容器导入AspectJAutoProxyRegistrar AspectJAutoProxyRegistrar.registerBeanDefinitions 给容器注册bean
	 *		internalAutoProxyCreator(beanName) = AnnotationAwareAspectJAutoProxyCreator.class(入参)
	 *		相当于注册名为AnnotationAwareAspectJAutoProxyCreator 的组件
	 *
	 * 2.AnnotationAwareAspectJAutoProxyCreator
	 *
	 *
	 */

}
