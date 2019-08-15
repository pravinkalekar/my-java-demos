package com.ppk.sorting;

import java.util.Arrays;

/**
 * 
 * Insetion Sort
 * <br>
 * Worst Case Time Complexity - <b>O(n^2)</b>
 * <br>
 * 
 * <b>Draw a card from deck, compare it with cards in hand, make space for it by shifting bigger cards to right</b>
 * 
 * <br>
 * 
 * 
 * @author pkalekar
 *
 */
public class InsertionSortDemo {
	
	private static void insertionSort(int[] data) {
		//first loop runs 4 times for 5 element array
		//consider this loop as if we have one card drawn from a deck at a time
		//every time we draw a new card, we compare it with cards in hand from top to bottom (reverse) order
		//and place the new card at a specific slot
		for (int i = 1; i < data.length; i++) {

			//hold i'th index item in temp location so that we can insert it at its right place in the array
			int current = data[i];
			//point another variable to i-1 index i.e. the top card in hand
			int j = i-1;
			//run second loop in reverse until either beginning of array or until we keep finding greater elements
			//i.e. loop if cards exists in hand and if there is a bigger card in hand
			while(j >= 0 && data[j]>=current) {
				//if greater elements are found, shift them to the end/right of array
				data[j+1]=data[j];
				//move loop pointer closer to the beginning of the array
				j = j-1;
			}
			//now either we are at the beginning of array or we have found the slot for i'th index item
			//but j points at one index left of expected slot so use j+1
			data[j+1]=current;
		}
	}	
	
	public static void main(String[] args) {
		int[] a = {4,3,6,4,43,1};

		System.out.println("Before - "+ Arrays.toString(a));

		insertionSort(a);

		System.out.println("After - "+ Arrays.toString(a));
	}

}
