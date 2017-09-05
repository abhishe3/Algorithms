package com.shekspeare.workshop;

public class ReverseWordsInAString {
	
	
	//method 1
	public static String reverseWords(String str){
		
		if(null==str) return null;
		
		String[] sArray = str.split(" ");
		
		for(int i=0, j=sArray.length-1;i<j;i++ , j--){
		
			String temp = sArray[i];
			sArray[i]= sArray[j];
			sArray[j] = temp;
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(String s: sArray){
			sb.append(s);
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	//method 2
	//1. Reverse the whole string
	//2. Reverse each word in that
	
	public static String reverseWordsAlt(String str){
		
		str = reverse(str, 0,str.length()-1);
		
		int start=0;
		int end =0;
		
		while(end < str.length()){
			
			while(end<str.length() && str.charAt(end)!=' '){
				end++;
			}
			
			if(start<end){
				str=reverse(str,start,end-1);
				start=end+1;
			}
			
			end++;
			
		}
		
		
		str = reverse(str,start,end-1);
		
		return str;
	}
	
	public static String reverse(String str, int start, int end){

		char[] cArray = str.toCharArray();
		while(start<end){
			
			char temp = cArray[end];
			cArray[end] = cArray[start];
			cArray[start] = temp;
			
			start++;
			end--;
		}
			
			return new String(cArray);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "hello my name is john";
		//System.out.println(reverse(s,0,s.length()-1));
		
		System.out.println(reverseWordsAlt(s));
	}

}
