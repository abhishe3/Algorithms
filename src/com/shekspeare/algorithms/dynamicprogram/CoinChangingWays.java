package com.shekspeare.algorithms.dynamicprogram;


/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * Video: https://www.youtube.com/watch?v=_fgjrs570YE 
 * BUT THE CODE IS TAKEN FROM : https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java
 * There is some discrpency between code and video..code below works
 * @author abashok
 *
 */
public class CoinChangingWays {

	public static int coinChange(int total, int[] coins){
		
		int[][] temp = new int[coins.length+1][total+1]; //Note the extra row and col (total +1)
		
		for(int i=0;i<coins.length+1;i++){  //**PTR- Initialize only first col as 1
			temp[i][0] = 1;          
		}
		
		
		for(int i=1;i<=coins.length;i++){
			
			for(int j=1;j<=total;j++){
				
				if(coins[i-1] > j){     //if value of coin is greater than the total
					temp[i][j] = temp[i-1][j];    //copy the top value
				}else{
					temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j]; //else add top value and count in cell 'j-value of coin' to the left . **PTR - Learn this step
				}
			}
		
		}
		return temp[coins.length][total];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {3,2,1};
		int total = 5;
		System.out.println(coinChange(total, coins));

	}

}
