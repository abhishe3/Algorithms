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
	
	public static int findMaxSum(int[] array, int n){
		
		int currMax=array[0], maxSum = array[0];
		
		for(int i=1;i<n;i++){
			
			int temp = currMax+array[i];
			
			currMax= Math.max(temp, array[i]);  //if adding the new element is not contributing to increasing the currMAx, just add the incoming element as currMax
			maxSum = Math.max(currMax, maxSum);		
		}
		
		return maxSum;
	}
	
	/**
	 * Main function to test the algorithm
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {-1,4,-1,-3,5,1,-19}; //{-2, -3, 4, -1, -2, 1, 5, -3}; //{-1,-2,-3};//{-2, -3, 4, -1, -2, 1, 5, -3};
		
		System.out.println(findMaxSum(array,array.length));
		
	}

}
