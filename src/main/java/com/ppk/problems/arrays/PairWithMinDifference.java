package com.ppk.problems.arrays;

import java.util.Arrays;

public class PairWithMinDifference {
	
	public static void main(String[] args) {
		System.out.println("n^2 >");
		System.out.println("Expect [-2, -2] : " + Arrays.toString(findPairWithMinDifference(new int[] {4,3,-2,1,5}, new int[] {8,5,1,5,-2})));
		System.out.println("Expect [1, 1] : " + Arrays.toString(findPairWithMinDifference(new int[] {4,3,2,1,5}, new int[] {8,5,1,5,-2})));
		System.out.println("Expect [4, 5] : " + Arrays.toString(findPairWithMinDifference(new int[] {4,3,2,1,15}, new int[] {8,5,7,5,-2})));
		System.out.println("n log n >");
		System.out.println("Expect [5, 6] : " + Arrays.toString(findPairWithMinDifferenceV1(new int[] {4,3,2,1,5}, new int[] {8,7,9,6,-2})));
		System.out.println("Expect [1, 1] : " + Arrays.toString(findPairWithMinDifferenceV1(new int[] {4,3,2,1,5}, new int[] {8,5,1,5,-2})));
		System.out.println("Expect [4, 5] : " + Arrays.toString(findPairWithMinDifferenceV1(new int[] {4,3,2,1,15}, new int[] {8,5,7,5,-2})));
	}
	
	/**
	 * Find the pair of numbers one from each array with the minimum absolute difference
	 * <p>
	 * Time Complexity - O(n<sup>2</sup>)
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static int[] findPairWithMinDifference(int[] array1, int[] array2) {

		int[] result = new int[2];

		int minDiff = Integer.MAX_VALUE;

		for(int i = 0; i < array1.length; i++){

			for(int j = 0; j < array2.length; j++){

				int diff = Math.abs(array1[i] - array2[j]);

				if(diff < minDiff){
					minDiff = diff;
					result[0]=array1[i];
					result[1]=array2[j];
				}
			}
		}

		return result;
	}
	
	
	/**
	 * Find the pair of numbers one from each array with the minimum absolute difference
	 * <p>
	 * Time Complexity - O(n log n)
	 * <p>
	 * mlogm + nlogn + m + n ~= x log x
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static int[] findPairWithMinDifferenceV1(int[] array1, int[] array2) {
		
		//Sort the arrays
		Arrays.sort(array1);	// m log m
		Arrays.sort(array2);	//n log n
		
		int[] result = new int[2];
		int minDiff = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		
		while (i < array1.length && j < array2.length) {	// m+n
			
			if(minDiff > Math.abs(array1[i] - array2[j])) {
				minDiff = Math.abs(array1[i] - array2[j]);
				result[0]=array1[i];
				result[1]=array2[j];
			}
			
			if(array1[i] < array2[j]) {
				i++;
			}else {
				j++;
			}
			
		}
		
		return result;
	}

}
