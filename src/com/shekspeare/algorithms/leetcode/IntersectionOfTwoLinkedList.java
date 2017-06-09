package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/?tab=Description
 * 
 * @author abashok
 * 
 * Explanation: Maintain two pointers nodeA and nodeB. Move them one step at a time till one reaches tail. If nodeA reaches tail first, point it to headB
 * and if nodeB reaches tail first, point it to headA. Then continue till the other reaches tail. At this point, the first one will be at point of intersection.
 * If there is no intersection, both will be null.
 * 
 * 
 * OR 
 * 
 * I found most solutions here preprocess linkedlists to get the difference in len.
Actually we don't care about the "value" of difference, we just want to make sure two pointers reach 
the intersection node at the same time.

We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist
after it reaches the tail node. 
In the second iteration, we will move two pointers until they points to the same node. Our operations in first iteration will help us 
counteract the difference. So if two linkedlist intersects, the meeting point in 
second iteration must be the intersection point. If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null
 *
 *
 */
public class IntersectionOfTwoLinkedList {

	public class LinkNode{
		int x;
		LinkNode next;
		
		LinkNode(int val){
		   x=val;
		   next=null;
		}
		
		LinkNode(){
			
		}
	}
	
	public LinkNode findIntersection(LinkNode headA, LinkNode headB){
		
		if(headA == null || headB == null) return null;
        
		LinkNode nodeA = headA;
		LinkNode nodeB = headB;
               
		while(nodeA!=nodeB){
			nodeA = nodeA==null?headB:nodeA.next;
	        nodeB = nodeB==null?headA:nodeB.next;
		}
		
		return nodeA;
		
	}
	
	public static void main(String[] args) {
	
		IntersectionOfTwoLinkedList solution = new IntersectionOfTwoLinkedList();
		LinkNode nodea1 = solution.new LinkNode(1);
		LinkNode nodea2 = solution.new LinkNode(2);
		LinkNode nodea3 = solution.new LinkNode(3);
		LinkNode nodec1 = solution.new LinkNode(31);
		LinkNode nodec2 = solution.new LinkNode(32);
		LinkNode nodec3 = solution.new LinkNode(33);
		
		LinkNode nodeb1 = solution.new LinkNode(21);
		LinkNode nodeb2 = solution.new LinkNode(22);
		LinkNode nodeb3 = solution.new LinkNode(23);
		LinkNode nodeb4 = solution.new LinkNode(24);

		
		nodea1.next = nodea2;
		nodea2.next = nodea3;
		nodea3.next = nodec1;
		nodec1.next = nodec2;
		nodec2.next = nodec3;
		
		nodeb1.next = nodeb2;
		nodeb2.next = nodeb3;
		nodeb3.next = nodeb4;
		nodeb4.next = nodec1;
		
		System.out.println((solution.findIntersection(nodea1, nodeb1).x));
		
		
	}

}
