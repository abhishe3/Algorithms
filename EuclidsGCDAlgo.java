/**
 * 
 */
package com.shekspeare.algorithms;

/**
 * @author Abhishek
 * This class is a demo for Euclid's Algorithm to find GCD of two given numbers
 */
public class EuclidsGCDAlgo {

	/**
	 * @param int m, n : Integers of which GCD is to be found
	 * The core of this algorithm is that GCD(m,n)  = GCD(n%m, m)
	 */
	
	public static int euclidGCD(int m, int n){
		//check if one mumber is divisible by the other
		//if not, find the remainder and exchange the remainder and the numbers
		while (n%m!=0){
			int r = n%m;
			n = m;
			m = r;
		}
		
		return m;
	}
	
	public static void main(String[] args) {
		//Scan input from user
		int m = 36;
		int n = 47;
		
		System.out.print(euclidGCD(m,n));
		
	}

}
