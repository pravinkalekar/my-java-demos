package com.ppk.sorting;

import java.util.Arrays;

/**
 * Heap Sort
 * <br>
 * Uses Heap Data Structure. So if we want to apply Heap Sort to an array of elements, we first need to convert the data into a Heap.
 * <br>
 * Heaps are binary trees (every node can have a max. of 2 nodes) with special properties -
 * <ul>
 * <li>Complete - completely filled in when reading from left to right across each row, though the last row may not be completely full</li>
 * <li>Parent node data is larger than the data contained in the child nodes (<b>Max Heap</b>)
 * <br> OR Parent node data is smaller than the data contained in the child nodes (<b>Min Heap</b>)</li>
 * </ul>
 * Max Heaps are used as <b>Priority Queue</b>, as the root element is always the largest.
 * <p>
 * Heaps can be represented in <b>Arrays</b> due to their first property. Elements are inserted in order. Array based representation is space efficient.
 * <p>
 * leftNodeIndex = 2 * parentIndex + 1;
 * <br>
 * rightNodeIndex = 2 * parentIndex + 2;
 * <p>
 * Time Complexity - <b>O(n log n)</b>
 * <br><br>
 * Note: Heap Sort using min heap sorts in descending order where as max heap sorts in ascending order
 * <br><br>
 * Applications of heap Sort - 
 * <ul>
 * <li>k largest(or smallest) elements in an array</li>
 * <li>sort a nearly sorted or k-sorted array</li>
 * </ul>
 * 
 * @author pkalekar
 */
public class HeapSortDemo {
	
	public static void main(String[] args) {
		
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println("Before - "+ Arrays.toString(arr));
		
		heapSort(arr);
		
		System.out.println("After - "+ Arrays.toString(arr));
		
	}
	
	/**
	 * Heap Sort using a Max Heap and the shiftDown or fixDown approach
	 * <p>
	 * FixDown approach is better than fixUp or bubbleUp approach as
	 * the leaf nodes are already considered in correct position in the array as
	 * they can not be moved further down.
	 * <br>
	 * So we need to fix only the other half elements
	 * <p>
	 * Build a heap in fixDown - O(n)
	 * <br>Build a heap in fixUp - O(n Log n)
	 * 
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
		int n = arr.length;
		
		//step1 - build the heap
		//If we consider 0 as starting index, then leaves starts from floor(n/2) and exist till end, i.e., (n-1).
		//In fixDown approach, we do not need to heapify leaf elements as they are already at the bottom
		//so, starting from non-leaf nodes in reverse order, we call heapify
		for(int i= n/2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		//step2 - remove root, replace it with the last element and heapify root
		for(int i = n-1; i >= 0; i--) {
			int root = arr[0];
			arr[0] = arr[i];
			arr[i] = root;	//put root the end
			
			heapify(arr, i, 0);
		}
	}
	
	
	/**
	 * The fixDown logic on the given array of given size with root at the given Index
	 * 
	 * @param arr	the entire array
	 * @param size	the array size
	 * @param indexToFix	the element index to fix
	 */
	private static void heapify(int[] arr, int size, int indexToFix) {
		
		
		int maxIndex = indexToFix;
		
		int leftIndex = 2 * indexToFix + 1;
		int rightIndex = 2 * indexToFix + 2;
		
		//remember to check if the leftNode exists
		//note not to use indexToFix but use maxIndex for comparison
		if(leftIndex < size && arr[leftIndex] > arr[maxIndex]) {
			maxIndex = leftIndex;
		}
		
		//remember to check if the rightNode exists
		//note not to use indexToFix but use maxIndex for comparison
		if(rightIndex < size && arr[rightIndex] > arr[maxIndex]) {
			maxIndex = rightIndex;
		}
		
		//Swap only if one of the child was greater
		if(maxIndex != indexToFix) {

			//Replace rootIndex element with maxIndex element
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[indexToFix];
			arr[indexToFix] = temp;

			//Recursively fixDown the tree from maxIndex where we just moved the root
			heapify(arr, size, maxIndex);
		}
	}
}