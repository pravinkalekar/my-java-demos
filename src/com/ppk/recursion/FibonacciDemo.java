package com.ppk.recursion;

/**
 * Fibonacci Series
 * <br>
 * Given a number n, print n-th Fibonacci Number.
 * <br>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,...
 * <br>
 * <br>
 * Fn = Fn-1 + Fn-2
 * <br>
 * where F0 = 0 and F1 = 1
 * 
 * @author pkalekar
 */
public class FibonacciDemo {

	public static void main(String[] args) {
		
		System.out.println("0th fibonacciNumber - "+fibonacciNumberRecursice(0));
		System.out.println("1th fibonacciNumber - "+fibonacciNumberRecursice(1));
		System.out.println("2th fibonacciNumber - "+fibonacciNumberRecursice(2));
		System.out.println("5th fibonacciNumber - "+fibonacciNumberRecursice(5));
		System.out.println("8th fibonacciNumber - "+fibonacciNumberRecursice(8));
		System.out.println();
		System.out.println("0th fibonacciNumber - "+fibonacciNumber(0));
		System.out.println("1th fibonacciNumber - "+fibonacciNumber(1));
		System.out.println("2th fibonacciNumber - "+fibonacciNumber(2));
		System.out.println("5th fibonacciNumber - "+fibonacciNumber(5));
		System.out.println("8th fibonacciNumber - "+fibonacciNumber(8));
		System.out.println();
		System.out.println("0th fibonacciNumber - "+fibonacciNumberRecursiceMemoized(0));
		System.out.println("1th fibonacciNumber - "+fibonacciNumberRecursiceMemoized(1));
		System.out.println("2th fibonacciNumber - "+fibonacciNumberRecursiceMemoized(2));
		System.out.println("5th fibonacciNumber - "+fibonacciNumberRecursiceMemoized(5));
		System.out.println("8th fibonacciNumber - "+fibonacciNumberRecursiceMemoized(8));
		
	}
	
	/**
	 * Recursive - Ineffective
	 * <br>
	 * <br>
	 * Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	 * @param n
	 * @return
	 */
	public static int fibonacciNumberRecursice(int n) {
		if(n == 0) return 0;

		if(n == 1) return 1;

		//we could also do-
		//		if (n <= 1) 
		//		       return n;

		return fibonacciNumberRecursice(n-1) + fibonacciNumberRecursice(n-2); 
	}
	
	/**
	 * Non-recursive space optimized
	 * <br>
	 * storing only the previous two numbers
	 * <br>
	 * Time Complexity:O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacciNumber(int n) {
		int a = 0, b = 1, c;
		
		if(n == 0)
			return a;
		
		//loop from 2..n
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return b;
	}
	
	/**
	 * Recursive - memoized version
	 * <br>
	 * <br>
	 * Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	 * @param n
	 * @return
	 */
	static int[] results = new int[1000];
	
	public static int fibonacciNumberRecursiceMemoized(int n) {
		
		results[0]=0;
		results[1]=1;
		
		if(n == 0) return 0;

		if(n == 1) return 1;

		if(results[n]!=0)
			return results[n];

		results[n] = fibonacciNumberRecursice(n-1) + fibonacciNumberRecursice(n-2); 
		
		return results[n];
	}

}
