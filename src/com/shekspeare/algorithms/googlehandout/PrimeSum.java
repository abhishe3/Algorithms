package com.shekspeare.algorithms.googlehandout;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

/** Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * Example:


Input : 4
Output: 2 + 2 = 4


Solution: 
 //generate prime numbers from 1 to n   
//Add these prime numbers to a set
 //if the set contains n-i, add i and n-i to the result and return
// itereate thru set. if it contains  n-i, add i and n-i to the result and return
 * @author abashok
 *
 */

public class PrimeSum {

	
	 public static ArrayList<Integer> primesum(int a) {
	        
	        if(a<=2) return null;
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        Set<Integer> set = new HashSet<Integer>();
	         
	        //generate prime numbers from 1 to a                         
	        boolean[] isPrime = new boolean[a+1];
	        Arrays.fill(isPrime, true);									  //**PTR: Notice how the array is being filled . Similar to Collections.nCopies
	      
	        //Add all prime numbers to a set	
	        for(int i=2;i<isPrime.length;i++){							 //**PTR: This is one way to generate prime numbers upto n (called Sieving)
	            
	            if(isPrime[i]){
	                
	                for(int j=i+i; j<isPrime.length;j=j+i){
	                    isPrime[j] = false;
	                }
	                
	                set.add(i);
	                
	            }
	            
	        }
	        
	        //if the set contains n-i, add i and n-i to the result and return
	        for(int i=2;i<=a; i++){
	            if(set.contains(a-i)){
	                result.add(i);
	                result.add(a-i);
	                return result;
	            }
	            
	            
	        }
	        
	        return result;
	        
	    }
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ArrayList<Integer> result = primesum(17);
		 
		 for(Integer i: result){
			 System.out.print(i+ " ");
		 }
	}

}
