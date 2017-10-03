package com.shekspeare.algorithms.dynamicprogram;



//https://www.youtube.com/watch?v=WepWFGxiwRs

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoWordsInDictionary {
	
	
	 public static boolean breakWordDP(String word, Set<String> dict){
		 
		 int n = word.length();
		 boolean[][] result= new boolean[n][n];
		 
		 //fill up matrix in bottom up manner.. in upper right diagonal
		 for(int L=1;L<=word.length();L++){
			 
			 for(int i=0;i<n-L+1;i++){
				 
				 int j = i+L-1;
				 
				 String str = word.substring(i, j+1);
				 
				//if string between i to j is in dictionary T[i][j] is true
				 if(dict.contains(str)){
					 result[i][j] = true;
					 continue;
				 }
				 
				//find a k between i+1 to j such that result[i][k-1] && result[k][j] are both true 
				 for(int k=i+1;k<=j;k++){
					 
					 if(result[i][k-1] && result[k][j]){
						 result[i][j]= true;
						 break;
					 }
				 }
				 
			 }
			 
		 }
		 
		 return result[0][n-1];
		 
	 }

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        
        System.out.println(breakWordDP(str,dictionary));
	}

}
