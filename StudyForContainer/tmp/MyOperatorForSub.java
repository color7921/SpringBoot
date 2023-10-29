package edu.pnu.back;

import edu.pnu.study.operator.MyOperator;

public class MyOperatorForSub extends MyOperator {

	public MyOperatorForSub() {
		super("-");
	}	
	
	@Override
	public int operate(int a, int b) {
		return a - b;
	}

}
