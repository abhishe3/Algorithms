package com.shekspeare.algorithms.leetcode;

import java.util.Vector;

import com.shekspeare.algorithms.leetcode.BinaryTreePathSum.TreeNode;

public class BalancedBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}
	
	public void preOrder(TreeNode node , Vector<TreeNode> arr){
		
		if(node==null) return;
		
		preOrder(node.left, arr);
		arr.add(node);
		preOrder(node.right, arr);
	}
	
	public TreeNode balBinTreeUtil(Vector<TreeNode> arr, int start, int end){
		
		if(start>end) return null;
		
		int mid = (start+end) / 2;
		
		TreeNode node = arr.get(mid);
		node.left = balBinTreeUtil(arr, start, mid-1);
		node.right= balBinTreeUtil(arr, mid+1, end);
		
		return node;
	}
	
	public TreeNode createBalBinaryTree(TreeNode node){
		
		if (node==null) return null;
		
		Vector<TreeNode> arr = new Vector<TreeNode>(); //**PTR: If you dont know the size of the array, use Vector
		preOrder(node, arr);
		
		TreeNode root = balBinTreeUtil(arr,0,arr.size()-1);
		
		return root;
	}
	
	void preOrder(TreeNode node) 
	{
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		
		BalancedBinaryTree solution = new BalancedBinaryTree();
		TreeNode node = solution.new TreeNode(10);
		node.left=solution.new TreeNode(8);
		node.left.left=solution.new TreeNode(7);
		node.left.left.left=solution.new TreeNode(6);
		node.left.left.left.left=solution.new TreeNode(5);
		
		TreeNode newNode = solution.createBalBinaryTree(node);
		
		solution.preOrder(newNode);
		
		
	}

}
