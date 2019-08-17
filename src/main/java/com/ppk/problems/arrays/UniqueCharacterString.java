package com.ppk.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Find out if a string contains unique characters
 * <p>
 * Best Case Time Complexity - O(n)
 * 
 * @author pkalekar
 *
 */
public class UniqueCharacterString {

	public static void main(String[] args) {
		System.out.println("Using Hash Table - O(n) - ");
		System.out.println("Expect - true f() - "+ isUniqueCharacterString(""));
		System.out.println("Expect - true f(pravin) - "+ isUniqueCharacterString("pravin"));
		System.out.println("Expect - false f(PravinPKalekar) - "+ isUniqueCharacterString("PravinPKalekar"));
		System.out.println("Expect - true f(pravink) - "+ isUniqueCharacterString("pravink"));
		System.out.println("Expect - false f(pravinprabhakar) - "+ isUniqueCharacterString("pravinprabhakar"));
		System.out.println("Brute Force - O(n^2) - ");
		System.out.println("Expect - true f() - "+ isUniqueCharacterStringV1(""));
		System.out.println("Expect - true f(pravin) - "+ isUniqueCharacterStringV1("pravin"));
		System.out.println("Expect - false f(PravinPKalekar) - "+ isUniqueCharacterStringV1("PravinPKalekar"));
		System.out.println("Expect - true f(pravink) - "+ isUniqueCharacterStringV1("pravink"));
		System.out.println("Expect - false f(pravinprabhakar) - "+ isUniqueCharacterStringV1("pravinprabhakar"));
		System.out.println("Sorting - O(n log n) - ");
		System.out.println("Expect - true f() - "+ isUniqueCharacterStringV2(""));
		System.out.println("Expect - true f(pravin) - "+ isUniqueCharacterStringV2("pravin"));
		System.out.println("Expect - false f(PravinPKalekar) - "+ isUniqueCharacterStringV2("PravinPKalekar"));
		System.out.println("Expect - true f(pravink) - "+ isUniqueCharacterStringV2("pravink"));
		System.out.println("Expect - false f(pravinprabhakar) - "+ isUniqueCharacterStringV2("pravinprabhakar"));
	}
	
	/**
	 * Using Hash Table
	 * <p>
	 * Time Complexity - O(n)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueCharacterString(String str) {
		
		HashSet<Character> set = new HashSet<>();
		for(Character c : str.toCharArray()) {
			if(set.contains(c))
				return false;
			else
				set.add(c);
		}
		return true;
	}
	
	
	/**
	 * Brute Force
	 * <p>
	 * Time Complexity - O(n^2)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueCharacterStringV1(String str) {
		
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i+1; j < chars.length; j++) {
				if(chars[i] == chars[j])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Sorting
	 * <p>
	 * Time Complexity - O(n log n)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueCharacterStringV2(String str) {
		
		char[] chars = str.toCharArray();
		
		Arrays.sort(chars);
		
		System.out.println(Arrays.toString(chars));
		
		for (int i = 0; i < chars.length - 1; i++) {
			if(chars[i] == chars[i+1])
				return false;
		}
		return true;
	}

}






