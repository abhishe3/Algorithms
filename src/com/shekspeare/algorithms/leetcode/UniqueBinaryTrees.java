package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.shekspeare.algorithms.leetcode.BinaryTreeZigZagLevelOrderTrav.TreeNode;

/** 96. Unique Binary Search Trees and
 *  95. Unique Binary Search Trees II
 *
 * 
 * Explanation: See Above link
 * @author abashok
 *
 */
public class UniqueBinaryTrees {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}
	
	/**
	 * https://leetcode.com/problems/unique-binary-search-trees/?tab=Solutions
	 */
	public int numTrees(int n){
		
		int[] G = new int[n+1];
		
		G[0] = G[1] =1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				G[i]+= G[j-1] * G[i-j];   //**PTR : Notice the '+=' .. Since for each i, we are adding all possible instances of j
			}
		}
		
		return G[n];
		
	}
	
	/** Generate all unique Subtree
	 * https://leetcode.com/problems/unique-binary-search-trees-ii/?tab=Solutions
	 */
	public List<TreeNode> generateTrees(int n){
		
		return generateSubtrees(1,n);
		
	}
	
	public List<TreeNode> generateSubtrees(int start, int end){
		
		List<TreeNode> list  = new ArrayList<TreeNode>();	
		
		if(start>end){
			list.add(null);   //empty tree
			return list;
		}
		
		for(int i=start;i<=end;i++){
			List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
			
			for(TreeNode left: leftSubtrees){
				for(TreeNode right: rightSubtrees){
					
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
			
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		UniqueBinaryTrees solution = new UniqueBinaryTrees();
		int n=4;
		System.out.println(solution.numTrees(n));
		
	}

}
