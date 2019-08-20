package com.ppk.problems.arrays;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author pkalekar
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println("Brute force - O(n^2)");
		System.out.println("Expect 49 f([1,8,6,2,5,4,8,3,7]) - "+maxAreaV1(new int [] {1,8,6,2,5,4,8,3,7}));
		System.out.println("Expect 1 f([1,1]) - "+maxAreaV1(new int [] {1,1}));
		System.out.println("Expect 0 f([]) - "+maxAreaV1(new int [] {}));
		System.out.println("Expect 0 f([1]) - "+maxAreaV1(new int [] {1}));
		System.out.println("Single Loop - O(n)");
		System.out.println("Expect 49 f([1,8,6,2,5,4,8,3,7]) - "+maxAreaV2(new int [] {1,8,6,2,5,4,8,3,7}));
		System.out.println("Expect 1 f([1,1]) - "+maxAreaV2(new int [] {1,1}));
		System.out.println("Expect 0 f([]) - "+maxAreaV2(new int [] {}));
		System.out.println("Expect 0 f([1]) - "+maxAreaV2(new int [] {1}));
	}
	
	/**
	 * Brute Force
	 * 
	 * <p>
	 * O(n)
	 * 
	 * @param height
	 * @return
	 */
	public static int maxAreaV1(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int d = j - i;
                int h = Math.min(height[i], height[j]);
                int area = d*h;
                if(maxArea < area){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
	
	
	/**
	 * Two Pointer Approach - Single Loop
	 * <p>
	 * O(n)
	 * 
	 * @param height
	 * @return
	 */
	public static int maxAreaV2(int[] height) {
        int maxArea = 0;
        
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
        	 int d = right - left;
            int h = Math.min(height[left], height[right]);
            int area = d*h;
            
            //keep capturing maxArea
            if(area > maxArea){
                maxArea = area;
            }
            
            //increment the smaller end
            if(height[right] > height[left]){
                left++;
            }else{
                right--;
            }
        }
        
        return maxArea;
    }

}
