package com.ydx.cycledependcy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestC {

	private TestA testA;

	public void c(){
		testA.a();
	}
}
