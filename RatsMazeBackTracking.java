/**
 * 
 */
package com.shekspeare.algorithms.backtracking;

/**
 * @author abashok
 *
 */
public class RatsMazeBackTracking {
	
	
	
	public static final int N = 4;
	
	public static void RMSolve(){
		
		int[][] maze =  {{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};  // new int[N][N];
		int[][] sol  =  new int[N][N];
		
		if(RMSolveUtil(maze,sol,0,0)){
			//print
			printSolutionMatrix(sol);
		}else{
			System.out.print("Solution does not exist for this maze");
		}
		
	}

	public static boolean RMSolveUtil(int[][]maze, int[][] sol, int x, int y){
		
		if(x==(N-1) && y==(N-1))
			return true;
		
		sol[x][y]=1;
		if(isSafe(maze,x,y+1)){
			sol[x][y+1] = 1;
			return RMSolveUtil(maze,sol,x,y+1);
			
		}
		
		if(isSafe(maze,x+1,y)){
			sol[x+1][y] = 1;
			return RMSolveUtil(maze,sol,x+1,y);
		}
		
		sol[x][y] = 0;
		return false;
		
	}
	
	public static boolean isSafe(int[][] maze, int x, int y){
		if(x>=0 && y>=0 && x<N && y<N && maze[x][y]==1)
			return true;
		
		return false;
		
	}
	
	public static void printSolutionMatrix(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RMSolve();

	}

}
