package com.ppk.problems.arrays;

import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1
 * <p>
 * Best Case - O(n)
 * 
 * @author pkalekar
 *
 */
public class UniqueCharInAString {

	public static void main(String[] args) {
		System.out.println("Using HashaMap");
		System.out.println("Expect - 0 f(pravinkalekar) - "+firstUniqChar("pravinkalekar"));
		System.out.println("Expect - 2 f(ppk) - "+firstUniqChar("ppk"));
		System.out.println("Expect - 1 f(mymapcode) - "+firstUniqChar("mymapcode"));
		System.out.println("Expect - 4 f(newyorknewjersey) - "+firstUniqChar("newyorknewjersey"));
		System.out.println("Expect - -1 f(aadadaad) - "+firstUniqChar("aadadaa"));
		System.out.println("Brute Force");
		System.out.println("Expect - 0 f(pravinkalekar) - "+firstUniqCharV1("pravinkalekar"));
		System.out.println("Expect - 2 f(ppk) - "+firstUniqCharV1("ppk"));
		System.out.println("Expect - 1 f(mymapcode) - "+firstUniqCharV1("mymapcode"));
		System.out.println("Expect - 4 f(newyorknewjersey) - "+firstUniqCharV1("newyorknewjersey"));
		System.out.println("Expect - -1 f(aadadaad) - "+firstUniqCharV1("aadadaa"));
		System.out.println("Array as Hash Table");
		System.out.println("Expect - 0 f(pravinkalekar) - "+firstUniqCharV2("pravinkalekar"));
		System.out.println("Expect - 2 f(ppk) - "+firstUniqCharV2("ppk"));
		System.out.println("Expect - 1 f(mymapcode) - "+firstUniqCharV2("mymapcode"));
		System.out.println("Expect - 4 f(newyorknewjersey) - "+firstUniqCharV2("newyorknewjersey"));
		System.out.println("Expect - -1 f(aadadaad) - "+firstUniqCharV2("aadadaa"));
		
	}
	
	/**
	 * Using HashMap
	 * <p>
	 * O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< chars.length; i++){
            if(map.containsKey(chars[i])){
                int value = map.get(chars[i]);
                map.put(chars[i], ++value);
            }else{
                map.put(chars[i], 1);
            }
        }
   
        for(int i=0; i< chars.length; i++){
            if(map.get(chars[i]) == 1)
               return i;
        }
        return -1;
    }
	
	
	/**
	 * Brute Force
	 * <p>
	 * O(n<sup>2</sup>)
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqCharV1(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			int j;
			for (j = 0; j < s.length(); j++) {
				if(i == j) continue;
				if(s.charAt(i) == s.charAt(j))
					break;
			}
			if(j == s.length()) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Assuming we have all small case ASCII character array
	 * Using array as a Hash Table instead of HashMap
	 * <p>
	 * O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqCharV2(String s) {
		
		int[] table = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			table[index]++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if(table[index] == 1) {
				return i;
			}
		}
		return -1;
		
	}
}
