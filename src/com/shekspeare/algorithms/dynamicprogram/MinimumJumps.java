package com.shekspeare.algorithms.dynamicprogram;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/ 
 * METHOD 2 - O(n^2)
 * Video : https://www.youtube.com/watch?v=cETfFsSTGJI
 * 
 * @author abashok
 *
 */
public class MinimumJumps {

	public static int minJumps(int[] arr){
		
		int n = arr.length;
		int[] jumps = new int[n];
		
		jumps[0] = 0;
		for(int i=1;i<n;i++){
			jumps[i] = Integer.MAX_VALUE-1;
		}
		
		 // Find the minimum number of jumps to reach arr[i]
	    // from arr[0], and assign this value to jumps[i]
		for(int i=1;i<n;i++){
			
			for(int j=0;j<i;j++){
				
				if(i<=j+arr[j] ){
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
				}
			}
			
		}
		return jumps[n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.println(minJumps(arr));
		
		
	}

}
