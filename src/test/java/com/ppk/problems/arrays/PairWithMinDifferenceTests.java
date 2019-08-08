package com.ppk.problems.arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PairWithMinDifferenceTests {
	
	@Test
	public void testPairWithMinDifference() {
		
		int[] expected = {5, 6};
		
		int[] actual = PairWithMinDifference.findPairWithMinDifference(new int[] {4,3,2,1,5}, new int[] {8,7,9,6,-2});
		
		assertArrayEquals(expected, actual);
		
		actual = PairWithMinDifference.findPairWithMinDifferenceV1(new int[] {4,3,2,1,5}, new int[] {8,7,9,6,-2});
		
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testPairWithMinDifferenceEmptyArg1() {
		
		int[] expected = new int[2];
		
		int[] actual = PairWithMinDifference.findPairWithMinDifference(new int[] {}, new int[] {8,7,9,6,-2});
		
		assertArrayEquals(expected, actual);
		
		actual = PairWithMinDifference.findPairWithMinDifferenceV1(new int[] {}, new int[] {8,7,9,6,-2});
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testPairWithMinDifferenceEmptyArg2() {
		
		int[] expected = new int[2];
		
		int[] actual = PairWithMinDifference.findPairWithMinDifference(new int[] {4,3,2,1,5}, new int[] {});
		
		assertArrayEquals(expected, actual);
		
		actual = PairWithMinDifference.findPairWithMinDifferenceV1(new int[] {4,3,2,1,5}, new int[] {});
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testPairWithMinDifferenceNegativeValues() {
		
		int[] expected = {-2, -2};
		
		int[] actual = PairWithMinDifference.findPairWithMinDifference(new int[] {4,3,-2,1,5}, new int[] {8,5,1,5,-2});
		
		assertArrayEquals(expected, actual);
		
		actual = PairWithMinDifference.findPairWithMinDifferenceV1(new int[] {4,3,-2,1,5}, new int[] {8,5,1,5,-2});
		
		assertArrayEquals(expected, actual);
	}
	
}
