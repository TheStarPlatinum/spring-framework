package com.ydx.anno.ext.config;

import com.ydx.anno.ext.bean.BeanForBeanFactoryPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanForBeanFactoryPostProcessor.class)
public class BeanFactoryPostProcessorConfig {


	/**
	 *
	 */

}
