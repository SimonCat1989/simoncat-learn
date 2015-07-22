package com.simoncat.learn.Q001_TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_05_HashMap {

	private Map<Integer, List<Integer>> innerMap = new HashMap<>();

	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int cur = nums[i];
			List<Integer> orders;
			if (innerMap.containsKey(cur)) {
				orders = innerMap.get(cur);
			} else {
				orders = new ArrayList<>();
			}
			orders.add(i + 1);
			innerMap.put(cur, orders);
		}

		for (int i = 0; i < length; i++) {
			int cur = nums[i];
			int other = target - cur;
			if (cur != other && innerMap.containsKey(other)) {
				int curOrder = innerMap.get(cur).get(0);
				int otherOrder = innerMap.get(other).get(0);
				return (curOrder < otherOrder) ? new int[] { curOrder,
						otherOrder } : new int[] { otherOrder, curOrder };
			} else {
				if (cur == other && innerMap.containsKey(cur)
						&& innerMap.get(cur).size() >= 2) {
					int curOrder = innerMap.get(cur).get(0);
					int otherOrder = innerMap.get(cur).get(1);
					return (curOrder < otherOrder) ? new int[] { curOrder,
							otherOrder } : new int[] { otherOrder, curOrder };
				}
			}
		}
		return new int[] { -1, -1 };
	}
}
