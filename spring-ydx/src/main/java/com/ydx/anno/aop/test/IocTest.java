package com.ydx.anno.aop.test;

import com.ydx.anno.aop.bean.BeanByCompent;
import com.ydx.anno.aop.bean.BeanForAutowired;
import com.ydx.anno.aop.bean.BeanForAutowiredType;
import com.ydx.anno.aop.config.MainConfig;
import com.ydx.anno.aop.bean.Person;
import com.ydx.anno.aop.config.MainConfigOfAutowired;
import com.ydx.anno.aop.config.MainConfigOfAware;
import com.ydx.anno.aop.config.MainConfigOfLifeCycle;
import com.ydx.anno.aop.service.BeanForAutowiredService;
import org.junit.Test;
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

	@Test
	public void lifeCycleTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		ac.close();
	}

	@Test
	public void autowiredTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		BeanForAutowiredService service = ac.getBean(BeanForAutowiredService.class);
		BeanForAutowired beanForAutowired1 = service.getBeanForAutowired();
		BeanForAutowired beanForAutowired2 = (BeanForAutowired) ac.getBean("beanForAutowired2");
		System.out.println(beanForAutowired1.toString());
		System.out.println(beanForAutowired2.toString());
		ac.close();
	}


	@Test
	public void autowiredTypeTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		System.out.println("//////////////////");
		printBeanDefinition(ac);
		System.out.println("//////////////////");
		BeanByCompent beanByCompent = (BeanByCompent) ac.getBean("beanByCompent");
		BeanForAutowiredType beanForAutowiredType = ac.getBean(BeanForAutowiredType.class);
		BeanByCompent beanByCompent2 = beanForAutowiredType.getBeanByCompent();
		System.out.println("beanByCompent : " + beanByCompent);
		System.out.println("beanByCompent2: " + beanByCompent2);
	}

	@Test
	public void awareTest(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAware.class);

		System.out.println("***********");



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
