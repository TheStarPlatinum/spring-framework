package com.ydx.anno.ext.config;

import com.ydx.anno.ext.bean.BeanForBeanFactoryPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanForBeanFactoryPostProcessor.class)
@ComponentScan("com.ydx.anno.ext.bean")
public class BeanFactoryPostProcessorConfig {


	/**
	 * applicationListener 监听容器中发布的事件 时间模型驱动开发
	 * interface ApplicationListener<E extend ApplicationEvent>
	 *     监听ApplicationEvent及下面的子事件
	 *
	 * 自定义事件步骤
	 * 1. 写一个监听器来监听某个事件 (ApplicationEvent及其子类)
	 * 2. 把监听器加入容器
	 * 3. 只要容器中有发布相关事件 就能监听这个事件
	 * 		ContextRefreshedEvent,容器刷新事件
	 * 		ContextCloseEvent,容器关闭事件
	 * 4. 发布一个事件
	 *
	 * 原理
	 * 1. ContextRefreshedEvent
	 *    finishRefresh()中的 publishEvent(new ContextRefreshedEvent(this)); 注册了一个 ContextRefreshedEvent
	 *    步骤--事件发布流程
	 *    	1.获取事件的多播器(派发器) getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType);
	 *      2.multicastEvent(applicationEvent, eventType) 派发事件方法
	 *		3.获取容器中所有监听此event的监听器 for (ApplicationListener<?> listener : getApplicationListeners(event, type))
	 *			1.如果有Executor 可以支持异步派发 Executor = getTaskExecutor();
	 *			2.没有Executor 直接执行 invokeListener(listener, event);
	 *
	 * 事件多播器(派发器)
	 * 		1.容器创建对象: refresh()
	 * 		2.initApplicationEventMulticaster 如果beanFactory包含applicationEventMulticaster 就直接使用 否则
	 * 		  this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory); 用simple新建caster
	 * 		  如果其他组件要派发事件 就可以用这个applicationEventMulticaster
	 *
	 * 容器中有哪些监听器
	 * 		1.容器中创建对象: refresh()
	 * 		2.registerListeners();
	 * 		3.getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName); 如果有listener 加入到派发器中
	 * 			然后从
	 *
	 */

}
