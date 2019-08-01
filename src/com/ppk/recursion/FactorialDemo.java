package com.ppk.recursion;

/**
 * Factorial of a given number using recursion
 * 
 * Factorial(x) = x * Factorial(x-1)
 * 
 * @author pkalekar
 *
 */
public class FactorialDemo {
	
	public static int factorial(int number) {
		//breaking condition
		if(number == 0) return 1;
		
		return number * factorial(number-1);
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
		System.out.println("Factorial(5)="+factorial(5));
		
		System.out.println("Factorial(6)="+factorialUsingTailRecursion(6));
	}

}
