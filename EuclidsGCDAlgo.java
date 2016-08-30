/**
 * 
 */
package com.shekspeare.algorithms;

/**
 * @author Abhishek
 *
 */
public class EuclidsGCDAlgo {

	/**
	 * @param args
	 */
	
	public static int euclidGCD(int m, int n){
		//check if 
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
