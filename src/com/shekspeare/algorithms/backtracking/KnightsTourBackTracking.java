/**
 * 
 */
package com.shekspeare.algorithms.backtracking;

/**
 * @author abashok
 *
 */
public class KnightsTourBackTracking {

	
	public static final int N = 8;
	public static final int [] xMoves = {2, 1, -1, -2, -2, -1, 1, 2}; //{1,-1,-2,2,1,-1,2,-2};
	public static final int [] yMoves = {1, 2, 2, 1, -1, -2, -2, -1}; //{2,2,1,1,-2,-2,-1,-1};
	
	public static boolean isSafe(int[][]board, int x,int y){
		
		if(x>=0 && y >=0 && x<N && y <N && board[x][y]==-1)
			return true;
		return false;
	}
	
	public static void KTSolve(){
		
		int[][] board =  new int[N][N];
		
		//initializing board to -1
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[i][j]=-1;
			}
		}
		board[0][0] = 1;
		
		if(KTSolveUtil(0,0,board,1)){
			//print solution
			printMatrix(board);
		}else{
			System.out.println("Solution does not exist from the given starting point.");
		}
		
	}
	
	public static boolean KTSolveUtil(int x, int y, int[][]board,int stepNum){
		
		if(stepNum == N*N){
			board[x][y] = stepNum;
			return true;
		}
		
		int k, xNew, yNew;
		int maxMoves = xMoves.length;
		for(k=0;k<maxMoves;k++){
			
			xNew = x + xMoves[k];
			yNew = y + yMoves[k];
			if(isSafe(board, xNew, yNew)){
				board[xNew][yNew] = stepNum;
				if(KTSolveUtil(xNew, yNew, board,stepNum+1))
					return true;
				
				board[xNew][yNew] = -1;	//backtracking
					
			}
			
			
		}
		
		return false;
			
		
	}
	
	
	public static void printMatrix(int[][] a){
		
		for(int i = 0 ; i < a.length; i++){
			for(int j = 0 ; j < a[0].length; j++){
				//System.out.print(j==0?"\n":""+ a[i][j] + (j==(a[0].length-1)?"":" ,"));
				System.out.print(a[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KTSolve();
	}

}
