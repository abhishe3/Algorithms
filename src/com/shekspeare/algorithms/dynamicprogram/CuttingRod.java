package com.shekspeare.algorithms.dynamicprogram;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * Video : https://www.youtube.com/watch?v=IRwVmTmN6go&lc=z132ezirmpisi1td522hiphrcsqbihgyk04
 * However the code below does not use matrix. It uses single dimensional array as in geeksforgeeks link above.
 * @author abashok
 *
 */
public class CuttingRod {

	
	public static int cutRod(int[] price, int L){
		int n = price.length;
		int[] temp = new int[n+1];
		
		int max = Integer.MIN_VALUE;
		temp[0] = 0;
		
		for(int i=1;i<=L;i++){
			
			for (int j=0;j<i;j++){
				max = Math.max(max, price[j] + temp[i-j-1]);
			}
			
			temp[i] = max;
		}
		
		return temp[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                            cutRod(arr, size));

	}

}
