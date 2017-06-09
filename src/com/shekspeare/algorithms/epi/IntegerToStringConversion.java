package com.shekspeare.algorithms.epi;

public class IntegerToStringConversion {

/**
 * page 96	
 * @param x
 * @return
 */
	public static String convertIntToString(int x){
		
		boolean isNeg = false;
		
		if(x<0) isNeg=true;
		
		StringBuilder sb = new StringBuilder();
		
		do{                   // do-while, because if input is 0, it wouldnt enter while loop
			
			sb.append((char) ('0'+Math.abs(x%10)));   // See explanation in book.

			x=x/10;
			
		}while (x!=0);
		
		
		if(isNeg)
			sb.append('-');
		
		sb.reverse();
		
		return sb.toString();
	}
	
	
	public static int convertStringtoInt(String str){
		
		int num =0;
		
		for(int i = str.charAt(0)=='-'?1:0; i<str.length();i++){
			int digit = str.charAt(i) - '0'; // See explanation in book. this is to remove the ASCII value of the character and only put the difference between the ASCII Values of the character and '0'
			
			num = num*10 + digit;
		}
		
		return str.charAt(0)=='-'?-num:num;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(convertIntToString(-2));
		System.out.println(convertStringtoInt("423"));

	}

}
