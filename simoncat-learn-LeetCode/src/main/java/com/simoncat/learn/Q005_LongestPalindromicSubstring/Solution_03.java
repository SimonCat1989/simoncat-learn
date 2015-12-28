package com.simoncat.learn.Q005_LongestPalindromicSubstring;

public class Solution_03 {

	char[] temp;

	public int match(int a, int b, int len) {
		int i = 0;
		while (a - i >= 0 && b + i < len && temp[a - i] == temp[b + i])
			i++;
		return i;
	}

	public String longestPalindrome(String s) {
		temp = new char[1001 * 2];
		int[] z = new int[1001 * 2];
		int L = 0, R = 0;
		int len = s.length();

		for (int i = 0; i < len * 2 + 1; i++) {
			temp[i] = '.';
		}

		for (int i = 0; i < len; ++i) {
			temp[i * 2 + 1] = s.charAt(i);
		}

		z[0] = 1;
		len = len * 2 + 1;

		for (int i = 0; i < len; i++) {
			int ii = L - (i - L); // i的映射位置
			int n = R + 1 - i;
			if (i > R) {
				z[i] = match(i, i, len);
				L = i;
				R = i + z[i] - 1;
			} else if (z[ii] == n) {
				z[i] = n + match(i - n, i + n, len);
				L = i;
				R = i + z[i] - 1;
			} else {
				z[i] = (z[ii] <= n) ? z[ii] : n;
			}
		}

		// 尋找最長迴文子字串的長度。
		int n = 0, p = 0;
		for (int i = 0; i < len; ++i)
			if (z[i] > n)
				n = z[p = i];

		// 印出最長迴文子字串，記得別印特殊字元。
		StringBuilder result = new StringBuilder();
		for (int i = p - z[p] + 1; i <= p + z[p] - 1; ++i)
			if (temp[i] != '.')
				result.append(String.valueOf(temp[i]));

		return result.toString();
	}
}
