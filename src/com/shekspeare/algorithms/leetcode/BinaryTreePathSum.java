package com.shekspeare.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/?tab=Description
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 */
public class BinaryTreePathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> masterList = new ArrayList<List<Integer>>();
	        List<Integer> currList = new ArrayList<Integer>();
	        
	        if(root==null) return masterList;
	        
	        findSumPath(root,sum,currList,masterList);
	        
	        return masterList;
	        
	    }
	    
	    
	    public void findSumPath(TreeNode node, int sum,List<Integer> currList,List<List<Integer>> masterList ){
	        
	        if(node==null) return;
	        
	        currList.add(node.val);
	        
	        if(node.left == null && node.right==null && node.val==sum){
	            masterList.add(new ArrayList<Integer>(currList)); //**PTR: when adding to masterList, use the 'new' operator, especially in recursion
	          //... since currList is being modified below. So the 'new' operator will create a new unchanged copy above in the masterList.
	            
	            
	            currList.remove(currList.size()-1);   // **PTR: Remember to remove the leaf from the list, so that a new leaf can be tried for matching sum.
	            return;
	        }else{
	            findSumPath(node.left, sum-node.val,currList, masterList);
	            findSumPath(node.right, sum-node.val,currList, masterList);
	        }
	        
	         currList.remove(currList.size()-1);   //**PTR: This is a leaf that does not add to the sum. So remove it too.
	        
	    }
	    /** 112. Path Sum
	     * https://leetcode.com/problems/path-sum/?tab=Description
	     * @param root
	     * @param sum
	     * @return
	     */
	    public boolean hasPathSum(TreeNode root, int sum) {
	         if(root==null) return false;
		       
		     if(root.left==null && root.right==null && root.val==sum){
		         return true;
		     }else{
		         return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
		     }    
		     
	    }

	public static void main(String[] args) {
		
		/*
		 *    5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
		 * 
		 */
		
		BinaryTreePathSum solution = new BinaryTreePathSum();
		TreeNode node1 = solution.new TreeNode(5);
		TreeNode node2 = solution.new TreeNode(4);
		TreeNode node3 = solution.new TreeNode(8);
		TreeNode node4 = solution.new TreeNode(11);
		TreeNode node5 = solution.new TreeNode(13);
		TreeNode node6 = solution.new TreeNode(4);
		TreeNode node7 = solution.new TreeNode(7);
		TreeNode node8 = solution.new TreeNode(2);
		TreeNode node9 = solution.new TreeNode(5);
		TreeNode node10 = solution.new TreeNode(1);

		node1.left=node2;
		node1.right = node3;
		node2.left =node4;
		node4.left=node7;
		node4.right=node8;
		node3.left=node5;
		node3.right=node6;
		node6.left=node9;
		node6.right=node10;
		
		List<List<Integer>> masterList;
		masterList=solution.pathSum(node1, 22);
		
		for(List<Integer> list: masterList){
			for(Integer i: list){
				System.out.print(i.intValue()+ ",");
			}
			System.out.println();
		}
		
		System.out.println(solution.hasPathSum(node1, 26));
	}

}
