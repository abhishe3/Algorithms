package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/** 102. Binary Tree Level Order Traversal
 *  https://leetcode.com/problems/binary-tree-level-order-traversal/?tab=Description
 * @author abashok
 *  Explanation : use two queues to track current level and next level
 *  Variation:   If asked to print from bottom to top, add list to the stack. In the end, iterate over stack and add to masterList.
 */

public class BinaryTreeLevelOrderArrayList {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x){
			val=x;
			left = right = null;
		}
	}
	
	public List<List<Integer>> levelOrder (TreeNode root){
		
		List<List<Integer>> masterList = new ArrayList<List<Integer>>();
		
		if(root==null) return masterList;
		
		LinkedList<TreeNode> currQ = new LinkedList<TreeNode>();  //**PTR: - WE cannot instantiate a Queue with new Queue() since Queue is an interface. So use LinkedList. 
																 // Also if adding to queue, don't use q.push() as it adds to the end of the queue. Use q.add() as it adds to the front of the queue.
		LinkedList<TreeNode> nextQ = new LinkedList<TreeNode>();  //**PTR: - However, we can instantiate a Stack with new Stack(); 
		
		
		List <Integer> list = new ArrayList<Integer>();
		currQ.add(root);
		
		while(!currQ.isEmpty()){   
			
			TreeNode node = currQ.pop();
			list.add(node.val);
			
			if(node.left!=null){
				nextQ.add(node.left);
			}
			
			if(node.right!=null){
				nextQ.add(node.right);
			}
			 
			if(currQ.isEmpty()){  //This means we are moving to next level
				currQ= nextQ;
				masterList.add(list);
				nextQ = new LinkedList<TreeNode>();
				list = new ArrayList<Integer>();
			}
			
		}
		
		
		return masterList;
		
	}
	
	public static void levelOrder_simple(TreeNode root){
		
		if(root==null) return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode node ;
		while(!q.isEmpty()){
			 node = q.poll();
			System.out.print(node.val);
			
			if(node.left!=null) q.add(node.left);
			if(node.right!=null) q.add(node.right);
			
		}		
	}
	
	//This was only coding practice
	
	public static void levelZigzagSimple(TreeNode root){
		
		if(root==null) return;
			
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();
		
		st1.push(root);
		
		TreeNode node;
		while(!st1.isEmpty() || !st2.isEmpty()){
			
			while(!st1.isEmpty()){
				node = st1.pop();
				System.out.print(node.val);	
				if(node.left!=null) st2.push(node.left);
				if(node.right!=null) st2.push(node.right);
			}
			
			System.out.println();
			
			while(!st2.isEmpty()){
				node = st2.pop();
				System.out.print(node.val);	
				if(node.right!=null) st1.push(node.right);
				if(node.left!=null) st1.push(node.left);
			}
			
			
			System.out.println();
			
			
		}
		
		
	}
	
	
	public static void levelOrder_bottom_up(TreeNode root){
		
		if(root==null) return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		Stack<Integer> st = new Stack<Integer>();
		
		TreeNode node;
		while(!q.isEmpty()){
			
			node = q.poll();
			st.push(node.val);
			if(node.left!=null){
				q.add(node.left);
			}
			if(node.right!=null){
				q.add(node.right);
			}
		}
		
		while(!st.isEmpty()){
			
			System.out.print(st.pop());
		}
		
	}
	

	
	public static void main(String[] args) {
		
		BinaryTreeLevelOrderArrayList solution = new BinaryTreeLevelOrderArrayList();
		
		TreeNode node1 = solution.new TreeNode(1);
		TreeNode node2 = solution.new TreeNode(2);
		TreeNode node3 = solution.new TreeNode(3);
		TreeNode node4 = solution.new TreeNode(4);
		TreeNode node5 = solution.new TreeNode(5);
		TreeNode node6 = solution.new TreeNode(6);
		TreeNode node7 = solution.new TreeNode(7);
		
		
		
		
		TreeNode node8 = solution.new TreeNode(8);
		TreeNode node9 = solution.new TreeNode(9);
		TreeNode node10 = solution.new TreeNode(10);
		TreeNode node11 = solution.new TreeNode(11);
		TreeNode node12 = solution.new TreeNode(12);
		TreeNode node13 = solution.new TreeNode(13);
		TreeNode node14 = solution.new TreeNode(14);
		TreeNode node15 = solution.new TreeNode(15);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node4.left = node8;
		node4.right = node9;
		
		node5.left = node10;
		node5.right = node11;
		
		node6.left = node12;
		node6.right = node13;
		
		node7.left = node14;
		node7.right = node15;

		List<List<Integer>> masterList = solution.levelOrder(node1);
		
		//**PTR: Note the syntax and use of Iterator... The iterator type is that of data type 'INSIDE' the container
		//** eg: for a List that contains <List<Integer>> , the iterator will be of type <List<Integer>>
		Iterator<List<Integer>> iter = masterList.iterator();
		
	/*	while(iter.hasNext()){
			//** eg: for a List that contains <Integer> , the iterator will be of type <Integer>
			List<Integer>list = iter.next();
			Iterator<Integer> iterator = list.iterator();
			while(iterator.hasNext()){
				System.out.print(iterator.next());
			}
			
			System.out.println();
		}*/
		
		//levelOrder_simple(node1);
		//levelZigzagSimple(node1);
		//levelOrder_bottom_up(node1);
		
		
 	}
	
	

}
