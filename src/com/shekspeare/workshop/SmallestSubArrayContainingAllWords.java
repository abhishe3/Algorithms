package com.shekspeare.workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Based on EPI : 13.7 page 222
public class SmallestSubArrayContainingAllWords {

	public static class SubArray{
	    
	    int left;
	    int right;
	    
	    SubArray(int left, int right){
	      this.left= left;
	      this.right= right;
	    }
	    
	  }
	  
	 
	public static SubArray smallestSubArrayContainingAllText(List<String> paragraph, List<String> keyWords){
	    
	    Map<String, Integer> keyWordsToCover = new HashMap<String, Integer>();
	    
	    for(String s: keyWords){
	      keyWordsToCover.put(s,keyWordsToCover.containsKey(s)?keyWordsToCover.get(s)+1:1);
	    }
	    
	    
	    SubArray subArray = new SubArray(-1,-1);
	    int remainingToCover = keyWords.size();
	    for(int left=0, right=0; right< paragraph.size(); right++){
	      
	      Integer keyWordCount = keyWordsToCover.get(paragraph.get(right));
	      
	      if(keyWordCount!=null){
	        keyWordsToCover.put(paragraph.get(right), --keyWordCount);
	        remainingToCover--;
	      }
	      
	      //Keep advancing left till subarray no longer covers all the keywords words
	      while(remainingToCover==0){
	        
	        if( (subArray.left==-1 && subArray.right==-1) || ( (right-left) < (subArray.right - subArray.left))){
	          subArray.left = left;
	          subArray.right = right;
	        }
	        
	         
	         keyWordCount = keyWordsToCover.get(paragraph.get(left));
	           
	         if(keyWordCount!=null){
	           
	            keyWordsToCover.put(paragraph.get(left),++keyWordCount );
	            remainingToCover++;
	           
	         }  
	           
	        left++;
	           
	        
	      }
	      
	      
	    }
	    
	    return subArray;
	    
	  }
	  
	  
	  public static void main(String[] args){
	    
	    List<String> paragraph = new ArrayList<String>(Arrays.asList("apple","banana","apple","apple", "dog",
	                                                                "cat","apple","dog","banana","apple","cat","dog"));                                                           
	    List<String> keyWords = new ArrayList<String>(Arrays.asList("banana","cat"));
	                                                  
	    SubArray subArray = smallestSubArrayContainingAllText(paragraph, keyWords);
	                                                  
	    for(int i=subArray.left ; i<=subArray.right; i++){
	      
	      System.out.print(paragraph.get(i)+" ");
	    }
	    
	  }
}
