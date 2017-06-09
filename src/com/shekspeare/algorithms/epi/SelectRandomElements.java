package com.shekspeare.algorithms.epi;

/** Page 78 - Given an array and size k, select a random sample of size k
 * Same as shuffling of cards question
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SelectRandomElements {

	public static void randomSampling(List<Integer> A, int k){
		
		Random random = new Random();
		if(k==0) return;
		
	
		for(int i=0; i<k ; i++){			
			
			Collections.swap(A, i, i+random.nextInt(A.size()-i));
			
		}
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> A = new ArrayList<Integer>();
		
		for(int i=0 ; i <=10; i++){
			A.add(0, new Integer(i));
		}
		
		int k =5;
		
		for(int j=0;j<10;j++){
			randomSampling(A, k);
			
			for(Integer i : A){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
		
	}

}
