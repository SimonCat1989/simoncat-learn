package com.simoncat.learn.Q001_TwoSum;

import org.junit.Ignore;
import org.junit.Test;

public class ResultTester {

	private static final int[] TEST_INT_ARRAY = new int[] { 1, 2, 3, 4, 8 };
	private static final int TEST_TARGET = 7;

	@Test
	@Ignore
	public void test() {
		Solution_01_FirstVersion solution = new Solution_01_FirstVersion();
		int[] result = solution.twoSum(TEST_INT_ARRAY, TEST_TARGET);
		System.out.println("First Index is : " + result[0]
				+ " and Next Index is : " + result[1] + ".");
	}
	
	@Test
	public void test2() {
		Solution_02_PreventOverFlowError solution = new Solution_02_PreventOverFlowError();
		int[] result = solution.twoSum(TEST_INT_ARRAY, TEST_TARGET);
		System.out.println("First Index is : " + result[0]
				+ " and Next Index is : " + result[1] + ".");
	}
}
