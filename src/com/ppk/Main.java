package com.ppk;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		maskEmailAddress("Sample message containing an email address USER@domain.com where in the email address user@domain.com should get masked");
		System.out.println();
		
		sumOfNumbersInString(new String[]{"1abc23", "geeks4geeks", "1abc2x30yz67", "123abc", "afiefiyh485rgfvrkjiv85rgrm"});
		System.out.println();
		
//		sumOfNumbersInStringScanner();
		
		
		
	}

	/**
	 * This function uses a case-insensitive REGEX pattern to search and mask any email addresses found inside a message
	 * 
	 * @param message
	 * @return
	 */
	private static String maskEmailAddress(String message) {
		System.out.println(message);
		
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
		final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(message);
		while(matcher.find()) {
			System.out.println("Found = "+matcher.group());
			System.out.println("Replacement = "+matcher.group().replaceAll(".", "X"));
			message = message.replaceAll(matcher.group(), matcher.group().replaceAll(".", "X"));
		}
		System.out.println(message);
		return message;
	}
	
	/**
	 * This function uses a REGEX pattern to search numbers in a given string and prints the sum of those numbers
	 * 
	 * @param args String Array
	 */
	public static void sumOfNumbersInString(String[] args) {
		
		Pattern pattern = Pattern.compile("[\\d]+");
		for (String string : args) {
			int count = 0;
			Matcher matcher = pattern.matcher(string);
			while (matcher.find()) {
				count += Integer.valueOf(matcher.group());
			}
			System.out.println("Input - "+ string);
			System.out.println("Sum - "+count);
		}
	}
	
	/**
	 * This function uses a REGEX pattern to search numbers in a given string and prints the sum of those numbers
	 * 
	 * Input Format - First line contains number of strings that follow, each next time up to the number specified contains one string
	 * 
	 * Input below -
	4
	1abc23
	geeks4geeks
	1abc2x30yz67
	123abc
	
	 * 
	 */
	public static void sumOfNumbersInStringScanner () {

		Pattern pattern = Pattern.compile("[\\d]+");
		Scanner scanner = new Scanner(System.in);
		int valueCount = Integer.valueOf(scanner.next());
		for (int i=0; i< valueCount; i++) {
			int count = 0;
			String string = new String(scanner.next());
			Matcher matcher = pattern.matcher(string);
			while (matcher.find()) {
				count += Integer.valueOf(matcher.group());
			}
			System.out.println(count);
		}
		scanner.close();
	}

	/**
	 * This function counts pairs of numbers in two LinkedLists where the sum of the two numbers is equal to given number
	 * <br>
	 * Time Complexity - O(n^2)
	 * 
	 * @param list1
	 * @param list2
	 * @param sum
	 * @return
	 */
	public static int countPairsFromListsWithGivenSumV1(LinkedList<Integer> list1, LinkedList<Integer> list2, int sum)
	{
		int count = 0;
		for (Integer integer : list1) {
			for (Integer integer2 : list2) {
				if(integer+integer2 == sum) count++;
			}
		}
		return count;
	}

	/**
	 * This function counts pairs of numbers in two LinkedLists where the sum of the two numbers is equal to given number
	 * <br>
	 * Time Complexity - O(n^2)
	 * 
	 * @param list1
	 * @param list2
	 * @param sum
	 * @return
	 */
	public static int countPairsFromListsWithGivenSumV2(LinkedList<Integer> list1, LinkedList<Integer> list2, int sum)
	{
		int count = 0;
		for (Integer integer : list1) {
			if(list2.contains(sum-integer)) count++;
		}

		return count;
	}

}


