package com.ydx.anno.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class BeanForAutowired {

	private String label = "default";


	@Override
	public String toString() {
		return "BeanForAutowired{" +
				"label='" + label + '\'' +
				'}';
	}
}
