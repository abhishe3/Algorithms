package com.shekspeare.algorithms.dynamicprogram;

/**
   '.' Matches any single character.
 	*  Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "a*") ? true
isMatch("aa", ".*") ? true
isMatch("ab", ".*") ? true
isMatch("aab", "c*a*b") ? true


Watch Tushar's video at  https://www.youtube.com/watch?v=3ZDZ-N0EPV0
 */



public class PatternMatching {

	public static boolean isMatch(String string, String pattern){
		
		if(null==string && null==pattern) return true;
		
		int m = string.length();
		int n = pattern.length();
		boolean[][] result = new boolean[m][n];
		
		//initialize first row and columns
		result[0][0] = true;    //this is for null string and null pattern
		
		for(int i=1;i<m;i++){
			result[i][0] = false;
		}
		
		for(int j=1;j<n;j++){
			result[0][j] = false;
		}
		
		for(int i=1;i<m;i++){
			
			for(int j=1;j<n;j++){
				
				if(pattern.charAt(j-1)=='.' || string.charAt(i-1)==pattern.charAt(j-1)){
					result[i][j] = result[i-1][j-1];
				}
				
				else if(pattern.charAt(j-1)=='*'){
					result[i][j] = result[i-1][j] || result[i][j-1];
				}
				
			}
			
		}
		
		return result[m-1][n-1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "xaylmz";
		String pattern = "x.y*z";
		
		System.out.println(isMatch("xaylmz", "x.y*z"));  //true
		
		System.out.println(isMatch("aa", "a"));   //false
		System.out.println(isMatch("aa","aa"));   //true
		System.out.println(isMatch("aaa","aa"));   //false
		System.out.println(isMatch("aa", ".*"));   //true
		System.out.println(isMatch("ab", ".*"));   //true
		System.out.println(isMatch("cab", "c*a*b"));  //true
		

	}

}
