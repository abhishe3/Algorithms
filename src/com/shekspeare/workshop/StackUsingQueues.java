package com.shekspeare.workshop;

/** Implement stack using two queues
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	Queue<Integer> q1 ;
	Queue<Integer> q2;
	
	public StackUsingQueues() {

		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int x){
		
		this.q1.add(x);
		
	}
	
	
	public int pop(){
		
		if(q1.isEmpty()) throw new IndexOutOfBoundsException("Queue is Empty");
		
		int n= q1.size();
		
		while(n>1){
			q2.add(q1.poll());
			n--;
		}
		
		
		int top = q1.poll();
		
		Queue<Integer> temp = q2;    //swap q1 with q2 rather than pushing all the remaining elements from q2 back to q1;
		q2=q1;
		q1=temp;
		
		return top;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackUsingQueues st = new StackUsingQueues();
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());

	}

}
