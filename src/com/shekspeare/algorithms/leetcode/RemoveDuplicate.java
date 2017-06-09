package com.shekspeare.algorithms.leetcode;

/** https://leetcode.com/problems/remove-duplicates-from-sorted-array/?tab=Description
 * 
 * Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * @author abashok
 *
 * Explanation: Have two pointers one(j) ahead of the other (i). 
 * 		If nums[i] == num[j]   there is a duplicate..hold on to i..just increment j  
 * 		if nums[i] !=num[j]    there is no duplicate, so increment i as well and copy num[j] into num[i]
 */
public class RemoveDuplicate {
	
	 public static int removeDuplicates(int[] nums) {
		 
	        if(nums.length==0) return 0;
	        
	        int i=0;
	        int n = nums.length;
	        for(int j=1; j <n; j++){
	            
	            if (nums[i]!=nums[j]){
	                i++;
	                nums[i] = nums[j];    //this may seem redundant till you replace the duplicate with the new value in the higher index(j). 
	            }
	        }
	        
	        return i+1;
	        
	        
	    }
	 
	 
	 /**Similar problem : Remove all occurrences of given element
	  * https://leetcode.com/problems/remove-element/?tab=Description
	  * Given an array and a value, remove all instances of that value in place and return the new length.
	  * @param args
	  */
	 
	    public static int removeElement(int[] nums, int val) {
	        
	        int i=0;
	        int n = nums.length;
	        for(int j=0; j<n ; j++){
	            
	            if(nums[j] != val){
	                nums[i] = nums[j];
	                i++;                     //increment i after copying.. unlike above
	            }
	        }
	        
	        return i;
	        
	    }
	 

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,3,4};
		
		System.out.println(removeDuplicates(nums));
		
		int[] nums_new = new int[]{4,2,4,1,1};
		System.out.println(removeElement(nums_new,4));
		

	}

}
