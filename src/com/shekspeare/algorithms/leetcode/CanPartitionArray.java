// WRONG solution...

package com.shekspeare.algorithms.leetcode;

import java.util.Arrays;

public class CanPartitionArray {
	
	 public static boolean canPartition(int[] nums) {
	        
	        Arrays.sort(nums)    ;
	        
	        int low = 0;
	        int high = nums.length-1;
	        
	        int lowSum=nums[low];
	        int highSum=nums[high];
	        
	        while(low<high){
	          
	            if(lowSum<highSum){
	            	lowSum += nums[++low];
	            }
	           else if(lowSum>highSum){
	        	    highSum+= nums[--high];
	            }
	            
	           else break; 
	        }
	        
	        if(high==low){
	            return false;
	        }
	        
	        if(lowSum==highSum && high-1 == low) return true;
	        
	        while(low<high){
	            
	        	low++;
	        	high--;
	        	
	        	if(low==high) return false;
	        	
	            if(nums[low] != nums[high]) 
	                return false;
	        }
	        
	        return true;
	    
	    }
	 
	public static void main(String[] args) {
	
		int[] nums = {1,1,1,1,1};
		
		System.out.println(canPartition(nums));
	}

}
