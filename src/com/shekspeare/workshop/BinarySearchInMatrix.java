package com.shekspeare.workshop;

public class BinarySearchInMatrix {

	public static int[] binarySearchMatrix(int [][] matrix, int x){
		
		int[] result = {-1,-1};
		int n = matrix.length;
		
		int i=0; int j =n-1;
		
		while(i>=0 && j>=0 && j<n && i<n){
			
			if(matrix[i][j] == x ){
				result[0]=i;
				result[1]=j;
				
				return result;
			}
		
			if(matrix[i][j] > x){
				j--;
			}else{
				i++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[] result =binarySearchMatrix(matrix,145);
		System.out.println(result[0] +","+ result[1]);
	}

}
