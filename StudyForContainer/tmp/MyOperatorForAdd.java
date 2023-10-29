package edu.pnu.back;

import edu.pnu.study.operator.MyOperator;

public class MyOperatorForAdd extends MyOperator {

	public MyOperatorForAdd() {
		super("+");
	}
	
	@Override
	public int operate(int a, int b) {
		return a + b;
	}

}
