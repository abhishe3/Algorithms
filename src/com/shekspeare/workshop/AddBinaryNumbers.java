package com.shekspeare.workshop;

public class AddBinaryNumbers {

	public static int[] addBinary(String s1, String s2){
		
		int[] res;
		int diff = s1.length()-s2.length();
		if((diff)>0){
			s2= new String (padZeroes(s2,diff));
			res = new int[s1.length()+1];
		}else if(diff<0){
			s1 = new String (padZeroes(s1,-diff));
			res = new int[s2.length()+1];
		}else{
			res = new int[s1.length()+1];
		}
		
		int carry =0;
		for(int i=res.length-1 ; i>0;i--){
			
			int r = (s1.charAt(i-1) - '0') +  (s2.charAt(i-1) - '0') + carry;
			
			if(r>2){ 
				carry =1;
				res[i] = 1;
			}else if(r==2){
				carry =1;
				res[i] = 0;
			}else{
				carry = 0;
				res[i] = r;
			}
			
		}
		
		if(carry==1){
			res[0] = 1;
		}
		
		return res;
		
	}

	
	public static String padZeroes(String s, int diff){
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<diff;i++){
			sb.append("0");
		}
		
		sb.append(s);
		
		return sb.toString();
		
	}
	
	
	public static void main(String[] args){
		
		int[] res = addBinary("000111","111");
		
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]);
		}
	}
}
