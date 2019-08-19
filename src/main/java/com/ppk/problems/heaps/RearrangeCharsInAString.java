package com.ppk.problems.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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

		System.out.println("Expect ababacaba-  f(aaaaabbbc) - "+ rearrangeChars("aaaaabbbc"));
		System.out.println("Expect NA- f(aaaaaabbbc) - " + rearrangeChars("aaaaaabbbc"));
		
		System.out.println("Expect ababacaba-  f(aaaaabbbc) - "+ rearrangeCharsV1("aaaaabbbc"));
		System.out.println("Expect NA- f(aaaaaabbbc) - " + rearrangeCharsV1("aaaaaabbbc"));
		
	}
	
	/**
	 * Cleaner impl
	 * 
	 * @param input
	 */
	public static String rearrangeCharsV1(String input) {
		
		//Populate frequency map
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		//queue in reverse order comparator based on frequency
		PriorityQueue<Character> heap = new PriorityQueue<>((c1, c2) -> map.get(c2).compareTo(map.get(c1)));
		heap.addAll(map.keySet());
		
		Character prev = '#';
		StringBuilder builder = new StringBuilder();
		while(!heap.isEmpty()) {
			Character c = heap.poll();
			//add top freq element in the output and reduce its freq
			builder.append(c);
			map.put(c, map.get(c) - 1);
			
			//if prev char is left with positive freq, add it back into the heap
			if(map.containsKey(prev) &&  map.get(prev) > 0) {
				heap.add(prev);
			}
			
			//hold reference to current character so that we can add it back next time to avoid repetition
			prev = c;
		}
		String output = builder.toString();
		if(input.length() != output.length()) {
			return "NA";
		}else {
			return output;
		}
	}
	
	public static String rearrangeChars(String input) {
		
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
			return "NA";
		}else {
			return output;
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

