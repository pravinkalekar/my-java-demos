package com.ppk.recursion;

/**
 * Greatest Common Divisor
 * This is a recursive algorithm
 * 
 * @author pkalekar
 *
 */
public class GCDDemo {

	public static int calculateGCD(int a, int b) {
		if(b == 0) throw new RuntimeException("One of the number provided is 0");
		
		//step 1 - divide two number and find the remainder
		int remainder = a%b;
		
		//step 2 - if remainder is 0, then return b as GCD
		//breaking condition
		if(remainder == 0) return b;
		
		//step 3 - if there is a remainder other than 0, find GCD of second number and the remainder
		return calculateGCD(b, remainder);
	}
	
	//one more way
	public static int calculateGCDv2(int a, int b) {
		//breaking condition
		//we are returning a here; do not get confused with above function where we return b
		//this is because the second number b is being passed as the first parameter (which becomes a) in the recursive call
		if (b == 0) return a;
		
		return calculateGCDv2(b, a % b);
	}
	
	public static void main(String[] args) {
		
		System.out.println(calculateGCD(6, 4));
		System.out.println(calculateGCD(7, 3));
		System.out.println(calculateGCD(12, 4));
		System.out.println(calculateGCD(25, 10));
		
		System.out.println();
		
		System.out.println(calculateGCDv2(6, 4));
		System.out.println(calculateGCDv2(7, 3));
		System.out.println(calculateGCDv2(12, 4));
		System.out.println(calculateGCDv2(25, 0));
	}
}
