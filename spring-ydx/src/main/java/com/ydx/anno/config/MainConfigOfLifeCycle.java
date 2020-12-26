package com.ydx.anno.config;

import com.ydx.anno.bean.BeanForInitMethod;
import com.ydx.anno.bean.BeanForInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ydx.anno.bean")
public class MainConfigOfLifeCycle  {



	@Bean(initMethod = "init",destroyMethod = "destroy")
	public BeanForInitMethod beanForInitMethod(){
		return new BeanForInitMethod();
	}

	/**
	 *
	 * 构造(对象创建)
	 * 		单实例，在容器启动的时候创建对象
	 * 	    多实例，在每次获取的时候创建对象
	 *
	 *
	 * BeanPostProcessor.postProcessorBeforeInitialization
	 *    初始化:
	 *    		对象创建完成并赋值好 调用初始化方法
	 * BeanPostProcessor.postProcessorAfterInitialization
	 * 	  销毁：
	 * 	  		单实例； 容器关闭
	 *
	 *
	 * AbstractAutowireCapableBeanFactory.populateBean(beanName, mbd, instanceWrapper);给bean的属性进行赋值
	 *
	 * initializeBean(beanName, exposedObject, mbd);
	 * {
	 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
	 * invokeInitMethods(beanName, wrappedBean, mbd); 执行自定义的初始化方法
	 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
	 * }
	 *
	 *
	 * 指定容器初始化和销毁的方法
	 * 1.通过指定的初始化方法
	 *   通过@bean init-method 和 destroy-method 方法
	 * 2.通过实现 InitializingBean接口和 disposableBean接口
	 * 3.通过使用 JSR250
	 *   @postConstruct 在bean创建完成并且属性赋值完成 来执行初始化方法
	 * 	 @preDestroy 在容器销毁bean之前
	 * 4.通过 BeanPostProcessor
	 *	 bean后置处理器
	 *   postProcessBeforeInitialization 在初始化之前操作 (like InitializingBean's {@code afterPropertiesSet}* or a custom init-method)
	 *   postProcessAfterInitialization 在初始化之后操作
	 *
	 *
	 */
}
