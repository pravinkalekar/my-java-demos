package com.ppk.recursion;

/**
 * Factorial of a given number
 * <br>
 * 1. Plain Iteration way
 * <br>
 * 2. Recursion
 * <br>
 * 3. Tail Recursion
 * 
 * @author pkalekar
 *
 */
public class FactorialDemo {
	
	
	/**
	 * Factorial using iteration
	 * 
	 * Factorial(x) = x * x-1 * x-2 * .. * 3 * 2 * 1
	 * 
	 * @param number
	 * @return
	 */
	public static int factorialIteration(int number) {
		
		int result = 1;
		for (int i = number; i > 0; i--) {
			result *= i;
		}
		return result;
	}
	
	/**
	 * Factorial(x) = x * Factorial(x-1)
	 * 
	 * @param number
	 * @return
	 */
	public static int factorialRecursion(int number) {
		//breaking condition
		if(number == 0) return 1;
		
		return number * factorialRecursion(number-1);
	}
	
	
	/**
	 * Factorial using tail recursion
	 * 
	 * In Tail recursion, we do not keep anything on Function Call stack however, we pass on the result as a parameter
	 * <br>
	 * In Java, the compiler does not take into account the tail recursion and hence does not optimize for it.
	 * 
	 * @param number
	 * @return
	 */
	public static int factorialUsingTailRecursion(int number) {
		// set result = 1 to begin with
		return factorialUsingTailRecursion(number, 1);
	}
	
	/**
	 * Factorial using tail recursion
	 * 
	 * This is the internal overloaded method
	 * 
	 * @param number
	 * @param result The result parameter is also called as the <b>accumulator</b>
	 * @return
	 */
	private static int factorialUsingTailRecursion(int number, int result) {
		// breaking condition
		if(number == 0) return 1;
		
		return number * factorialUsingTailRecursion(number-1, result);
	}

	public static void main(String[] args) {
		System.out.println("factorialIteration(5)="+factorialIteration(5));
		
		System.out.println("factorialRecursion(5)="+factorialRecursion(5));
		
		System.out.println("factorialUsingTailRecursion(5)="+factorialUsingTailRecursion(5));
	}

}
