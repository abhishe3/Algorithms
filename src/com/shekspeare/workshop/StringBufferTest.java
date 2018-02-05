package com.shekspeare.workshop;

public class StringBufferTest {
	
	
	
	public static String addWhiteSpace(int size){
		
		StringBuilder	sbr = new StringBuilder(size);
		
		for(int i=0;i<size;i++){
			sbr.append(" ");
		}
		
		return sbr.toString();
	}
	
	public static String getName(){
		
		return addWhiteSpace(1)+ "Hello";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			

		
		System.out.println(getName());
	}

}
