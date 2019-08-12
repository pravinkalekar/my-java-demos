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
 * In the Selection Sort algorithm what we do is that we search for the smallest element 
 * and swap it with the item in the first index
 * <br>
 * Notice that we need <b>two</b> temporary variables here, one to hold minIndex 
 * and the other for swaping
 * 
 * @author pkalekar
 *
 */
public class SelectionSortDemo {
	
	/**
	 * Not Stable
	 * <p>
	 * Does not maintain the same order of the two equal elements
	 * 
	 * <p>
	 * Time Complexity - <b>O(n^2)</b>
	 * 
	 * @param data
	 */
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
	
	/**
	 * Stable Version
	 * <p>
	 * Maintain the same order of the two equal elements by shifting all the elements towards right 
	 * before placing the min element at the beginning 
	 * 
	 * <p>
	 * Time Complexity - <b>O(n^2)</b>
	 * @param data
	 */
	public static void selectionSortStable(int[] data) {
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
			//now that we have found the index of the element with minimum value, make space for i'th element
			int minValue = data[minIndex];	//keep hold of value at minIndex before we start shifting elements right
			while(minIndex > i) {
				data[minIndex] = data[minIndex -1];
				minIndex--;
			}
			data[i] = minValue; 
		}
	}
	
	public static void main(String[] args) {
		int[] a = {4,3,6,4,43,1};

		System.out.println("Before - "+ Arrays.toString(a));

		selectionSort(a);

		System.out.println("After - "+ Arrays.toString(a));
		
		a = new int[]{4,3,6,4,43,1};
		
		System.out.println("Before - "+ Arrays.toString(a));

		selectionSortStable(a);

		System.out.println("After - "+ Arrays.toString(a));
	}

}
