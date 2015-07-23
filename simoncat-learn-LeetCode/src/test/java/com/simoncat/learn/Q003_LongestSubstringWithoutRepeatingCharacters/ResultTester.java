package com.simoncat.learn.Q003_LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

public class ResultTester {

	private static final String TEST_STRING_1 = "abcabcbb";
	private static final String TEST_STRING_2 = "bbbbb";
	private static final String TEST_STRING_3 = "aab";

	@Test
	public void test1() {
		Solution_01 solution = new Solution_01();
		int result1 = solution.lengthOfLongestSubstring(TEST_STRING_1);
		System.out.println("Result for " + TEST_STRING_1 + " is: " + result1
				+ ".");
		System.out.println(result1 == 3);
		
		int result2 = solution.lengthOfLongestSubstring(TEST_STRING_2);
		System.out.println("Result for " + TEST_STRING_2 + " is: " + result2
				+ ".");
		System.out.println(result2 == 1);
		
		int result3 = solution.lengthOfLongestSubstring(TEST_STRING_3);
		System.out.println("Result for " + TEST_STRING_3 + " is: " + result3
				+ ".");
		System.out.println(result3 == 2);
	}

}
