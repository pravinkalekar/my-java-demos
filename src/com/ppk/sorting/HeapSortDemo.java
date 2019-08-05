package com.ppk.sorting;

/**
 * Heap Sort
 * <br>
 * Uses Heap Data Structure. So if we want to apply Heap Sort to an array of elements, we first need to convert the data into a Heap.
 * <br>
 * Heaps are binary trees (every node can have a max. of 2 nodes) with special properties -
 * <br> 1. Complete - completely filled in when reading from left to right across each row, though the last row may not be completely full
 * <br> 2. Parent node data is larger than the data contained in the child nodes (<b>Max Heap</b>)
 * <br> OR Parent node data is smaller than the data contained in the child nodes (<b>Min Heap</b>)
 * <br><br>
 * Max Heaps are used as <b>Priority Queue</b>, as the root element is always the largest.
 * <br><br>
 * Heaps can be represented in <b>Arrays</b> due to their first property. Elements are inserted in order. Array based representation is space efficient.
 * <br><br>
 * leftNodeIndex = 2 * parentIndex + 1;
 * <br>
 * rightNodeIndex = 2 * parentIndex + 2;
 * <br>
 * <br>
 * Time Complexity - <b>O(n log n)</b>
 * <br><br>
 * Note: Heap Sort using min heap sorts in descending order where as max heap sorts in ascending order
 * <br><br>
 * Applications of heap Sort - k largest(or smallest) elements in an array
 * 
 * @author pkalekar
 */
public class HeapSortDemo {
	
	public static void main(String[] args) {
		//TODO
	}
}

/**
 * Implementation of heap using arrays
 * 
 * @author pkalekar
 *
 */
class Heap{
	
	private Integer[] heapData;
	private int currentPosition = -1;
	
	/**
	 * Algorithm -
	 * <br>1. Build a max heap from the input data.
	 * <br>2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
	 * <br>3. Repeat above steps while size of heap is greater than 1.
	 * 
	 */
	public static void heapSort() {
		//TODO
	}
	
	/**
	 * This method builds a heap from the given data array
	 * <br>
	 * Heapification must be performed in the bottom up order
	 * 
	 * @param data
	 * @return
	 */
	public static Heap heapify(int[] data) {
		//TODO
		return null;
	}
}