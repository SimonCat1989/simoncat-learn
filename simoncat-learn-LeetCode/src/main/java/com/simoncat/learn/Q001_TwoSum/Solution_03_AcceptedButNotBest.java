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
public class Solution_03_AcceptedButNotBest {

	class InnerValue {
		private int order;
		private int value;

		public InnerValue(int order, int value) {
			super();
			this.order = order;
			this.value = value;
		}

		public int getOrder() {
			return order;
		}

		public int getValue() {
			return value;
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
		if (validation()) {
			// Algorithm start
			sort();
			return calculate(0, length - 1);
		}
		return new int[] { -1, -1 };
	}

	/**
	 * Validation for input parameters.
	 * 
	 * @param nums
	 * @return
	 */
	private boolean validation() {
		if (length <= 0) {
			System.out.println("Invalid input !");
			return false;
		}
		return true;
	}

	/**
	 * Sorts the specified range of the array.
	 */
	private void sort() {
		Arrays.sort(this.objectNums, new Comparator<InnerValue>() {

			@Override
			public int compare(InnerValue o1, InnerValue o2) {
				if (o1.getValue() == o2.getValue())
					return 0;
				else
					return (o1.getValue() > o2.getValue()) ? 1 : -1;
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

		int result = objectNums[low].getValue() + objectNums[high].getValue();
		if (result == target) {
			int lowOrder = objectNums[low].getOrder();
			int highOrder = objectNums[high].getOrder();
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
