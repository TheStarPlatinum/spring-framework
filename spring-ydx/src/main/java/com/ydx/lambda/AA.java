package com.ydx.lambda;

public abstract class AA extends A {
	int i;


	public void mainTest() {
//		test(1, () -> getObject());
	}


	public void test(int i, A a) {

	}

	public BB getObject(){
		return (BB)new Object();
	}

	AA(){

	}
}
