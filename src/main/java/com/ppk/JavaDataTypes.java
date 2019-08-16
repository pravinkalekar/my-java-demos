package com.ppk;

public class JavaDataTypes {
	
	public static void main(String[] args) {
		
		System.out.format("%10s |%5s |%20s |%20s |%5s |%s\n", "Type", "Byte", "Min Value", "Max Value", "Bits", "Notes");
		System.out.println();
		System.out.format("%10s |%5d |%20d |%20d |%5d |%s\n", Byte.class.getSimpleName(), Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.SIZE, "-2^7 to 2^7-1");
		System.out.format("%10s |%5d |%20d |%20d |%5d |%s\n", Short.class.getSimpleName(), Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE, Short.SIZE, "-2^15 to 2^15-1");
		System.out.format("%10s |%5d |%20d |%20d |%5d |%s\n", Integer.class.getSimpleName(), Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.SIZE, "-2^31 to 2^31-1");
		System.out.format("%10s |%5d |%20d |%20d |%5d |%s\n", Long.class.getSimpleName(), Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE, Long.SIZE, "-2^63 to 2^63-1");
		System.out.println();
		System.out.format("%10s |%5d |%20e |%20e |%5d |%s\n", Float.class.getSimpleName(), Float.BYTES,Float.MIN_VALUE, Float.MAX_VALUE, Float.SIZE, "6 decimal digits of accuracy, use 'f' as suffix ");
		System.out.format("%10s |%5d |%20e |%20e |%5d |%s\n", Double.class.getSimpleName(), Double.BYTES,Double.MIN_VALUE, Double.MAX_VALUE, Double.SIZE, "14 decimal digits of accuracy, by default fraction value is double in java");
		System.out.println();
		System.out.format("%10s |%5s |%20s |%20s |%5s |%s\n", Boolean.class.getSimpleName(), "<1", "-", "-", "-", "one bit of information, True/False");
		System.out.format("%10s |%5d |%20d |%20d |%5d |%s\n", Character.class.getSimpleName(), Character.BYTES, (int)Character.MIN_VALUE, (int)Character.MAX_VALUE, Character.SIZE, "0 to 2^16-1, '\\u0000' to '\\uffff'");
		
		//Literals
		boolean result = true;
		
		//Integer Literals
		byte b = 100; // integer literal of type int, converted into a byte
		short s = 10000; // integer literal of type int, converted into a short
		int i = 100000;	// integer literal of type int
		long l1 = 100000l; // integer literal of type long
		//long l2 = 100000089899999999; // Error - Literal x of type int is out of range 
		long l2 = 100000089899999999L; // integer literal of type long
		
		// The number 26, in decimal, Base 10
		int decVal = 26;
		//  The number 26, in hexadecimal, Base 16
		int hexVal = 0x1a;	//prefix 0x indicates hexadecimal
		// The number 26, in binary, Base 2
		int binVal = 0b11010;	//prefix 0b indicates binary
		
		
		//Floating point literals
		double d1 = 123.4;	//floating-point literal is of type double
		double d2 = 123.4d;	//floating-point literal is of type double
		double d3 = 123.4D;	//floating-point literal is of type double
		// same value as d1, but in scientific notation
		double d4 = 1.234e2;	// 1.234 x 10^2
		float f1  = 123.4f;	//floating-point literal is of type float
		float f2  = 123.4F;	//floating-point literal is of type float
//		float f3  = 123.4;	//error - cannot convert from double to float
		
		//Character and String Literals
		char capitalC = 'C';	//use 'single quotes' for char literals
		//Unicode escape sequences may be used elsewhere in a program (such as in field names, for example)
		char unicodeChar = '\u0108';	//Unicode escape
		String string = "SomeStringLiteral";	//use "double quotes" for String literals
		
		//special escape sequences for char and String literals: \b (backspace), \t (tab), \n (line feed), \f (form feed), \r (carriage return), \" (double quote), \' (single quote), and \\ (backslash)
		
		
		//In Java SE 7 and later, any number of underscore characters (_) can appear anywhere between digits in a numerical literal
		//improve the readability of your code
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		float pi =  3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
	}

}
