package com.shekspeare.algorithms.googlehandout;

import java.util.Random;

public class ShuffleDeckOfCards {

	/**
	 * Given  an  array  of  distinct  integers, give  an  algorithm  to  randomly  reorder  the 
integers  so  that  each  possible  reordering  is  equally  likely.  In  other  words, given  a 
deck  of  cards, how  can  you  shuffle  them  such  that  any  permutation  of  cards is  
equally  likely?


 Go through the elements in order, swapping each element with a 
random element in the array that does not appear earlier than the element.  This 
takes O(n) time
	 * @param args
	 */
	
	
	public static void shuffleCards(int[] arr){
		
		int n = arr.length;
		int min = 0; int max=0;int i;
		Random rand = new Random();
		for(i=0;i<n-2;i++){
			max = n-1;
	        min = i+1;
			swap(arr, i, rand.nextInt(max-min)+min);
			
		}
		
		swap(arr, i, n-1);
	}
	
	
	public static void swap(int[] arr, int x, int y){
		
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {5,3,4,1,9};
		shuffleCards(a);
		
		for(int x: a){
			System.out.print(x+" ");
		}

	}

}
