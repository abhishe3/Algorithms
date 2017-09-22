package com.shekspeare.workshop;

public class JumpGame {

	public static boolean canReachEnd(int[] matrix){
		
		//assumes all integers are positive
		
		return canReachEndUtil(matrix,0);
		
		
	}
	
	public static boolean canReachEndUtil(int[] matrix, int index){
		
		if(index==matrix.length-1){
			return true;
		}
		
		if(index>=matrix.length || matrix[index]==0){
			return false;
		}
		
		return canReachEndUtil(matrix, index+matrix[index]);
		
		
		
	}
	
	public static void main(String[] args) {
	
		int[] arr = {3,2,1,0,4};//{2,3,1,1,4};
		
		System.out.println(canReachEnd(arr));

	}

}
