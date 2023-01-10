package com.example;

public class Calc {
	// 계산 결과 보관을 위한 변수로 초기값을 0으로 설정함
	private int result;
	
	public Calc() {
		result = 0;
	}
	
	public Calc(int num1, int num2, String op) {
		// 연산자에 따른 계산 수행
		if(op.equals("+"))
			result = num1 + num2;
		else if(op.equals("-"))
			result = num1 - num2;
		else if(op.equals("*"))
			result = num1 * num2;
		else if(op.equals("/")) {
			if(num2!=0)
				result = num1 / num2;
			else
				result = 0;
		}
	}
	
	public int getResult() {
		return result;
	}
}
