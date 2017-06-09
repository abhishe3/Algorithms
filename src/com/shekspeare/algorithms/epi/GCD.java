package com.shekspeare.algorithms.epi;

public class GCD {

	public static int getGCD(int x, int y){
	
		return (y==0)?x:getGCD(y,x%y); 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getGCD(13,4));

	}

}
