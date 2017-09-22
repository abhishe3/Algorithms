package com.shekspeare.workshop;


//TEST ONLY: Not complete solution.. Does not cover all slopes
public class DrawLinesMatrix {

	public static void drawLine(char[][] matrix, int x1, int y1, int x2, int y2){
		
		//assume x1, y1, x2, y2 are all valid and always x1<=x2, and y1<=y2
		
		if(x1==x2 && y1!=y2){
			while(y1!=y2+1){
				matrix[x1][y1++] = '+';
			}
		}
		
		else if(x1!=x2 && y1==y2){
			while(x1!=x2+1){
				matrix[x1++][y1] = '+';
			}
		}
		
		else{
			
			int slope = (y2-y1)/(x2-x1);
			
			if(slope==1){
				
				while(x1!=x2+1){
					matrix[x1++][y1++]='+';
				}
				
			}
			
			else if(slope==-1){
				while(x1!=x2-1){
					matrix[x1--][y1++]='+';
				}
				
			}
			
		}
		
		
		printMatrix(matrix);
		
	}
	
	
	public static void printMatrix(char[][] matrix){
		
		for(int i=0; i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		
		char[][] matrix = {{'_','_','_','_','_'},{'_','_','_','_','_'},{'_','_','_','_','_'},{'_','_','_','_','_'},{'_','_','_','_','_'}};
		drawLine(matrix, 3, 1, 1, 4);
	}

}
