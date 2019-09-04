package com.ppk.problems.linkedlists;

/**
 * Add two numbers represented as Linked Lists with head pointing to the least significant digit in the number
 * <br>
 * Return the sum of two numbers represented as a Linked List with the head pointing to the least significant digit
 * <p>E.g.
 * <br>List1 -> 2->4->3
 * <br>List2 -> 5->6->7
 * <br>Result -> 7->0->1->1
 * 
 * @author pkalekar
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		System.out.print("List1 - ");
		printList(l1);
		
		System.out.print("List2 - ");
		printList(l2);
		
		ListNode result = addTwoNumbers(l1, l2);
		System.out.print("First Attempt - ");
		printList(result);
		
		result = addTwoNumbersCleaner(l1, l2);
		System.out.print("Cleaner code - ");
		printList(result);
		
//		result = addTwoNumbersRecursive(l1, l2);
//		System.out.print("Recursive - ");
//		printList(result);
		
		System.out.println();
		
		l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		
		System.out.print("List1 - ");
		printList(l1);
		
		System.out.print("List2 - ");
		printList(l2);
		
		result = addTwoNumbers(l1, l2);
		System.out.print("First Attempt - ");
		printList(result);
		
		result = addTwoNumbersCleaner(l1, l2);
		System.out.print("Cleaner code - ");
		printList(result);
		
//		result = addTwoNumbersRecursive(l1, l2);
//		System.out.print("Recursive - ");
//		printList(result);
	}

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = null, current = null;
		int carry = 0;
		while(l1 != null || l2 != null){	//while there are elements in either of the lists
			int sum = 0;

			int n1 = 0;
			int n2 = 0;

			if(l1 != null){
				n1 = l1.val;
				l1 = l1.next;
			}

			if(l2 != null){
				n2 = l2.val;
				l2 = l2.next;
			}

			sum = n1 + n2 + carry;

			if(sum >= 10){
				carry = 1;
			}else{
				carry = 0;
			}

			if(current == null){
				current = new ListNode(sum%10);
				result = current;
			}
			else{
				current.next = new ListNode(sum%10);
				current = current.next;
			}


		}
		if(carry == 1){
			current.next = new ListNode(1);
		}

		return result;
	}
	
	
	public static ListNode addTwoNumbersCleaner(ListNode l1, ListNode l2) {
		
		int sum = 0;
		ListNode current = new ListNode(0);	//pre-created node
		ListNode result = current;
		while(l1 != null && l2 != null || sum!=0) {
			
			if(l1 != null) sum += l1.val;	//add carry and first number if exists
			if(l2 != null) sum += l2.val;	//add carry and second number if exists
			
			current.next = new ListNode(sum%10);	//append new node
			current = current.next;		//make new node current
			
			sum /= 10;	//holds carry for next iteration
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		
		return result.next;	//remove the temp node 0 added at the beginning
		
	}
	

	
	/**
	 * 
	 * WORK IN PROGRESS - NOT FUNCTIONAL
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(0);
		head.next = addTwoNumbersRecursiveInternal(l1, l2);
		if(head.next.val > 9) {
			head.val = head.next.val/10;
			head.next.val = head.next.val%10;
			return head;
		}
		return head.next;
	}
	
	private static ListNode addTwoNumbersRecursiveInternal(ListNode l1, ListNode l2) {
		
		if(l1 == null & l2 == null)	return null;
		
		ListNode left = new ListNode(l1.val + l2.val);
		ListNode right = (l1 == null) ? addTwoNumbersRecursiveInternal(l1, l2.next) : addTwoNumbersRecursiveInternal(l1.next, l2);
		
		if(right != null && right.val > 9) {
			left.val += right.val/10;
			right.val = right.val%10;
		}
		
		left.next = right;
		return left;
	}
	
	/**
	 * 
	 * WONT WORK FOR BIG NUMBERS
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {
		long sum = 0;
		ListNode result = null;

		long index = 1;
		ListNode current = l1;
		while(current != null){
			sum += current.val * index;
			index = index*10;
			current = current.next;
		}

		index = 1;
		current = l2;
		while(current != null){
			sum += current.val * index;
			index = index*10;
			current = current.next;
		}

		if(sum == 0){
			result = new ListNode(0);
			return result;
		}


		for(long exp = 1; sum/exp > 0; exp *= 10){
			int digit = (int) ((sum/exp) % 10);   
			ListNode node = new ListNode(digit);

			if(exp == 1) {
				result = node;
				current = node;
			}else{
				current.next = node;
				current = node;
			}
		}
		return result;
	}


	//	  Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void printList(ListNode node) {
		ListNode current = node;
		while(current != null) {
			System.out.print(current.val+"->");
			current = current.next;
			
		}
		System.out.println();
	}

}
