package com.ppk.sorting;

import java.util.Arrays;

/**
 * Bubble Sort
 * <br>
 * Worst Case Time Complexity - <b>O(n^2)</b>
 * <br>
 * 
 * <b>Compare adjacent pairs</b>
 * 
 * <br>
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list to be sorted, 
 * compares each pair of adjacent items and swaps them if they are in the wrong order. 
 * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.
 * 
 * @author pkalekar
 *
 */
public class BubbleSortDemo {

	
	public static void bubbleSort(int[] data) {
		//first loop runs for array length minus one i.e. 4 times for 5 element array
		for (int i = 0; i < (data.length -1) ; i++) {
			//second loop runs for i less than first loop
			for (int j = 0; j < (data.length -1) - i ; j++) {
				if(data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {4,3,6,4,43,1};
		
		System.out.println("Before - "+ Arrays.toString(a));
		
		bubbleSort(a);
		
		System.out.println("After - "+ Arrays.toString(a));
	}
	
}
