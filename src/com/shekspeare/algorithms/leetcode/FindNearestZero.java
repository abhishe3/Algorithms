package com.shekspeare.algorithms.leetcode;

/**  https://leetcode.com/problems/01-matrix/description/
 * 
 * INCORRECT ATTEMPT: look at link for suggested solutions
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.

 *
 */

public class FindNearestZero {

public static int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length; //rows
        int n = matrix[0].length; //cols
        
        int[][] result = new int [m][n];
        
        for(int i=0;i<m;i++){
            
            for(int j=0; j<n;j++){
                
                if(matrix[i][j] != 0){
                    
                   int leftMin= findNearestZero(i,j-1,matrix,result,1);
                   int rightMin= findNearestZero(i,j+1,matrix,result,1);
                    int upMin= findNearestZero(i-1,j,matrix,result,1);
                    int downMin= findNearestZero(i+1,j,matrix,result,1);
                    
                    result[i][j] = Math.min(leftMin, Math.min(rightMin, Math.min(upMin,downMin)));
                }
            }
            
        }
        
        return result;
        
    }
    
    
    public static int findNearestZero(int i, int j, int[][] matrix, int[][] result, int dist){
        
        if(i>=0 && i <matrix.length && j>=0 && j<matrix[0].length){
            
            if(matrix[i][j] == 0) return dist;
            
            else{
                int leftMin= findNearestZero(i,j-1,matrix,result,dist+1);
                   int rightMin= findNearestZero(i,j+1,matrix,result,dist+1);
                    int upMin= findNearestZero(i-1,j,matrix,result,dist+1);
                    int downMin= findNearestZero(i+1,j,matrix,result,dist+1);
                return Math.min(leftMin, Math.min(rightMin, Math.min(upMin,downMin)));
            }
            
        }
        
        return Integer.MAX_VALUE;
    }
    
    
    public static void main (String[] args){
    	
    	int[][] matrix = {{0,0,0},{0,1,0}, {1,1,1}};

    	
    	int[][] result = updateMatrix(matrix);
    	
    	for(int i=0;i<result.length;i++){
    		for(int j=0;j<result[0].length;j++){
    			
    			System.out.print(result[i][j]+" ,");
    		}
    		
    		System.out.println();
    	}
    }
	
}
