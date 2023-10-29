package edu.pnu.back;

import edu.pnu.study.operator.MyOperator;

public class MyOperatorForDiv extends MyOperator {

	public MyOperatorForDiv() {
		super("/");
	}
	
	@Override
	public int operate(int a, int b) {
		return a / b;
	}

}
