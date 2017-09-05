/**
 * 
 */
package com.shekspeare.algorithms.binarytrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


/**
 * @author abashok
 *
 */

class Node{
	int key;
	Node left ;
	Node right;
	Node next; //this is only added for function connectRightNodes(Node)
	Node parent; // This is only added for findLCAWithParentPointer()
	
	Node(int item){
		key = item;
		left = right = null;		
		
	}
	
	Node(int item, Node leftChild, Node rightChild){
		key = item;
		left = leftChild;
		right=rightChild;
		
	}
}


class Height{
	int h=0;
}




public class BinaryTree {

	public Node root;
	int max_length = 0;
	
	BinaryTree(int item){
		root = new Node(item);
	}
	
	BinaryTree(){
		root = null;
	}
	
	
	int getHeight(Node node){

		if(node!=null){
			return (1+Math.max(getHeight(node.left), getHeight(node.right)));
		}
		
		return 0;
	}
	
	//Find the depth of a given node
	int getDepth(Node root,Node node){
		
		int val = node.key;
		return getDepthUtil(root,val,0);
	}
	
	int getDepthUtil(Node root, int val, int level){
		
		if(root==null) return 0;
		
		if(root.key==val) return level;
		
		int left= getDepthUtil(root.left, val, level+1);
		int right = getDepthUtil(root.right, val, level+1);
		
		return (left==0?right:left);
	}
	
	/**
	 * The diameter of a tree T is the largest of the following quantities:

* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)	
	 * @param node
	 * @return
	 */
	
	int diameter(Node node){
		
		if(node==null) return 0;
		
		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);
		
		int lTreeDiameter = diameter(node.left);
		int rTreeDiameter = diameter(node.right);
		
		return (Math.max((1+lHeight+rHeight),Math.max(lTreeDiameter, rTreeDiameter)));
		
		
	}

	int diameterOptimized(Node node, Height height){
		
		
		if(node==null){
			height.h = 0;
			return 0;
		}
		
		Height lHeight = new Height();
		Height rHeight = new Height();
		
		int lTreeDiameter = diameterOptimized(node.left,lHeight);
		int rTreeDiameter = diameterOptimized(node.right,rHeight);

	      /* Height of current node is max of heights of left and
        right subtrees plus 1*/
       height.h = Math.max(lHeight.h,rHeight.h) + 1;
       
       int rootHeight = lHeight.h+rHeight.h+1;
        
        return Math.max(rootHeight,Math.max(lTreeDiameter, rTreeDiameter));
		
		
	}
	
	// Find if a BT is balanced (similar to above, Optimized for Height calculation)
	//http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
	boolean isBalancedTree(Node node, Height height){
		
		if(node==null){
			height.h = 0;
			return true;
		}
		
		 /* Get heights of left and right sub trees */
		Height lHeight = new Height();
		Height rHeight = new Height();
		
		boolean l = isBalancedTree(node.left, lHeight);
		boolean r = isBalancedTree(node.right, rHeight);
		
		int lh = lHeight.h;
		int rh = rHeight.h;
		
		 /* Height of current node is max of heights of
        left and right subtrees plus 1*/
		height.h = Math.max(lh,rh) + 1;
		
		 /* If difference between heights of left and right
        subtrees is more than 2 then this node is not balanced
        so return false*/
	    if ((lh-rh >= 2) ||
	            (rh - lh >= 2))
	            return false;
	    
	    /* If this node is balanced and left and right subtrees
        are balanced then return true */
	    else return (l && r);
		
	}
	
	void inOrderTraversalNonRecursive(Node root){
		
		if(root==null) return;
		
		
		Stack<Node> st = new Stack<Node>();
		Node node = root;
		
		//push everything in the left subtree into the stack
		while(node!=null){
			st.push(node);
			node= node.left;
		}
		
		while(!st.isEmpty()){
			
			//once all left nodes are in stack, pop stack, make it current node and print
			node = st.pop();
			System.out.print(node.key+" ");
			
			//**PTR:if the current node has a right child, make it current and push all its left subtree nodes into stack
			//**PTR: since the next node to be visited is the leftmost child of the right subtree
			if(node.right!=null){
				node = node.right;
				
				// pushing the left subtree into stack
				while(node!=null){
					st.push(node);
					node = node.left;
				}
			}
			
		}

		
	}
	

	
	void preOrderTraversalNonRecursive(Node root){
		
		if(root==null) return;
		
		Stack <Node> st = new Stack<Node>();
		Node node = root;
		
		st.push(node);
		
		 /* Pop all items one by one. Do following for every popped item
        a) print it
        b) push its right child
        c) push its left child
		  **PTR: Note that right child is pushed first so that left is processed first */
		
		while(!st.isEmpty()){
			// Pop the top item from stack and print it
			node = st.pop();
			System.out.println(node.key+" ");
			
			
			  // Push right and left children of the popped node to stack
			if(node.right!=null){
				st.push(node.right);
			}
			
			if(node.left!=null){
				st.push(node.left);
			}
			
		}
		
	}
	
	
	/** Similar to Pre-oder Traversal, but :
	 * 	a) Instead of printing an item, we push it to a stack.
		b) We push left subtree before right subtree.
		
	We need two stacks because, it creates reverse post order traversal.	
		ALGO: 
	   1. Push root to first stack.
	   2. Loop while first stack is not empty
   			2.1 Pop a node from first stack and push it to second stack
   			2.2 Push left and right children of the popped node to first stack
	   3. Print contents of second stack
	 * 
	 */

	void postOrderTraversalNonRecursive2Stacks(Node root){
		
		if(root==null) return;
		
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		
		Node node  = root;
		//Push root to first stack.
		st1.push(node);

		
		while(!st1.isEmpty()){
			
			//Pop a node from first stack and push it to second stack
			node = st1.pop();
			st2.push(node);
			
			//Push left first and then right child of the popped node to first stack
			if(node.left!=null) 
				st1.push(node.left);

			if(node.right!=null) 
				st1.push(node.right);
		}
		
		//The above while loop creates reverse postorder traversal in this stack. So pop and print
		while(!st2.isEmpty()){
			System.out.println(st2.pop().key+" ");
		}
		
		
	}
	

	int lengthOflongestConsecutivePath(Node root){
/*		Use this with consecutiveLengthHelper(Node root, int curr, int target) below
		if(root==null) return 0;
		
		consecutiveLengthHelper(root, 0, root.key);
		return max_length;*/
		
		
		
		//return (root==null)?0:Math.max(dfs(root.left,1,root.key), dfs(root.right,1,root.key));
		return (root==null?0:dfs(root,1,root.key));
	}
	
	/**
	 * Leetcode https://discuss.leetcode.com/topic/28234/easy-java-dfs-is-there-better-time-complexity-solution/9
	 * @param root
	 * @return
	 */
	void consecutiveLengthHelper(Node root, int curr, int target){
		if(root==null) return;
		
		if(root.key==target)
			curr++;
		else
			curr=1;
		
		max_length = Math.max(curr, max_length);
		
		consecutiveLengthHelper(root.left, curr, root.key+1);
		consecutiveLengthHelper(root.right, curr, root.key+1);
		
	}
	
	/**
	 * Leetcode https://discuss.leetcode.com/topic/29205/simple-recursive-dfs-without-global-variable/6
	 * @param root
	 * @return
	 */
	//alternate consecutiveLengtHelper
	int dfs(Node root, int count, int val){
		if (root==null) return count;
		
		if((root.key-val)==1) count ++; else count =1;
		
		int left = dfs(root.left,count,root.key);
		int right = dfs(root.right,count, root.key);
		
		return Math.max(Math.max(left, right),count);
	}
	
	// Print the maximum width if a binary tree (GFG) http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
	// use BFS and size of queue to determine width at each level
	int getMaxWidth(Node root){
		
		if(root == null) return 0;
		
		int maxWidth = 0 ;
		int currWidth = 0 ;
		
		Queue <Node> q = new LinkedList<Node>();  //**PTR: Notice how Queue is instantiated as LinkedList
		q.add(root);
		
		while(!q.isEmpty()){
			currWidth = q.size();
			maxWidth = Math.max(currWidth, maxWidth);
			Node node;
			while(currWidth!=0){      // loop till only children of next level are in the queue. This will ensure queue.size = width at that level 
				node = q.poll();
				currWidth --;
				if(node.left!=null) q.add(node.left);
				if(node.right!=null) q.add(node.right);
				
			}
		}
		
		
		return maxWidth;
	}
	
	//Print nodes at k distance from root (http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/)
	//used recursion
	
	void printkLevelNodes(Node node, int k){
		if(node==null) return;
		
		if(k==0){
			System.out.print(node.key);
			return;
		}
		
		printkLevelNodes(node.left, k-1);
		printkLevelNodes(node.right, k-1);
	}
	
	
	//Print Ancestors of a given node in Binary Tree http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
	boolean printAncestors(Node node, int target){
		if(node == null) return false;
		
		if(node.key == target){
			return true;
		}
		
		/* If target is present in either left or right subtree 
        of this node, then print this node */
		if(printAncestors(node.left,target) || printAncestors(node.right, target)){
			System.out.print(node.key+" ");
			return true;
		}
		
		return false;
	}
	
	
	
	
	// Connect nodes at same level using constant extra space  : HAVENT TESTED THIS...SEE LINK BELOW AGAIN
	// https://discuss.leetcode.com/topic/2202/a-simple-accepted-solution/12  (Comment from  tyuan73)
	
	//This only works for complete binary trees. Look for BFS solution below this that works for all cases
	void connectRightNodes(Node root){
		
		while(root!=null){
			
			Node current = root;
			while(current!=null && current.left!=null){
				current.left.next = current.right;
				current.right.next = (current.next == null) ? null: current.next.left;
			}
			
			root = root.left;
		
		}
		
		//call printTree to see the right nodes
	}
	
	//Connect nodes at same level BFS (works for all cases) : Disadv : O(n) space (two queues)
	// Algo: Use two queues. Push next level into next queue.
	//       In each queue:
	//                    (1) poll
	//                    (2) if(queue size > 0) there are siblings, so curr.next = q.peek()
	//                    (1) push left and then right child in other queue
	
	void connectRight(Node root){
	    
	    if(root==null)
	        return;
	        
	    Queue<Node> q1 = new LinkedList<Node>();
	    Queue<Node> q2 = new LinkedList<Node>();
	    q1.add(root);
	    
	    while(!q1.isEmpty() || !q2.isEmpty()){
	        
	        while(!q1.isEmpty()){
	            
	            Node curr = q1.poll();
	            if(q1.size()>0){
	                curr.next=q1.peek();
	            }
	            
	            if(curr.left!=null)
	                q2.add(curr.left);
	            if(curr.right!=null)
	                q2.add(curr.right);
	        }
	        
	        while(!q2.isEmpty()){
	            
	            Node curr = q2.poll();
	            if(q2.size()>0){
	                curr.next=q2.peek();
	            }
	            
	            if(curr.left!=null)
	                q1.add(curr.left);
	            if(curr.right!=null)
	                q1.add(curr.right);
	        }
	        
	        
	    }
	    
	    
	}
	
	void BFSPrint(Node root){
		if(root==null){
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node node = q.poll();
			System.out.println("Key "+ node.key);
			if(node.next==null) System.out.print(node.key+".right is null");
			else System.out.print(node.key+".right "+ node.next.key);
			
			if(node.left!=null) q.add(node.left);
			if(node.right!=null) q.add(node.right);
		}
		
	}
	
	//Lowest Common Ancestor in a Binary Tree  : Method 2 (Using Single Traversal)
	//http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	// It assumes both n1 and n2 are present
	Node findLCA(Node root, int n1, int n2){
		
		if(root==null) return null;
		
		//if either numbers are equal to the root, then root is the LCA
		if(root.key==n1 || root.key==n2)
			return root;
		
		Node leftLCA = findLCA(root.left, n1, n2);
		Node rightLCA = findLCA(root.right, n1, n2);
		
		if(leftLCA!=null && rightLCA!=null){ // if neither are null, this is the LCA, as each number is on either side of it
			return root;
		}
		
		//only one of them is null, so it must be in the corresponding subtree. So return whatever LCA node you found
		return (leftLCA!=null)?leftLCA:rightLCA;
		
		
	}
	
	
	
	Node findLCAWithParentPointer(Node root, Node n1, Node n2){
		
		int d1 = depth(n1), d2=depth(n2);
		int diff = d1-d2;
		
		//if n2 is deeper, swap n1 and n2
		if(d2>d1){
			Node temp = n1;
			n1=n2;
			n2=temp;
			diff = -diff;
		}
		
		while(diff!=0){
			n1=n1.parent;
			diff--;
		}
		
		//Now n1 and n2 are at same levels
		while(n1!=null && n2!=null){
			if(n1==n2) return n1;
			n1=n1.parent;
			n2=n2.parent;
		}
		
		return null;
		
		
	}
	
	//Util function to find the depth of a node, if parent pointers are provided
	int depth (Node node){
		
		int d=-1;
		while(node!=null){
			node = node.parent;
			d++;
		}
		return d;
	}
	
	int callMe(int n){
		
		if(n==0){
			return n;
		}
		
		throw new IllegalArgumentException();
	}
	
	//return true if there is a path with a given sum
	 boolean findExistsSumPath(Node root, int sum){
		
		if(root==null) return false;
		
		if(root.key==sum) return true;
		
		return ( findExistsSumPath(root.left,sum-root.key) || findExistsSumPath(root.right,sum-root.key));
		
	}
	 
	//return true if there is a root-leaf path with a given sum
		 boolean findExistsSumPathRootToLeaf(Node root, int sum){
			
			if(root==null) return false;
			
			if(root.key==sum && root.left==null && root.right==null) return true;
			
			return ( findExistsSumPathRootToLeaf(root.left,sum-root.key) || findExistsSumPathRootToLeaf(root.right,sum-root.key));
			
		}

	 // returns the sum of all integers in the tree weighted by their depth ( Sum at each level * level)
	 int weightedTotalSum(Node root){
		 
		 if(root==null) return -1;
		 
		 return weightedTotalSumUtil(root,1, 0);
	
		 
	 }
	 
	 int weightedTotalSumUtil(Node root, int level, int sum){
		 
		 if(root==null){
			 return sum;
		 }
		 
		 Queue<Node> q1 = new LinkedList<Node>();
		 Queue<Node> q2 = new LinkedList<Node>();
		 
		 q1.add(root);
		 
		
		 while(!q1.isEmpty() || !q2.isEmpty()){
			 
			 while(!q1.isEmpty()){
				 
				 Node x = q1.poll();
				 
				 sum = sum + x.key*level;
				 if(x.left!=null){
					 q2.add(x.left);
				 }
				 if(x.right!=null){
					 q2.add(x.right);
				 } 
				 
				
			 }
			 
			 level++;
			 while(!q2.isEmpty()){
				 
				 Node x = q2.poll();
				 
				 sum = sum + x.key*level;
				 if(x.left!=null){
					 q1.add(x.left);
				 }
				 if(x.right!=null){
					 q1.add(x.right);
				 } 
				 
				 
			 }
			 
			 level++;
			 
		 }
		 
		 return sum;
	 }
	 
	 //          6
	 //         /  \
	 //        7    7
	 //       /      \
	 //      3        3
	 //       \      /
	 //        2     2
	 boolean isTreeSymmetric(Node root){
		 
		 if(root==null) return true;
		 
		 return isTreeSymmetricUtil(root.left,root.right);
	 }
	 
	 boolean isTreeSymmetricUtil(Node subTree1, Node subTree2){
		 
		 if(subTree1==null && subTree2==null) return true;
		 
		 if(subTree1!=null && subTree2!=null) {
			 return ( ( subTree1.key == subTree2.key) &&
					  (isTreeSymmetricUtil(subTree1.left, subTree2.right)) &&
					  (isTreeSymmetricUtil(subTree1.right, subTree2.left))
					 ); 
		 }
		  //One of them is null.. so cannot be symmetric
		 return false;
	 }
	 
	 //Create Binary Tree from Inorder and PreOrder list
	 //Refer Question 10.12 : Page 167 EPI
	 
	 Node createBinTreeFromInorderPreOrder(List<Integer> preOrder, List<Integer> inOrder){
		 
		 Map<Integer,Integer> inOrderMap = new HashMap<Integer,Integer>();
		 
		 for(int i=0;i<inOrder.size();i++){
			 inOrderMap.put(inOrder.get(i),i);
		 }
		 
		 return (createBinTreeFromInorderPreOrderHelper(preOrder,0,preOrder.size(),0,inOrder.size(),inOrderMap));

	 }
	 
	 Node createBinTreeFromInorderPreOrderHelper(List<Integer> preOrder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd, Map<Integer,Integer> inOrderMap){
		 
		 if(preOrderStart>=preOrderEnd || inOrderStart>=inOrderEnd){
			 return null;
		 }
		 
		 int rootIndx = inOrderMap.get(preOrder.get(preOrderStart)) ;
		 int leftSubTreeSize = rootIndx - inOrderStart;
		 
		 return new Node(
				 preOrder.get(preOrderStart),
				 createBinTreeFromInorderPreOrderHelper(preOrder,preOrderStart+1,preOrderStart+1+leftSubTreeSize, inOrderStart,rootIndx,inOrderMap),
				 createBinTreeFromInorderPreOrderHelper(preOrder,preOrderStart+1+leftSubTreeSize,preOrderEnd, rootIndx+1,inOrderEnd,inOrderMap)
				 );
		 
	 }
	 
	 //Create LList of leaves in a Binary Tree
	 // Basically do an inOrderTraversal
	 // Refer Question 10.14 page 170 , EPI
	 List<Integer> createListFromLeaves(Node root){
		 
		 if(root==null) return null;
		 
		 List<Integer> llist = new LinkedList<Integer>();
		 
		 return createListFromLeavesUtil(root,llist);
		 
	 }
	 
	 List<Integer> createListFromLeavesUtil(Node root,List<Integer> llist){
		 
		 if(root==null) return null;
		 
		 createListFromLeavesUtil(root.left,llist);
		 
		 if(root.left==null && root.right==null){
			 llist.add(root.key);
		 }	 
		 createListFromLeavesUtil(root.right,llist);
		 
		 return llist;
	 }
	 
	 
	 
	 //Print exteriors of a tree
	 // See diagram at http://www.geeksforgeeks.org/wp-content/uploads/BoundryTraversal.gif
	 
		// A function to print all left boundary nodes, except a leaf node.
		// Print the nodes in TOP DOWN manner
	 void printLeftExterior_a(Node node){
		    
		    if(node==null) return;

		    
		    if(node.left!=null){
		    	// to ensure top down order, print the node
				// before calling itself for left subtree
		        System.out.print(node.key+" ");
		        printLeftExterior_a(node.left);
		    }
		    else if(node.right!=null){
		         System.out.print(node.key+" ");
		         printLeftExterior_a(node.right);
		    }
		    
		}
		
		// A function to print all right boundary nodes, except a leaf node
		// Print the nodes in BOTTOM UP manner
		void printRightExterior_a(Node node){
		    
		    if(node==null) return;
		    
		    if(node.right!=null){
		    	// to ensure bottom up order, first call for right
				// subtree, then print this node
		        printRightExterior_a(node.right);
		        System.out.print(node.key+" ");
		    }
		    else if(node.left!=null){
		         printRightExterior_a(node.left);
		         System.out.print(node.key+" ");
		    }
		    
		}
		
		// A function to do print leaves only
		void printTreeLeaves(Node node){
		    
		    if(node==null) return;
		    
		    printTreeLeaves(node.left);
		    if(node.left==null && node.right==null){
		         System.out.print(node.key+" ");
		    }
		    printTreeLeaves(node.right);
		}
		
		// A function to do boundary traversal of a given binary tree
		void printExterior(Node root){
		    
		    if(root==null)
		      return;
		     
		    //first print root
		      System.out.print(root.key+" ");  
		      printLeftExterior_a(root.left);
		      printTreeLeaves(root);
		      printRightExterior_a(root.right);
		      
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree tree = new BinaryTree();
/*	tree.root = new Node(1);
		tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);*/
		
/*		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(9);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);*/
		
		
/*		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(9);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);*/
		
	/*	tree.root = new Node(6);
		tree.root.right = new Node(9);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(10);
		tree.root.right.right.right = new Node(11);*/
		
        
       // System.out.println(tree.diameter(tree.root));
       // System.out.println(tree.diameterOptimized(tree.root, new Height()));
        
    //   tree.inOrderTraversalNonRecursive(tree.root);
     //  tree.preOrderTraversalNonRecursive(tree.root);
		//tree.postOrderTraversalNonRecursive2Stacks(tree.root);
		//System.out.println(tree.getMaxWidth(tree.root));
		
		//tree.printkLevelNodes(tree.root, 8);
		//tree.printAncestors(tree.root, 7);
		
		//System.out.println(tree.getDepth(tree.root, tree.root.right.left));
		
	
	//	tree.printAncestorsNew(tree.root, 7);
		//tree.connectRightNodes(tree.root);
		//tree.BFSPrint(tree.root);
		
		//System.out.println(tree.findLCA(tree.root,15,11).key);
	//	 System.out.println(tree.isBalancedTree(tree.root, new Height()));
		
		//tree.callMe(null);
		//System.out.println(tree.findExistsSumPath(tree.root,12));
		//System.out.println(tree.findExistsSumPathRootToLeaf(tree.root,18));
		//System.out.println(tree.lengthOflongestConsecutivePath(tree.root));

		//System.out.println(tree.weightedTotalSum(tree.root));
		
		
		//Symmetric tree test
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);
		
		//System.out.println(tree.isTreeSymmetric(tree.root));
/*		List<Integer>llist = tree.createListFromLeaves(tree.root);
		
		for(Integer i: llist){
			System.out.print(i + " -> ");
		}*/
		
		tree.printExterior(tree.root);
	}

}
