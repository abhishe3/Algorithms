package com.shekspeare.workshop;

/**Check if two given strings are isomorphic to each other
 * Input:  str1 = "aab", str2 = "xxy"
   Output: True
   'a' is mapped to 'x' and 'b' is mapped to 'y'.

   Input:  str1 = "aab", str2 = "xyz"
   Output: False
   One occurrence of 'a' in str1 has 'x' in str2 and 
   other occurrence of 'a' has 'y'.
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	public static boolean isIsomorphic(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		
		for(int i=0;i<s1.length();i++){
			
			if(!map.containsKey(s1.charAt(i))){ //if this character is seen first time,
				 
				if(map.containsValue(s2.charAt(i))){   //means that s2.charAt(i) is already mapped to another char. so false;
					return false;
				}
				
				map.put(s1.charAt(i),s2.charAt(i));
			}else{    //not the first time. so check if its value corresponds to s2.charAt(i)
				
				if(map.get(s1.charAt(i))!= s2.charAt(i))
					return false;
			}
			
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isIsomorphic("aaa", "xxy"));
	}

}
