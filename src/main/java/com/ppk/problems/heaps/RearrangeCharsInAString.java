package com.ppk.problems.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Problem Statement -
 * <p>
 * Rearrange characters in a string such that no two adjacent characters are same
 * <br>
 * Assume that characters in a string are english lowercase characters
 * <br>
 * E.g.1. aaabc -> abaca
 * <br>
 * E.g.2. aaaabc -> NA
 * <p>
 * Logic -
 * <br>
 * We can use a <b>priority queue or heap</b> to store the unique characters in the string based on their frequency in the string.
 * Thus, the character with the highest frequency would be stored at the root of heap.
 * <br> Logic is to process (pop, print, reduce freq) the root and hold a reference to it.
 * While the next highest freq element is processed (pop, print, reduce freq) in the next iteration, 
 * we add the previous node back if it is still left with a non-zero freq.
 * <br> This way, each element gets processed as per its frequency and no same element gets processed consecutively.
 * <br> In the end, we need to check the size of result vs. the input string and if same, we have the expected result.
 * <p>
 * Time complexity : O(n)
 * 
 * @author pkalekar
 *
 */
public class RearrangeCharsInAString {

	public static void main(String[] args) {

		String input = "aaaaabbbc";
		
		System.out.println("Input - "+input);
		System.out.print("Output - ");
		rearrangeChars(input);
		
		input = "aaaaaabbbc";
		
		System.out.println("Input - "+input);
		System.out.print("Output - ");
		rearrangeChars(input);
		
	}
	
	private static void rearrangeChars(String input) {
		
		//Calculate character frequencies using a Map
		HashMap<Character, Node> nodes = new HashMap<>();
		for(char c : input.toCharArray()) {
			if(nodes.containsKey(c)) {
				Node node = nodes.get(c);
				node.freq++;
				nodes.put(c, node);
			}else {
				Node node = new Node(1, c);
				nodes.put(c, node);
			}
		}
		
//		System.out.println(nodes);
		
		// Build a Max Heap
		//Priority Queue is by default a Min Heap (The head of this queue is the least element with respect to the specified ordering.)
		//So we have given a reverse comparator
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());
		priorityQueue.addAll(nodes.values());
		
//		System.out.println(priorityQueue);

		//temporary node to hold the char value which was recently added to output to avoid consecutive occurrence
		Node prev = new Node(-1, '#');
		
		StringBuilder buffer = new StringBuilder();
		
		while(!priorityQueue.isEmpty()) {

			//Poll max freq char and add it to output
			Node current = priorityQueue.poll();
			buffer.append(current.c);
			
			//Since the current char is added to output once, reduce its freq by 1
			current.freq--;
			
			// Add the previous node back into the heap if it is still left with >0 freq 
			if(prev.freq > 0) {
				priorityQueue.add(prev);
			}
			
			//Hold the a reference to the current node which is for now removed from heap
			prev = current;
		}
		
		String output = buffer.toString();
		if(input.length() != output.length()) {
			System.out.println("NA");
		}else {
			System.out.println(output);
		}
		
	}

	static class Node{
		int freq;
		char c;
		public Node(int freq, char c) {
			super();
			this.freq = freq;
			this.c = c;
		}
		
		@Override
			public String toString() {
				return "Node("+c+", "+freq+")";
			}
	}
	
	static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {

			//reverse comparator
			int diff = o2.freq - o1.freq; //ideally we calculate o1 - o2, but since we want a Max Heap
			
			//we could return the diff itself
			if(diff < 0)
				return -1;
			
			if(diff > 0)
				return 1;
			
			return 0;
		}
		
	}

}

