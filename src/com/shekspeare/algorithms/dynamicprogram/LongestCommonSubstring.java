package com.shekspeare.algorithms.dynamicprogram;

/**
 * http://www.geeksforgeeks.org/longest-common-substring/
 * @author abashok
 *
 * Simple soln: if char are same, then add 1 to the left top diagonal; update max.
 * 				if not same, then 0; dont touch max
 */

public class LongestCommonSubstring {

	public static int longestCommonSubstring(String str1, String str2){
		
		int result =0;
		
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] temp = new int[n2+1][n1+1];
		
		for(int i=0;i<=n1;i++){
			temp[0][i] = 0;
		}
		
		for(int j=0;j<=n2;j++){
			temp[j][0] = 0;
		}
		
		
		int i=1,j=1;
		
		while(i<=n1 && j<=n2){
			
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				temp[i][j] = 1 + temp[i-1][j-1];
				result = Math.max(result, temp[i][j]);
			}else{
				temp[i][j]= 0;
			}
			
			i++; j++;
		}
		
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(longestCommonSubstring("geeksforgeeks", "geeksquiz"));
		
	}

}
