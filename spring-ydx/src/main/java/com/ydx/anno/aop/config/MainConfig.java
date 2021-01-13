package com.ydx.anno.aop.config;

import com.ydx.anno.aop.condition.*;
import com.ydx.anno.aop.bean.Color;
import com.ydx.anno.aop.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
//满足条件
@Conditional(WindowsCondition.class)
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

	@Bean
	@Lazy
//	@Scope("prototype")
	Person person(){
		System.out.println("person init");
		return new Person(11,"11");
	}



	@Bean
	@Conditional(WindowsCondition.class)
	public Person windowsBean(){
		return new Person(22,"windows");
	}

	@Bean
	@Conditional(LinuxCondition.class)
	public Person linuxBean(){
		return new Person(33,"linux");
	}

	/**
	 * 容器中注册
	 * 1.包扫描 组件注解
	 * 2.@bean
	 * 3.@import
	 *  1).@Import (要导入到容器中的组件 id默认是全类名)
	 *  2).ImportSelectors (返回需要导入的方法的全类名数组)
	 *  3).ImportBeanDefinitionRegistrar 手动调用register注册bean
	 * 4.FactoryBean springboot常用的配置方式 前面加上&用以取得对应FactoryBean
	 *
	 */

	@Bean
	public MyFactoryBean myFactoryBean(){
		return new MyFactoryBean();
	}

}
