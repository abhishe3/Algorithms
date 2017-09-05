package com.shekspeare.algorithms.leetcode;

public class SearchForARange {
	
	static class ArrayIndex{
        
        int start;
        int end;
        
        ArrayIndex(){
            this.start=-1;
            this.end=-1;
        }
        
        ArrayIndex(int start, int end){
            
            this.start=start;
            this.end=end;
        }
        
    }
	
public static ArrayIndex searchRange(int[] nums, int target) {
        
        ArrayIndex result = new ArrayIndex();
        int n = nums.length-1;
       searchRangeUtil(nums,target,result,0,n);
       
       return result;
    }
    
    public static void searchRangeUtil(int[] nums, int target, ArrayIndex result, int low, int high){
        
        if(low<=high){
        	
            int mid = low + (high-low)/2;        
            if(nums[mid] == target){     
                int i=mid-1; 
                while(i>=0 && nums[i]==target){
                    i--;
                }             
                    result.start = i+1;    
               
                    i=mid+1;
                
                while(i<nums.length && nums[i]==target){
                    i++;
                }
                    result.end= i-1;
 
            }
            
            else if(nums[mid] < target){
                searchRangeUtil(nums,target,result,mid+1,high);
            }else{
                  searchRangeUtil(nums,target,result,low,mid-1);
            }
            
        }
        
    
        
    }

	public static void main(String[] args) {
		 int[] nums = {5,7,8,8,10};
	        int target = 8;
	        
	        ArrayIndex result = searchRange(nums,target);
	        
	        System.out.print("Start :"+result.start+" End: "+result.end);

	}

}
