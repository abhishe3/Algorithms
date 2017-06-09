package com.shekspeare.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**https://leetcode.com/problems/word-pattern/#/description
 * 
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 * @author abashok
 *
 */
public class WordPattern {
	
public static boolean wordPattern(String pattern, String str) {
        
        if(pattern==null || str==null) return true;
        
        
        char[] pat = pattern.toCharArray();
        String[] strings = str.split(" ");
        
        if(pat.length != strings.length) return false;
        
        Map<Character, String> map = new HashMap<Character, String>();
        
        for(int i=0; i<pat.length;i++){
            
            if(map.containsKey(pat[i])){
                
                if(!map.get(pat[i]).equals(strings[i]))     //**PTR: Always use .equals to compare two strings
                    return false;
            }else{
                
                if(map.containsValue(strings[i]))       //**PTR: map.containsValue() is also useful
                    return false;
                    
                map.put(pat[i],strings[i]);    
            }
            
            
        }
        
        return true;
        
        
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordPattern("abba","dog cat cat dog"));
	}

}
