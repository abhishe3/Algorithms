package com.shekspeare.datastructures.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class HashTableApplications {
/** SOURCE : EPI - Page 210
 * Write a program that takes as input, a set of words and returns a group of anagrams for those words. Each group must contain
 * at least two words :
 *  Eg if input is "debitcard","elvis", "badcredit","lives","freedom", "listen","levis" etc, the output will have 3 groups as follows:
 * (1) debitcard, badcredit
 * (2) elvis, lives, levis
 * (3) silent, listen
 * @param
 */
	public static List<List<String>> findAnagram(List<String> dictionary){
		
		List<List<String>> anagramGroups = new ArrayList<List<String>>();
		
		Map<String,List<String>> table = new HashMap<String,List<String>>();
		
		for(String s : dictionary){
			
			char[] str = s.toCharArray();
			Arrays.sort(str);
			String sortedKey = new String(str);  //**PTR : This is how you can convert an Array to String.
			if(!table.containsKey(sortedKey)){
				table.put(sortedKey, new ArrayList());
			}
			
			table.get(sortedKey).add(s);
			
		}
		
		for(Map.Entry<String, List<String>> p : table.entrySet()){  //**PTR: Observe the way a map is iterated over
			
			if(p.getValue().size()>=2){
				anagramGroups.add(p.getValue());
			}
		}
		
		return anagramGroups;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> dictionary = new ArrayList<String>();
		
		dictionary.add("debitcard");
		dictionary.add("elvis");
		dictionary.add("levis");
		dictionary.add("listen");
		dictionary.add("freedom");
		dictionary.add("badcredit");
		dictionary.add("lives");
		dictionary.add("silent");
		
		List<List<String>> result = findAnagram(dictionary);
		
		for(List<String> l : result){
			for(String s: l){
				System.out.print(s+" ");
			}
			
			System.out.println();
		}
		
	}
	

}
