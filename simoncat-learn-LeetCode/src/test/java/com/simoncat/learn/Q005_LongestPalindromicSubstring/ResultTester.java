package com.simoncat.learn.Q005_LongestPalindromicSubstring;

import org.junit.Test;

public class ResultTester {

	private static final String TEST_STRING = "bbb";

	@Test
	public void test1() {
		Solution_01 solution = new Solution_01();
		String result = solution.longestPalindrome(TEST_STRING);
		System.out.println("The result is :" + result + ". "
				+ (result.equals("bbb")));
	}
}
