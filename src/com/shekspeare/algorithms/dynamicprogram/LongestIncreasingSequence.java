package com.shekspeare.algorithms.dynamicprogram;

/**http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * 
 * @author abashok
 *  PTR: This has order O(n^2) ... 
 *  See O(n logn) Solution : http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 */
public class LongestIncreasingSequence {
	
	/* lis() returns the length of the longest increasing
    subsequence in arr[] of size n */
	static int lis(int arr[],int n)
    {
          int lis[] = new int[n];
          int i,j,max = 0;
 
          /* Initialize LIS values for all indexes */
           for ( i = 0; i < n; i++ )
              lis[i] = 1;
 
           /* Compute optimized LIS values in bottom up manner */
           for ( i = 1; i < n; i++ )
              for ( j = 0; j < i; j++ ) 
                        if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)   //watch video on above page to understand this lis[i] < lis[j] + 1...contd below
                        	 lis[i] = lis[j] + 1;								//basically it ensures that lis[i] is updated as max(lis[i], lis[j]+1)
           
           		//Above code is similar to :
			           /*if ( arr[i] > arr[j] ){
			     		  lis[i] = Math.max(lis[i], lis[j]+1);
			     	  } */
                   
 
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ )
              if ( max < lis[i] )
                 max = lis[i];
 
            return max;
    }
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) + "\n" );
	}

}
