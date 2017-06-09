package com.shekspeare.algorithms.leetcode;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/?tab=Description
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Do it in O(n) time and O(1) space
 * 
 * @author abashok
 * Explanation:  Use slow and fast pointers to get to the midpoint. Reverse the second half and return the new head.
 * Now start from original head for the first half of LL and start with newHead for second half to see if each node is same.
 */

public class PalindromeLL {
	
	class ListNode{
		int val;
		ListNode next;
		
		ListNode(int x){
			val=x;
			next=null;
		}
	}
	
	
    public boolean isPalindrome(ListNode head) {
        
        if(head==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode newHead;
        
        while(fast!=null && fast.next!=null){ //**PTR - Remember to check both fast and fast.next for null (for even-odd no. of elements in LL)
            slow = slow.next;
            fast = fast.next.next;
        }
        
         newHead = reverseLL(slow); 
         
        while(newHead!=null){
            
            if(head.val!=newHead.val){
                return false;
            }
            
            head = head.next;
            newHead = newHead.next;
        }
        
        return true;
    }
    
    
    public ListNode reverseLL(ListNode head){
        
        if(head==null) return null;
		
		if(head.next==null) return head;
		
		ListNode curr = head;
		ListNode next = curr.next;
		ListNode prev = null;
		
		while(next!=null){
			
			curr.next = prev;
			prev = curr;
			curr = next;
			next=next.next;
		}
		
		curr.next = prev;
		
		head = curr;
		return head;
    }
    
    
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null || head.next.next==null) return;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode st1 = head;
        ListNode st2 = head.next;
        
        ListNode end1=head.next;
        ListNode end2= head;
        //search for end1 and end 2
        
        while(end1.next!=null){
            end2=end1;
            end1 = end1.next;
        }
        
        while(st1.next!=null){
            
            end1.next = st2;
            end2.next = null;
            
            st1.next = end1;
            
            st1 = end1.next;
            st2 = st1.next;
            end2 = null;
            
            while(end1.next!=null){
            end2=end1;
            end1 = end1.next;
           }
            
            
        }
        
           
       }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PalindromeLL solution = new PalindromeLL();
		ListNode nodea1 = solution.new ListNode(1);
		ListNode nodea2 = solution.new ListNode(2);
		ListNode nodea3 = solution.new ListNode(3);
		ListNode nodea4 = solution.new ListNode(4);
		ListNode nodea5 = solution.new ListNode(5);
		//ListNode nodea6 = solution.new ListNode(1);
		
		nodea1.next=nodea2;
		nodea2.next=nodea3;
		nodea3.next=nodea4;
		nodea4.next=nodea5;
		//nodea5.next=nodea6;
		
		//System.out.println(solution.isPalindrome(nodea1));
		//System.out.println(solution.isPalindrome(nodea1));
		
		solution.reorderList(nodea1);
		
		ListNode curr = nodea1;
		while(curr!=null){
			System.out.print(curr.val+" ");
			curr = curr.next;
		}
	}

}
