/**
 * 
 */
package com.shekspeare.algorithms.searching;

/**
 * @author abashok
 *
 */
public class SearchingTechniques {
	
	//Binary Sort
	//Expects a sorted array
	// O(Logn) 
	public int binarySearch(int[] arr, int data){
		return binarySearchUtil(arr,data,0,arr.length-1);
	}

	int binarySearchUtil(int[] arr, int data, int start, int end) {

		if (start <= end) {

			int mid = (start + end) / 2;

			if (arr[mid] == data)
				return mid;

			if (arr[mid] > data)
				return binarySearchUtil(arr, data, start, mid);

			return binarySearchUtil(arr, data, mid + 1, end);

		}

		return -1;

	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {5,7,9,10,11,12,13};
		SearchingTechniques st = new SearchingTechniques();
		System.out.print(st.binarySearch(arr, 9));
	}

}
