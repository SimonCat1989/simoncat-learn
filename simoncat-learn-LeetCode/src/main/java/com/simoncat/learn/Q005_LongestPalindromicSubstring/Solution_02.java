package com.simoncat.learn.Q005_LongestPalindromicSubstring;

/**
 * Let's convert it to find the same longest substring of two strings.
 * 
 * @author simoncat
 *
 */
public class Solution_02 {

	private char[] array;
	private int len = 0;
	private int[] temp;
	private int[] vector;
	private int endPos = 0;
	private int maxLen = 0;
	
	public String longestPalindrome(String s) {
		array = s.toCharArray();
		len = array.length;
		temp = new int[len + 1];
		temp[0] = 0;
		vector = new int[len + 1];
		for (int i = 0; i <= len; i++) {
			vector[i] = 0;
		}
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int pos = len - j - 1;
				if (array[i] != array[pos]) {
					temp[j + 1] = 0;
				} else {
					temp[j + 1] = vector[j] + 1;
				}
				if (temp[j + 1] > maxLen) {
					endPos = j;
					maxLen = temp[j + 1];
				}
			}
			
			int[] swap = vector;
			vector = temp;
			temp = swap;
		}
		
		char[] result = new char[maxLen];
		for (int k = 1; k <= maxLen; k++) {
			result[k - 1] = array[endPos - maxLen + k];
		}
		
		return new String(result);
	}
}
