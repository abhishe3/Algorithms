package com.shekspeare.algorithms;

/** Used the technic in EPI (look in Searching chapter)..very simple
 * 
 * @author abashok
 *
 */

public class SearchInMatrix {

	
    public static boolean search(int[][] matrix,int x){
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int row=0,col=n-1;
    	
    	while(row>=0 && row<m && col<n&& col>=0){
    		
    		if(x==matrix[row][col]){
    			return true;
    		}else if(x<matrix[row][col]){ //column and below is eliminated
    			col--;
    		}else{  //row is eliminated
    			row++;
    		}
    		
    	}
    	
    	return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		
	//	findInSortedMatrix(mat,51);
		
		System.out.println(search(mat,10));
		
	}

}
