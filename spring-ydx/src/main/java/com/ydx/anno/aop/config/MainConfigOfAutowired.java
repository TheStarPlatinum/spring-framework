package com.ydx.anno.aop.config;

import com.ydx.anno.aop.bean.BeanByCompent;
import com.ydx.anno.aop.bean.BeanForAutowired;
import com.ydx.anno.aop.bean.BeanForAutowiredType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ydx.anno.aop.service", "com.ydx.anno.aop.bean"})
public class MainConfigOfAutowired {

	@Bean
	@Qualifier
//	@Primary
	public BeanForAutowired beanForAutowired2(){
		return new BeanForAutowired("@bean");
	}

	/**
	 * @autowired
	 * 1.默认按类型装配
	 * 2.如果找到多个 1.将属性的名称作为id进行查找
	 * 			  2.根据 @Qualifier 名称进行匹配
	 * 3.可以用@autowired(required=false)
	 * 4.可以用@Primary
	 *
	 */

	/**
	 * @resource
	 * @inject
	 */

//	AutowiredAnnotationBeanPostProcessor



	/**
	 * @see com.ydx.anno.aop.bean.BeanForAutowiredType
	 * @autowired 在不同位置 构造器 方法（setter） 参数 属性 都是从容器中获取参数组件的值
	 * 		1.【标注在方法上】 @bean + 方法参数 参数从容器中获取 写不写 @autowired一样 都能自动装配
	 * 		2.【标注在构造器】 如果只有一个有参构造器 这个有参构造器的 @autowired可以省略
	 *
	 *
	 */

	/**
	 * @bean 标注的方法创建对象的时候 方法参数的值从容器中获取
	 * @param beanByCompent
	 * @return
	 */
	@Bean
	public BeanForAutowiredType beanForAutowiredType(BeanByCompent beanByCompent){
		return new BeanForAutowiredType(beanByCompent);
	}


}
