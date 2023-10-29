package edu.pnu.back;

import edu.pnu.study.operator.MyOperator;

public class MyOperatorForMul extends MyOperator {

	public MyOperatorForMul() {
		super("*");
	}		
	
	@Override
	public int operate(int a, int b) {
		return a * b;
	}

}
