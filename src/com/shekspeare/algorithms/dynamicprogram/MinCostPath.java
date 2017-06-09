package com.shekspeare.algorithms.dynamicprogram;

import java.util.Stack;

public class MinCostPath {

	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
	 * Video: https://www.youtube.com/watch?v=lBRtnuxg-gU
	 * @param cost
	 * @return
	 */
	public static int minCostPath(int[][]cost){
		int m = cost.length-1;
		int n = cost[0].length-1;
		
		int[][]temp = new int[m+1][n+1];
		
		temp[0][0] = cost[0][0];   //**PTR - Make first cell same as cost[0][0]
		
		for(int i=1;i<=m;i++){     // Initialize first col 
			temp[i][0] = temp[i-1][0]+cost[i][0];
		}
		  
		for(int i=1;i<=n;i++){     //Initialize first row
			temp[0][i] = temp[0][i-1]+cost[0][i];
		}
		
		
		 
		for(int i=1;i<=m;i++){    // Fill rest of the inner cells
			for(int j=1;j<=n;j++){
				//cost will be the min of (upper, left, upper-left-diagonal) + cost of current cell
				temp[i][j] = cost[i][j] + Math.min(temp[i-1][j-1], Math.min(temp[i-1][j], temp[i][j-1])) ;
			}
		}
		
		printActualPath(temp,cost);
		
		return temp[m][n]; // return the cost of the destination cell
	}
	
	public static void printActualPath(int[][]temp, int[][]cost){
		Stack<Integer> st = new Stack<Integer>();
		int m = cost.length-1;
		int n = cost[0].length-1;
		st.push(cost[m][n]);    //obviously, push the last (destination) element
		
		while(true){
			
			if(m==0 || n==0) break;
			
			if(temp[m][n] == (temp[m-1][n]+cost[m][n])){  // came from top
				st.push(cost[m-1][n]); 
				m=m-1;
			}else if(temp[m][n] == temp[m-1][n-1] + cost[m][n]) {// came from diagonal upper left
				st.push(cost[m-1][n-1]);
				m=m-1;
				n=n-1;
			}else if(temp[m][n] == temp[m][n-1]+cost[m][n]){  //came from left
				st.push(cost[m][n-1]);
				n=n-1;
			}
			
		}
		
		st.push(cost[0][0]);   //obviously, push the first (source) element
		
		while(!st.isEmpty()){
			System.out.println(st.pop() + ", ");
		}
	}
	
	public static void main(String[] args) {
		int cost[][] = {{1,2,3},
						{4,8,2},
						{1,5,3},
						{6,2,9}};
        int result = minCostPath(cost);
        
        System.out.println(result);

	}

}
