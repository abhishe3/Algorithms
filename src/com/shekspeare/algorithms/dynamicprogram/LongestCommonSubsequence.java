package com.shekspeare.algorithms.dynamicprogram;

public class LongestCommonSubsequence {

	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
	 * Watch Tushar Roy video at https://www.youtube.com/watch?v=NnD96abizww
	 * @param str1
	 * @param str2
	 * @return
	 */
	
	public static int lcs(String str1, String str2){
		int max = 0;
		
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int[][] temp = new int[s1.length+1][s2.length+1]; //**PTR - The matrix has one extra row and column
		
		for(int i=1 ; i <temp.length;i++){     //**PTR - both Loops start from 1, because of the extra column
			for(int j=1;j<temp[i].length;j++){
				
				if(s1[i-1]==s2[j-1]) {        //**PTR  - compare i-1 and j-1 .. as the indexes i and j are one ahead w.r.t the matrix 
					temp[i][j] = temp[i-1][j-1] +1 ;   // if they are same, add 1 to the upper left diagonal 
				}else{
					temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);  //if they are different, take the max(left, top)
				}
				
				if(temp[i][j] > max){        //update max
					max=temp[i][j];
				}
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		String str1 = "ABCDGHLQR";
        String str2 =  "AEDPHR";
        
        int result = lcs(str1, str2);
        System.out.print(result);

	}

}
