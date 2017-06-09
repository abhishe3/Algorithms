package com.shekspeare.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	   private Queue<Integer> q;
	   
	    /** Initialize your data structure here. */
	    public MyStack() {
	       this.q = new LinkedList<Integer>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        q.add(x);
	        int size = q.size();
	        
	        while(size>0){
	            
	            q.add(q.remove());
	            size--;
	            
	        }
	        
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	       return q.remove();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	return q.peek();
	    	
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        
	        return q.isEmpty();
	    }

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	    
	    public static void main(String[] args){
	    	
	    	  MyStack obj = new MyStack();
	    	  obj.push(1);
	    	  obj.push(2);
	    	  int param_2 = obj.pop();
	    	  int param_3 = obj.top();
	    	 boolean param_4 = obj.empty();
	    	 
	    	 System.out.print(param_2+" : "+param_3+" : "+param_4);
	    	
	    }
}
