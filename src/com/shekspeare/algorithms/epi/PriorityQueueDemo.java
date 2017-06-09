package com.shekspeare.algorithms.epi;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(5);
		pq.add(7);
		pq.add(2);
		pq.add(9);
		
		 Iterator<Integer> itr = pq.iterator();
	        while (itr.hasNext())
	            System.out.println(itr.next());
	        
	        pq.poll();
	        pq.poll();
	        System.out.println("**&&*&*&");
	        
	        Iterator<Integer> iter = pq.iterator();
	        while (iter.hasNext())
	            System.out.println(iter.next());
	        
	        
	        Iterator<Integer> iter1 = pq.iterator();
	        while (iter1.hasNext())
	            System.out.println(iter1.next());

	}

}
