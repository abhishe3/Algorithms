package com.shekspeare.algorithms.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/#/description
 * @author abashok
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

   An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 *
 */

public class MinArrowsToBurstBaloons {

	public static int minArrows(int[][] points){
		
		Arrays.sort(points, new Comparator<int[]>(){	              //** PTR: Notice how the matrix is sorted by custom comparator
			@Override
			public int compare (int[] arr1, int[] arr2){
				
				if(arr1[0] == arr2[0]){                      //if x-coordinates are same, the sort by y-coordinates
					return arr1[1] - arr2[1];
				}else{
					return arr1[0] - arr2[0];
				}
			}
			
		});
		
		int minArrows = 1;
		int arrowLimit = points[0][1];                    //for first arrow, max limit is end of first balloon
		for(int i=0; i<points.length; i++){
			
			int[] balloon = points[i];
			
			if(balloon[0] < arrowLimit ){   //the max position of arrow is greater than the start of the next balloon. So it will hit
				arrowLimit = Math.min(arrowLimit, balloon[1]);
			}else{    //it will miss .. so add arrow and adjust max arrowLimit to end of this balloon
 				minArrows++;
 				arrowLimit = balloon[1];
			}
			
		}
		
		return minArrows;
		
	}
	
	
	public static void main(String[] args) {
		
		int[][] points = { {10,16}, 
						   {2,8}, 
						   {1,6},
						   {7,12}		
		};
		
		System.out.println(minArrows(points));
	}

}
