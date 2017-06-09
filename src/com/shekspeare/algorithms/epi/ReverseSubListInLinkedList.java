package com.shekspeare.algorithms.epi;

import java.util.ArrayList;
import java.util.List;

class Node{
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		next = null;
	}
	
}


public class ReverseSubListInLinkedList {
	
	
	/*public static Node reverseSubList(Node head, int start, int finish){
		
		Node dummyHead = new Node(0);
		dummyHead.next = head;
		
		if(start==finish) return head;
		
		int k = 1;
		Node curr = dummyHead;
		while(start++ < k){
			curr = curr.next;
		}
		
		
		while(start++<finish){
			
			
			
		}
		
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Node> LL = new ArrayList<Node>();
		
		Node head = new Node(1);
		LL.add(head);
		
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node curr = head;
		
		while(curr.next!=null){
			System.out.print(curr.data + " -->") ;
			curr = curr.next;
		}
		

	}

}
