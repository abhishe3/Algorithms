package com.shekspeare.algorithms.epi;

/**
 * Question 12.1 - Find the first occurrence of an element in a sorted array
 * Pg 192;
 * 
 * Hint: Dont stop when you find the element. Once you find it store its index, but keep looking
 * in the left half (since it is sorted) till low>high
 * @author abashok
 * 
 */
public class FindFirstOccurenceInSortedArray {
	
	public static int binSearchFirstOccurrence(int[] arr, int k){
		
		if(arr.length==0) return -1;
		
		return binSearchFirstOccurUtil(arr,k,0,arr.length-1,-1);
		
	}

	
	public static int binSearchFirstOccurUtil(int[] arr,int k,int low, int high,int result){
		
		if(low<=high){
			
			int mid = low + (high-low)/2;
			
			if(arr[mid] == k){
				
				result = mid;
				return binSearchFirstOccurUtil(arr, k, low, mid-1,result);
			}
			
			if(arr[mid] > k){
				return binSearchFirstOccurUtil(arr, k, low, mid-1,result);
			}
			
			else{
				return binSearchFirstOccurUtil(arr, k, mid+1, high,result);
			}
			
		}		
		return result;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-14,-10,2,108,108,243,285,285,284,401};
		System.out.println(binSearchFirstOccurrence(arr,600));
	}

}
