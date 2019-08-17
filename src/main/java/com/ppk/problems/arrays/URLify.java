package com.ppk.problems.arrays;

/**
 * Replace all spaces in a string with '%20'
 * <p>
 * Assumptions-
 * <ul>
 * <li>The string has sufficient number of spaces (can be more) at the end to hold the extra characters</li>
 * <li>You are given the <i>true</i> length of the string</li>
 * </ul>
 * <p>
 * Time Complexity - O(n)
 * 
 * @author pkalekar
 *
 */
public class URLify {

	public static void main(String[] args) {
		System.out.println("urlify(\"pravin kalekar  \") - "+urlify("pravin kalekar  ", 14));
		System.out.println("urlify(\"Mr John Smith      \") - "+urlify("Mr John Smith     ", 13));
		System.out.println("Working on char array");
		
		System.out.print("urlify(\"pravin kalekar  \") - ");
		char[] chars = "pravin kalekar  ".toCharArray();
		urlify(chars, 14);
		System.out.println(new String(chars));
		
		System.out.print("urlify(\"Mr John Smith    \") - ");
		chars = "Mr John Smith    ".toCharArray();
		urlify(chars, 13);
		System.out.println(new String(chars));
		
		System.out.print("urlify(\"Mr John Smith         \") - ");
		chars = "Mr John Smith         ".toCharArray();
		urlify(chars, 13);
		System.out.println(new String(chars));
	}

	/**
	 * A common approach to solving to string manipulation problems
	 * is to edit the string starting from the end and work backwards.
	 * 
	 * @param str
	 * @param trueLength
	 * @return
	 */
	public static String urlify(String str, int trueLength) {
		char[] chars = str.toCharArray();
		
//		int index = str.length() - 1;	//can not do this if there are more than required spaces
		
		int numSpaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if(chars[i] == ' ') {
				numSpaces++;
			}
		}
		int index = trueLength - 1 + numSpaces*2;
		
		for (int i = trueLength - 1; i >= 0; i--) {
			if(chars[i] != ' ') {
				chars[index--] = chars[i];
			}else {
				chars[index--] = '0';
				chars[index--] = '2';
				chars[index--] = '%';
			}
		}
		return new String(chars);
	}
	
	/**
	 * In case we do not know the number of spaces and 
	 * if the character array has exact number spaces needed to accommodate extra chars,
	 * we need to calculate it
	 * <p>
	 * Otherwise -we will end up having old chars at the beginning e.g. -
	 * <br><code>urlify("Mr John Smith.........") - "Mr JoMr%20John%20Smith"<code>
	 * 
	 * @param chars
	 * @param trueLength
	 */
	public static void urlify(char[] chars, int trueLength) {
		
//		int index = chars.length - 1;
		
		int numSpaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if(chars[i] == ' ') {
				numSpaces++;
			}
		}
		int index = trueLength - 1 + numSpaces*2;	//each space needs 2 more spaces
		if(chars.length - 1 > index)	//if there are extra spaces than are needed
			chars[index + 1] = '\0';	//mark the end with null char, means spaces after this are not replaced
		//(the above does not change the arr size as such)
		
		for (int i = trueLength - 1; i >= 0; i--) {
			if(chars[i] != ' ') {
				chars[index--] = chars[i];
			}else {
				chars[index--] = '0';
				chars[index--] = '2';
				chars[index--] = '%';
			}
		}
	}
}
