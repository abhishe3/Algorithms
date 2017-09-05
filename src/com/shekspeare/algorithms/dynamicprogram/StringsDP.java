package com.shekspeare.algorithms.dynamicprogram;

public class StringsDP {
	
	
	/**Print all combinations of balanced parentheses
	 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
	 * @param n
	 */
	/* Wrapper over printParenthesis()*/
	public static void printParenthesis(int n)
	{
	  if(n > 0){
		  char[] str = new char[100];
	     printParenthesis(str, 0, n, 0, 0);
	 //return;
	  }
	} 
	
	public static void printParenthesis(char[] str, int pos, int n, int open, int close){
		if(close==n){
			System.out.println(str); //**PTR: We can print a char array like this too
			return;
		}
		
		else{
			if(open<n){     // as long as open brackets are remaining, add them to string and recurse
				str[pos] = '(';
				printParenthesis(str, pos+1, n, open+1, close);
			}
			
			if(open>close){  //as long as there are more close brackets remaining than open brackets, add them to string and recurse
				str[pos] = ')';
				printParenthesis(str, pos+1, n, open, close+1);
				
			}
		}
		
	
	}
	
	
	
	/**
	 * http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
	 * O(2^n)  : Since there are 2^n combinations
	 * @param str
	 * 
	 */
	public static void printPowerSet(char[] str){
		
		int n = str.length;
	
		// Run a loop for printing all 2^n
        // subsets one by one
		for(int i=0; i< 1<<n ; i++ ){     // (1<<n) means there is bit 1 at position n; so here it will be 1000 = 16 (2^4)
		// this is also same for(int i=0; i< Math.pow(2.0, n) ; i++ )	
			System.out.print("{ ");
			
			for(int j = 0; j <n ; j++){
				
				// (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
				
				int x = 1<<j;
				if( (i & (x)) > 0){     
					System.out.print(str[j]+" ");
				}
				
			}
			
			System.out.println(" }");	
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TEST 1
		char[] str = {'a','b','c','d'};
		printPowerSet(str);
		
		//TEST 2
	//	int n =3;
	//	printParenthesis(n);

	}

}
