package com.shekspeare.algorithms;

/**
 * 
 * @author shekspeare
 * This class simply demonstrates multiplication of two square matrices
 */

public class MatrixMultiplication {

	
	/* 
	 * @param: int[][] a , int[][]b - int matrices to be multiplied
	 * The crux of this algorithm is :
	 * c[i,j] = c[i,j] + a[i,k] * b[k,j]
	 */
	public static int[][] matrixMultiply(int[][]a, int[][]b){
		int[][]c = {{0,0,0},{0,0,0},{0,0,0}} ;
		
		int m = a.length;
		int n = a[0].length;
		
		for (int i = 0 ; i<m; i++){
			
			for (int j = 0 ; j < n ; j ++) {
				
					for (int k = 0; k < n; k++){
						c[i][j]+= a[i][k] * b[k][j];
				
			}
			
			}
		}
		return c;
		
	}
	
	/**
	 * This function simply prints each row of an integer matrix
	 * @param a : an m*n matrix
	 */
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
		
		
		int[][]a = {{1,2,3},{4,5,6},{7,8,9}} ;
		int[][]b = {{1,2,3},{4,5,6},{7,8,9}} ;
		
		int [][] result = matrixMultiply(a, b);
		
		printMatrix(result);
			
		

	}

}
