package com.shekspeare.datastructures.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UGraph {
	
	private int V;
	private LinkedList<Integer>[] adjList;
	private List<LinkedList<Character>> adjLList;
	
	UGraph(int v){
		V = v;
		//adjList = new LinkedList[V];
		adjLList = new ArrayList<LinkedList<Character>>();
		/*for(int i=0;i<v;i++){
			adjList[i] = new LinkedList<Integer>();
		}*/
		
/*		for(int i=0;i<v;i++){
			adjLList.add(new LinkedList<Character>());
		}*/
	
	}
	
	void addEdge(char a, char b){
		
		if(null!= adjLList.get(a)){
			adjLList.get(a).add(b);
		}else{
			adjLList.add(new LinkedList<Character>());
		}
	}
	
	void addEdge(int v, int w){
		if(v<0 || w<0){
			throw new IllegalArgumentException("Vertex index cannot be less than 0");
		}
		if(v>adjList.length || w>adjList.length){
			throw new IllegalArgumentException("Vertex index cannot be greater than Graph size");
		}
		
		adjList[v].add(w);
		adjList[w].add(v);
	}
	
	void BFS(int s){
		
		//Check if s is valid
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList();
		
		queue.add(s);
		visited[s]= true;
		while(!queue.isEmpty()){
			int v = queue.poll();
			System.out.print(v);
			Iterator iter = adjList[v].iterator();
			while(iter.hasNext()){
				int x = (int) iter.next();
				
				if(!visited[x]){
					visited[x]=true;
					queue.add(x);
				}
			}
		
		}
		
	}
	
	
     
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UGraph g = new UGraph(4);
		 
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    
	    g.BFS(2);

	}

}
