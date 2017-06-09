package com.shekspeare.algorithms.dynamicprogram;


/* This program uses Kadane's Algorithm to find the largest
 * sum of contiguous elements within a 1-D array.
 * However, this solution does not work if all elements are negative.
 * It will only return 0 in all-negative integers cases.
 * 
 * To accommodate negative cases, we can run a pass on the array to 
 * check if all are negative, and that case, return the biggest element in 
 * the array
 */

public class LargestContSubArray {
	
	/**
	 * Returns the maximum sum in the contiguous sub-array
	 * @param array
	 * @param n
	 * @return maximum sum in a contiguous sub-array
	 */
	public static int findMaxSumUtil(int[] array, int n){
		
		int max = 0;
		int currentMax = 0;
		for (int i=0;i<n; i++){
			
			currentMax += array[i];
			
			if(currentMax < 0){
				currentMax=0;           //reset to 0, if sum goes below 0
			}
			
			max=Math.max(currentMax,max);
			
		} 
		
		return max;
			
	}
	
	/**
	 * Checks if the array consists of only negative numbers.
	 * If all are negative, it prints the greatest negative number
	 * @param array
	 * @param n
	 * @return boolean
	 */
	public static boolean isAllNegative(int[] array, int n){
		
		boolean isNeg = true;
		int max = array[0];
		for(int i =1; i<n ;i++){
			if (array[i]>0)
				isNeg = false;
			
			if (array[i]>max)
				max = array[i];
		}
		
		if(isNeg)
		System.out.println("Max sum is : "+max);
		
		return isNeg;
	}
	
	/**
	 * Function to call the findMaxSumUtil function
	 * @param array
	 * @param n
	 */
	public static void findMaxSum(int[] array, int n){
		if(!isAllNegative(array,array.length)){
			System.out.println("Max sum is : "+ findMaxSumUtil(array,array.length));
		}
	}
	
	/**
	 * Main function to test the algorithm
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {5,4,-1}; //{-1,-2,-3};//{-2, -3, 4, -1, -2, 1, 5, -3};
		
		findMaxSum(array,array.length);
		

	}

}
