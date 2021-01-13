package com.ydx.anno.aop.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	/**
	 *
	 * @param importingClassMetadata 
	 * @return 导入到容器中的组件全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {


		return new String[]{
				"com.ydx.anno.aop.bean.ImportSelectorBean"
		};
	}
}
