package com.shekspeare.algorithms.interesting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterestingUtils {
	
	//util function to create palindrome 
	//Note the use of String builder
    private long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }
    
    
    public static boolean sumExists(int[] a, int sum){
    	
    	if(a==null || a.length==0){
    		return false;
    	}
    	Set<Integer> map = new HashSet<Integer>();   	
    	for(int i=0;i<a.length;i++){
    		
    		if(map.contains(sum-a[i])) return true;
    		else map.add(a[i]);
    		
    	}
    	
    	return false;
    	
    }
    
    //Also called AtoI (ASCII to Integer) function
    public static int convertStringToInteger(String str){
    	
    	int sum=0;
    	boolean isNeg = str.charAt(0)=='-'?true:false;
    	int i =0;
    	if(isNeg)
    		i=1;
    	for(;i<str.length();i++){
    		
    		sum = sum*10 +  Character.getNumericValue(str.charAt(i));    //**PTR - just getting (int) str.charAt(i) will get its ASCII value. not what we want here. 
    		
    	}
    	
    	if(isNeg) sum = sum*-1;
    	
    	return sum;
    }
    
    
    public static String reverseWords(String str){
    	
    	String[] arr = str.split(" ");

    	StringBuilder sBuilder = new StringBuilder();
    	
    	for(int i=arr.length-1; i>=0;i--){
    		
    		sBuilder.append(arr[i]).append(" ");
    		
    	}
    	
    	return sBuilder.toString();
    }
    
    
    
    public static String reverseWords_1(String str){
    	
    	if(str==null || str.length()==0) return str;
    	
    	char[] ch = str.toCharArray();
    	int n = str.length()-1;
    	char temp = ' ';
    	for(int i=0;i<=(n)/2;i++){
    		
    		temp = ch[i];
    		ch[i] = ch[n-i];
    		ch[n-i] = temp;
    	}
    	
    	int begin = 0,end = 1;
    	while(end<=n){
    		
    		while(end<=n && ch[end]!=' '){
    			end++;
    		}
    		
    		reversewordsUtil(ch,begin,end);
    		begin = end+1;
    		end = begin+1;
    	}
    	
    	reversewordsUtil(ch, begin, n);
    	
    	return new String(ch);
    }
    
    public static void reversewordsUtil(char[] ch, int begin, int end){
    	
    	int n = (begin + end)/2;
    	while(begin<end){
    		
    		char temp = ch[begin];
    		ch[begin] = ch[end-1];
    		ch[end-1] = temp;
    		begin++;
    		end--;
    	}
    	
    	
    }

    
/*START This section is to find the kth Smallest Element in an Array using Quick sort as basis */
    // INCORRECT SOLUTION yet...do not follow... Use minheap sol for now
	static int kthSmallest(int[] arr, int k){
		return kthSmallest(arr, 0, arr.length-1, k);
	}
	
	static int kthSmallest(int[] arr, int left, int right, int k){
		
		int index = partition(arr, left, right);
		
		
		if (index== k) return arr[index-1];
		if(index>k)  //sort left half
			return kthSmallest(arr, left ,index-1,k);
		
		
		else
			return kthSmallest(arr, index ,right,k);
		
	}
	
	static int partition(int[] arr, int left, int right){
		
		int pivot = arr[(left+right)/2]; //pick pivot point
		while(left<=right){
			//Find element on left that should be on right
			while(arr[left]< pivot) left++;
			
			//Find element on right that should be on left
			while(arr[right]> pivot) right--;
			
			//swap elements and move left and right indices
			
			if(left<=right){
				swap(arr,left, right);
				left++;
				right--;
			}
		}
		
		return left;
	}
	//Generic function to swap two elements in an array
	static void swap (int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
/* END*/
	

    

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a =  {100,300,500,7,600,1,900 };
	//	System.out.print(sumExists(a, 35));
		
		//System.out.println(convertStringToInteger("1234"));
		//System.out.println(reverseWords_1("My name is Johns"));
		System.out.println(kthSmallest(a,5));
	
	}

}
