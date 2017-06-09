/**
 * 
 */
package com.shekspeare.algorithms.dynamicprogram;

/**
 * @author abashok
 *   
 */

//********************************** THIS IS WRONG SOLUTION *************************************
public class UglyNumber {

	public static void printUgly(int n){
		int seed = 0;
		int count = 1;
		
		while(count<n){
			seed++;
			if((seed%2==0) || (seed%3==0) || (seed%5==0)){
				count++;
			}
		}
		
		System.out.println("The "+n+"th Ugly Number is: "+seed);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printUgly(150);
	}

}
