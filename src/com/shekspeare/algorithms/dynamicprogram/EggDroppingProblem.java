package com.shekspeare.algorithms.dynamicprogram;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * https://www.youtube.com/watch?v=amdKmQlATmQ
 * Time Complexity: O(nk^2)
 * @author abashok
 *
 */

public class EggDroppingProblem {

	//In the result[][] we are trying to fill the minimum num of trials we will get to find if 
	// the given eggs  will break for the given number of floors. 
	static int eggDrop(int eggs, int floors){
		
		/* A 2D table where entry result[e][f] will represent minimum
	       number of trials needed for e eggs and f floors. */
		int[][] result = new int[eggs+1][floors+1];
		int current=0;
		
		
		// We need one trial for one floor and 0 trials for 0 floors
		for(int i=1;i<=eggs;i++){
			result[i][0] = 0;  //filling 0th floor as 0 for all rows..technically this is not required as 0 is default
			result[i][1] = 1;  //filling 1 for all rows in col 1
		}
		
		// We always need i trials for one egg and i floors.
		for(int i=1;i<=floors;i++){
			result[1][i] = i;      //for row 1 (1 egg) each floor will 'floor' number of trials
		}
		
		
		for(int e=2;e<=eggs;e++){
			
			for(int f=2;f<=floors;f++){
					result[e][f]= Integer.MAX_VALUE;
				
					for(int k=1;k<=f;k++){    //for each round of f floors, we drop eggs from first floor till f floor
						
						//Read the below line as follows:
						// current = 1 (its own trial) + Math.max( Possibility 1, Possibility 2)
						//  Possibility 1: egg breaks..therefore e-1 , and trials needed for one floor below (k-1)
						//  Possibility 2: egg does not break..so same no. of eggs e and trails needed remaining no. of floors
						
						current = 1+ Math.max(result[e-1][k-1], result[e][f-k]);
						
						//update the minimum
						if(current<result[e][f]){
							result[e][f] = current;
						}
					}
					
					
			}
		}
		
		return result[eggs][floors];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2, k = 36;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                 " floors is "+eggDrop(n, k));   
	}

}
