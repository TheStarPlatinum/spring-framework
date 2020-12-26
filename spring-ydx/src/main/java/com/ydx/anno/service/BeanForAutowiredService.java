package com.ydx.anno.service;

import com.ydx.anno.bean.BeanForAutowired;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class BeanForAutowiredService {

	@Autowired
	private BeanForAutowired beanForAutowired;
}
