package com.ppk.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class PairOfIndicesWithGivenSum {

	public static void main(String[] args) {
		System.out.println("O(n^2) : ");
		System.out.println("Expect [1, 2] : "+Arrays.toString(twoSum(new int[]{3, 4, 5, 7, 11}, 9)));
		System.out.println("Expect [0, 2] : "+Arrays.toString(twoSum(new int[]{3, 4, 6, 7, 11}, 9)));
		System.out.println("Expect [0, 3] : "+Arrays.toString(twoSum(new int[]{7, 4, 6, 2, 11}, 9)));
		System.out.println("Expect [3, 4] : "+Arrays.toString(twoSum(new int[]{17, 14, 16, 12, 11}, 23)));
		System.out.println("Expect [3, 4] : "+Arrays.toString(twoSumLabeledBreak(new int[]{17, 14, 16, 12, 11}, 23)));
		System.out.println("O(n) : ");
		System.out.println("Expect [1, 2] : "+Arrays.toString(twoSum(new int[]{3, 4, 5, 7, 11}, 9)));
		System.out.println("Expect [0, 2] : "+Arrays.toString(twoSum(new int[]{3, 4, 6, 7, 11}, 9)));
		System.out.println("Expect [0, 3] : "+Arrays.toString(twoSum(new int[]{7, 4, 6, 2, 11}, 9)));
		System.out.println("Expect [3, 4] : "+Arrays.toString(twoSum(new int[]{17, 14, 16, 12, 11}, 23)));
	}
	
	/**
	 * Brute Force
	 * <p>
	 * Time Complexity - O(n<sup>2</sup>)
	 * <p>
	 * Imp Note - If you just <b>break</b> inside the inner for loop, the outer loop will continue to run even if we have our result found
	 * <p>
	 * One way to break both the loops is to return immediately from inside the loops (requires another return/throw error at the end of the function)
	 * <p>
	 * Another way is to use a labeled break -
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for(int i=0; i < nums.length; i++) {
			for(int j=i+1; j < nums.length; j++) {
				if(nums[i]+nums[j] == target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		throw new IllegalArgumentException("Invalid array given");
	}
	
	public static int[] twoSumLabeledBreak(int[] nums, int target) {
		int[] result = new int[2];
		here:
		for(int i=0; i < nums.length; i++) {
			for(int j=i+1; j < nums.length; j++) {
				if(nums[i]+nums[j] == target){
					result[0] = i;
					result[1] = j;
					break here;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Using a map to store the element and its index
	 * <p>
	 * Time Complexity - O(n)
	 * <p>
	 * Idea is that for an element in the array, we have to search for its pair or complement and we need to output its index.
	 * So, we store the elements and their indices in a Hash table data structure for fast lookup based on element to find out its index if it exists
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSumWithMaps(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i < nums.length; i++){
            int temp = target - nums[i];    
            if(map.containsKey(temp)){
                return new int[]{ map.get(temp), i};
            }else{
                map.put(nums[i], i);
            }
        }   
        throw new IllegalArgumentException("Invalid array given");
    }

}
