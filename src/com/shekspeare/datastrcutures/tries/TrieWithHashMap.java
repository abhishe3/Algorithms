package com.shekspeare.datastrcutures.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();  //This could also be an Array of size 26
    boolean isLeaf;
 
    public TrieNode() {}
 
    public TrieNode(char c){
        this.c = c;
    }
}

public class TrieWithHashMap {
	
	 private TrieNode root;
	 
	    public TrieWithHashMap() {
	        root = new TrieNode();
	    }
	    
	    
	    
	    // Inserts a word into the trie.
	    public void insert(String word) {
	        HashMap<Character, TrieNode> children = root.children;
	 
	        for(int i=0; i<word.length(); i++){
	            char c = word.charAt(i);
	 
	            TrieNode t;
	            if(children.containsKey(c)){
	                    t = children.get(c);
	            }else{
	                t = new TrieNode(c);
	                children.put(c, t);
	            }
	 
	            children = t.children;
	 
	            //set leaf node
	            if(i==word.length()-1)
	                t.isLeaf = true;    
	        }
	    }
	    
	 // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode t = searchNode(word);
	 
	        if(t != null && t.isLeaf) 
	            return true;
	        else
	            return false;
	    }
	 
	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        if(searchNode(prefix) == null) 
	            return false;
	        else
	            return true;
	    }
	 
	    public TrieNode searchNode(String str){
	        Map<Character, TrieNode> children = root.children; 
	        TrieNode t = null;
	        for(int i=0; i<str.length(); i++){
	            char c = str.charAt(i);
	            if(children.containsKey(c)){
	                t = children.get(c);
	                children = t.children;
	            }else{
	                return null;
	            }
	        }
	 
	        return t;
	    }
	    
	    
	    
	    
	    public List<String> getWordsList (String str){
	    	
	    	List<String> list = new ArrayList<String>();
	    	StringBuffer sb = new StringBuffer();
	    	
	    	Map<Character,TrieNode> children = root.children;
	    	
	    	for(int i=0;i<str.length();i++){
	    		
	    		char c = str.charAt(i);
	    		if(!children.containsKey(c)){
	    			return null;
	    		}
	    		
	    		TrieNode tn = children.get(c);
	    		sb.append(c);
	    		if(tn.isLeaf)
	    			list.add(new String(sb));
	    		children = tn.children;
	    	}
	    	
	    	
	    	getWordListHelper (list, sb, children);
	    	
	    	
	    	return list;
	    	
	    }
	    
	    
	    public void getWordListHelper(List<String> list,StringBuffer sb,Map<Character,TrieNode> children){
	    
	    	if(children == null) return;
	    	
	    	for(Map.Entry<Character, TrieNode> entry: children.entrySet()){
	    		
	    		TrieNode tn = entry.getValue();
	    		char c = entry.getKey();
	    		
	    		sb.append(c);
	    		if(tn.isLeaf)
	    			list.add(new String(sb));
	    		
	    		getWordListHelper(list, sb, tn.children);
	    		
	    		sb.deleteCharAt(sb.length()-1);
	    		
	    		
	    	}
	    	
	    	
	    }

	public static void main(String[] args) {
		
			TrieWithHashMap trie = new TrieWithHashMap();
			
			trie.insert("cat");
			trie.insert("catalog");
			trie.insert("catering");
			trie.insert("catmaran");
			trie.insert("cgtchy");
			trie.insert("fish");
			
			
			//System.out.println(trie.search("catering"));
			
			List<String> list = trie.getWordsList("ca");
			if(null!=list){
				for(String s : list){
					System.out.println(s);
				}
			}
			
		
	}

}
