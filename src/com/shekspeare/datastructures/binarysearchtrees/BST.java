/**
 * 
 */
package com.shekspeare.datastructures.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abashok
 *
 */



class Node{
	int key;
	Node left;
	Node right;
	
	Node(int data){
		key = data;
		left = right = null;
	}
}

public class BST {
	
	// These two are only used for findPredSucc()
	Node successor;
	Node predecessor;
	
	Node root;
	
	int count , count1= 0; //used only for findKthElement()

	BST(){
		this.root = null;
	}
	
	
/*	BST(int root){      //Dont make anything as root by default
		this.root = new Node(root);
	}*/

	//Search for a node in BST
	Node search(Node root, int key){
		if(root == null) return null;
		
		if(root.key == key) return root;
		
		if(key<root.key) return search(root.left,key);
		else return search(root.left,key);
		
	}
	
	
	void insertNode(int key){
		insertNodeUtil(this.root, key);
	}
	
	Node insertNodeUtil(Node root, int key){
		
		if(root==null){
			root = new Node(key);
			return root;
		}
		
		if(key<root.key){
			root.left  = insertNodeUtil(root.left, key);
		}
		
		else if(key>root.key){
			root.right  = insertNodeUtil(root.right, key);
		}
		
		return root;
	}
	
	
	void deleteNode(int key){
		if(root==null) return;
		root = deleteNodeUtil(root, key);
	}
	
	Node deleteNodeUtil(Node root, int key){
		
		if(root==null) return null;
		
		// Step 1 : Locate the node to be deleted
		if(key < root.key){
			root.left = deleteNodeUtil(root.left, key);
		}else if(key > root.key){
			root.right = deleteNodeUtil(root.right, key);
		}else{    // this means that root.key = key .. and so THIS is the node to be deleted
			
			// Case 1: if it is a leaf; simply delete it
			if(root.left ==null && root.right==null){
				root = null;
				return root;
			}
			// Case 2: if it has only one child ; either left or right; copy the child's data to this node (root = root.left/right);
			else if (root.left==null){
				return root.right;
			}else if(root.right==null){
				return root.left;
			}
			
			// Case 3: it has two children , replace node with the smallest element in the right-subtree (left most child in the right subtree)
			// and **PTR: Delete this child
			else{ 
				
				root.key = findMinKey(root.right);;
				root.right = deleteNodeUtil(root.right, root.key);
				
			}
			
		}
		
		return root;
		
	}
	
	int findMinKey(Node root){
		
		int minVal = root.key;
		while(root.left!=null){
			root = root.left;
			minVal = root.key;
		}
		
		return minVal;
	}
/*	
	//trial
	Node deleteNodesLargerThan(Node root, int value){
		
		if(root==null) return null;
		
		//search
		 if(root.key>value){
			 root.left = deleteNodesLargerThan(root.left,value);
			 return root.left;
		 }
		 
		 if(root.key<value){
			 root.right = deleteNodesLargerThan(root.right, value);
			 return root;
		 }
		 
		 if(root.key ==value){
			 root.right = null;
		 
		 if(root.left!=null){
			 //search rightmost child in left subtree
			 int minval = searchleftChild(root.left);
			 root.key = minval;
			 Node currRoot
		 }
		 }
	}
	
	
	int searchleftChild(Node root){
		
		int minval = root.key;
		while(root.left!=null){
			root=root.left;
			minval = root.key;
		}
		
		return minval;
	}
	*/

	//Read this as well:
	// http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
	
	
	//Inorder predecessor and successor for a given key in BST (http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/)
	// May not be complete
	
	
	void findPredSucc(int key){		
		findPredSuccUtil(this.root,key);
	}
	
	void findPredSuccUtil(Node root, int key){
		
		if(root==null) return ;
		
		//step 1: locate the node with given key
		if(root.key==key){       
			 successor = findSuccRightTree(root.right); //if key is found,  successor will be the left most child of right subtree
			 predecessor = findPreddLeftTree(root.left);//if key is found,  predecessor will be the right most child of left subtree
		}
		
		else{   //key not found yet, look recursively on left and right subtrees
			if (key<root.key){
				successor = root;
				findPredSuccUtil(root.left, key);
			}else{
				if(key>root.key){
					predecessor = root;
					findPredSuccUtil(root.right, key);
				}
			}
		}
		

	}
	
	Node findSuccRightTree(Node root){
		if(root==null){
			return null;
		}
		
		while(root.left!=null){
			root = root.left;
		}
		return root;
	}
	
	Node findPreddLeftTree(Node root){
		if(root==null){
			return null;
		}
		
		while(root.right!=null){
			root = root.right;
		}
		return root;
	}
	
	// check if a binary tree is BST or not 
	// GFG Method 3: http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	void checkBST(Node root){
		if( checkBSTUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE)){
			System.out.println("It is a BST");
		}else{
			System.out.println("Not a BST");
		}
	}
	
	boolean checkBSTUtil(Node root, int minVal, int maxVal){
		
		//Empty tree is a BST
		if(root==null) return true;  
		
		/* false if this node violates the min/max constraints */
		if((root.key<minVal) || (root.key>maxVal)){
			return false;
		}
		 
		/* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
		return ( checkBSTUtil(root.left,minVal,root.key-1) && ( checkBSTUtil(root.right,root.key+1,maxVal)));
	}
	
	// Lowest Common Ancestor in a Binary Search Tree
	Node findLCA(Node root, int n1, int n2){
		
		// This method assumes n1 and n2 are present in the tree
		if(root==null) return null;
		
		// if root is greater than BOTH, look in left subtree
		if(root.key > n1 && root.key>n2){
			return findLCA(root.left,n1, n2);
		}
		
		// if root is smaller than BOTH, look in right subtree
		if(root.key <n1 && root.key<n2){
			return findLCA(root.right,n1, n2);
		}
		
		// this means root is in between n1 and n2. So this root is the LCA
		return root;
	}
	
	
	// find Inorder Successor in Binary Search Tree : Method 2 (Search from root) http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/ 
	Node findInOrderSuccessor(Node root, Node p){
		
		//If p has a right node, then the successor is the smallest element in the right subtree
		if(p.right!=null){
			return findMinNode(p.right);
		}
		
		//This means p does not have a right node. So its successor is its parent. To find parent we have to start from root; so start searching for p from root and record the parent (successor) along the way
		Node successor = null;
		
		while(root!=null){
			
			if(p.key<root.key){ //look in left subtree and record parent (successor along the way)
				successor = root;
				root = root.left;
			}
			
			else if (p.key>root.key){  // keep moving right till we find it
				root = root.right;
			}
			
			else break;  //means p.key = root.key ...we found it already ..so return successor that was already recorded  .. (equivalent to " return successor ; " )
			
		}
		
		return successor;
		
	}
	
	//Util function to find the smallest element in a BST  (which should be the left-most element of a BST)
	Node findMinNode(Node node){
		while(node.left!=null){
			node = node.left;
		}
		
		return node;
	}
	
	// find Inorder Successor in Binary Search Tree : Based on above function findInOrderSuccessor
	Node findInorderPredecessor(Node root, Node p){
		
		//If p has a left node, then the predecessor is the largest element in the left subtree
		if(p.left!=null){
			return findMaxNode(p.left);
		}
		
		//This means p does not have a left node. So its predecessor is its parent/grandparent. To find it we have to start from root; so start searching for p from root and record the parent (predecessor) along the way
		Node predecessor = null;
		
		while(root!=null){
			
			if(p.key<root.key){   // keep moving left till we find it
				root = root.left;
			}
			
			else if (p.key>root.key){ //look in left subtree and record parent (predecessor along the way)
				predecessor = root;
				root=root.right;
				
			}
			
			else break; //means p.key = root.key ...we found it already ..so return predecessor that was already recorded  .. (equivalent to " return predecessor ; " )
		}
		
		return predecessor;
	}
	
	//Util function to find the largest element in a BST  (which should be the right-most element of a BST)
	Node findMaxNode(Node node){
		while(node.right!=null){
			node = node.right;
		}
		
		return node;
	}
	
	//This is only an improvisation of inOrderTraversal below. Before printing we check if global count ==k . Once we find it, we return
	void printKthElement(Node root, int k){
		
		if(root==null) return;	
		
		printKthElement(root.left, k);
		
	   ++count;
		if(count==k){ 
			System.out.println("The "+k+"th element is : "+root.key);
			return;
		}
		printKthElement(root.right, k);
		
		
	}
	
	//Given a node, return the next highest node...
	//Can be done by Inorder traversal, but it does not take adv of BST's ordered nature.
	// This solution is from EPI : Q15.2 page 262
	public static int nextHighest(Node root, int k){
	    
	    if(root==null) return -1;
	    
	    Node node = root;
	    Node nextHighest = null;
	    
	    while(node!=null){
	          if(node.key>k){
	      
	            nextHighest=node;
	            node=node.left;
	          }else{
	            node=node.right;
	          }
	    }
	  
	      return (nextHighest==null?-1:nextHighest.key);
	    
	  }
	
	
	void inOrderTraversal(Node root){
		if(root==null) return;
		
		inOrderTraversal(root.left);
		System.out.println(++count1+" "+ +root.key);	
		inOrderTraversal(root.right);
	}
	
//Print the K largest elements in a BST
//Soln: Do a reverse Inorder (right>>root>>left) and fill the list till it reaches size k
//EPI Q 15.3 Page 263
	public static List<Integer> getKLargestNodes(Node root, int k){
	    
	    List<Integer> list = new ArrayList<Integer>();
	    
	    if(root==null || k==0) return null;    
	    getKLargestNodesUtil(root,list,k);
	    return list;
	    
	  }
	  
	  
	   public static void getKLargestNodesUtil(Node root, List<Integer> list, int k ){
	     
	     if(root==null) return;
	     
	     getKLargestNodesUtil(root.right,list,k);
	     
	     if(list.size()<k){
	      list.add(root.key);
	     }
	     
	     if(list.size()==k){
	       return;
	     }
	     
	     getKLargestNodesUtil(root.left,list,k);
	     
	   }
	
	   
	   //Create min height BST from sorted array
	   // Soln Idea: EPI Q15.9 page 275
	   public static Node createMinHeightTree(int[] arr){
		    
		    return createMinHeightTreeUtil(arr,0,arr.length-1);
		    
		  }
		 
		  
		  public static Node createMinHeightTreeUtil(int[] arr, int low,int high){
		    
		    if(low<=high){
		      
		      
		      int mid = low + (high-low)/2;
		      
		      Node root = new Node(arr[mid]);
		      
		      root.left = createMinHeightTreeUtil(arr,low,mid-1); 
		      root.right =createMinHeightTreeUtil(arr,mid+1,high);
		      
		      return root;
		      
		    }else{
		      
		      return null;
		    }
		    
		    
		    
		  }
		  
		  public static void inOrder(Node root){
		    
		    if(root==null) return;
		    
		    inOrder(root.left);
		    System.out.print(root.key+" ");
		    inOrder(root.right);
		    
		    
		  }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		BST bst = new BST(50);
		bst.insertNode(80);
		bst.insertNode(30);
		bst.insertNode(40);
		bst.insertNode(70);
		bst.insertNode(20);
		bst.insertNode(60);*/
		
/*		BST bst = new BST();
		bst.insertNode(10);
		bst.insertNode(20);
		bst.insertNode(50);
		bst.insertNode(30);
		bst.insertNode(60);
		bst.insertNode(40);*/
		
		// START
		BST bst = new BST();
		bst.root = new Node(50);
		bst.root.left = new Node(40);
		bst.root.right = new Node(60);
		bst.root.left.left = new Node(30);
		//bst.root.left.left.left = new Node(20);
		//bst.root.left.left.left.left = new Node(10);
		bst.root.left.right = new Node(45);
		bst.root.left.right.left = new Node(44);
		bst.root.left.right.right = new Node(46);
		
		
		bst.root.right.left = new Node(55);
		bst.root.right.left.left = new Node(51);
		bst.root.right.left.right = new Node(56);
		
		
	//	bst.root.right.right = new Node(70);
	//	bst.root.right.right.right = new Node(75);
	//	bst.root.right.right.right.left = new Node(74);
 
		//End	*/
		
		/*BST bst = new BST();
		bst.root = new Node(25);
		bst.root.right = new Node(50);
		bst.root.right.right = new Node(70);
		bst.root.right.right.left = new Node(60);*/
		
/*		 System.out.println("Inorder traversal of the given tree");
		 bst.inOrderTraversal(bst.root);
	 
	     System.out.println("\nDelete 20");
	     bst.deleteNode(20);
        System.out.println("Inorder traversal of the modified tree");
        bst.inOrderTraversal(bst.root);
 
        System.out.println("\nDelete 30");
        bst.deleteNode(30);
        System.out.println("Inorder traversal of the modified tree");
        bst.inOrderTraversal(bst.root);
 
        System.out.println("\nDelete 50");
        bst.deleteNode(50);
        System.out.println("Inorder traversal of the modified tree");
        bst.inOrderTraversal(bst.root);*/
		
		//bst.findPredSucc(25);
		//System.out.println("predecessor : "+bst.predecessor.key);
        //System.out.println("sucsessor : "+bst.successor.key);
		
	//	bst.checkBST(bst.root);
	//	bst.inOrderTraversal(bst.root);
		
		//System.out.println(bst.findLCA(bst.root, 50, 50).key);

		

		//System.out.println(bst.findInOrderSuccessor(bst.root, bst.root).key);
		
		//System.out.println(bst.findInorderPredecessor(bst.root, bst.root).key);
		//System.out.println("**************************");
		//bst.printKthElement(bst.root, 3);
		
	bst.printKthElement(bst.root, 4);


	}

}
