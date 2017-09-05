package com.shekspeare.algorithms.leetcode;

/** Two version of the question. See each function for details
 * 
 */



public class RemoveDuplicateSortedLL {
	
	class LinkNode{
		int val;
		LinkNode next;
		
		LinkNode(int x){
			val=x;
			next=null;
		}
	}
	
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/?tab=Description
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
			Given 1->1->2, return 1->2.
			Given 1->1->2->3->3, return 1->2->3.
	 * @param head
	 * @return
	 */
	public LinkNode deleteDuplicates_1(LinkNode head) {
		
		if(head==null) return null;
		
		LinkNode node = head;
		
		while(node!=null){
			
			if(node.next!=null && node.next.val==node.val){
				node.next = node.next.next;
			}
			
			
			node=node.next;
			
		}
		
		return head;
		
        
    }
	
/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?tab=Description
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only <b>distinct numbers</b> from the original list.	
 * For example,
		Given 1->2->3->3->4->4->5, return 1->2->5.
		Given 1->1->1->2->3, return 2->3.
 * @param head
 * @return
 */
public LinkNode deleteDuplicates_2(LinkNode head) {
        
        
        if(head==null) return null;
        
        //**PTR - need fakeHead here so that if main head is also duplicate, we wont lose track of it after deleting.
        //** PTR - Fake head points to the real head.
        LinkNode fakeHead = new LinkNode(-1);
        fakeHead.next = head;
        LinkNode pre = fakeHead;
        LinkNode curr = head;
        
        while(curr!=null){
            
            while(curr.next!=null && curr.val==curr.next.val){
                curr = curr.next;
            }
            
            if(pre.next == curr){
                pre=pre.next;
            }else{
                
                pre.next=curr.next;
            }
            
            curr=curr.next;
        }
        
        return fakeHead.next;
        
        
        
    }
	
	public void printLL(LinkNode head){
		
		if(head!=null){
			
			LinkNode node = head;
			
			while(node!=null){
				System.out.print(node.val+" --> ");
				node=node.next;
			}
		}
	}
	
	/**
	 * Util code to reverse a LL
	 * @param head
	 * @return
	 */
	
	public LinkNode reverseLL(LinkNode head){
		
		if(head==null) return null;
		
		if(head.next==null) return head;
		
		LinkNode curr = head;
		LinkNode next = curr.next;
		LinkNode prev = null;
		
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
	
	 private long createPalindrom(long num) {
	       String str = num + new StringBuilder().append(num).reverse().toString();
	        return Long.parseLong(str);
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateSortedLL solution = new RemoveDuplicateSortedLL();
		LinkNode nodea1 = solution.new LinkNode(1);
		LinkNode nodea2 = solution.new LinkNode(1);
		LinkNode nodea3 = solution.new LinkNode(2);
		LinkNode nodea4 = solution.new LinkNode(3);
		LinkNode nodea5 = solution.new LinkNode(3);
		LinkNode nodea6 = solution.new LinkNode(4);
		
		nodea1.next=nodea2;
		nodea2.next=nodea3;
		nodea3.next=nodea4;
		nodea4.next=nodea5;
		nodea5.next=nodea6;
		
		
	//System.out.print(solution.deleteDuplicates_1(nodea1).val);
		
		LinkNode head = solution.deleteDuplicates_1(nodea1);
		while(head!=null){
			System.out.print(head.val);
			head=head.next;
		}
		
		///solution.printLL(solution.deleteDuplicates_2(nodea1));
		
		//solution.reverseLL(nodea1);
		//solution.printLL(solution.reverseLL(nodea1));

		//System.out.print(solution.createPalindrom(999*999));
	}

}
