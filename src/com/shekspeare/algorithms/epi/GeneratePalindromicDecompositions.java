package com.shekspeare.algorithms.epi;

import java.util.ArrayList;
import java.util.List;


/** EPI Q 16.7 Page 298 (Recursion)
 * 
 * @author abashok
 *
 */

public class GeneratePalindromicDecompositions {

	
	public static List<List<String>> palindromicDecompisitions(String str){
		
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> partialResults = new ArrayList<String>();
		
		palindromicDecompisitionsHelper(str,0,partialResults,result);
		
		
		return result;
	}
	
	public static void palindromicDecompisitionsHelper(String str, int offset,List<String> partialResults, List<List<String>> result){
		
		if(offset==str.length()){
			result.add(new ArrayList<String>(partialResults));
			return;
		}
		
		for(int i=offset+1; i<=str.length();i++){
			
			String prefix = str.substring(offset, i);
			if(isPalindrome(prefix)){
				partialResults.add(prefix);
				palindromicDecompisitionsHelper(str,i,partialResults,result);
				partialResults.remove(partialResults.size()-1);
			}
		}
		
	}
	
	public static boolean isPalindrome(String str){
		
		int i=0;
		int j= str.length()-1;
		
		while(i<j){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		
		String str = new String ("0204451881") ;// ("0204451881") ; // ; 
		List<List<String>> result =palindromicDecompisitions(str);
		
		
		for(List<String> list : result){
			
			for(String s : list){
				System.out.println(s);
			}
			System.out.println("*****************");
			
		}
	}

}
