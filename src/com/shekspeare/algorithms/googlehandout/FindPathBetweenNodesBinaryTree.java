package com.shekspeare.algorithms.googlehandout;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//Wrong Solution... Still looking
public class FindPathBetweenNodesBinaryTree {
	
	public static class Node{
		
		int data ;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
		
	}
	
	
	public static List<Integer> findPath(Node root, Node node1, Node node2){
		
		Stack<Integer> st1 = new Stack<Integer>();
		Stack<Integer> st2 = new Stack<Integer>();
		
		
		Node lca = findLCA(root, node1, node2);
		
		
		findNode(lca, node1,node2, st1);
		findNode(lca, node1,node2, st2);
		
		st1.push(lca.data);
		    // invert the second path
		    while (!st2.isEmpty()) {
		    	st1.push(st2.pop());
		    }
		    return st1;
		
	}
	
	public static void findNode(Node root, Node node1,Node node2, Stack<Integer> st){
		
		if(root==null) return;
		
		if(root.data == node1.data || root.data==node2.data){
			st.push(root.data);
			return;
		}
		
		findNode(root.left,node1,node2,st);
		findNode(root.right,node1,node2,st);
		
		st.push(root.data);
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

	public static void main(String[] args) {
		Node root = new Node (17);
		root.left = new Node (6);
		root.right = new Node(46);
		root.left.left = new Node (3);
		root.left.left.left= new Node(1);
		root.left.right= new Node(12);
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(15);
		root.right.right= new Node(56);
		root.right.right.left=new Node(48);

		List<Integer> list = findPath(root,root.left.left, root.left.right.right );
		
		for(Integer i: list){
			System.out.println(i);
		}
	}

}
