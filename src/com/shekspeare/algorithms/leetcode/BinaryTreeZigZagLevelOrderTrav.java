package com.shekspeare.algorithms.leetcode;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;



public class BinaryTreeZigZagLevelOrderTrav {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> masterList = new ArrayList<List<Integer>>();

		if (root == null)
			return masterList;
		
		
		//Use two stacks. New Stack for each level
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();

		st1.push(root);

		while (!st1.isEmpty() || !st2.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			
			while (!st1.isEmpty()) {
				TreeNode node = st1.pop();
				list.add(node.val);	
				//push left child first so that right child is popped first
				if (node.left != null)
					st2.push(node.left);

				if (node.right != null)
					st2.push(node.right);
			}
			
			if (!list.isEmpty()) {    //**PTR: Ensure that list is not empty before adding to master list.
				masterList.add(list);  
			}
			
			list = new ArrayList<Integer>();

			while (!st2.isEmpty()) {
				TreeNode node = st2.pop();
				list.add(node.val);
				// push right child first so that left child is popped first
				if (node.right != null)
					st1.push(node.right);
				if (node.left != null)
					st1.push(node.left);
			}

			if (!list.isEmpty()) {
				masterList.add(list);  
			}
		}

		return masterList;
	}

	public static void main(String[] args) {
		BinaryTreeZigZagLevelOrderTrav solution = new BinaryTreeZigZagLevelOrderTrav();
		
		TreeNode node1 = solution.new TreeNode(1);
		TreeNode node2 = solution.new TreeNode(2);
		TreeNode node3 = solution.new TreeNode(3);
		TreeNode node4 = solution.new TreeNode(4);
		TreeNode node5 = solution.new TreeNode(5);
		TreeNode node6 = solution.new TreeNode(6);
		TreeNode node7 = solution.new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		

		List<List<Integer>> masterList = solution.zigzagLevelOrder(node1);
		
		Iterator<List<Integer>> iter = masterList.iterator();  
		
		while(iter.hasNext()){
			
			Iterator <Integer> integerIter = iter.next().iterator();
			while(integerIter.hasNext()){
				System.out.print(integerIter.next());
			}
			
			System.out.println();
		}
		
	}
	


}
