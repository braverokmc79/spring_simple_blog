
package com.caculator;

import java.util.Scanner;

public class Calculator{

	private void operation(){
		
		//Compute 클래스는 IAdd, IDiv, IMul, ISub  의 다중 상속을 받은 클래스이다.
		//Compute 객체 생성
		Compute compute =new Compute();
		
		//어노테이션을 사용하여 컴파일 단위의 서브세트와 관련된 컴파일 경고를 사용하지 않도록 설정
		@SuppressWarnings("resource")
		
		
		Scanner sc=new Scanner(System.in);
	
		while(true){
			
			System.out.println("첫번째 숫자 입력 : ");
			//첫번째 값을 입력 받아서 num1 넣는다.  
			String num1=sc.next(); 
			System.out.println("연산 기호를 입력하세요.");
			//두번째 값을 입력 받아서 op 변수에 넣는다.
			String op=sc.next();  
			System.out.println("두번째 숫자 입력 : ");
			//세번째 값을 입력 받아서 num2 에 넣는다.
			String num2=sc.next();

			// Compute 에서 반환되는 값을 변수 result 에 담기위한 변수 선언
			double result=0.0;
						
			try{
				//더하기일 경우  다음을 실행 반환되는 값을 result 에 담는다.
				if(op.equals("+")) result = compute.add(Double.parseDouble(num1), Double.parseDouble(num2));
				
				//더하기일 경우  다음을 실행 반환되는 값을 result 에 담는다.
				if(op.equals("-")) result = compute.subtract(Double.parseDouble(num1), Double.parseDouble(num2));
				
				//곱하기일 경우  다음을 실행 반환되는 값을 result 에 담는다.
				if(op.equals("*")) result =compute.mul(Double.parseDouble(num1), Double.parseDouble(num2));

				//나누기일 경우  다음을 실행 반환되는 값을 result 에 담는다.
				if(op.equals("/")) result = compute.div(Double.parseDouble(num1), Double.parseDouble(num2));
				
				
				// 두번째 입력값이 +, - , * , / 아닐경우 예외로 던진다. 
				if(!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))){
					throw new Exception();
				}
				
				System.out.println("result= " + result);
				
			}catch(Exception e){
				System.out.println("\n ----  연산입력이 잘 못 되었습니다. 다시 입력하세요.");
			}
			
			System.out.println("\n\n");
			
		}
		
	}
	
	
	public static void main(String[] args) {		
		// Calculator 객체 생성 후  operation 메소드를 호출 한다.
		Calculator cal =new Calculator();
		cal.operation();
	}
	
	
}
