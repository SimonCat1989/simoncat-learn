package com.simoncat.learn.Q003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution_01 {

	private Map<Character, Integer> innerMap;
	
	public int lengthOfLongestSubstring(String s) {
		innerMap = new HashMap<>();
		char[] array = s.toCharArray();
		int length = array.length;
		int finalLen = 0;
		int curLen = 0;
		int previousInd = -1;
		
		for (int i = 0; i < length; i++) {
			char cur = array[i];
			if (innerMap.containsKey(cur)) {
				int ind = innerMap.get(cur);
				if (ind >= previousInd) {
					previousInd = ind;
					innerMap.put(cur, i);
					if (curLen > finalLen) {
						finalLen = curLen;
					}
					curLen = i - ind;
				} else {
					innerMap.put(cur, i);
					curLen++;
				}
			} else {
				innerMap.put(cur, i);
				curLen++;
			}
		}
		if (curLen > finalLen) {
			finalLen = curLen;
		}
		
		return finalLen;
	}
}
