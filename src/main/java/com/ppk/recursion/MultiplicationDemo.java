package com.ppk.recursion;

/**
 * Multiplication without asterisk
 * 
 * @author pkalekar
 *
 */
public class MultiplicationDemo {

	public static void main(String[] args) {
		System.out.println("Recursive");
		System.out.println("Expect 0 - f(0,3) = "+ multiply(0, 3));
		System.out.println("Expect 0 - f(4,0) = "+ multiply(4, 0));
		System.out.println("Expect 0 - f(0,0) = "+ multiply(0, 0));
		
		System.out.println("Expect -12 - f(-4,3) = "+ multiply(-4, 3));
		System.out.println("Expect -16 - f(4,-4) = "+ multiply(4, -4));
		System.out.println("Expect 16 - f(-4,-4) = "+ multiply(-4, -4));
		System.out.println("Expect 12 - f(4,3) = "+ multiply(4, 3));
		
		System.out.println("Iterative");
		
		System.out.println("Expect 0 - f(0,3) = "+ multiplyIterative(0, 3));
		System.out.println("Expect 0 - f(4,0) = "+ multiplyIterative(4, 0));
		System.out.println("Expect 0 - f(0,0) = "+ multiplyIterative(0, 0));
		
		System.out.println("Expect -12 - f(-4,3) = "+ multiplyIterative(-4, 3));
		System.out.println("Expect -16 - f(4,-4) = "+ multiplyIterative(4, -4));
		System.out.println("Expect 16 - f(-4,-4) = "+ multiplyIterative(-4, -4));
		System.out.println("Expect 12 - f(4,3) = "+ multiplyIterative(4, 3));

	}
	
	/**
	 * Recursive
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int multiply(int x, int y) {
		
		if(x == 0 || y == 0) return 0;
		
		if(y < 0) {
			return - multiply(x, -y);
		}
		
		return x + multiply(x, y - 1);
	}
	
	/**
	 * Iterative
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int multiplyIterative(int x, int y) {
		int sum = 0;
		int sign = 1;
		
		if(y < 0){
			sign = -1;
			y = -y;
			//or
			//return - multiplyIterative(x, -y);
		}
		
		for (int i = 0; i < y; i++) {
			sum += x;
		}
		
		return sign * sum;
	}
	
}
