package com.shekspeare.algorithms.googlehandout;

import com.shekspeare.algorithms.googlehandout.FindPathBetweenNodesBinaryTree.Node;

public class LengthOfPathBetweenTwoNodes {

public static class Node{
		
		int data ;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
		
		public  Node getInstance(){
			return left;
		}
	} 
	
/* Solution:
 * 
 *  
 *  Distance(X, Y) = Distance(root, X) +Distance(root, Y) — 2*(Distance(root to LCA(X,Y)
 *  
 */

	public static int distanceBetweenTwoNodes(Node root, Node node1, Node node2){
		
		int leftNodeDistance = findLenghtFromRoot(root,node1);
		int rightNodeDistance = findLenghtFromRoot(root,node2);
		Node lca = findLCA(root,node1,node2);
		int lcaDistance = findLenghtFromRoot(root, lca);
		return leftNodeDistance + rightNodeDistance - 2*(lcaDistance);
		
	}

	public static Node findLCA(Node root, Node node1, Node node2){
		
		if(root==null) return null; 
		
		if(root.data==node1.data || root.data == node2.data){
			return root;
		}
		
		Node leftLCA = findLCA(root.left, node1, node2);
		Node rightLCA = findLCA(root.right, node1, node2);
		
		if(leftLCA!=null && rightLCA!=null){
			return root;
		}
		return (leftLCA!=null)?leftLCA:rightLCA;

		
	}
	public static int findLenghtFromRoot(Node root, Node node){  //basically getDepth()
		
		if(root==null || node==null) return 0;
		
		return findLenghtFromRootUtil(root,node,1);
		
	}
	
	public static int findLenghtFromRootUtil(Node root, Node node,int level){  //basically getDepthUtil()
		
		if(root==null) return 0;
		
		if(root==node) return level;
		
		return Math.max(findLenghtFromRootUtil(root.left, node, level+1), findLenghtFromRootUtil(root.right, node, level+1));
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		   17
		 /   \
		 6    46
		/ \    \
		3 12    56
	   /  / \   /
	  1  9 15  48	
		 
*/		 
		
		Node root = new Node (17);
		root.left =  new Node (6);
		root.right = new Node(46);
		root.left.left = new Node (3);
		root.left.left.left= new Node(1);
		root.left.right= new Node(12);
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(15);
		root.right.right= new Node(56);
		root.right.right.left=new Node(48);
		
		//System.out.println(findLenghtFromRoot(root,root.left.left.left));
		
		System.out.println(distanceBetweenTwoNodes(root,root.left.left.left,root.right.right));   //Between 1 and 56

 
	}

}
