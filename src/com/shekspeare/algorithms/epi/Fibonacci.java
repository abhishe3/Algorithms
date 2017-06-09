package com.shekspeare.algorithms.epi;

import java.util.HashMap;

public class Fibonacci {
	
	public static int regularFibonoacci(int n){
		
		if(n<=1) return n;
		
		return regularFibonoacci(n-1) + regularFibonoacci(n-2);
		
	}
	
	
	public static int cachedFibonacci (int n , HashMap<Integer,Integer> map){
		
		if(n<=1) return n;
	
		if(!map.containsKey(n)){
			map.put(n, cachedFibonacci(n-1, map) + cachedFibonacci(n-2, map));	
		}
		
		return map.get(n);

	}

	
	public static int optimizedFibonacci(int n){     //No extra memory ( O(1))
		
		int fMinus2 = 0;
		int fMinus1 = 1;
	
		for (int i = 2 ; i<=n; i++){
			
			int f = fMinus1 + fMinus2;
			fMinus2 = fMinus1;
			fMinus1 = f;
		}
		
		return fMinus1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(regularFibonoacci(7));
		
		System.out.println(cachedFibonacci(7, new HashMap<Integer,Integer>()));

		System.out.println(optimizedFibonacci(7));
	}

}
