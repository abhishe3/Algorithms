package com.shekspeare.workshop;

import java.util.Arrays;

/** http://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
 *  
 * @author abashok
 *
 */
	
public class MaxProductOfThreeNumbers {

	/* Function to find a maximum product of a triplet
	   in array of integers of size n */
	
	//O(nlogn)
	int maxProduct(int arr[], int n)
	{
	    // if size is less than 3, no triplet exists
	    if (n < 3)
	        return -1;
	 
	    // Sort the array in ascending order
	    Arrays.sort(arr);
	 
	    // Return the maximum of product of last three
	    // elements and product of first two elements
	    // and last element  .. This is because if the first two numbers are neg, their product is positive
	    return Math.max(arr[0] * arr[1] * arr[n - 1],
	               arr[n - 1] * arr[n - 2] * arr[n - 3]);
	}
	
	
	
	//O(n)
	/*
	 * 1)Scan the array and compute Maximum, second maximum and third maximum element present in the array.
	   2)Scan the array and compute Minimum and second minimum element present in the array.
	   3)Return the maximum of product of Maximum, second maximum and third maximum and product of Minimum, second minimum and Maximum element.
		Note – Step 1 and Step 2 can be done in single traversal of the array.
	 */
	int maxProduct_optimized(int arr[], int n)
	{
	    // if size is less than 3, no triplet exists
	    if (n < 3)
	        return -1;
	 
	    // Initialize Maximum, second maximum and third
	    // maximum element
	    int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
	 
	    // Initialize Minimum and second mimimum element
	    int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
	 
	    for (int i = 0; i < n; i++)
	    {
	        // Update Maximum, second maximum and third
	        // maximum element
	        if (arr[i] > maxA)
	        {
	            maxC = maxB;
	            maxB = maxA;
	            maxA = arr[i];
	        }
	 
	        // Update second maximum and third maximum element
	        else if (arr[i] > maxB)
	        {
	            maxC = maxB;
	            maxB = arr[i];
	        }
	 
	        // Update third maximum element
	        else if (arr[i] > maxC)
	            maxC = arr[i];
	 
	        // Update Minimum and second mimimum element
	        if (arr[i] < minA)
	        {
	            minB = minA;
	            minA = arr[i];
	        }
	 
	        // Update second mimimum element
	        else if(arr[i] < minB)
	            minB = arr[i];
	    }
	 
	    return Math.max(minA * minB * maxA,
	               maxA * maxB * maxC);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
