package com.shekspeare.algorithms.dynamicprogram;

public class MinEditDistance {
	/**
	 * // A Dynamic Programming based Java program to find minimum number operations to convert str1 to str2
	 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
	 * Video: Tushar Roy - https://www.youtube.com/watch?v=We3YDTzNXEk
	 * @param str1
	 * @param str2
	 * @return                
	 *                        
	 * Summary:  if(same) copy top-left diagonal ;
	 * 			 if(!same) 1+ min(left, top-left diagonal, top)  
	 */
	public static int minEditDistance(String str1, String str2){
		
		char[]s1 = str1.toCharArray();
		char[]s2 = str2.toCharArray();
		
		int[][]temp = new int[s1.length+1][s2.length+1];  //**PTR -  The matrix has one extra row and column
		
		for(int i=0;i<temp[0].length;i++){   //**PTR -Initializing the first row as 0,1,2, etc
			temp[0][i] = i;
		}
		
		for(int j=0;j<temp.length;j++){     //**PTR -Initializing the first col as 0,1,2, etc
			temp[j][0] = j;
		}
		
		for(int i=1;i<temp.length;i++){
			for(int j=1;j<temp[0].length;j++){
				
				if(s1[i-1]==s2[j-1]) {
					temp[i][j] = temp[i-1][j-1];  //if they are same, copy the upper left diagonal value here
				}else{
					temp[i][j] = 1+Math.min(temp[i-1][j-1], Math.min(temp[i-1][j],temp[i][j-1]));  // if they are different, take 1+  min(left, upper diagonal left, top) 
				}
			}
		}
		
		printActualEdits(temp,s1,s2);
		
		return temp[s1.length][s2.length];    // print the value of last row , last col
	}
	
	

	
	//print the actual edits
	public static void printActualEdits(int temp[][], char[] s1, char[] s2){
		
		 int i = temp.length - 1;
	     int j = temp[0].length - 1;
	     
	     while(true){
	    	 
	    	 if(i==0 || j==0) break;
	    	 
	    	 if (s1[i-1] == s2[j-1]) {   //if they are same; do nothing, go up diagonal
	                i = i-1;
	                j = j-1;
	            } else if (temp[i][j] == temp[i-1][j-1] + 1){  //if it is diagonal + 1; then Edited ; go diagonal (i-1, j-1)
	                System.out.println("Edit " + s2[j-1] + " in string2 to " + s1[i-1] + " in string1");
	                i = i-1;
	                j = j-1;
	            } else if (temp[i][j] == temp[i-1][j] + 1) {   //if it is top + 1; then deleted in String1 ; go top (only i-1)
	                System.out.println("Delete in string1 " + s1[i-1]);
	                i = i-1;
	            } else if (temp[i][j] == temp[i][j-1] + 1){    //if it is left + 1; then deleted in String2; go left (only j-1)
	                System.out.println("Delete in string2 " + s2[j-1]);
	                j = j -1;
	            } else {
	                throw new IllegalArgumentException("Something wrong with given data");
	            }
	     }
	     
	}

	public static void main(String[] args) {
		    String str1 = "sunday";
	        String str2 = "saturday";
	
	        int result = minEditDistance(str1, str2);
	        System.out.print(result);
	        

	        

	}

}
