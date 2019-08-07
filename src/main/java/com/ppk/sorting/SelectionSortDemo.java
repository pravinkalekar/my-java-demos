package com.ppk.sorting;

import java.util.Arrays;

/**
 * Selection Sort
 * <br>
 * Worst Case Time Complexity - <b>O(n^2)</b>
 * <br>
 * 
 * <b>Search smallest and bring it to the beginning</b>
 * 
 * <br>
 * In the Selection Sort algorithm what we do is that we search for the smallest element and swap it with the item in the first index
 * <br>
 * Notice that we need <b>two</b> temporary variables here, one to hold minIndex and the other for swaping
 * 
 * @author pkalekar
 *
 */
public class SelectionSortDemo {
	
	public static void selectionSort(int[] data) {
		//first loop runs for array length minus one i.e. 4 times for 5 element array
		for (int i = 0; i < data.length - 1; i++) {
			//imp = we need to track the INDEX of the minimum value element, not the value itself
			int minIndex = i;
			//second loop runs for i+1 to the end of the array
			for (int j = i+1; j < data.length; j++) {
				//compare next element with element at current minIndex
				//if next element is found to be smaller, change minIndex to next element's index
				if(data[j] <= data[minIndex]) minIndex = j;
			}
			//now that we have found the index of the element with minimum value, swap with i'th element
			int temp = data[i];
			data[i] = data[minIndex];
			data[minIndex] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {4,3,6,4,43,1};

		System.out.println("Before - "+ Arrays.toString(a));

		selectionSort(a);

		System.out.println("After - "+ Arrays.toString(a));
	}

}
