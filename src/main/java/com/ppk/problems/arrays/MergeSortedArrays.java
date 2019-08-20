package com.ppk.problems.arrays;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <ul>
 * <li>The number of elements initialized in nums1 and nums2 are m and n respectively.</li>
 * <li>You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.</li>
 * </ul>
 * <p>
 * O(n)
 * 
 * @author pkalekar
 *
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		merge(nums1, 3, new int[] {4,5,6}, 3);
		System.out.println("Expect [1,2,3,4,5,6] - "+ Arrays.toString(nums1));
		nums1 = new int[]{1,2,3,0,0,0};
		merge(nums1, 3, new int[] {2,5,6}, 3);
		System.out.println("Expect [1,2,2,3,5,6] - "+ Arrays.toString(nums1));
		nums1 = new int[]{6,7,8,0,0,0};
		merge(nums1, 3, new int[] {2,5,6}, 3);
		System.out.println("Expect [2,5,6,6,7,8] - "+ Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index = m + n - 1;
        int index2 = n - 1;
        int index1 = m - 1;
        
        for(int i = index; i >= 0; i--){
        	if(index1 < 0){
                nums1[i] = nums2[index2--];
                continue;
            }
            
            if(index2 < 0){
                nums1[i] = nums1[index1--];
                continue;
            }
            
            if(nums2[index2] > nums1[index1]){
                nums1[i] = nums2[index2--];
            }else{
                nums1[i] = nums1[index1--];
            }
        }
    }

}
