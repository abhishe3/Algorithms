package com.shekspeare.algorithms.sorting;


/**
 * 1) Initialize both first and second smallest as INT_MAX
        first = second = INT_MAX
   2) Loop through all the elements.
   		a) If the current element is smaller than first, then update first 
       		and second. 
   		b) Else if the current element is smaller than second then update 
    		second.
    		
 * @author abashok
 *
 */
public class FindMinandSecondMin {
	
	
	public static void findMinAndSecondMin(int[] arr){
		
		
		if(arr.length<2) return;
		
		int first,second;
		first = second = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++){
			
			if(arr[i] < first){
				second = first;
				first = arr[i];
			}else if(arr[i]<second){
				second = arr[i];
			}
			
		}
		
		
		System.out.println("Smallest element is: "+first);
		System.out.println("Second smallest element is: "+second);
	}
	
	
	
	
	public static void findMinMax(int[] arr){
		
		if(arr.length<2) return;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length;i++){
			
			if(arr[i]<min){
				min = arr[i];
			}
			
			else if(arr[i] > max){
				max = arr[i];
			}
		}
		
		System.out.println("Min is: "+min );
		System.out.println("Max is: "+max );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,2};
		//findMinAndSecondMin(arr);
		System.out.println("*******");
		findMinMax(arr);
	}

}
