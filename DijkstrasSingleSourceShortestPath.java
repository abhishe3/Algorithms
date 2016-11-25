/**
 * 
 */
package com.shekspeare.algorithms;

import java.util.HashMap;

/**
 * @author abashok
 *
 */
public class DijkstrasSingleSourceShortestPath {

	class HeapNode{
		int v;
		int dist;
		
		HeapNode(int v,int dist){
			this.v=v;
			this.dist=dist;
		}
	}
	
	class Heap{
		HeapNode[] heapNodes;
		int CAPACITY;
		int size;
		
		Heap(int capacity){
			CAPACITY = capacity;
		    heapNodes = new HeapNode[CAPACITY];
		    size=0;
		}
		
		int getParentIndex(int pos){
			return (pos-1)/2;
		}
		
		int getLeftChildIndex(int pos){
			return (pos*2)+1;
		}
		
		int getRighttChildIndex(int pos){
			return (pos*2)+2;
		}
		
		void swap(int pos1, int pos2){
			
			HeapNode temp = heapNodes[pos2];
			heapNodes[pos2] = heapNodes[pos1];
			heapNodes[pos1] = temp;
		
		}
		
		
		void insertNode(HeapNode heapNode){
			if(size>CAPACITY) throw new IndexOutOfBoundsException("Heap is full");
			
			heapNodes[size++] = heapNode;
			//adjust with parent node
			int i = size-1;
			
			while(i>0 && heapNodes[i].dist > heapNodes[getParentIndex(i)].dist){
				swap(i, getParentIndex(i));
			}
			
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
