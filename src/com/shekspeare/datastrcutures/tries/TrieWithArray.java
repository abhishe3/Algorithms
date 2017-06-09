package com.shekspeare.datastrcutures.tries;

import java.util.HashMap;

 class TrieNode_Arr {
	
	 TrieNode_Arr[] arr;
	    boolean isEnd;
	    // Initialize your data structure here.
	    public TrieNode_Arr() {
	        this.arr = new TrieNode_Arr[26];
	    }
}

public class TrieWithArray {
	
	
	
	 private TrieNode_Arr root;
	 
	    public TrieWithArray() {
	        root = new TrieNode_Arr();
	    }
	 
	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode_Arr p = root;
	        for(int i=0; i<word.length(); i++){
	            char c = word.charAt(i);
	            int index = c-'a';
	            if(p.arr[index]==null){
	                TrieNode_Arr temp = new TrieNode_Arr();
	                p.arr[index]=temp;
	                p = temp;
	            }else{
	                p=p.arr[index];
	            }
	        }
	        p.isEnd=true;
	    }
	 
	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode_Arr p = searchNode(word);
	        if(p==null){
	            return false;
	        }else{
	            if(p.isEnd)
	                return true;
	        }
	 
	        return false;
	    }
	 
	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode_Arr p = searchNode(prefix);
	        if(p==null){
	            return false;
	        }else{
	            return true;
	        }
	    }
	 
	    public TrieNode_Arr searchNode(String s){
	        TrieNode_Arr p = root;
	        for(int i=0; i<s.length(); i++){
	            char c= s.charAt(i);
	            int index = c-'a';
	            if(p.arr[index]!=null){
	                p = p.arr[index];
	            }else{
	                return null;
	            }
	        }
	 
	        if(p==root)
	            return null;
	 
	        return p;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
