package com.ppk.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph Representation in the form of Adjacency Lists
 * <br>
 * Uses a custom class <code>Node</code> to represent Graph vertices.
 * <br> 
 * Each Node maintains its neighboring nodes in the form of a <code>LinkedList</code>.
 * 
 * @author pkalekar
 *
 */
public class GraphNodeDemo {

	/**
	 * Demo Graph
	 * <br>
	 * <br>					  6
	 * <br>					/
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

		Graph graph = new Graph();
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
		
		System.out.println("DFS Recursive - ");
		System.out.println("\nExpect true - hasPathDFS(1, 6) - " + graph.hasPathDFS(1, 6));
		System.out.println("\nExpect true - hasPathDFS(1, 10) - " + graph.hasPathDFS(1, 10));
		System.out.println("\nExpect true - hasPathDFS(1, 1) - " + graph.hasPathDFS(1, 1));
		System.out.println("\nExpect false - hasPathDFS(1, 0) - " + graph.hasPathDFS(1, 0));
		
		System.out.println("\nDFS Using Stack - Iterative - ");
		System.out.println("\nExpect true - hasPathDFSUsingStack(1, 6) - " + graph.hasPathDFSUsingStack(1, 6));
		System.out.println("\nExpect true - hasPathDFSUsingStack(1, 10) - " + graph.hasPathDFSUsingStack(1, 10));
		System.out.println("\nExpect true - hasPathDFSUsingStack(1, 1) - " + graph.hasPathDFSUsingStack(1, 1));
		System.out.println("\nExpect false - hasPathDFSUsingStack(1, 0) - " + graph.hasPathDFSUsingStack(1, 0));
		
		System.out.println("\nBFS - Iterative -");
		System.out.println("\nExpect true - hasPathBFS(1, 6) - " + graph.hasPathBFS(1, 6));
		System.out.println("\nExpect true - hasPathBFS(1, 10) - " + graph.hasPathBFS(1, 10));
		System.out.println("\nExpect true - hasPathBFS(1, 1) - " + graph.hasPathBFS(1, 1));
		System.out.println("\nExpect false - hasPathBFS(1, 0) - " + graph.hasPathBFS(1, 0));
		
		System.out.println("\nShorted Path - BFS - Iterative -");
		System.out.println("\nExpect true - shortestPath(1, 6) - " + graph.shortestPath(1, 6));
		System.out.println("\nExpect true - shortestPath(1, 10) - " + graph.shortestPath(1, 10));
		System.out.println("\nExpect true - shortestPath(6, 10) - " + graph.shortestPath(6, 10));
		System.out.println("\nExpect true - shortestPath(6, 4) - " + graph.shortestPath(6, 4));
		System.out.println("\nExpect true - shortestPath(1, 1) - " + graph.shortestPath(1, 1));
		System.out.println("\nExpect false - shortestPath(1, 0) - " + graph.shortestPath(1, 0));
		
		
	}
	
}

class Graph{
	
	HashMap<Integer, Node> nodes = new HashMap<>();
	
	public Node getNode(int id) {
		nodes.put(id, nodes.getOrDefault(id, new Node(id)));
		return nodes.get(id);
	}
	
	public void addEdge(int source, int dest) {
		Node src = getNode(source);
		Node dst = getNode(dest);
		src.neighbours.add(dst);
		dst.neighbours.add(src);	//this makes it a bidirectional graph
	}
	
	
	/**
	 * Check if a path exists between two nodes
	 * <br>
	 * Depth First Search Implementation - Recursive
	 * <br>
	 * We go deep first instead of visiting other neighbors
	 * 
	 * @param source
	 * @param dest
	 * @return
	 */
	public boolean hasPathDFS(int source, int dest) {
		
		Node src = getNode(source);
		Node dst = getNode(dest);
		HashSet<Integer> visitedNodes = new HashSet<>();
		
		return hasPathDFS(src, dst, visitedNodes);
	}
	
	private boolean hasPathDFS(Node source, Node dest, HashSet<Integer> visitedNodes) {

		//if we already have visited the source node, the path does not exists so return false
		if(visitedNodes.contains(source.getId())) {
			return false;
		}

		//add source to visited list
		visitedNodes.add(source.getId());
		System.out.print(source.getId()+"->");

		//if we have reached the destination, return true as path exists
		if(source.getId() == dest.getId()) {
			return true;
		}

		//else visit its neighbors and if path exists, return true
		for (Node node : source.neighbours) {
			if(hasPathDFS(node, dest, visitedNodes)) {
				return true;
			}
		}
		//we could not find any path
		return false;
	}
	
	/**
	 * Check if a path exists between two nodes
	 * <br>
	 * Breadth First Search Implementation - Iterative
	 * <br>
	 * Uses a queue to maintain neighbor nodes or the next nodes to visit
	 * 
	 * @param source
	 * @param dest
	 * @return
	 */
	public boolean hasPathBFS(int source, int dest) {
		
		Node src = getNode(source);
		Node dst = getNode(dest);
		
		return hasPathBFS(src, dst);
	}
	
	private boolean hasPathBFS(Node source, Node dest) {
		
		Queue<Node> queue = new LinkedList<>();
		HashSet<Integer> visitedNodes = new HashSet<>();
		
		queue.add(source);
		
		while(!queue.isEmpty()) {
			//remove one by one
			Node node = queue.poll();
			
			//ignore the already visited nodes from the queue as it now removed from the queue
			if(visitedNodes.contains(node.getId())) {
				continue;
			}
			
			//mark visited
			visitedNodes.add(node.getId());
			System.out.print(node.getId()+"->");
			
			//if reached dest, return true as path exists
			if(node.getId() == dest.getId()) {
				return true;
			}
			
			//else, add all neighbors in queue
			for(Node child : node.neighbours) {
				queue.add(child);
			}
		}
		return false;
	}
	
	
	/**
	 * Check if a path exists between two nodes
	 * <br>
	 * Depth First Search Implementation - Using Stack - Iterative
	 * <br>
	 * We go deep first instead of visiting other neighbors
	 * <br>
	 * Uses a Stack 
	 * 
	 * @param source
	 * @param dest
	 * @return
	 */
	public boolean hasPathDFSUsingStack(int source, int dest) {
		Node src = getNode(source);
		Node dst = getNode(dest);
		
		Stack<Node> stack = new Stack<>();
		HashSet<Integer> visitedNodes = new HashSet<>();
		
		stack.add(src);
		
		while(!stack.isEmpty()) {
			
			Node node = stack.pop();
			
			if(visitedNodes.contains(node.getId())) {
				continue;
			}
			
			visitedNodes.add(node.getId());
			System.out.print(node.getId()+"->");
			
			if(node.getId() == dst.getId()) {
				return true;
			}
			
			for(Node child : node.neighbours) {
				stack.add(child);
			}
			
		}
		return false;
	}
	
	
	/**
	 * Find shortest path and return true if exists
	 * <br>
	 * Uses modified BFS to calculate the distances and predecessor node references while traversing from dest.
	 * <br>
	 * Then back-tracks the shortest distance path from src to dest using predecessor nodes
	 * 
	 * @param src
	 * @param dest
	 * @return true if exists, false if path does not exist
	 */
	public boolean shortestPath(int src, int dest) {
		
		Node srcNode = getNode(src);
		Node destNode = getNode(dest);
		
		HashSet<Integer> visitedNodes = new HashSet<>();
		
		return shortestPath(srcNode, destNode, visitedNodes);
		
	}
	
	private boolean shortestPath(Node src, Node dest, HashSet<Integer> visitedNodes) {
		
		Queue<Node> nodesToVisit = new LinkedList<>();
		dest.distance = 0;
		dest.predecessor = null;
		visitedNodes.add(dest.getId());
		nodesToVisit.add(dest);
		
		while(!nodesToVisit.isEmpty()) {

			Node node = nodesToVisit.poll();

			for(Node neighbor : node.neighbours) {
				
				if(!visitedNodes.contains(neighbor.getId())) {
					visitedNodes.add(neighbor.getId());
					neighbor.distance = node.distance + 1;
					neighbor.predecessor = node;
					nodesToVisit.add(neighbor);
					
					if(neighbor.getId() == dest.getId())
						break;
				}
			}
		}
		Node current = src;
		while(current != null) {
			System.out.print(current.getId()+"->");
			current = current.predecessor;
		}
		System.out.print("\nPath Length - "+ src.distance);
		if(src.getId()!= dest.getId() && src.predecessor == null)
			return false;
		else
			return true;
	}
}

class Node{
	/**
	 * Unique ID for the node
	 */
	private int id;
	
	int distance;
	Node predecessor;
	
	/**
	 * Adjacent or neighbor nodes
	 */
	LinkedList<Node> neighbours = new LinkedList<>();
	
	public Node(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}