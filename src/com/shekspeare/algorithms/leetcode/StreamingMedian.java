package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class StreamingMedian {
	
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());  //**PTR: this is how to make a max heap by default
	
	public static int calculateStreamingMedian(List<Integer> stream){
		
		if(stream==null) return -1;
		int median = -1;
		
		maxHeap.add(stream.get(0));
		for(int i=1;i<stream.size();i++){
			
			//before adding to heap, calculate current median
			median = getMedian(minHeap, maxHeap);
			
			//add to correct heap
			int num = stream.get(i);
			if(num < median){ //incoming num is < than median...add to max heap (PTR- it is opposite)
				maxHeap.offer(num);
			}else{
				minHeap.offer(num);
			}
			
			//rebalance if any queue is greater than the other by more than 1 element
			if(minHeap.size()-maxHeap.size()>1){
				maxHeap.offer(minHeap.poll());
			}else if(maxHeap.size()-minHeap.size()>1){
				minHeap.offer(maxHeap.poll());
			}
		}
		
		return getMedian(minHeap,maxHeap);
	}
	
	static int getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
		
		int median = -1;
		
		
		if(minHeap.size()>maxHeap.size()){
			median=minHeap.peek();
		}else if(maxHeap.size()>minHeap.size()){
			median = maxHeap.peek();
		}else{   //both are equal.. take average of top
			median = (maxHeap.peek() + minHeap.peek()) /2;
		}
		
		return median;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> stream = new ArrayList<Integer>(Arrays.asList(1,15,20,4,9,50,45,40,25));  //PTR: Notice how ArrayList is initialized as Array
		System.out.println(calculateStreamingMedian(stream));
		
	}

}
