package com.shekspeare.algorithms.dynamicprogram;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * 
 * https://www.youtube.com/watch?v=8LusJS5-AGo
 * However, in his explanation, he has not created extra row for row=0 and col=0 ;
 * The code below creates extra row and col; as done in geeksforgeeks link above
 * @author abashok
 */

public class Knapsack01 {

	public static int knapsack(int wt[], int[]val, int W){
		
		int n = wt.length;
		int[][] T = new int[n+1][W+1];
		
		
		for(int i=0;i<=n;i++){
			
			for(int j=0;j<=W;j++){
				
				if(i==0 || j==0){
					T[i][j] = 0;
					continue;
				}
				
				if(wt[i-1] > j){
					T[i][j] = T[i-1][j];
				}
				
				else{
					T[i][j] = Math.max(val[i-1] + T[i-1][j-wt[i-1]], T[i-1][j] );
					
				}
			
			}
		}
		
		return T[n][W];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    System.out.println(knapsack(wt,val,W));
	}

}
