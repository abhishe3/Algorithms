package com.shekspeare.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/find-the-duplicate-number/?tab=Description
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 * @author abashok
 * 
 * 
 * Explanation: This is similar to finding a loop in a linked list. Have a fast and slow runner. Once they meet, reset the fast
 * and make it move at the speed of slow. When fast and slow meet again, that is the duplicate.
 */
public class FindDuplicate {

	public static int findDuplicate(int[] nums) {

		if (nums.length > 0) {
			int slow = nums[0];
			int fast = nums[nums[0]];

			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;

			while (slow != fast) {
				fast = nums[fast];
				slow = nums[slow];
			}

			return slow;

		}

		return -1;
	}
	
	//by self
	public static int findDuplicateHash(int[] num){
		
		Set<Integer> map = new HashSet<Integer>();
		
		for(int i=0;i<num.length;i++){
			
			if (map.contains(num[i])){
				return num[i];
			}
			
			map.add(new Integer(num[i]));
		
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,5,6,4};
		System.out.println(findDuplicate(nums));
		
		System.out.print(findDuplicateHash(nums));

	}

}
