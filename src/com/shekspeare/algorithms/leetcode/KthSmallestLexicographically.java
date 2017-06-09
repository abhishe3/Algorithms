package com.shekspeare.algorithms.leetcode;

import java.util.PriorityQueue;

/**
 *  check in leetcode.. This soln does nor work.. cos the comparator does not work well
 */
import java.util.Comparator;

public class KthSmallestLexicographically {
	
	 public static int findKthNumber(int n, int k) {
	        
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
			 
			 @Override
             public int compare(Integer i1, Integer i2){
                /* StringBuffer sb1 = new StringBuffer();
                 sb1.append(i1);
                 
                 StringBuffer sb2 = new StringBuffer();
                 sb1.append(i2);*/
				 
				 String s1 = i1+"";
				 String s2 = i2+"";
                 
                 return (s1.compareTo(s2));
             }
         }
 );
	        
	        for(int i=0;i<5;i++){
	            
	            pq.add(new Integer(i));
	        }

	        
	        for(int i=1;i<k;i++){
	            pq.poll();
	        }
	        
	        return pq.poll();
	        
	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =13;
		int k =2;
		
        
        
//        String s1 = 12+"";
//        String s2 = 2+"";
//        String s3 = 13+"";
//        
//        System.out.print(s2.compareTo(s3));
		
		System.out.print(findKthNumber(n,k));
		
	}

}
