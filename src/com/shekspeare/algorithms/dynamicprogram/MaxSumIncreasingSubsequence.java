package com.shekspeare.algorithms.dynamicprogram;


/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * 
 * Code : Self :)  Draw matrix to understand
 * 
 * Pic: https://www.dropbox.com/s/svz8x44qffu03ja/Photo%20Feb%2006%2C%2012%2002%2050%20AM.jpg?dl=0
 * 
 * OR : Read code at http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * to see the solution similar to Longest Increasing Subsequence
 * @author abashok
 *
 */

public class MaxSumIncreasingSubsequence {
   //See other code below this...its more concise and similar to LIS solution
	public static int maxSum(int[] input){
		int n = input.length;
		int[][] temp = new int[n][n];
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			
			for(int j=i; j<n;j++){   // We are filling only upper diagonal half
				
				if(i==j){				 //for the same indices, fill the number itself
					temp[i][j] = input[i];
				}

				else if(input[i]>input[j]){		//if the number is bigger than its successor then put the successor
					temp[i][j] = input[j];
				}
				
				else {		
						if(input[j]>input[j-1]){         //if increasing, then add previous cell value as the sum is being continued.
							temp[i][j] = input[j] + temp[i][j-1];	
						}else{							 // decreasing, so add the two numbers directly to start new sum
							temp[i][j] = input[j] + input[i];
						}
				}
				
				
				if(temp[i][j] > max){				//update max
					max = temp[i][j];
				}
			}
			
		}
		
        
        printMatrix(temp);
		
		return max;
		
	}
	
	
	
	//test: this is similar approach to lis question..LongestIncreasingSubsequence.java
	
	public static int maxSumSubSequence(int[] arr){
		
		int maxSum=0;
		int n= arr.length;
		int[] lis = new int[n];
		
		for(int i=0;i<n;i++){
			lis[i]= arr[i];
		}
		
		
		for(int i=1; i<n;i++){
			
			for(int j = 0; j<i; j++){
				
				if(arr[j] < arr[i]){
					
					lis[i] = lis[j]+ arr[i];
					if(lis[i]>maxSum){
						maxSum = lis[i];
					}
				}
				
			}
			
		}
		
		return maxSum;
	}
	
	
	public static void printMatrix(int[][] a){
		int n = a.length;
		int m = a[0].length;
		for (int i = 0 ; i <m ; i++){
			for (int j=0 ; j <n; j++){
				System.out.print((j==0?"": ",") + a[i][j]);
			}
			System.out.print("\n");
		} 
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[]{-10,-2,5,-6}; //{1, 101, 2, 3, 100, 4, 5};
        System.out.println("Sum of maximum sum increasing "+
                           " subsequence is "+
        maxSum( arr ) );

        System.out.println(maxSumSubSequence(arr));

	}

}
