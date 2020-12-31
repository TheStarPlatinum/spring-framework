package com.ydx.anno.ext.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanForBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("***************************");
		System.out.println("BeanPostProcessorCount: " + beanFactory.getBeanPostProcessorCount());
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName:beanDefinitionNames){
			System.out.println(beanDefinitionName);
		}
		System.out.println("***************************");
	}

	public BeanForBeanFactoryPostProcessor(){
		System.out.println("invoke BeanForBeanFactoryPostProcessor Constructor");
	}
}
