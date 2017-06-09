/**
 * 
 */
package com.shekspeare.datastructures.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author abashok
 *
 */
public class Graph {

	private int V; // number of Vertices
	private LinkedList<Integer> adjList[];

	Graph(int v) {

		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

	}

	void addUndirectedEdge(int v, int w) {
		if (v < 0 || w < 0  ) {
			throw new IllegalArgumentException("The vertex index cannot be less than 0");
		}
		if (v > adjList.length || w > adjList.length) {
			throw new IllegalArgumentException("Cannot add edge for non existent Vertex");
		}

		adjList[v].add(w);
		adjList[w].add(v);
	}
	
	void addDirectedEdge(int v, int w) {
		if (v < 0 || w < 0  ) {
			throw new IllegalArgumentException("The vertex index cannot be less than 0");
		}
		if (v > adjList.length || w > adjList.length) {
			throw new IllegalArgumentException("Cannot add edge for non existent Vertex");
		}

		adjList[v].add(w);
	}

	void BFS(int start) {

		boolean[] visited = new boolean[V];

		visited[start] = true;
		LinkedList<Integer> queue = new LinkedList();
		queue.add(start);

		while (!queue.isEmpty()) {
			int v = queue.poll();

			System.out.println(v);

			Iterator<Integer> iter = adjList[v].iterator();
			while (iter.hasNext()) {
				int x = (int) iter.next();
				if (!visited[x]) {
					visited[x] = true;
					queue.add(x);
				}

			}

		}

	}

	void DFS(int v, boolean[] visited) {

		System.out.print(v);
		visited[v] = true;

		Iterator iter = adjList[v].iterator();

		while (iter.hasNext()) {
			int x = (int) iter.next();
			if (!visited[x]) {
				DFS(x, visited);
			}
		}

	}

	void DFSNonRecursive(int v) {    // same as BFS, but use Stack instead of queue

		Stack<Integer> st = new Stack();
		boolean[] visited = new boolean[V];

		visited[v] = true;

		st.push(v);

		while (!st.isEmpty()) {
			int x = st.pop();
			System.out.println(x);

			Iterator iter = adjList[x].iterator();
			while (iter.hasNext()) {
				int y = (int) iter.next();
				if (!visited[y]) {
					visited[y] = true;
					st.push(y);
				}
			}
		}

	}


	void DFSNonRecursive_test(int v) {    // same as BFS, but use Stack instead of queue

		Stack<Integer> st = new Stack();
		boolean[] visited = new boolean[V];

		st.push(v);

		while (!st.isEmpty()) {
			int x = st.pop();
			
			if(visited[x]) continue;
			
			visited[x] = true;
			System.out.println(x);
			
			Iterator iter = adjList[x].iterator();
			while(iter.hasNext()){
				int y = (int) iter.next();
				st.push(y);

			}
			
			
		}	

	}
	
	

	void DFSUtilRecursive(int v) {
		boolean[] visited = new boolean[V];
		DFS(v, visited);

		// Do the following, if the graph is disconnected
		// basically do DFS from each node if it has not been visited
		// starting from all vertices one by one

		/*
		 * for (int i = 0; i < V; i++) if (visited[i] == false) DFS(i, visited);
		 */

	}
	
	
	//We can use DFS or BFS, but if it is a directed graph, only DFS is possible
	void detectUndirectedGraphCycle(){
		boolean[] visited = new boolean[V];
		
		
		for(int i=0; i < V; i++){
			if(!visited[i]){
				if(detectUndirectedGraphCycleUtil(i,visited,-1)){    //**PTR: Note the parent is -1
					System.out.println("There is a cycle");
					return;
				}
			}
		}
		
		System.out.println("No cycle detected");
	}
	
	boolean detectUndirectedGraphCycleUtil(int v, boolean[] visited, int parent){
		
		visited[v] = true;
		int u;
		
		Iterator<Integer> iter = adjList[v].iterator();
		while(iter.hasNext()){
			u = iter.next();
			if(!visited[u]){
				 if (detectUndirectedGraphCycleUtil(u,visited,v)){
					 return true;
				 }
			}else{   // this vertex is already visited, so check if it has been visited already from any other vertex
					 // that is not this vertex's parent, because that means it has a cycle (it means that there is another way to reach the parent that does
					 // not start from current node)
				if(parent!=u){
					return true;
				}
			}
		}
		
		return false;
	}
	

	
	//Can use DFS Only
	void detectDirectedGraphCycle(){
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		for(int v=0;v<V;v++){
			if(!visited[v]){
				if(detectDirectedGraphCycleUtil(v,visited,recStack)){
					System.out.print("Cycle detected");
					return;
				}
			}
		}
		
		System.out.print("No cycle detected");
	}
	
	
	boolean detectDirectedGraphCycleUtil(int v, boolean[] visited, boolean[] recStack){
		
		visited[v] = true;
		recStack[v] = true;
		
		int u;
		Iterator<Integer> iter = adjList[v].iterator();
		while(iter.hasNext()){
			u = iter.next();
			if(!visited[u]){
				if(detectDirectedGraphCycleUtil(u, visited, recStack)){
					return true;
				}
			}else{                 //**PTR: put this inside else, because we want to check the recstack only if the above if condition fails
				if(recStack[u]){  /// this means that this vertex is still being visited by another node (grey color); indicates cycle
					return true;
				}
			}
		}
		
		recStack[v] = false;   //once all its neighbours are tested, remove it from stack (black color)
		return false;
	}

	// It is DFS only
	void topologicalSort(int v, boolean[] visited, Stack stack){

		visited[v] = true;
		Iterator iter = adjList[v].iterator();
		while(iter.hasNext()){
			int w = (int) iter.next();
			if(!visited[w]){
				topologicalSort(w,visited,stack);
			}
			
		}
		
      //Once all vertices are visited, push it to stack 
			stack.push(v);

	}
	 
	void topologicalSortUtil(){
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		//calling from all vertices one by one
		for (int i = 0; i < V; i++){ 
			
            if (visited[i] == false){
            	topologicalSort(i, visited, stack);
            }

		}
		//print contents of stack  
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}
	
	//It is basically BFS....but at each step check the color of the current node's neighbors
	boolean isBipartite(int[] color, int v, boolean[] visited){
		
		LinkedList<Integer> queue = new LinkedList<Integer>();		
		queue.add(v);
		color[v] = 0;
		
		while(!queue.isEmpty()){
			int w = queue.pop();
			visited[w] = true;
			
			Iterator iter = adjList[w].iterator();
			while(iter.hasNext()){
				int x = (int) iter.next();
				//first check if it is not colored. If not, color it
				if(color[x]==-1){
					color[x] = Math.abs(1-color[w]);     //is Math.abs necessary?  Probably not  1- color[w] is sufficient
				}
				
				//if it has the same color as the predecessor, return false
				if(color[x]==color[w]){
					return false;
				}
				
				// at this point, it is colored with a different color of predecessor
				// so add it to queue and continue with BFS, 
				if(!visited[x]){
					queue.add(x);
				}
				
			}
			
			
		}
		
		return true;
	}
	
	void biPartiteTestUtil(){
		
		int[] color = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++){
			color[i] = -1;
		}
		
		if(isBipartite(color, 0, visited)){
		 System.out.println("Graph is bipartite.. as follows");
		 for(int x=0; x<V;x++){
			 System.out.println(color[x]);
		 }
		}else{
			System.out.println("Graph is not bipartite");
		}
	}
	
	void sccFillStackDFSUtil(int v, boolean[] visited, Stack<Integer> stack){
		
		visited[v] = true;
		Iterator iter = adjList[v].iterator();
		int w;
		while(iter.hasNext()){
			w = (int) iter.next();
			if(!visited[w]){
				sccFillStackDFSUtil(w,visited,stack);
			}
		}
		
		stack.push(new Integer(v));
	}
	
	void sccPerformDFSUtil(int v, boolean[] visited){
		
		visited[v] = true;
		System.out.print(v+" ");
		
		Iterator<Integer> iter = adjList[v].iterator();
		int w;		
		while(iter.hasNext()){
			w = (int) iter.next();
			if(!visited[w]){
				sccPerformDFSUtil(w,visited);
			}
		}		
	}
	
	Graph reverseGraph(){
		
		Graph graph = new Graph(V);   //**PTR - This is a new copy of the graph.
		int w;
		
		for(int i=0;i<V;i++){
			Iterator iter = adjList[i].iterator();
			while(iter.hasNext()){
				w = (int) iter.next();
				graph.addDirectedEdge(w,i);
			}
		}
		
		return graph;
	}
	

	
	//This uses Kosaraju's Algorithm
	void printStronglyConnectedComponents(){
		//STEP 1:
		//Perform DFS on a graph 
		//While doing DFS add vertex to a STACK when all its children are visited
		
		//STEP 2:
		//In the end, reverse the Graph and clear the visited array
		
		//STEP 3:
		//Perform DFS on reversed graph starting by popping each vertex from the stack created above
		
		boolean[] visited = new boolean[V];
		Stack <Integer> stack = new <Integer> Stack();
		
		//Step 1 
		  for (int i = 0; i < V; i++){
	            if (visited[i] == false){
	            	 sccFillStackDFSUtil(i, visited, stack);
	            }
	            	
		  }
	    
	    //Step 2
	    for(int i=0;i<V;i++){
	    	visited[i] = false;
	    }
		Graph graph = reverseGraph();
		
		//Step 3
		while(!stack.isEmpty()){
			int v = stack.pop();
			if(!visited[v]){
				graph.sccPerformDFSUtil(v,visited);
				System.out.println();
			}
		}

	}
	
	
	
	
	public static void main(String args[]) {

		Graph g = new Graph(4);

		
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(2, 0);
//        g.detectUndirectedGraphCycle();
		g.detectUndirectedGraphCycle();
	}
}
