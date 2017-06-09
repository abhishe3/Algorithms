package com.shekspeare.algorithms.googlehandout;

public class NumberOfZeroesFactorial {

	
	// Find the no. of zeroes in n!
	
	
	public static int numZeroes(int n){
		
		if(n<5) return 0;
		if(n<10) return 1;
		int count =0;
		
		for(int i=1; Math.pow(5, i)<=n; i++){
			
			count+= n/Math.pow(5, i);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(numZeroes(10));

	}

}
