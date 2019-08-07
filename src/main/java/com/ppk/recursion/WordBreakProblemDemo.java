package com.ppk.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Word Break Problem
 * <br>
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.
 * <br>
 * Plain Recursive Approach - 
 * <br>
 * If the Entire string is present in the dictionary, return true, done<br>
 * Otherwise, split the string, check if the first part of the  string is directly present in the dict AND check the second part recursively
 * <br>
 * <br>
 * Memoization -
 * <br>
 * As part of the recursive approach we end up doing the same calculations multiple times. (overlapping sub-problems)
 * <br>
 * So, we keep a map of previous calculations and check against it before going for recursive calls.
 * 
 * 
 * @author pkalekar
 *
 */
public class WordBreakProblemDemo {

	public static void main(String[] args) {
		String[] dictArray = new String[] {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango","sun", "and"};
		HashSet<String> dict = new HashSet<>(Arrays.asList(dictArray));
		
		System.out.println("* Word Break Plain Recursive *");
		
		System.out.println("ilike - Expected true, Actual - " + wordBreakRecursive("ilike", dict));
		System.out.println("ilikesam - Expected true, Actual - " + wordBreakRecursive("ilikesam", dict));
		System.out.println("ilikesamsung - Expected true, Actual - " + wordBreakRecursive("ilikesamsung", dict));
		System.out.println("samsungmobile - Expected true, Actual - " + wordBreakRecursive("samsungmobile", dict));
		System.out.println("iceman - Expected true, Actual - " + wordBreakRecursive("iceman", dict));
		System.out.println("ilikemangoicecreamandsamsungmobile - Expected true, Actual - " + wordBreakRecursive("ilikemangoicecreamandsamsungmobile", dict));
		
		System.out.println("samsmango - Expected false, Actual - " + wordBreakRecursive("samsmango", dict));
		System.out.println("ego - Expected false, Actual - " + wordBreakRecursive("ego", dict));
		
		System.out.println();
		System.out.println("* Word Break Memoization Recursive *");
		
		System.out.println("ilike - Expected true, Actual - " + wordBreakMemoization("ilike", dict));
		System.out.println("ilikesam - Expected true, Actual - " + wordBreakMemoization("ilikesam", dict));
		System.out.println("ilikesamsung - Expected true, Actual - " + wordBreakMemoization("ilikesamsung", dict));
		System.out.println("samsungmobile - Expected true, Actual - " + wordBreakMemoization("samsungmobile", dict));
		System.out.println("iceman - Expected true, Actual - " + wordBreakMemoization("iceman", dict));
		System.out.println("ilikemangoicecreamandsamsungmobile - Expected true, Actual - " + wordBreakMemoization("ilikemangoicecreamandsamsungmobile", dict));
		
		System.out.println("samsmango - Expected false, Actual - " + wordBreakMemoization("samsmango", dict));
		System.out.println("ego - Expected false, Actual - " + wordBreakMemoization("ego", dict));
		
		System.out.println();
		System.out.println("* Word Break Recursive BackTracking *");
		System.out.println("ilikeman -");
		wordBreakBackTracking("ilikeman", dict);
		System.out.println("manmobilecreamicecream -");
		wordBreakBackTracking("manmobilecreamicecream", dict);
		System.out.println("ilikemangoicecreamandsamsungmobile -");
		wordBreakBackTracking("ilikemangoicecreamandsamsungmobile", dict);
		
		

	}

	public static boolean wordBreakRecursive(String s, Set<String> dict) {

		//breaking condition
		if(dict.contains(s))
			return true;

		for(int i=1; i < s.length();i++) {

			if(dict.contains(s.substring(0, i)) && wordBreakRecursive(s.substring(i, s.length()), dict)) {
				return true;
			}
		}

		return false;
	}
	

	/**
	 * Memoization is an optimization technique used primarily to speed up computer programs by storing the results of expensive function calls 
	 * and returning the cached result when the same inputs occur again.
	 * 
	 * <br>
	 * It is a Dynamic Programing <b>Top-Down</b> problem solving technique.
	 * <br>
	 * Note - <b>Tabulation</b>: Bottom Up
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean wordBreakMemoization(String s, Set<String> dict) {
		
		return wordBreakMemoizationInternal(s, dict, new HashMap<String, Boolean>());
	}
	
	
	private static boolean wordBreakMemoizationInternal(String s, Set<String> dict, Map<String, Boolean> mem) {
		//breaking condition
		if(dict.contains(s))
			return true;

		if(mem.containsKey(s) && true == mem.get(s))
			return true;
		
		for(int i=1; i< s.length(); i++) {
			if(dict.contains(s.substring(0, i)) && wordBreakMemoizationInternal(s.substring(i, s.length()), dict, mem)) {
				mem.put(s.substring(i, s.length()), true);
				return true;
			}
		}

		mem.put(s, false);
		return false;
	}

	
	
	private static void wordBreakBackTracking(String string, HashSet<String> dict) {
		
		HashMap<String, Boolean> map = new HashMap<>();
		wordBreakBackTrackingInternal(string, dict, "");
	}

	private static void wordBreakBackTrackingInternal(String s, HashSet<String> dict, String result) {

		for(int i=1; i<= s.length(); i++) {

			String prefix = s.substring(0, i);
			
			//if dictionary contains this prefix
			if(dict.contains(prefix)) {
				
				//kinda breaking condition
				// if we reach the end of the string we were trying to break
				if(i == s.length()) {
					//add this element to previous prefix
					result += prefix; 
					System.out.println(result);
					return;
				}
				
				//we check for remaining string
				wordBreakBackTrackingInternal(s.substring(i, s.length()), dict, result + prefix + " ");
			}
		}
	}
	
	
}
