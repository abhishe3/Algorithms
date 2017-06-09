package com.shekspeare.algorithms.dynamicprogram;

public class MatrixMultiplicationCost {

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * Explanation from : https://www.youtube.com/watch?v=GMzVeWpyTN0
 * Code referred from : http://ideone.com/l54tKD
 * @param arr
 * @return
 * Time Complexity: O(n^3)
 * Underlying formula is at https://www.youtube.com/watch?v=GMzVeWpyTN0&t=7m59s
 * 
 *     
 * 
 */
	
	  public int findCost(int arr[]){
		    int n = arr.length;
		  //table of multiplication values
	        int[][] M = new int[n][n];
	      //auxillary table to hold choosen k values
	        int[][] B= new int[n][n];
	        
			//no need to initialise M[i][i] = 0 
			//because by default the whole array 
			//is filled with zeros
	        
	      //chain size
	        for(int L=2;L<n;L++){    //L is chain length. Here L < n and not L<=n, because at max L=n-1 (if 4 martices, max matrices within a bracket is 3)
	        	
	        	//start index
	        	for(int i=1;i<n-L+1;i++){   // PTR: i<n-L+1 ..to fill diagonal only. no need to fill bottom diagonal of matrix              
	        		//end index
	        		int j= i + L -1;
	        		
	        		int min = Integer.MAX_VALUE;
	        		
					//k value where we will split the matrices
					//(i... k)(k+1... j)
	        		for(int k=i;k<j;k++){
	        			//cost of  left mult. + right mult.
	        			int current = M[i][k] + M[k+1][j] + arr[i-1]*arr[k]*arr[j]; 
	        			
	        			if(current<min){
	        				min=current;
	        				B[i][j] = k;
	        			}
	        		}
	        		
	        		M[i][j] = min;
	        	}
	        	
	        }
	      //print the result of multiplying matrices from 1 to n
	        print(B,1,n-1);
	        return M[1][n-1];
	        
	    }
	  
	//helper method to recursively print brackets
		static void print(int[][] B,int i, int j){
			if(j-i == 1){
				System.out.print("("+i+"*"+j+")");
				return ;
			}
			else if(j-i ==0){
				System.out.print(i);
				return ;
			}
			int k = B[i][j];
			System.out.print("(");
			print(B,i,k);
			print(B,k+1,j);
			System.out.print(")");
		}
		
		

	public static void main(String[] args) {
		MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
		//matrices are 4X10 10X3 3X12 12X20 20X7
        int arr[] = {4, 10, 3, 12, 20, 7};
        int cost = mmc.findCost(arr);
        System.out.print(cost);

	}

}
