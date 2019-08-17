package com.ppk.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Best Solution Time Complexity - O(n)
 * 
 * @author pkalekar
 *
 */
public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1,2,4,1,2));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(4,7,2,8,6));
		System.out.println("Expect 2: "+countPairsFromListsWithGivenSumV1(list1, list2, 4));
		System.out.println("Expect 2: "+countPairsFromListsWithGivenSumV2(list1, list2, 4));
		System.out.println("Expect 2: "+countPairsFromListsWithGivenSumV3(list1, list2, 4));
		list1 = new LinkedList<>(Arrays.asList(11,12,14,7,23));
		list2 = new LinkedList<>(Arrays.asList(2,7,3,8,6));
		System.out.println("Expect 3: "+countPairsFromListsWithGivenSumV1(list1, list2, 14));
		System.out.println("Expect 3: "+countPairsFromListsWithGivenSumV2(list1, list2, 14));
		System.out.println("Expect 3: "+countPairsFromListsWithGivenSumV3(list1, list2, 14));
		list1 = new LinkedList<>(Arrays.asList(11,2,4,1,2));
		list2 = new LinkedList<>(Arrays.asList(4,7,2,9,6));
		System.out.println("Expect 0: "+countPairsFromListsWithGivenSumV1(list1, list2, 12));
		System.out.println("Expect 0: "+countPairsFromListsWithGivenSumV2(list1, list2, 12));
		System.out.println("Expect 0: "+countPairsFromListsWithGivenSumV3(list1, list2, 12));
	}
	
	/**
	 * Brute Force -
	 * This function counts pairs of numbers in two LinkedLists where the sum of the two numbers is equal to given number
	 * <br>
	 * Time Complexity - O(n^2)
	 * 
	 * @param list1
	 * @param list2
	 * @param sum
	 * @return
	 */
	public static int countPairsFromListsWithGivenSumV1(LinkedList<Integer> list1, LinkedList<Integer> list2, int sum)
	{
		int count = 0;
		for (Integer integer1 : list1) {
			for (Integer integer2 : list2) {
				if(integer1+integer2 == sum) count++;
			}
		}
		return count;
	}

	/**
	 * This function counts pairs of numbers in two LinkedLists where the sum of the two numbers is equal to given number
	 * <br>
	 * Time Complexity - O(n^2)
	 * 
	 * @param list1
	 * @param list2
	 * @param sum
	 * @return
	 */
	public static int countPairsFromListsWithGivenSumV2(LinkedList<Integer> list1, LinkedList<Integer> list2, int sum)
	{
		int count = 0;
		for (Integer integer : list1) {
			if(list2.contains(sum - integer)) count++;	// List.contains takes O(n)
		}

		return count;
	}
	
	
	/**
	 * This function counts pairs of numbers in two LinkedLists where the sum of the two numbers is equal to given number
	 * <br>
	 * Time Complexity - O(n)
	 * 
	 * @param list1
	 * @param list2
	 * @param sum
	 * @return
	 */
	public static int countPairsFromListsWithGivenSumV3(LinkedList<Integer> list1, LinkedList<Integer> list2, int sum)
	{
		int count = 0;
		HashSet<Integer> hashSet = new HashSet<>(list2);// O(n)
		for (Integer integer : list1) {	//O(n)
			if(hashSet.contains(sum - integer)) count++;	// Hash Set look up O(1) - constant time
		}

		return count;
	}

}
