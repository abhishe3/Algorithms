/**
 * 
 */
package com.shekspeare.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abashok
 * Tushar Roy : https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * Time Compelxity: O(n!) becuse there are n! permuations possible. 
 * For repetition = eg AABC   4! /(2!)  = 12 combinations
 *
 */
public class PrintStringPermutations {

	
	/**
	 * @param args
	 */
	public static void permute(char[] input) {
		
		//Convert input char into HashMap with count
		Map <Character, Integer> charCountMap = new HashMap<Character, Integer>();
		
		for(char c : input){
			if(charCountMap.containsKey(c)){
				int value = charCountMap.get(c);
				charCountMap.put(c, ++value);
			}else{
				charCountMap.put(c, 1);
			}
		}
		
		int index = 0;
		char[] str = new char[charCountMap.size()];
		int[] count = new int[charCountMap.size()];
		char[] result = new char[input.length];
		
		for(Map.Entry<Character, Integer> entry: charCountMap.entrySet()){	
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		
		permuteUtil(str, count, 0, result);
		
	}
	
	public static void printArray(char[] array){
		
		System.out.println();
		for(int i = 0 ;
				i < array.length ; i++){
			System.out.print((i==0?"":",") + array[i]);
		}
	}
	
	public static void printArray(int[] array){
		
		System.out.println();
		for(int i = 0 ;
				i < array.length ; i++){
			System.out.print((i==0?"":",")+ array[i]);
		}
	}
	
	public static void permuteUtil(char[] str, int[] count, int level, char[] result){
		
		if(level==result.length){
			printArray(result);
			return;
		}
		
		
		for(int i=0; i<str.length;i++){
			
		/*	if(count[i] == 0)
				continue;*/
			if(count[i]>0){	
				result[level] = str[i];
				count[i] --;	
				permuteUtil(str, count, level+1, result);
				count[i]++;
			}
		}
		
		
	
	}
	
	
	
	//Test : Given distinct numbers in an Array, print all combinations
	
	public static void permute(int[] arr){
		
		int [] result = new int[arr.length];		
		permuteHelper (arr, result,0);
		
	}
	
	public static void permuteHelper (int[] arr, int[] result,int level){
		
		if(level==arr.length){
			printArray(result);
			return ;
		}
		
		for(int i=0;i<arr.length;i++){
			
			result[level] = arr[i];
			permuteHelper(arr,result,level+1);
			
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] input = {'A','A', 'B','C'};
		//permute(input);
		
		int[] inputArr = {2,3,5};
		permute(inputArr);

	}

}
