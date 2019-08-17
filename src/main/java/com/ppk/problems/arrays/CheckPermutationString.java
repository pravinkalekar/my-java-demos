package com.ppk.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Check if a string is a permutation of other
 * It means they have same character set, but in different order.
 * <p>
 * 
 * Best Solution Time Complexity - O(n)
 * 
 * @author pkalekar
 *
 */
public class CheckPermutationString {

	public static void main(String[] args) {
		System.out.println("Sorting - O(nlogn) - ");
		System.out.println("Expect true - f(pravin, nvirap) - "+ isPermutationString("pravin", "nvirap"));
		System.out.println("Expect true - f(pravinKalekar, nvakiKreaalrp) - "+ isPermutationString("pravinKalekar", "nvakiKreaalrp"));
		System.out.println("Expect false - f(Pravin, nviraZ) - "+ isPermutationString("Pravin", "nviraZ"));
		System.out.println("Using Built-In HashMap - O(n) - ");
		System.out.println("Expect true - f(pravin, nvirap) - "+ isPermutationStringV1("pravin", "nvirap"));
		System.out.println("Expect true - f(pravinKalekar, nvakiKreaalrp) - "+ isPermutationStringV1("pravinKalekar", "nvakiKreaalrp"));
		System.out.println("Expect false - f(PravinPK, PKnviraZ) - "+ isPermutationStringV1("PravinPK", "PKnviraZ"));
		System.out.println("Using Custom Hash Table - O(n) - ");
		System.out.println("Expect true - f(pravin, nvirap) - "+ isPermutationStringV2("pravin", "nvirap"));
		System.out.println("Expect true - f(pravinKalekar, nvakiKreaalrp) - "+ isPermutationStringV2("pravinKalekar", "nvakiKreaalrp"));
		System.out.println("Expect false - f(PravinPK, PKnviraZ) - "+ isPermutationStringV2("PravinPK", "PKnviraZ"));
	}
	
	/**
	 * Sorting
	 * <p>
	 * O(n log n)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutationString(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		
		return new String(chars1).equals(new String(chars2));
	}
	
	/**
	 * Using Built-In Hash Map
	 * <p>
	 * O(n)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutationStringV1(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (Character c : s1.toCharArray()) {
			if(map.containsKey(c)) {
				int value = map.get(c);
				map.put(c, ++value);
			}else {
				map.put(c, 1);
			}
		}
		
		for(Character c : s2.toCharArray()) {
			if(map.containsKey(c)) {
				int value = map.get(c);
				value--;
				
				if(value < 0) {	//return immediately if any value goes negative (meaning there will be an positive as well) 
					return false;
				}
				
			}else {
				return false;
			}
		}
		//here we should ideally need to make sure the map has all ZEROs and no positive values left
		//since we already checked lengths, if there is no negative value, means there is no positive either and hence all ZEROs
		return true;
	}
	
	/**
	 * Using Custom Hash Table
	 * <p>
	 * Assumption - String contains only ASCII characters (128)
	 * <p>
	 * O(n)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutationStringV2(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		int[] table = new int[128];
		
		for (int i = 0; i < s1.length(); i++) {
			table[s1.charAt(i)]++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			table[s2.charAt(i)]--;
			
			if(table[s2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}

}
