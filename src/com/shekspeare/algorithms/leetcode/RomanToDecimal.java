package com.shekspeare.algorithms.leetcode;

public class RomanToDecimal {

	public int getVal(char c) {

		switch (c) {            //**PTR: revise the switch-case syntax. should use 'break' within each case else it is fall-through

		case ('I'):
			return 1; 
		case ('V'):
			return 5;
		case ('X'):
			return 10;
		case ('L'):
			return 50;
		case ('C'):
			return 100;
		case ('D'):
			return 500;
		case ('M'):
			return 1000;
		default:
			return -1;
		}

	}
	
	public int romanToDecimal(String s){
		
		if(s==null || s.equals("") || s.equals(" ")){
			return -1;
		}
		
		int sum = 0;
		
		for(int i=0;i<s.length();i++){
			
			if((i+1)<s.length()){
				
				if(getVal(s.charAt(i)) >=getVal(s.charAt(i+1))){
					sum+=getVal(s.charAt(i));
				}else{
					sum = sum+ (getVal(s.charAt(i+1)) - getVal(s.charAt(i)));
					i++;
				}
				
			}else{
				sum+=getVal(s.charAt(i));
			}
			
		}
		
		return sum;
	}

	public static void main(String[] args) {
		RomanToDecimal solution = new RomanToDecimal();
		System.out.println(solution.romanToDecimal("MCIX"));
	}
}
