package com.ydx.cycledependcy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestB {

	private TestC testC;

	public void b(){
		testC.c();
	}
}
