
package com.caculator;

//Compute 클래스는 IAdd, IDiv, IMul, ISub  의 다중 상속을 받는 클래스이다.
public class Compute implements IAdd, IDiv, IMul, ISub  {

	//더하기 메소드
	@Override
	public double add(double num1 , double num2) throws Exception {
		return num1+num2;	
	}

	//빼기 메소드
	@Override
	public double subtract(double num1 , double num2) throws Exception{	
		return num1-num2;
	}

	//곱하기 메소드
	@Override
	public double mul(double num1 , double num2) throws Exception {
		return num1*num2;
	}

	//나누기 메소드
	@Override
	public double div(double num1 , double num2) throws Exception {
		return num1/num2;
	}


	
}
