package com.ppk.problems.arrays;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println("Expect 2 : mySqrt(7) = "+mySqrt(7));
		System.out.println("Expect 3 : mySqrt(9) = "+mySqrt(9));
		System.out.println("Expect 3 : mySqrt(10) = "+mySqrt(10));
		System.out.println("Expect 4 : mySqrt(17) = "+mySqrt(17));
		System.out.println("Expect 46339 : mySqrt(2147395599) = "+mySqrt(2147395599));
		
		System.out.println("Expect 4 : mySqrtUsingLib(17) = "+mySqrtUsingLib(17));
	}

	/**
	 * Using Binary Search method to find
	 * <p>
	 * For x>=2, square root of x is always 0 < a < x/2. 
	 * So, binary search boundaries - 2...x/2
	 * <p>
	 * Time Complexity - O(log n)
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		if(x < 2) return x;
		
		long square;//imp - we would need a long to hold the square value as it would otherwise be out of range of an int
		//binary search boundaries
		int left = 2, right = x/2, pivot;
		
		while(left <= right) {
			pivot = (left+right)/2; //find middle
			
			square = (long)pivot*pivot; //VIMP - Cast to long
			if(square < x) {
				left = pivot + 1;	//search second half
			}else if(square > x) {
				right = pivot - 1; //search first half
			}else {
				return pivot;	//found exact match
			}
		}
		//comes here when left > right
		return right; //in the end, right should hold the correct value
	}
	
	public static int mySqrtUsingLib(int x) {
		return (int)Math.floor(Math.sqrt(x));
	}
	
}
