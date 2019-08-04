package com.ppk.sorting;

import java.util.Arrays;

/**
 * Quick Sort
 * <br>
 * Pretty Fast Algorithm but takes O(n^2) in worst case
 * <br>
 * Why use it?
 * <br>
 * We use it as it is found that on an average it takes O(n log n) which is same as Merge Sort algorithm.
 * <br>
 * Merge sort has more space complexity as compared to Quick Sort, as Merge sort takes O(n) spaces.
 * <br>
 * That is, for an array of size n, Merge sort creates temporary array of size n.
 * <br>
 * Quick Sort performs better than Merge Sort in most cases.
 * 
 * <br>
 * Worst Case Time Complexity - O(n^2)
 * <br>
 * Average Case Time Complexity - O(n log n)
 * 
 * @author pkalekar
 *
 */
public class QuickSortDemo {
	
	public static void main(String[] args) {
		int[] array = {23, 5, 2, 8, 12, 7, 16, 9};

		System.out.println("Before - "+Arrays.toString(array));

		quickSort(array);

		System.out.println("After - "+Arrays.toString(array));
	}

	public static void quickSort(int[] array) {
		
		quickSort(array, 0, array.length-1);
		
	}

	private static void quickSort(int[] array, int startIndex, int endIndex) {

		//breaking condition
		if(startIndex >= endIndex) return;
		
		//partition the array
		int pivot = partition(array, startIndex, endIndex);
		
		//recursive calls on left and right arrays excluding pivot element
		quickSort(array, startIndex, pivot-1);
		quickSort(array, pivot+1, endIndex);
	}

	/**
	 * Idea is to partition the array in such a way that elements on the left of chosen PIVOT element are smaller than pivot
	 * and elements on the right side of pivot are greater than pivot (though not in sorted order)
	 * 
	 * <br>
	 * Convention is to choose the lastIndex element as our PIVOT, declare one variable to keep track of pivot point while looping
	 * <br>
	 * then we loop through the array from start to pivot-1
	 * <br>
	 * We bring smaller than pivot element towards start and every time we do it, we increment pivot pointer
	 * <br>
	 * At the end of the loop, we get our pivot pointer, we swap elements at pivot pointer and chosen pivot element (last element)
	 * <br>
	 * Finally return the new partition pointer i.e. pivot pointer
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int partition(int[] array, int startIndex, int endIndex) {

		//start with pivot as last element of the array
		int pivotElement = array[endIndex];
		
		//IMP - use startIndex, not 0
		int pivotPointer = startIndex; // will end up holding the pivot index end by the end of loop
		
		//IMP - remember to use startIndex to initialize j, not 0
		for (int j = startIndex; j < endIndex -1; j++) {	//all but pivot element, so one less
			if(array[j] < pivotElement) { 
				int temp = array[j];
				array[j] = array[pivotPointer];
				array[pivotPointer] = temp;
				pivotPointer++;
			}
		}
		
		//swap chose pivot element 
		int temp = array[pivotPointer];
		array[pivotPointer] = array[endIndex];
		array[endIndex] = temp;
		
		return pivotPointer;
	}

}
