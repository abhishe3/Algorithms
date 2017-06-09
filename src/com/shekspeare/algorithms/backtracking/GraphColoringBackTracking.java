/**
 * 
 */
package com.shekspeare.algorithms.backtracking;

/**
 * @author abashok
 *
 */
public class GraphColoringBackTracking {

	
	
	
	
	public static final int GRAPH_SIZE = 4;
	
	
	public static void colorGraph(){
		
		int[][] graph ={{0, 1, 1, 1},
					   {1, 0, 1, 0},
					   {1, 1, 0, 1},
					   {1, 0, 1, 0}};
		int m = 3;
		int[] color = new int[4];
		
/*		for(int i=0;i<m; i++){
			color[i] =0;
		}
		*/
		
		colorGraphUtil(graph, color,0, m);
		
	}
	
	public static boolean colorGraphUtil(int[][] graph, int[] color, int node, int m){
		
		if(node == GRAPH_SIZE){
			printColorArray(color, color.length);
			return true;
		}
			
		for(int c=1;c<=m; c++){
			
			if (isSafe(graph,color, node,c)){
				color[node] = c; 
				
				if( colorGraphUtil(graph, color, node+1,m)){
					return true;
				}
				
				color[node] = 0;
			}

			
		}
		
		System.out.print("Solution does not exist for given conditions..");
		
		return false;
		
	}
	
	
	public static void printColorArray(int[] color, int size){
		for(int i=0;i<size; i++){
			System.out.print(color[i]+ " ");
		}
	}
	
	public static boolean isSafe(int[][]graph, int[] color ,int node, int c){
		
		
		for(int i=0;i<GRAPH_SIZE; i++){
			if (graph[node][i]==1 && color[i] == c){
				return false;
			}
		}
		
		return true;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		colorGraph();

	}

}
