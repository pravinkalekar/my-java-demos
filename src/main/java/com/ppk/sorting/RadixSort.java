package com.ppk.sorting;

import java.util.Arrays;

/**
 * Radix Sort
 * <p>
 * Radix is also known as base for a given number system.
 * <p>
 * Radix/Base for decimal numbers is 10 (0-9)
 * <br>
 * Radix/Base for Binary Numbers is 2 (0-1)
 * 
 * @author pkalekar
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] a = {403,115,86,4,743,1000};

		System.out.println("Before - "+ Arrays.toString(a));

		radixSort(a);
		
		System.out.println("After - "+ Arrays.toString(a));
		
		
		a= new int[] {170, 45, 75, 90, 802, 24, 2, 66};
		System.out.println("Before - "+ Arrays.toString(a));
		
		radixSort(a);
		
		System.out.println("After - "+ Arrays.toString(a));
	}
	
	/**
	 * Radix Sort
	 * <p>
	 * Logic -
	 * <br>
	 * Find the maximum number so that we can find out the max number of digits.
	 * <br>
	 * Loop over to sort the array from lowest significant digit to highest significant digit using Count Sort.
	 * 
	 * @param arr
	 */
	public static void radixSort(int[] arr) {
		
		int max = Arrays.stream(arr).max().getAsInt();
		
		for(int i = 1; max/i > 0; i *= 10) {
			countSort(arr, i);
		}
	}

	/**
	 * Modified Count Sort
	 * <p>
	 * Does counting sort but takes an exponent to divide and find each digits in the original numbers
	 * 
	 * @param arr
	 * @param exp
	 */
	public static void countSort(int[] arr, int exp) {
		
		int[] counts = new int[10];	//array to store digit counts for decimal numbers
		int[] output = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			//first find the reduced number by arr[i]/exp and then do modulo 10
			counts[ (arr[i]/exp) % 10 ]++;
		}
		
		//for stable sort - determine actual positions
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
		
		for (int i = output.length - 1; i >= 0 ; i--) {
			output[counts[ (arr[i]/exp) %10 ] - 1] = arr[i];	//fill as per original arr into diff positions in outout array
			counts[ (arr[i]/exp) %10 ]--;	//this is to place duplicate numbers correctly
		}
		
		for (int i = 0; i < output.length; i++) {
			arr[i] = output[i];
		}
		
	}
}
