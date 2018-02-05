package com.shekspeare.algorithms.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestSubArrayCoveringSet {
	
	//EPI Page 221, Q 13.7
	
	static class Pair{
		int start;
		int end;
		
		Pair(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	
	static Pair getSubArrayCoveringSet(Set<String> keywords, List<String> paragraph){
		
		Pair result = new Pair(-1,-1);
		
		Map<String, Integer> keyWordsToCover = new HashMap<String,Integer>();
		
		for(String word: keywords){
			
			keyWordsToCover.put(word, keyWordsToCover.get(word)==null?1:keyWordsToCover.get(word)+1);
		}
		
		int remainingToCover = keywords.size();
		
		for (int left=0,right=0; right<paragraph.size();right++){
			
			Integer keyWordsCount = keyWordsToCover.get(paragraph.get(right));
			
			if(keyWordsCount!=null){
				
				keyWordsToCover.put(paragraph.get(right),--keyWordsCount);
				
				if(keyWordsCount>=0)
					--remainingToCover;
			}
			
			while(remainingToCover==0){
				
				if((result.start==-1 && result.end==-1) //first time
						|| right-left < result.end - result.start ){ //or update minimum
					result.start = left;
					result.end = right;
				}
				
				keyWordsCount = keyWordsToCover.get(paragraph.get(left));
				
				if(keyWordsCount!=null){
					keyWordsToCover.put(paragraph.get(left), ++keyWordsCount);
				
				if(keyWordsCount>0){
					++remainingToCover;
				}
				
				}
				
				
				++left;
			}
			
		}
		
		
		return result;
		
	}

	public static void main(String[] args) {
		
		List<String> paragraph = new ArrayList<String>(Arrays.asList("apple","banana","apple","apple","dog","cat","apple","dog","banana","apple","cat","dog"));
		
		Set<String> keyWords = new HashSet<String>(Arrays.asList("banana","cat","banana"));
		
		Pair result = getSubArrayCoveringSet(keyWords,paragraph);
		
		for( int index =result.start ;  index<=result.end; index++){
			System.out.println(paragraph.get(index));
		}
		
		
	}

}
