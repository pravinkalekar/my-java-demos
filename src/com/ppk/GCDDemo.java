package com.ppk;

/**
 * Greatest Common Divisor
 * This is a recursive algorithm
 * 
 * @author pkalekar
 *
 */
public class GCDDemo {

	public static int calculateGCD(int a, int b) {
		//step 1 - divide two number and find the remainder
		int remainder = a%b;
		//step 2 - if remainder is 0, then return b as GCD
		if(remainder == 0) return b;
		//step 3 - if there is a remainder other than 0, find GCD of second number and the remainder
		return calculateGCD(b, remainder);
	}
	
	//one more way
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		
		System.out.println(calculateGCD(6, 4));
		System.out.println(calculateGCD(7, 3));
		System.out.println(calculateGCD(12, 8));
		System.out.println(calculateGCD(25, 10));
	}
	
}
