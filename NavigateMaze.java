/**
 * 
 */
package com.shekspeare.algorithms;

/**
 * @author abashok
 * 
 * This class demonstrates navigating an NxN matrix
 * in the form of a maze. The objective of the maze 
 * is to find a way from the top-left of the matrix 
 * to the bottom right, such that it can only take 
 * a path if it the cell has value 1.
 * 
 * Eg: Maze: 1,1,1,0
			 1,0,1,0
			 0,0,1,1
			 0,1,0,1
 * 
 * Sol is  : X,X,X,-
			 -,-,X,-
			 -,-,X,X
			 -,-,-,X
 *
 */
public class NavigateMaze {


	
	
	/* This function performs the maze navigation
	 * @param: maze: the maze matrix, 
	 * 		   n   : the size of maze
	 * 		   x   : the current row index of maze
	 * 		   y   : the current col index of maze
	 * 		  sol  : the solution matrix,	
	 * 
	 * @return: boolean 
	 */
	static boolean navigateMaze(int[][] maze, int n, int x, int y, char[][] sol){
		
		if(x==n-1 && y==n-1 && maze[x][y]==1){    //base case of recursion; we have reached bottom-right-most index of maze; exit 
			sol[x][y] ='X';                       //mark the solution matrix with 'X'
			return true;
		}
		
		if(isSafe(maze, n, x,y)){
			sol[x][y] = 'X';
			
			if(navigateMaze(maze,n,x+1,y,sol)) return true;  // move down
			if(navigateMaze(maze,n,x,y+1,sol)) return true;  // move right
			//if(navigateMaze(maze,n,x,y-1,sol)) return true;  // move left
			//if(navigateMaze(maze,n,x-1,y,sol)) return true;  // move up

			//System.out.println("Backtracked");   //None of the options were safe; backtrack by marking sol[x][y] as '-'
			sol[x][y] = '-';
			return false;

		}
		
		return false;
	}
	
	/* This function checks if it is safe to navigate to a given cell 
	 * in the maze, by ensuring that:
	 * 	1:  the indices x and y are within the range [0,n)
	 *  2:  the cell maze[x][y] has value 1
	 * @param: maze: the maze matrix, 
	 * 		   n   : the size of maze
	 * 		   x   : the current row index of maze
	 * 		   y   : the current col index of maze	
	 * 
	 * @return: boolean 
	 */
	
	static boolean isSafe(int[][] maze, int n, int x, int y){
		
		if(x >=0 && x<n && y<n && y>=0 && maze[x][y]==1){
			return true;
		}
		
		return false;
	}
	
	/**
	 * This function simply prints each row of an char matrix
	 * @param a : an m*n matrix
	 */
	 static void printSolution(char[][] a){
				int n = a.length;
				int m = a[0].length;
				for (int i = 0 ; i <m ; i++){
					for (int j=0 ; j <n; j++){
						System.out.print((j==0?" ": ",") + a[i][j]);
					}
					System.out.print("\n");
				} 
	 }
	
	/** This is the main function to test this demo
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int[][] maze = {{1,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,1,1}};   //one sample maze
		int[][] maze = {{1,1,1,0},{1,0,1,0},{0,0,1,1},{0,1,0,1}};
		char[][] sol = {{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'}}; //solution array being initialized
		int n = maze[0].length;
	
		if( navigateMaze(maze, n, 0, 0,sol)){
			System.out.println("Solution Found!!... Printing path");
			printSolution(sol);
		}else{
			System.out.println("Solution not found!!... No possible path exists..");
		}

	}

}
