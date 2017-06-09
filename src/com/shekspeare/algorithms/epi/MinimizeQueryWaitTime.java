package com.shekspeare.algorithms.epi;

import java.util.Arrays;

/**
 * Page 340 : DP
 * Given an array of service times for different SQL queries, find the minimum wait time
 * The time a query waits before its turn is called wait time.
 * @author abashok
 *
 */

public class MinimizeQueryWaitTime {

	public static int minimizeWaitTime(int[] arr){
	
		Arrays.sort(arr);  //its best to sort and start with the least service time first.
		
		int n = arr.length;
		int time =0;
		int[] totalTime = new int[n];
		totalTime[0] = 0;
		for(int i=1;i<n;i++){
			
			totalTime[i] = totalTime[i-1] + arr[i-1];
		}
		
		for(int i=0; i<n;i++){
			time+= totalTime[i];
		}
		
		return time;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,2,1,3};
		
		System.out.println(minimizeWaitTime(arr));
		
	}

}
