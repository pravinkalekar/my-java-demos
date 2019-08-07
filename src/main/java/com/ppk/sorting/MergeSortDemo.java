package com.ppk.sorting;

import java.util.Arrays;

/**
 * Merge Sort
 * 
 * <br>
 * Logically break down array into smaller arrays from the middle until we get single element arrays which we consider sorted
 * <br>
 * Then, start merging the arrays upwards
 * <br>
 * Note that we need two temporary arrays to hold left side and right side when we merge
 * <br>
 * We respectively need two temporary pointers for the temporary left and right arrays
 * <br><br>
 * Time Complexity - <b>O(n log n)</b>
 * <br><br>
 * Java Collections API used Merge Sort as its default algorithm
 * 
 * @author pkalekar
 *
 */
public class MergeSortDemo {
	
	
	public static void mergeSort(int[] array) {
		// ensure end pointer is one less than total length since its 0 based index
		mergeSort(array, 0, array.length-1);
	}
	
	/**
	 * @param array
	 * @param start the start element index
	 * @param end the last element index (not the total length of the array)
	 */
	public static void mergeSort(int[] array, int start, int end) {

		//breaking condition
		if(start == end) return;	//means that there is one element in the array which we consider as sorted

		int middle = Math.round((start + end)/2);	//Step 1 - find middle - imp - test calculation where start is other than 0

		mergeSort(array, start, middle);	//Step 2 - recursive call for left side array

		mergeSort(array, middle+1, end);	//Step 3 - recursive call for right side array - imp - middle+1

		merge(array, start, middle, end);	//Step 4 - first time it comes here when we have first two elements of array broken down as single element array, start=0, middle=0, end=1
	}
	
	/**
	 * Method which merges two sorted arrays by comparing one element at a time from each array
	 * <br>
	 * Note that we do not actually break down the array but use the start, middle and end indices to create temporary left and right arrays
	 * 
	 * @param array
	 * @param start
	 * @param middle
	 * @param end imp - end is the last element index, not the length of the array
	 */
	private static void merge(int[] array, int start, int middle, int end) {
		int sizeLeft = middle - start + 1;	// +1 is imp
		int sizeRight = end - middle;
		
		int[] left = new int[sizeLeft];
		int[] right = new int[sizeRight];
		
		for (int i = 0; i < sizeLeft; i++) {
			left[i] = array[start + i];	//do not forget to add start index into i, start is the offset
		}
		
		for (int i = 0; i < sizeRight; i++) {
			right[i] = array[middle + 1 + i];	//+1 is imp as right array start at middle+1 index
		}
		
		//so far created temp copies of left and right side arrays
		
		int i =0 ,j = 0;//these are used to point at the left and right temp array respectively
		
		//loop over entire part of array given to merge i.e. from start to end
		for (int k = start; k <= end; k++) {	// end is the last element index, not the length of the array so loop is <= end
			
			//handle if right array gets exhausted so that we can continue copying left side elements
			if(j>=sizeRight) {	//sizeRight is the length of right so >=
				array[k] = left[i];
				i++;
				continue;
			}
			
			//handle if left array gets exhausted so that we can continue copying right side elements
			if(i>=sizeLeft) {
				array[k] = right[j];
				j++;
				continue;
			}
			
			if(left[i]>right[j]) {
				//if left array element is greater, copy right element into main array
				array[k] = right[j];
				j++; 	//increment right pointer
			}else {
				//otherwise cope left element into main array
				array[k] = left[i];
				i++; 	//increment left pointer
			}
			
		}
			
	}

	public static void main(String[] args) {
		int[] array = {23, 5, 2, 8, 12, 7, 16, 9};
		
		System.out.println("Before - "+Arrays.toString(array));
		
		mergeSort(array);
		
		System.out.println("After - "+Arrays.toString(array));
	}

}
