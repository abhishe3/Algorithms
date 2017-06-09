package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/#/description
 * Given a non-empty array of integers, return the k most frequent elements.

	For example,
	Given [1,1,1,2,2,3] and k = 2, return [1,2].

	Note: 
	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @author abashok
 *
 */
public class KMostFrequentCharacters {
	
	public static List<Integer> findKMostFrequentChar(int[] nums, int k){
		
		if(nums.length == 0) return null;
		
		List<Integer> list = new ArrayList<Integer>();
		
		Map<Integer,Integer> map =  new HashMap<Integer,Integer>();
		
		//The foll is a Priority Queue (Max heap) that compares the entries in a HashMap to determine the order of storing elements in it.
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>( new Comparator <Map.Entry<Integer, Integer>>(){
			
			public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
				
				return entry2.getValue() - entry1.getValue();     //**PTR: Note it is entry2 - entry1 .. You can also put if else and return 0,1 or -1
			//	return entry1.getValue() - entry2.getValue();    //Change the order to make in Min heap . So it will show least frequent elements
				
			}
			
		});
		
		
		  for(int i=0;i<nums.length;i++){
	            
	            if(!map.containsKey(nums[i])){
	                
	                map.put(nums[i],0);
	            }else{
	                map.put(nums[i], map.get(nums[i])+1);
	            }
	        }
	        
	        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
	            
	            pq.add(entry);
	            
	            
	        }
	        
	        
	        for(int i=0;i<k;i++){
	            list.add(pq.poll().getKey());
	        }
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,2,2,2,3,3,4,4,4,5,5};
		int k = 2;
		
		List<Integer> list = findKMostFrequentChar(arr,k);
		
		for(Integer i : list){
			System.out.println(i);
		}
		
	}

}
