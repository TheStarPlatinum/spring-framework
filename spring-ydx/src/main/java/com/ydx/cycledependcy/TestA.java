package com.ydx.cycledependcy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestA {

	private TestB testB;

	public void a(){
		testB.b();
	}


}
