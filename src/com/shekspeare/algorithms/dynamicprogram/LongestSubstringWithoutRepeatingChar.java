package com.shekspeare.algorithms.dynamicprogram;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * O(n)
 * 
 * Actually better solution is in EPI page 227 : Q 13.9 : See Code Below
 */
public class LongestSubstringWithoutRepeatingChar {

	public static int longestUniqueSubst(String str){
		char[] input = str.toCharArray();
		
		final int CONST = 256;
		
		int currLength = 1;   // Length of current non repeating substring **PTR- currLength and maxLength are initialized as 1
		int maxLength=1;	  // Length of longest substring with non repeating characters found
		int strtIndex= 0;     // Starting index of longest substring with non repeating characters found
		int n = input.length;
		
		// array to store last index of string characters seen in the string, initialized to -1 to indicate "not visited"
		int[] visited = new int[CONST];
		for (int i=0;i<CONST;i++){
			visited[i] = -1;
		}
		
		visited[input[0]] = 0;    // **PTR  -Mark first character as visited by storing the index of first   character in visited array. */
		
		for(int i=1;i<n;i++){     //**PTR -  Start with index 1, since first character is taken care of ; 
			
			int prevIndex = visited[input[i]];
			
			/* If the current character is not present in the
	           already processed substring or it is not part of
	           the current Longest Unique Substring, then do cur_len++ */
			if(prevIndex==-1 || (i-currLength) > prevIndex){
				currLength++;
			}else{
				
				/* /** PTR  Also, when we are changing the Longest Unique Substring, we
	               should also check whether length of the
	               previous Longest Unique Substring was greater than max_len or
	               not.*/
				if(maxLength<currLength){
					maxLength = currLength;
					strtIndex = i-maxLength; // store the starting index, to print the Longest Unique Substring later
				}	
				
				currLength = i-prevIndex;
			}
			// update the index of current character
			visited[input[i]] = i;
		}
		// Check if longest substring with non repeating characters ends at end of the string
		//**PTR - Do this check again because the else part may not be executed for the last character and currLenght might have 
		//        been updated in the 'if' part
		if(maxLength<currLength){
			maxLength = currLength;
			strtIndex = n-maxLength;
		}
		
		//print the substring
		System.out.println(str.substring(strtIndex,strtIndex+maxLength));
		
		return maxLength;
	}
	
	//EPI solution
	
	public static int longestUniqueSubstring (String str){
		
		int max=1;
		
		Map<Character,Integer> indexMap = new HashMap<Character,Integer>();
		int currStartIdx = 0;
		for(int i=0;i<str.length();i++){
			
			Integer lastIndex = indexMap.put(str.charAt(i), i);
			
			if(lastIndex!=null){
				
				if(lastIndex>=currStartIdx){
					max = Math.max(max, i-currStartIdx);
					currStartIdx=lastIndex+1;
				}
				
			}
			
		}
		
		return Math.max(max, str.length()-currStartIdx);
		
		
	}
	
	public static void main(String[] args) {
		
		 String str = "GEEKSFORGEEKS";
		 int result = longestUniqueSubst(str);
		 System.out.println(result);
		 
		 System.out.println(longestUniqueSubstring(str));
	}

}
