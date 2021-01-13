package com.ydx.anno.aop.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

	/**
	 *
	 * @param context the condition context 判断条件能使用的上下文
	 * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
	 * or {@link org.springframework.core.type.MethodMetadata method} being checked
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {


		//ioc使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取环境信息
		Environment environment = context.getEnvironment();
		//获取bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();

		String property = environment.getProperty("os.name");
		return property.contains("Windows");

//		return false;
	}
}
