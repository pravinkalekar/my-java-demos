package com.ppk.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph Representation in the form of Adjacency Lists
 * <br>
 * Uses simple <code>Integer</code> nodes and number of vertices in graph to initialize an Array of <code>LinkedList</code>s
 * 
 * @author pkalekar
 *
 */
public class GraphAdjacencyListsDemo {

	/**
	 * Demo Graph
	 * <br>
	 * <br>		0			  6
	 * <br>		|			/
	 * <br>		 1		  5	
	 * <br>	  /	   \	/ | \		
	 * <br>	4		  2	----- 7
	 * <br>	  \    /	\ | /
	 * <br>		 3		  8
	 * <br>	  /	   \
	 * <br>	10		9
	 * <br>
	 * <br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Graph graph = new Graph(11);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(2, 7);
		graph.addEdge(2, 8);
		graph.addEdge(4, 3);
		graph.addEdge(3, 9);
		graph.addEdge(3, 10);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(5, 8);
		graph.addEdge(7, 8);
		
		graph.printGraph();
		System.out.println("\nDFS -Iterative -");
		graph.traverseDFS(0);
		System.out.println("\nDFS - Recursive -");
		graph.traverseDFSRecursive(0);
		System.out.println("\nBFS - Iterative -");
		graph.traverseBFS(0);
		System.out.println("\nPath between 0 to 6 -");
		System.out.println("\n Exists - "+graph.hasPath(0, 6));
		System.out.println("\nPath between 0 to 99 -");
		System.out.println("\n Exists - "+graph.hasPath(0, 99));
		
		

	}
	
	static class Graph{
		
		int size;
		LinkedList<Integer>[] adjList;
		
		public Graph(int size) {
			
			this.size = size;
			adjList = new LinkedList[size];
			
			for (int i = 0; i < size; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int src, int dest) {
			adjList[src].add(dest);
			adjList[dest].add(src);	//this makes it a bidirectional graph
		}
		
		public void printGraph() {
			for (int i = 0; i < this.size; i++) {
				System.out.print("Adjacency List for Node "+i+" = ");
				System.out.println(adjList[i].toString());
				
			}
		}
		
		/**
		 * DFS Iterative using Stack
		 * 
		 * @param startVertex
		 */
		public void traverseDFS(int startVertex) {
			HashSet<Integer> visitedNodes = new HashSet<>();
			Stack<Integer> stack = new Stack<>();
			
			stack.add(startVertex);
			
			while(!stack.isEmpty()) {
				
				int node = stack.pop();
				
				if(visitedNodes.contains(node))
					continue;
				
				visitedNodes.add(node);
				System.out.print(node+"->");
				
				for(int neighbor : adjList[node]) {
					stack.add(neighbor);
				}
			}
		}
		
		/**
		 * DFS Recursive
		 * 
		 * @param startVertex
		 */
		public void traverseDFSRecursive(int startVertex) {
			
			HashSet<Integer> visitedNodes = new HashSet<>();
			
			traverseDFSRecursive(startVertex, visitedNodes);
		}
		
		private void traverseDFSRecursive(int startVertex, HashSet<Integer> visitedNodes) {
			
			if(visitedNodes.contains(startVertex))
				return;
			
			visitedNodes.add(startVertex);
			System.out.print(startVertex+"->");
			
			for(int neighbor : adjList[startVertex]) {
				traverseDFSRecursive(neighbor, visitedNodes);
			}
		}
		
		public void traverseBFS(int startIndex) {
			
			Queue<Integer> nodesToVisit = new LinkedList<>();
			HashSet<Integer> visitedNodes = new HashSet<>();
			
			nodesToVisit.add(startIndex);
			
			while(!nodesToVisit.isEmpty()) {
				
				int node = nodesToVisit.poll();
				
				if(visitedNodes.contains(node)) {
					continue;
				}
				
				visitedNodes.add(node);
				System.out.print(node+"->");
				
				for(int neighbor : adjList[node]) {
					nodesToVisit.add(neighbor);
				}
			}
		}
		
		/**
		 * Find path and return true if exists
		 * 
		 * @param src
		 * @param dest
		 * @return true if exists, false if path does not exist
		 */
		public boolean hasPath(int src, int dest) {
			
			Queue<Integer> nodesToVisit = new LinkedList<>();
			HashSet<Integer> visitedNodes = new HashSet<>();
			
			nodesToVisit.add(src);
			
			while(!nodesToVisit.isEmpty()) {

				int node = nodesToVisit.poll();

				if(visitedNodes.contains(node)) {
					continue;
				}

				visitedNodes.add(node);
				System.out.print(node+"->");

				if(node == dest) {
					return true;
				}

				for(int neighbor : adjList[node]) {
					nodesToVisit.add(neighbor);
				}

			}
			return false;
		}
		
	}

}
