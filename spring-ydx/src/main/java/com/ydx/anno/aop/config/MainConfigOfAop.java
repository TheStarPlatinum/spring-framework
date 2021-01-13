package com.ydx.anno.aop.config;


import com.ydx.anno.aop.AspectLog;
import com.ydx.anno.aop.bean.BeanForAop;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {

	@Bean
	public BeanForAop beanForAop() {
		return new BeanForAop();
	}

	@Bean
	public AspectLog aspect() {
		return new AspectLog();
	}


	/*
	 * 1.@EnableAspectJAutoProxy
	 * 		->@Import(AspectJAutoProxyRegistrar.class)
	 *		给容器导入AspectJAutoProxyRegistrar AspectJAutoProxyRegistrar.registerBeanDefinitions 给容器注册bean
	 *		internalAutoProxyCreator(beanName) = AnnotationAwareAspectJAutoProxyCreator.class(入参)
	 *		相当于注册名为AnnotationAwareAspectJAutoProxyCreator 的组件
	 *
	 * 2.AnnotationAwareAspectJAutoProxyCreator
	 *
	 *
	 *  流程
	 *
	 *  	1.创建ioc容器
	 *  	2.refresh()方法 刷新容器
	 *  	3.registerBeanPostProcessors(beanFactory),PostProcessorRegistrationDelegate；注册bean的后置处理器来方便拦截bean的创建
	 *			1).先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
	 *			2).给容器中加到别的BeanPostProcessor   beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount))
	 * 			3).将所有的 BeanPostProcessor根据是否实现了 PriorityOrdered,Ordered,没有实现ordered 分类 并按照其顺序依次给容器中注册并实现
	 * 			   具体操作为
	 * 				1. beanFactory.getBean(ppName, BeanPostProcessor.class) --ppName = internalAutoProxyCreator[AnnotationAwareAspectJAutoProxyCreator]
	 *					1).创建bean实例? --doCreateBean(beanName, mbdToUse, args);
	 * 					2).populateBean(beanName, mbd, instanceWrapper);对bean进行属性填充
	 * 					3).initializeBean(beanName, exposedObject, mbd);
	 * 						1.处理aware --invokeAwareMethods(beanName, bean); internalAutoProxyCreator会在这里处理beanFactoryAware
	 *						2.applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
	 * 						3.invokeInitMethods(beanName, wrappedBean, mbd);
	 * 						4.applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
	 *					4).beanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功 -->
	 * 			4).把beanPostProcessor注册到beanFactory中
	 * ====================以上未创建和注册AnnotationAwareAspectJAutoProxyCreator的过程==================================
	 *				AnnotationAwareAspectJAutoProxyCreator-->InstantiationAwareBeanPostProcessor
	 * 		4.finishBeanFactoryInitialization(beanFactory); 初始化剩下的实例
	 * 			1).拿到所有的beanName 依次创建bean  --> 在for循环中 getBean -> doGetBean -> getSingleton(beanName)   --preInstantiateSingletons()中的 for (String beanName : beanNames)
	 *			2).创建bean --getBean() 在 AnnotationAwareAspectJAutoProxyCreator
	 * 				[BeanPostProcessor] 是在bean对象创建之后初始化前后调用的后置处理器
	 * 				[InstantiationAwareBeanPostProcessor] 是在创建bean实例之前 先尝试用后置处理器返回
	 * 				1.先从缓存中获取bean 如果能获取到 说明bean是之前被创建过的 直接使用 否则再创建 bean一旦被创建 就会被存入缓存中
	 * 				2.createBean() --缓存中获取不到bean 进行创建bean
	 * 					1).resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation 希望后置处理器在此能返回一个代理对象;如果能返回代理对象就使用 如果不能就继续
	 * 						1).后置处理器先尝试返回对象
	 * 						   bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
	 * 							1).拿到所有的postProcessor后置处理器 如果有InstantiationAwareBeanPostProcessor 就用它返回bean
	 * 						   bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
	 * 					2).doCreateBean(beanName, mbdToUse, args); 真正创建一个bean实例 同上面doCreateBean的流程
	 *					3). AnnotationAwareAspectJAutoProxyCreator-->InstantiationAwareBeanPostProcessor
	 *				     	创建bean之前调用 BeanPostProcessorBeforeInstantiation 对于切点类 beanForAop和切面类AspectLog来说
	 * 						1).bean是否在adviseBeans当中 (保存了所有需要增强的bean)
	 * 						2).判断bean是否是基础类型的Advice,Pointcut,Advisor,AopInfrastructureBean或是否是切面(@Aspect)
	 *						3).是否需要跳过
	 * 							1).List<Advisor> candidateAdvisors 它实际是InstantiationModelAwarePointcutAdvisor类型
	 * 								判断是否是AspectJPointcutAdvisor类型的增强器 返回true
	 *							2).总是返回false?
	 * 						创建bean
	 * 						创建bean之后调用BeanPostProcessorAfterInstantiation 如果需要包装 返回wrapIfNecessary(bean, beanName, cacheKey)
	 * 							1.获取当前bean所有增强器 	Object[] specificInterceptor
	 *								1)。获取所有增强器
	 *								2). 获取能在bean上使用的增强器 findEligibleAdvisors(beanClass, beanName);
	 * 								3). 给增强器排序
	 *							2.将增强器放到advisedBeans[AbstractAutoProxyCreator] 中
	 *							3.如果当前bean需要增强 创建当前类的代理对象
	 *								1). 获取所有的增强器(后置处理)
	 *								2). 保存到ProxyFactory中
	 *								3). 创建代理对象 Spring决定创建方式
	 *									如果实现接口 JdkDynamicAopProxy(config);
	 * 									如果不实现接口 ObjenesisCglibAopProxy(config);
	 * 							4.给当前容器返回需要增强的cglib代理对象
	 *							5.以后容器中获得的就是这个组件的代理对象 执行目标方法的时候 就会使用代理对象
	 *
	 *
	 * 3.目标方法的执行
	 * 	 容器中保存了组件的代理对象 (cglib增强后的对象) 这个对象保存了详细信息 如(目标对象,增强器 等等)
	 * 		1. CgLibAopProxy.intercept() 拦截目标对象的执行
	 * 		2. 根据ProxyFactory对象获取到将要执行的目标方法拦截器链
	 * 		   List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
			   1. chain的长度为所有切面方法数目+1 有一个默认的ExposeInvocationInterceptor
			   2. 将所有的增强器转化为拦截器 registry.getInterceptors(advisor)
			   3. 将增强器转化为List<MethodInterceptor> 如果是methodInterceptor 直接加入集合 如果不是 用AdvisorAdaptor
			      转化为MethodInterceptor
	 * 		3. 如果没有拦截器链 直接执行目标方法
	 * 		4. 如果有拦截器链 把需要执行的目标方法,拦截器链等创建一个CglibMethodInvocation对象 并调用其proceed方法
	 * 		   retVal = new CglibMethodInvocation(proxy, target, method, args, targetClass, chain, methodProxy).proceed();
	 * 		   retVal = processReturnType(proxy,target,method,retVal)
	 *
	 *
	 *
	 *
	 */

}
