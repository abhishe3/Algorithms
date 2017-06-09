package com.shekspeare.algorithms.dynamicprogram;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * Video : https://www.youtube.com/watch?v=_nCsPn7_OgI
 * O(n^2)
 * Draw matrix before writing code to understand
 */

public class LongestPalindromincSubsequence {
	
	
	static int longestPalSubsequence(String str){
		
		char[] input = str.toCharArray();
		int n = input.length;
		int[][] result = new int[n][n];
		
		for(int i=0;i<n;i++){
			result[i][i]=1;
		}
		
		for(int L = 2;L<=n;L++){     //For each length run the loop from i=first row to n-L+1
		
			for(int i=0;i<n-L+1;i++){ // PTR: i<n-L+1 ..to fill diagonal only. no need to fill bottom diagonal of matrix . Similar to approach in Matrix Chain Multiplication Problem
				
				int j = i+L-1;   // ending index to get the character at the end of the possible palindromic string
				
				if(L==2 && input[i] == input[j]){   //Special case for L=2, because only in this case if input[i] == input[j], then count is 2.. for L>2, it will be as below
					result[i][j] = 2;
				}
				
				else if(input[i]==input[j]){             //for L>2, if input[i] == input[j] then 2 + left bottom diagonal
					result[i][j] = 2 + result[i+1][j-1]; 
				}
				
				else{								//for L>2, if input[i] != input[j] then Max(left cell, bottom cell)
					result[i][j] = Math.max(result[i][j-1],result[i+1][j]);
				}	
			
			}
			
		}
		
		return result[0][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String seq = "GEEKSFORGEEKS";
	     System.out.println("The length of the lps is "+ longestPalSubsequence(seq));
	}

}
