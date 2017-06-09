package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ThreeSumClosest {
	// WRONG Solution....Dont follow
    public static int threeSumClosest(int[] nums, int target) {
        int diff=0;
        int three_sum = 0;
        int n = nums.length;
        if(n==3) return getSum(nums);
        
        int start =0;
        int end = start+2;
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
       
        while(start<=n){
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i=start;i<=end;i++){
        		if(i>n) {i=0;}
        		list.add(nums[i]);
        	}
        	
        	set.add(list);
        	start++;
        	end = (end==n)?0:end;
        }
        
        Iterator<List<Integer>> iterator = set.iterator();
        
        while(iterator.hasNext()){
        	
        	Iterator<Integer> iter = iterator.next().iterator();
        	int sum=0;
        	while(iter.hasNext()){
        		sum+=iter.next();
        	}
        int	curr_diff = sum-target;
        	if(Math.abs(curr_diff)<diff){
        		diff= curr_diff;
        		three_sum=sum;
        	}
        }
        
        Arrays.sort(nums);
        
        return three_sum;
    }
    
    public static int getSum(int[] nums){
    	int sum=0;
    	for(int i=0;i<nums.length;i++){
    		sum+=nums[i];
    	}
    	
    	return sum;
    }
    
    public static boolean isHappy(int n) {
        
        if(n==0) return false;
        if(n==1) return true;
        
        Set<Integer> set = new HashSet<Integer>();
        int sum=0;  
        
        while(true){
           int y =n;
           sum=0;
            while(y>0){
                int x = y%10;
                sum+=(x*x);
                y=y/10;        
            }
            
            if(sum==1) return true;
            if(set.contains(sum)){
                return false;
            }
            
            set.add(sum);
            n=sum;
            
        
        }
        

   
    }
    
    
 public static int addDigits(int num) {
        
        if(num/10==0) return num;
        
        int sum=0;
        
        while(true){
            int y =num;
            sum=0;
            while(y>0){
                int x= y%10;
                sum+=x;
                y=y/10;
            }
            
            int f = (int) Math.pow(5, 1);
            if(sum<10) return sum;
            num=sum;
            
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 15, 10};
		String str="";
	
	//	System.out.println(isHappy(19));
		System.out.println(addDigits(1457));

	}

}
