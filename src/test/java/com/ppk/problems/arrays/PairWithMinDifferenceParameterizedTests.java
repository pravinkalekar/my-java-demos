package com.ppk.problems.arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PairWithMinDifferenceParameterizedTests {
	
	@Parameters(name = "Test{index}: Array1 = {0}, Array2 = {1}, Expected = {2}")
	public static int[][][] parameters() {
		int[][][] params = new int[][][] {
			{{4,3,2,1,5}, {8,7,9,6,-2}, {5, 6}},
			{{}, {8,7,9,6,-2}, new int[2]},
			{{4,3,2,1,5}, {}, new int[2]},
			{{4,3,-2,1,5}, {8,5,1,5,-2}, {-2,-2}}
		};
		return params;
	}
	
	int[] array1;
	int[] array2;
	int[] expected;
	
	public PairWithMinDifferenceParameterizedTests(int[] array1, int[] array2, int[] expected) {
		super();
		this.array1 = array1;
		this.array2 = array2;
		this.expected = expected;
	}

	@Test
	public void testPairWithMinDifference() {
		
		int[] actual = PairWithMinDifference.findPairWithMinDifference(this.array1, this.array2);
		
		assertArrayEquals(this.expected, actual);
		
		actual = PairWithMinDifference.findPairWithMinDifferenceV1(this.array1, this.array2);
		
		assertArrayEquals(this.expected, actual);
	}
	
}
