package com.shekspeare.algorithms;

/** http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * 
 * Done differently here than in above link. Used Binary search .
 * 
 * @author abashok
 *
 */

public class SearchInMatrix {

	public static void findInSortedMatrix(int[][]arr, int x){
		
		int m = arr.length; //rows
		int n = arr[0].length; //cols
		
		//Start with top-right
		int j = n-1;
		
		
		while(x<arr[0][j]){  
			j--;
		} 					//found the column . it is in j
							
		//Binary search in col j;
		int low = 0;
		int high= m-1;
		
		while(low<high){
		
			int mid = low + (high-low)/2;
			
			if(arr[mid][j] == x){
				System.out.println("Found "+x+" at ("+mid+","+j+")");
				return;
			}
			
			if(arr[mid][j] > x){
				high=mid;
			}
			else{
				low=mid;
			}
		}
		
		System.out.print("Not found");
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		
		findInSortedMatrix(mat,29);
		
	}

}
