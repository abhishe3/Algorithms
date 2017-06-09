package com.shekspeare.workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPalindromePairs {

	
	public static List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> ret = new ArrayList<>(); 
	    if (words == null || words.length < 2) return ret;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i<words.length; i++) map.put(words[i], i);
	    for (int i=0; i<words.length; i++) {
	        // System.out.println(words[i]);
	        for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);
	            if (isPalindrome(str1)) {
	                String str2rvs = new StringBuilder(str2).reverse().toString();
	                if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(map.get(str2rvs));
	                    list.add(i);
	                    ret.add(list);
	                    // System.out.printf("isPal(str1): %s\n", list.toString());
	                }
	            }
	            if (isPalindrome(str2)) {
	                String str1rvs = new StringBuilder(str1).reverse().toString();
	                // check "str.length() != 0" to avoid duplicates
	                if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(i);
	                    list.add(map.get(str1rvs));
	                    ret.add(list);
	                    // System.out.printf("isPal(str2): %s\n", list.toString());
	                }
	            }
	        }
	    }
	    return ret;
	}
	
	
public static boolean isPalindrome(String str){
        
        
        if(str==null || str.length()==0) return true;
        
        str = str.toLowerCase();
        
        int n= str.length();
        int j = n-1;
        
        for(int i=0;i<n/2;i++,j--){
            
            if(str.charAt(i) == str.charAt(j))
                continue;
            
            
            else return false;
        }
        
        return true;
        
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"abcd","dcba","lls","s","sssll"};
		
		 List<List<Integer>> list = palindromePairs(arr);
		 

			 
			 System.out.println(list);

	}

}
