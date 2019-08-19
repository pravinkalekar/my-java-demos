package com.ppk.problems.arrays;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * <p>
 * Best Solution - O(n) using two pointers
 * 
 * @author pkalekar
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		System.out.println("Brute Force - O(n^2)");
		System.out.println("Expect 6 - f([0,1,0,2,1,0,1,3,2,1,2,1]) - "+ trapIterative(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("Expect 2 - f([2,0,2]) - "+ trapIterative(new int[] {2,0,2}));
		System.out.println("Expect 1 - f([2,0,1]) - "+ trapIterative(new int[] {2,0,1}));
		System.out.println("Expect 0 - f([]) - "+ trapIterative(new int[] {}));
		System.out.println("Dynamic Programming - O(n)");
		System.out.println("Expect 6 - f([0,1,0,2,1,0,1,3,2,1,2,1]) - "+ trapDP(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("Expect 2 - f([2,0,2]) - "+ trapDP(new int[] {2,0,2}));
		System.out.println("Expect 1 - f([2,0,1]) - "+ trapDP(new int[] {2,0,1}));
		System.out.println("Expect 0 - f([]) - "+ trapDP(new int[] {}));
		System.out.println("Stacks - O(n)");
		System.out.println("Expect 6 - f([0,1,0,2,1,0,1,3,2,1,2,1]) - "+ trapStack(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("Expect 2 - f([2,0,2]) - "+ trapStack(new int[] {2,0,2}));
		System.out.println("Expect 1 - f([2,0,1]) - "+ trapStack(new int[] {2,0,1}));
		System.out.println("Expect 0 - f([]) - "+ trapStack(new int[] {}));
		System.out.println("Two pointers - O(n)");
		System.out.println("Expect 6 - f([0,1,0,2,1,0,1,3,2,1,2,1]) - "+ trapTwoPointers(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println("Expect 2 - f([2,0,2]) - "+ trapTwoPointers(new int[] {2,0,2}));
		System.out.println("Expect 1 - f([2,0,1]) - "+ trapTwoPointers(new int[] {2,0,1}));
		System.out.println("Expect 0 - f([]) - "+ trapTwoPointers(new int[] {}));
		
	}

	/**
	 * Brute Force
	 * <p>
	 * Logic - 
	 * <ul>
	 * <li>For each entry, find out the max height on both left and right sides</li>
	 * <li>Amount of water trapped would be the difference between lower of left and right max heights and the self height</li>
	 * </ul>
	 * <p>
	 * O(n<sup>2</sup>)
	 * 
	 * @param height
	 * @return
	 */
	public static int trapIterative(int[] height) {

		int sum = 0;
		for(int i=0; i < height.length; i++){
			int leftMax = height[i];
			int rightMax = height[i];

			for(int j = i - 1; j >= 0; j--){
				if(height[j] > leftMax){
					leftMax = height[j];
				}
			}

			for(int j = i + 1; j < height.length; j++){
				if(height[j] > rightMax){
					rightMax = height[j];
				}
			}

			sum += Integer.min(leftMax, rightMax) - height[i];
		}
		return sum;
	}
	
	/**
	 * Dynamic Programming
	 * <p>
	 * Instead of finding out the max left and max right for each index every time, 
	 * we calculate them and store them in separate arrays
	 * <p>
	 * Time complexity: O(n)
	 * <br>
	 * Space complexity: O(n)
	 * 
	 * @param height
	 * @return
	 */
	public static int trapDP(int[] height) {
        int size = height.length;
        if(size == 0) return 0;
        
        int sum = 0;
        int[] leftMaxArr = new int[size];	//array of same size to maintain indices of leftMax for each element
        int[] rightMaxArr = new int[size];	//array of same size to maintain indices of rightMax for each element
        
        //For leftMax, we start from left
        leftMaxArr[0] = height[0];	//leftMax of 0th element is itself
        for(int i=1; i < height.length; i++){
        	//leftMax of next is max of its height and previous element's maxLeft
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i]);
        }
        
        //For rightMax, we start from right
        rightMaxArr[size - 1] = height[size - 1];	//rightMax of last element is itself
        for(int i = size - 2; i >= 0; i--){
        	//rightMax of previous is max of its height and next element's maxRight
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i]);
        }
       
        for(int i=0; i < height.length; i++){
           sum += Integer.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return sum;
    }
	
	
	
	/**
	 * Using Stacks - found bit difficult to understand
	 * <p>
	 * O(n)
	 * 
	 * @param height
	 * @return
	 */
	public static int trapStack(int[] height) {
		int size = height.length;
        if(size == 0) return 0;
        int sum = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < size; i++){
            
        	//if the current height is greater than height of the stack top index element
        	//we have found the right side bound
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
            	//remove the top element for which we will calculate the sum
                int top = stack.pop();
                //if stack is empty, there is no left bound so just break
                if(stack.isEmpty()) break;
                
                int rightMax = height[i];
                int leftMax = height[stack.peek()];
                
                //there is a chance that the stack had more than one same height elements between left and right boundaries
                int distance = i - stack.peek() - 1;
                
                sum += distance * (Math.min(rightMax, leftMax) - height[top]);
                
            }
            //keep adding indices smaller than or equal to the bar at top of stack
            stack.push(i);
        }
        return sum;
	}
	
	
	
	/**
	 * Using two pointers
	 * <p>
	 * Logic - We needed minimum between leftMax or rightMax to calculate sum in prior examples.
	 * <br>
	 * As long as there is a right bar larger than left, we can depend on leftMax.
	 * Similarly, as long as there is a larger left bar, we can use rightMax to calculate sum.
	 * <p>
	 * Time complexity: O(n)
	 * <br>
	 * Space complexity: O(1)
	 * 
	 * @param height
	 * @return
	 */
	public static int trapTwoPointers(int[] height) {
        int size = height.length;
        if(size == 0) return 0;
        int sum = 0;
        
        int left = 0, right = size-1;
        int leftMax = 0, rightMax = 0;
        
        while(left < right){
            
        	//we needed minimum between leftMax or rightMax to calculate sum
            if(height[left] < height[right]){
                //work on left as left is smaller than right
                
                if(leftMax > height[left]){
                    //add to sum without worrying abt rightMax
                    sum += leftMax - height[left];
                }else{
                    //update leftMax
                    leftMax = height[left];
                }
                left++;
            }else{
                //work on right here as right is smaller than(or equal to) left
                if(rightMax > height[right]){
                    sum += rightMax - height[right];    
                }else{
                    //update rightMax without worrying abt leftMax
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }
	
}
