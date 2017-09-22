package com.shekspeare.workshop;

public class BinarySearchInMatrix {

	public static void searchSortedMatrix(int[][] matrix, int x){
		
		int m= matrix.length-1;
		int n= matrix[0].length-1;
		 searchSortedMatrixUtil(matrix,0,m,0,n,x);		
	}
	
	public static void searchSortedMatrixUtil(int[][] matrix, int startRow, int endRow, int startCol, int endCol, int x){
		
		
		if(startRow>=0 && startRow<=matrix.length-1 && endCol>=0 && endCol<=matrix[0].length-1) {
			int midCellRow = startRow + (endRow-startRow )/2;
			int midCellCol = startCol + (endCol-startCol )/2;
			
			int midValue = matrix[midCellRow][midCellCol];
			if(midValue==x){
				System.out.println(x+" found at ("+midCellRow+","+midCellCol+")");
				return;
			}
			
			
			//search top right in all cases
			//if (midCellRow!=endRow || midCellCol!=startCol)
			searchSortedMatrixUtil(matrix, startRow,midCellRow,midCellCol,endCol,x);
			
			 
			
/*			// Special case for iteration with 1*2 matrix
			// mat[i][j] and mat[i][j+1] are only two elements.
			// So just check second element
			if (startRow == endRow && startCol + 1 == endCol)
			if (matrix[startRow][endCol] == x)
				System.out.println("Found "+ x+ " at "+ 
						startRow + " " + endCol);*/
			
			
			if(midValue<x){
				//search bottom 
			//	if (midCellRow+1<=endRow)
				searchSortedMatrixUtil(matrix, midCellRow+1,endRow,startCol,endCol,x);
			}
			
			else if (midValue>x) {
				//search left
			//	if (midCellCol-1>=startCol)
				searchSortedMatrixUtil(matrix, startRow,endRow,startCol,midCellCol-1,x);
				
			}
		}else{
			System.out.println("Not found..");
			return;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {{5,10,15,20,25},{6,12,18,24,30},{7,14,21,28,35},{8,16,24,32,40},{9,19,27,36,45}};
		searchSortedMatrix(matrix,32);
	}

}
