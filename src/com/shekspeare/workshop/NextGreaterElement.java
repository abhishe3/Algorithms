package com.shekspeare.workshop;


//http://www.geeksforgeeks.org/next-greater-element/
/*
 * 1) Push the first element to stack.
2) Pick rest of the elements one by one and follow following steps in loop.
….a) Mark the current element as next.
….b) If stack is not empty, then pop an element from stack and compare it with next.
….c) If next is greater than the popped element, then next is the next greater element for the popped element.
….d) Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
….g) If next is smaller than the popped element, then push the popped element back.
3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
	
	
    static class Pair{
        int x;
        int y;
        
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static List<Pair> getNextGreatestPair(int[] arr){
        
        List<Pair> list = new ArrayList<Pair>();
        
        Stack<Integer> st = new Stack<Integer>();
        /* push the first element to stack */
        st.push(arr[0]);
        int top;
        // iterate for rest of the elements
        for(int i=1;i<arr.length;i++){
            
            int next = arr[i];
            
            
            if(!st.isEmpty()){
            	// if stack is not empty, then 
                // pop an element from stack
                top = st.pop();
              
                /* If the popped element is smaller than 
                next, then a) print the pair b) keep 
                popping while elements are smaller and 
                stack is not empty */
                while(top<next){
                    list.add(new Pair(top,next));
                    if(st.isEmpty()) break;
                    top = st.pop();
                    
                }
                /* If element is greater than next, then 
                push the element back */
                if(top>next){
                    st.push(top);
                }
                
               
                
            }
            /* push next to stack so that we can find next
            greater for it */
             st.push(next);
            
        }
        
        /* After iterating over the loop, the remaining 
        elements in stack do not have the next greater 
        element, so print -1 for them */  
            while(!st.isEmpty()){
                
                top = st.pop();
                list.add(new Pair(top, -1));
            }
            
            return list;
        
    }
    
    
    public static void  main (String[] args){
        int arr[] = { 11, 13, 21, 3 };
        List<Pair> list = getNextGreatestPair(arr);
        
        for(Pair p : list){
            
            System.out.println("("+p.x+","+p.y+")");
        }
    }

}
