package com.shekspeare.algorithms;

public class SolveNQueenProblem {
	
	public static final int N = 25;
	
	
	
	public static boolean isSafe(int[][] board, int row, int col){
		
		//check if any queen already placed in same column
		for (int i = 0 ; i < N ; i ++){
			if (board[i][col] == 1) return false;
		}
		
		//check upper left diagonal
		for  (int i=row ,  j=col; i >=0 && j>=0; i--, j--){
			if (board[i][j] == 1) return false;
		}
		
		//check upper right diagonal
		for (int i = row, j= col ; i>=0 && j<N ; i--, j++){
			if(board[i][j] == 1) return false;
		}
		
		return true;
	}
	
	public static boolean solveNQueenUtil(int[][] board, int row){
		
		
		if (row == N) return true;
		
		//for each col in a row, check if it is safe to place a queen
		for (int col = 0; col < N ; col++){
			
			if (isSafe(board, row, col)){
				board[row][col] = 1;
				
					if (solveNQueenUtil(board, row+1)){
						return true;
					}
			}	
			
				board[row][col] = 0; //backtracking
		}
		
		//if queen cannot be placed in any column of this row return false
		return false;      
		
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
	
	public static void solveNQueen(){
		
		int[][] board = new int[N][N];
		if(!solveNQueenUtil(board, 0)){
			System.out.println("Solution does not exist");
		}else{
			printMatrix(board);
		}
			;
	}
	
	
	
	public static void main(String[] args){
		
		solveNQueen();
		
	}

}
