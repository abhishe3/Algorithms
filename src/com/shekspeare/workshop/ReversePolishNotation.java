package com.shekspeare.workshop;

import java.util.EmptyStackException;
import java.util.Stack;

public class ReversePolishNotation {

	public static int calculateRPN(String rpn) throws EmptyStackException{   //throws is optional..just to learn
		
		int result =0;
		
		String[] str = rpn.split(",");
		
		Stack<Integer> st = new Stack<Integer>();
		
				for(int i=0;i<str.length;i++){
					
					if(Character.isDigit(str[i].charAt(0))){
						st.push(Integer.parseInt(str[i]));
					}else{
						int operand_2 = st.pop();
						int operand_1 = st.pop();
						switch(str[i]){
						
							case("*"):
								result = operand_1*operand_2;
								break;
								
							case("+"):
								result = operand_1+operand_2;
								break;
								
							case("-"):
								result = operand_1-operand_2;
								break;
								
							case("/"):
								result = operand_1/operand_2;
								break;
								
							default:
								throw new IllegalArgumentException("Unrecognized Operation :" +str[i]);
						}
						
						st.push(result);
					}
					
				}
				
		return result;		//or return st.pop()
		
	}
	
	
	public static void main(String[] args) {

		String rpn = "3,4,+,2,*,1,+"; //15
		System.out.println(calculateRPN(rpn));
			
	}

}
