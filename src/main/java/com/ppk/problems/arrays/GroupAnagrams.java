package com.ppk.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * <br>
 * Two strings are anagrams if and only if their character counts are same
 * <p>
 * Best Solution - O(n * k)
 * 
 * @author pkalekar
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strings));
		System.out.println(groupAnagramsV2(strings));
	}

	/**
	 * Using HashMaps
	 * <p>
	 * Logic - Sort the string and use it as a key in the hashmap
	 * <br>Hold all string with same key as a list as value in the map
	 * 
	 * <p>
	 * Time Complexity: O(n * k log k)
	 * <br>
	 * Space Complexity: O(n * k)
	 * <br>
	 * where k is the maximum length of a string in the array
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();

		for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            
            if(!map.containsKey(sortedKey)){
            	map.put(sortedKey, new ArrayList<String>());
            }
            map.get(sortedKey).add(str);
        }

		return new ArrayList<>(map.values());
	}
	
	/**
	 * Using HashMaps
	 * <p>
	 * Logic -
	 *  <br>
	 *  Two strings are anagrams if and only if their character counts are same
	 * <br>Generate a string concatenated using the frequency of each character inside the string as the key in the hashmap
	 * <br>Hold all string with same key as a list as value in the map
	 * 
	 * <p>
	 * Time Complexity: O(n * k)
	 * <br>
	 * Space Complexity: O(n * k)
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagramsV2(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();

		for(String str : strs){
			
			int[] table = new int[26];
			
            for (Character c : str.toCharArray()) {
				table[c - 'a']++;
			}
            
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < table.length; i++) {
				keyBuilder.append('#');
				keyBuilder.append(table[i]);
			}
            
            String sortedKey = keyBuilder.toString();
            
            if(!map.containsKey(sortedKey)){
            	map.put(sortedKey, new ArrayList<String>());
            }
            map.get(sortedKey).add(str);
        }

		return new ArrayList<>(map.values());
	}

}
