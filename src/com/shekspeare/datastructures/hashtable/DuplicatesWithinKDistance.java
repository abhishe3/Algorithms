package com.shekspeare.datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

public class DuplicatesWithinKDistance {

	public static boolean existsDupWithinK(int[] arr,int k){
		
		if(arr==null || arr.length==0) return false;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++){
			
			if(map.containsKey(arr[i])){
				if(Math.abs(map.get(arr[i]) - i ) <=k)
					return true;
			}
				 map.put(arr[i], i);
			
		}
		
		return false;
	}
	public static void main(String[] args) {
		
		int arr[] = {1, 1};
		if (existsDupWithinK(arr, 1))
		System.out.println("Yes");
		else
		System.out.println("No");
	}

}
