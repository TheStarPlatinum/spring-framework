package com.ydx.anno.aop.condition;

import com.ydx.anno.aop.bean.BeanForFactoryBean;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<BeanForFactoryBean> {


	@Override
	public BeanForFactoryBean getObject() throws Exception {
		return new BeanForFactoryBean();
	}

	@Override
	public Class<?> getObjectType() {
		return BeanForFactoryBean.class;
	}

	@Override
	public boolean isSingleton() {

		return false;
	}
}
