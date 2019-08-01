package com.ppk.recursion;

import java.util.Stack;

/**
 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. 
 * <br>
 * When the stack becomes empty, insert all held items one by one at the bottom of the stack.
 * 
 * <br>
 * Requires two recursive functions for each operation
 * 
 * @author pkalekar
 *
 */
public class ReverseStackDemo {
	
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("Original Stack - "+stack);
		
		reverse();
		
		System.out.println("Reversed Stack - "+stack);
	}
	
	private static void reverse() {
		//first thing we need to do is to empty the stack and then store the items in reverse order

		//the first operation that we can do on the stack is to pop the top most item
		//stack.pop()
		//then pop the next item and so on, until the stack becomes empty
		// we are traversing from top -> bottom

		//1. since we are removing items until stack becomes empty, add condition to check if stack is empty
		//always handle the corner case i.e. what if stack is empty
		if(stack.empty())
			return;

		//2. until stack becomes empty, keep removing the items and holding them in function call stack
		int top = stack.pop();
		reverse();

		//3. when the last item is removed, we need a way to keep the bottom element at the top as we go on
		// when we reach here, we are getting values from bottom -> top
		//so we need to keep pushing at the bottom so that the old bottom is kept the top of stack
		insertAtBottom(top);
	}
	
	private static void insertAtBottom(int i) {
		//1. always handle the corner case i.e. what if stack is empty
		//Since we are inserting at the bottom, we just push the element when stack is empty
		if(stack.isEmpty()) {
			stack.push(i); 
			return;
		} 
		
		//now that we handled empty use case, what if there is one item in the list?
		//remove top and hold it in function call stack
		int temp = stack.pop();
		
		//keep inserting at bottom for rest of the stack
		insertAtBottom(i);

		//when we reach here, the new item will be pushed into the stack at the bottom
		//push the old item back on top
		stack.push(temp);
	}

}
