package com.shekspeare.algorithms.epi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Refer EPI : HashTables Q 13.09 Page 227
public class LongestSubArrayWithDistinctEntries {

	public static int longestSubArrayWithDistinctEntries(List<Character> listOfEntries){
		
		int result=0;
		
		Map<Character,Integer> mostRecentEntryMap = new HashMap<Character,Integer>();
		int longestDupFreeSubArrayStartIdx = 0;
		
		for(int i=0; i<listOfEntries.size();i++){
			
			Integer lastEntry = mostRecentEntryMap.put(listOfEntries.get(i), i);   
			//**PTR:- map.put returns the existing value of the key before replacing it (if it does not exist, it returns null)
			
			if(lastEntry!=null){   //means this character existed, so update the results
				if(lastEntry>=longestDupFreeSubArrayStartIdx){
					result = Math.max(result, i-longestDupFreeSubArrayStartIdx);
					longestDupFreeSubArrayStartIdx = lastEntry+1;
				}

				
			}
		}
	
		result = Math.max(result, listOfEntries.size()-longestDupFreeSubArrayStartIdx); //in case no duplicates at all
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
