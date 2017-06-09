/**
 * 
 */
package com.shekspeare.datastructures.heaps;

import java.nio.BufferOverflowException;

/**
 * @author abashok
 *
 */
public class Heap {
	
	private int[] nodes;
	private int CAPACITY;
	private int size;
	
	Heap(int capacity){
		CAPACITY = capacity;
		size = 0;
		nodes = new int[capacity];
	}
	
	private int getParentIndex(int pos){
		return (pos-1)/2;
	}
	
	private int getLeftChildIndex(int pos){
		return (pos*2)+1;
	}
	
	private int getRighttChildIndex(int pos){
		return (pos*2)+2;
	}
	
	private boolean isLeaf(int pos){
		if(pos>(size/2) && pos<CAPACITY) return true;
		else return false;
	}
	
	private void swap(int index1, int index2){
		int temp = nodes[index1];
		nodes[index1] = nodes[index2];
		nodes[index2] = temp;
	}
	
	private void insertKey(int key){
		
		if((this.size)==CAPACITY){
			throw new ArrayIndexOutOfBoundsException("Cannot exceed Heap Capacity");
		}
		
		size++;
		nodes[size-1]= key;
		int i = size-1;
		
		while(i!=0 && nodes[getParentIndex(i)]>nodes[i]){
			swap(getParentIndex(i), i);
			i=getParentIndex(i);
		}
		
	}
	
	
	private void heapify(int pos){
		if(pos<0 || pos>(size-1)){
			throw new ArrayIndexOutOfBoundsException("Invalid heap index");
		}
		if(pos==size || isLeaf(pos)){
			return;
		}
		
		
		int leftChildIndex = getLeftChildIndex(pos);
		int rightChildIndex = getRighttChildIndex(pos);
		int smallest = pos;
		
		if((leftChildIndex<size) && (nodes[leftChildIndex]<nodes[smallest])){
			smallest = leftChildIndex;
		} if((rightChildIndex<size) && (nodes[rightChildIndex]<nodes[smallest])){
			smallest = rightChildIndex;
		}
		
		if(pos!=smallest){
			swap(pos,smallest);
			heapify(smallest);
		}
	
		
	}
	
	private int extractMin(){
		
		if(size==0){
			throw new ArrayIndexOutOfBoundsException("Heap is empty");
		}
		
		if(size==1){
			size--; 
			return nodes[0];
		}
		
		//Store min value and remove it from heap
		int root = nodes[0];
		nodes[0] = nodes[size-1];
		size--;
		heapify(0);
		return root;
	}
	

	
	private void deleteKey(int i){
		if(i <0 || i>(size-1)){
			throw new ArrayIndexOutOfBoundsException("Invalid heap index");
		}
		
		nodes[i] = Integer.MIN_VALUE;
		
		while(i!=0 && nodes[getParentIndex(i)]>nodes[i]){
			swap(getParentIndex(i), i);
			i=getParentIndex(i);
		}
		
		extractMin();
	}
	
	private void printRoot(){
		
		if(size>0){
			System.out.println("Root is : "+nodes[0]);
		}else{
			System.out.println("Root is null");
		}
	}
	
	private void printHeap(){
		
		if(size>0){
			for(int i=0;i<size;i++){
				System.out.print(nodes[i]+" ,");
			}
		}else{
			System.out.println("Heap is empty");
		}
		System.out.println();
	}
	
	void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	//Learn this from GFG and implement here after revising heaps
	void heapSort(int[] array){
		
	}
	
	
	//This function does not belong here. It is only to demonstrate K-sorting
	//Algo:
	//     1) Create Min-Heap for first K+1 elements   (0 to <=K)
	//	   2) In Loop from K+1 to n; 
				// a) Extract Min from heap and put in result array
				// b) Add next element from un-sorted array into heap
	void kSortArray(int[] array,int k){
		
		if(null==array) return ;
		int n = array.length;
		
		int[] sortedArray = new int[n];
		Heap heap = new Heap(k+1);
		for(int i=0;i<=k;i++){
			heap.insertKey(array[i]);
		}
		
		for(int result=0,j=(k+1); result<n; j++, result++){
			
			sortedArray[result]=heap.extractMin();

			if(j<n){
				heap.insertKey(array[j]);
			}
		}
		
		printArray(sortedArray);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		Heap heap = new Heap(15);
		heap.insertKey(3);
		heap.insertKey(2);
		heap.insertKey(15);
		heap.insertKey(5);
		heap.insertKey(4);
		heap.insertKey(45);
		
		//heap.extractMin();
		//heap.printRoot();
		heap.printHeap();
		
		
		
		heap.deleteKey(1);
		
		heap.printHeap();
		
		heap.extractMin();
		
		heap.printHeap();*/
		
		int k = 3;
	    int arr[] = {2, 6, 3, 12, 56, 8};
	    Heap heap = new Heap(15);
	    heap.kSortArray(arr, k);

	}

}
