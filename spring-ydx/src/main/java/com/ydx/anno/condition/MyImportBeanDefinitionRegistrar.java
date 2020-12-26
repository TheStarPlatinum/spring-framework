package com.ydx.anno.condition;

import com.ydx.anno.bean.ImportBeanDefinitionRegistrarBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {



		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ImportBeanDefinitionRegistrarBean.class);



		registry.registerBeanDefinition("ImportBeanDefinitionRegistrar",rootBeanDefinition);
	}
}
