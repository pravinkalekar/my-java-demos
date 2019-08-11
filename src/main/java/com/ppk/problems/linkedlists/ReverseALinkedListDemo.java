package com.ppk.problems.linkedlists;

import com.ppk.problems.linkedlists.LinkedList.Node;

public class ReverseALinkedListDemo {
	
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.head = new Node(1);
		linkedList.head.next = new Node(2);
		linkedList.head.next.next = new Node(3);
		linkedList.head.next.next.next = new Node(4);
		
		linkedList.printList();
		System.out.println("Reversing iteratively-");
		linkedList.reverseList();
		linkedList.printList();
		System.out.println("Reversing recursively-");
		linkedList.reverseListRecursive();
		linkedList.printList();
	}

}

class LinkedList{
	Node head;
	
	static class Node{
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println();
			
	}

	public void reverseList() {
		
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current != null) {
			
			next = current.next;	//keep a reference to next node before updating current node's next pointer
			current.next = prev;	//update current node's next pointer to prev node
			prev = current;		//increment prev to current
			current = next;		//increment current to next where we kept the next node reference in step 1
		}
		
		head = prev;	//finally, loop breaks when current points to null and prev pointing to last node which now becomes the head of the list
	}
	
	
	/**
	 * Recursive Reversal
	 * <p>
	 * Logic is to -
	 * <br>1. break the list into two parts - first node and rest of the nodes
	 * <br>2. call reverse on the rest of the nodes
	 * <br>3. Break the loop when rest becomes null, change head to point to last node
	 * <br>4. Finally keep pointing rest node to first node and first node to null
	 */
	public void reverseListRecursive() {
		reverseListRecursive(head, head.next);
	}
	
	private void reverseListRecursive(Node first, Node rest) {
		
		//breaking condition
		if(rest == null) {
			head = first;
			return;
		}
		
		reverseListRecursive(rest, rest.next);
		
		rest.next = first;
		first.next = null;
	}
	
}














