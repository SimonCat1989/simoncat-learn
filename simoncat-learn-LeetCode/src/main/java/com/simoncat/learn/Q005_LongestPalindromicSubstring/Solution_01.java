package com.simoncat.learn.Q005_LongestPalindromicSubstring;



public class Solution_01 {
	
	public String longestPalindrome(String s) {
		char[] array = s.toCharArray();
		int length = array.length;
		int finalLen = 0;
		int finalLeftInd = 0;
		int finalRightInd = 0;
		int tempLen = 0;
		int tempLeftInd = 0;
		int tempRightInd = 0;
		
		int lenFor1 = 2 * length - 3;
		int lenFor2 = 2 * length - 4;
		
		for (int i = 1, j = 2; i <= lenFor1 && j <= lenFor2; i=i+2, j=j+2) {
			int factorJ = j /2;
			int searchLengthFor1 = Math.min(factorJ, length - factorJ);
			int searchLengthFor2 = Math.min(factorJ, length - factorJ - 1);
			
			tempLen = 0;
			for (int k = 1; k <= searchLengthFor1; k++) {
				int factorK = 2 * k - 1;
				int factorLeft = (i - factorK) / 2;
				int factorRight = (i + factorK) / 2;
				if (array[factorLeft] == array[factorRight]) {
					tempLen += 2;
					tempLeftInd = factorLeft;
					tempRightInd = factorRight;
				} else {
					if (tempLen > finalLen) {
						finalLen = tempLen;
						finalLeftInd = tempLeftInd;
						finalRightInd = tempRightInd;
					}
					break;
				}
			}
			if (tempLen > finalLen) {
				finalLen = tempLen;
				finalLeftInd = tempLeftInd;
				finalRightInd = tempRightInd;
			}
			tempLen = 1;
			for (int k = 1; k <= searchLengthFor2; k++) {
				int factorK = 2 * k;
				int factorLeft = (j - factorK) / 2;
				int factorRight = (j + factorK) / 2;
				if (array[factorLeft] == array[factorRight]) {
					tempLen += 2;
					tempLeftInd = factorLeft;
					tempRightInd = factorRight;
				} else {
					if (tempLen > finalLen) {
						finalLen = tempLen;
						finalLeftInd = tempLeftInd;
						finalRightInd = tempRightInd;
					}
					break;
				}
			}
			if (tempLen > finalLen) {
				finalLen = tempLen;
				finalLeftInd = tempLeftInd;
				finalRightInd = tempRightInd;
			}
		}
		return s.substring(finalLeftInd, finalRightInd + 1);
	}
}
