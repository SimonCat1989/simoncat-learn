package com.simoncat.learn.Q001_TwoSum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <ul>
 * <li>
 * Make a order of inputed numbers. Set <code>low</code> and <code>high</code>
 * indexes and the initial values are the first one and the last one.</li>
 * <li>
 * Plus the <code>low</code> value with <code>high</code> value as result:
 * <ul>
 * <li>
 * If result EQUAL target, bingo !</li>
 * <li>
 * If result LESS THAN target, move <code>low</code> to next one.</li>
 * <li>
 * If result GREATER THAN target, move <code>high</code> to previous one.</li>
 * </ul>
 * </li>
 * <li>
 * Continuously do as above until <code>low</code> meets <code>high</code></li>
 * </ul>
 * 
 * @author simoncat
 *
 */
public class Solution_04_AcceptedWithBest {
	class InnerValue {
		int order;
		int value;

		public InnerValue(int order, int value) {
			super();
			this.order = order;
			this.value = value;
		}
	}

	private InnerValue[] objectNums;
	private int length;
	private int target;

	public int[] twoSum(int[] nums, int target) {
		this.length = nums.length;
		this.target = target;
		this.objectNums = new InnerValue[this.length];
		for (int i = 0; i < this.length; i++) {
			this.objectNums[i] = new InnerValue(i + 1, nums[i]);
		}

		// Assume the input parameter is correct.
		// Algorithm start
		sort();
		return calculate(0, length - 1);
	}

	/**
	 * Sorts the specified range of the array.
	 */
	private void sort() {
		Arrays.sort(this.objectNums, new Comparator<InnerValue>() {

			@Override
			public int compare(InnerValue o1, InnerValue o2) {
				int val1 = o1.value;
				int val2 = o2.value;
				if (val1 == val2)
					return 0;
				else
					return (val1 > val2) ? 1 : -1;
			}
		});
	}

	/**
	 * Calculate the two indexes.
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @param target
	 * @return
	 */
	private int[] calculate(int low, int high) {
		if (low >= high) {
			return new int[] { -1, -1 };
		}

		int result = objectNums[low].value + objectNums[high].value;
		if (result == target) {
			int lowOrder = objectNums[low].order;
			int highOrder = objectNums[high].order;
			return (lowOrder < highOrder) ? new int[] { lowOrder, highOrder }
					: new int[] { highOrder, lowOrder };
		} else {
			if (result < target) {
				return calculate(++low, high);
			}
			return calculate(low, --high);
		}
	}
}
