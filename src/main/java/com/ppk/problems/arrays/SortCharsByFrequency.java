package com.ppk.problems.arrays;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <br>Note - same characters must be together
 * <br>e.g.
 * <ul>
 * <li>tree -> eert or eetr</li>
 * <li>cccaaa -> cccaaa or aaaccc (cacaca is incorrect)</li>
 * <li>Aabb -> bbAa (as A and a are two different characters)</li>
 * <li>loveleetcode -> eeeeoollvtdc (eeeelolovtcd is incorrect)</li>
 * </ul>
 * <p>
 * Using TreeMap gives fastest results
 * 
 * @author pkalekar
 *
 */
public class SortCharsByFrequency {

	public static void main(String[] args) {
		System.out.println("Expect \"eeeeoollvtdc\" f(loveleetcode) - "+ frequencySortV1("loveleetcode"));
		System.out.println("Using HashMap and Priority Queue");
		System.out.println("Expect \"eert\" f(tree) - "+ frequencySort("tree"));
		System.out.println("Expect \"cccaaa\" f(cccaaa) - "+ frequencySort("cccaaa"));
		System.out.println("Expect \"bbAa\" f(Aabb) - "+ frequencySort("Aabb"));
		System.out.println("Expect \"eeeeoollvtdc\" f(loveleetcode) - "+ frequencySort("loveleetcode"));
		System.out.println("Expect \"eeeeoollvtdc\" f(loveleetcode) - "+ frequencySortV2("loveleetcode"));
		System.out.println("Using HashMap and TreeMap");
		System.out.println("Expect \"bbAa\" f(Aabb) - "+ frequencySortV3("Aabb"));
		System.out.println("Expect \"eeeeoollvtdc\" f(loveleetcode) - "+ frequencySortV3("loveleetcode"));
	}

	/**
	 * Using HashMap and TreeMap - Sorted Map
	 * <p>
	 * Fastest
	 * <p>
	 * O(n log n)
	 *  
	 * @param s
	 * @return
	 */
	public static String frequencySortV3(String s) {
		//find frequency of each char
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		TreeMap<Integer, String> treeMap = new TreeMap<>();	//note frequency integer is the key here and multi-char string is the value
		
		for (Entry<Character, Integer> entry : map.entrySet()) {
			treeMap.put(entry.getValue(), treeMap.getOrDefault(entry.getValue(), "")+ entry.getKey());	//we concatenate two chars with same frequency
		}
		
		StringBuilder builder = new StringBuilder();
		while (!treeMap.isEmpty()) {
			Entry<Integer, String> treeEntry = treeMap.pollLastEntry();	// treeMap is sorted in ascending order of key (here the frequency) by default, so last is highest
			for (Character c : treeEntry.getValue().toCharArray()) {
				for (int i = 0; i < treeEntry.getKey(); i++) {
					builder.append(c);
				}
			}
		}
		return builder.toString();
	}	
	
	
	/**
	 * Using HashMap and Priority Queue
	 * <p>
	 * O(n log n)
	 * 
	 * @param s
	 * @return
	 */
	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i < s.length(); i++){
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1 );
		}
		
		PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> map.get(c2).compareTo(map.get(c1)));
		queue.addAll(map.keySet());
		
		char[] chars = new char[s.length()];
		int index = 0;
		while(!queue.isEmpty()) {
			char c = queue.poll();
			for (int i = 0; i < map.get(c); i++) {
				chars[index++] = c;
			}
		}
		return new String(chars);
	}
	
	/**
	 * Using HashMap and Priority Queue - minor variation, cleaner
	 * <p>
	 * O(n log n)
	 * 
	 * @param s
	 * @return
	 */
	public static String frequencySortV2(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i < s.length(); i++){
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1 );
		}
		
		PriorityQueue<Entry<Character, Integer>> heap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
		heap.addAll(map.entrySet());
		
		StringBuilder builder = new StringBuilder();
		while(!heap.isEmpty()) {
			
			Entry<Character, Integer> entry = heap.poll();
			char c = entry.getKey();
			int freq = entry.getValue();
			
			for (int i = 0; i < freq; i++) {
				builder.append(c);
			}
		}
		return builder.toString();
	}
	
	
	/**
	 * bubble sort variation - comparison based on frequency of each char
	 * <p>
	 * DOES NOT WORK - violates "same characters must be together"
	 * <p>
	 * Expected - "loveleetcode" -> "eeeeoollvtdc"
	 * <br>
	 * Actual - "loveleetcode" -> "eeeelolovtcd"
	 * 
	 * <p>
	 * O(n<sup>2</sup>)
	 * 
	 * @param s
	 * @return
	 */
	public static String frequencySortV1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        
        //bubble sort variation
        char[] chars = s.toCharArray();
        for(int i=0; i < s.length() - 1; i++){
            for(int j=0; j< s.length() - 1 - i; j++){
                int freq1 = map.get(chars[j]);
                int freq2 = map.get(chars[j+1]);
                if(freq2 > freq1){
                    char c = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = c;
                }
            }   
        }
        return new String(chars);
    }

}
