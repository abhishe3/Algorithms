package com.shekspeare.algorithms.epi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Given an integer n, print all prime numbers between 1 and n
 *  
 * @author abashok
 *
 */
public class PrintAllPrimes {

	public static List<Integer> getPrimeNumbers(int n){
		
		List<Integer> list = new ArrayList<Integer>();
		
		boolean[] isPrime = new boolean[n+1];  // create a boolean array of size n+1
		
		isPrime[0] = false;    // 0 is not prime
		isPrime[1] = false;    // 1 is not prime
		for (int i=2; i<isPrime.length;i++){    //by default set all numbers to be True (=prime)
			isPrime[i] = true;
		}
		
		
		for (int i=2; i<isPrime.length;i++){    // now start with 2. if it is prime, make all its multiples false. Continue for 3,4,5 etc.
			if(isPrime[i]){
				list.add(i);
				
				for(int j=i; j<isPrime.length;j=j+i){  //**PTR: note how to get multiples. make all its multiples false.
					
					isPrime[j] = false;
				}
			}
		}
		
		
		
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = getPrimeNumbers(20);
		
		System.out.print(list);
		
		int n=10;
		String str;
		str=n+"";
		str.concat("man");
		
		System.out.println(str);
		
	}

}
