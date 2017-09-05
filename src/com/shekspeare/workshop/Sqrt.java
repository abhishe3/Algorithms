package com.shekspeare.workshop;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find sqrt of a num
 * 1) Start with 'start' = 0, end = 'x',
   2) Do following while 'start' is smaller than or equal to 'end'.
      a) Compute 'mid' as (start + end)/2
      b) compare mid*mid with x.
      c) If x is equal to mid*mid, return mid.
      d) If x is greater, do binary search between mid+1 and end. In this case, we also update result (Note that we need floor).
      e) If x is smaller, do binary search between start and mid-1
 * 
 * @author abashok
 *
 */
public class Sqrt {
	
	public static Set<Integer> map = new HashSet<Integer>();
	
	static{                                          //**PTR: this is only to show that we can initialize static objects in a static block.
		map.add(1);
	}
	
	public static int sqrt(int num){
		
		if(num==1 || num==0) return num;
		
		int start =1; int end =num;int mid=0;
		int result=0 ;
		
		while(start<=end){
			
			 mid = (start + end )/2;
			
			if(mid*mid==num) return mid;
			
			if(mid*mid<num){
				start = mid+1;
				result= mid;
			}
			
			else{
				end = mid-1;
				
			}
			
			
		}
		
		return result;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(11));
	}

}
