package test;

import com.ydx.beanDefinition.demo1.DerivedTestBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ttest {
	public static void main(String[] args) {
//		int i=7;
//		System.out.println(i&5);


		List<DerivedTestBean> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(new DerivedTestBean(""+i,i));
		}

		List<DerivedTestBean> derivedTestBeanList = list.stream().filter(d -> d.getAge() > 5).collect(Collectors.toList());

		System.out.println(derivedTestBeanList.size());

	}
}
