package com.shekspeare.workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapPractise {

	
	public static List<Integer> sortTimeStamps(List<List<Integer>> unsortedTimes){
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				return Integer.compare(i1, i2);
			}
		});
		
		for(List<Integer> list : unsortedTimes){
			
			for(Integer i: list){
				minHeap.add(i);
			}
			
		}
		
		List<Integer> output = new ArrayList<Integer>();
		
		while(!minHeap.isEmpty()){
			output.add(minHeap.poll());
		}
		
		return output;
	}
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>(Arrays.asList(100,150,200));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(110,120,130,140,150,160,170,180,190));
		List<Integer> list3 = new ArrayList<>(Arrays.asList(125,155,175));
		
		List<List<Integer>> input = new ArrayList<List<Integer>>(Arrays.asList(list1,list2,list3));
		
		List<Integer> output = sortTimeStamps(input);
		
		for(Integer i : output){
			System.out.print(i+", ");
		}

	}

}
