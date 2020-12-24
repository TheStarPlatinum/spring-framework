package com.ydx.anno.test;

import com.ydx.anno.config.MainConfig;
import com.ydx.anno.entity.Person;
import org.junit.Test;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IocTest {

	ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);


	@Test
	public void testImport(){

		printBeanDefinition(ac);
		Object myFactoryBean = ac.getBean("myFactoryBean");
		System.out.println(myFactoryBean.getClass());
		Object $myFactoryBean = ac.getBean("&myFactoryBean");
		System.out.println($myFactoryBean.getClass());
	}

	private void printBeanDefinition(ApplicationContext ac){
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

	@Test
	public void test1(){
		String[] names = ac.getBeanNamesForType(Person.class);
		Environment environment = ac.getEnvironment();
		String os = environment.getProperty("os.name");
		System.out.println(os);

		for (String name : names) {
			System.out.println(name);
		}

		Map<String, Person> beanMap = ac.getBeansOfType(Person.class);


	}
}
