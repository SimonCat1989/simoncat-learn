package com.simoncat.learn.Q001_TwoSum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
public class Solution_01_StackOverFlow {

	public int[] twoSum(int[] nums, int target) {
		// Assume the input parameter is correct.
		if (validation(nums)) {
			// Algorithm start
			return calculate(sort(capsulate(nums)), 0, nums.length - 1, target);
		}
		return new int[] { -1, -1 };
	}

	/**
	 * Validation for input parameters.
	 * 
	 * @param nums
	 * @return
	 */
	private boolean validation(int[] nums) {
		if (nums.length <= 0) {
			System.out.println("Invalid input !");
			return false;
		}
		return true;
	}

	/**
	 * Encapsulate the input numbers in order to keep the original orders
	 * information.
	 * 
	 * @param nums
	 * @return
	 */
	private List<Operator> capsulate(int[] nums) {
		int length = nums.length;
		List<Operator> result = new ArrayList<>(length);
		for (int i = 0; i < length; i++) {
			result.add(new Operator(i + 1, nums[i]));
		}
		return result;
	}

	/**
	 * Sort the encapsulated number list.
	 * 
	 * @param nums
	 * @return
	 */
	private List<Operator> sort(List<Operator> nums) {
		nums.sort(new Comparator<Operator>() {

			@Override
			public int compare(Operator o1, Operator o2) {
				if (o1.getValue() == o2.getValue())
					return 0;
				return (o1.getValue() < o2.getValue()) ? -1 : 1;
			}
		});
		return nums;
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
	private int[] calculate(List<Operator> nums, int low, int high, int target) {
		if (low >= high) {
			return new int[] { -1, -1 };
		}

		int result = nums.get(low).getValue() + nums.get(high).getValue();
		if (result == target) {
			int lowOrder = nums.get(low).getOrder();
			int highOrder = nums.get(high).getOrder();
			return (lowOrder < highOrder) ? new int[] { lowOrder, highOrder }
					: new int[] { highOrder, lowOrder };
		} else {
			if (result < target) {
				return calculate(nums, ++low, high, target);
			}
			return calculate(nums, low, --high, target);
		}
	}

	/**
	 * Inner Class used to hold order information
	 * 
	 * @author simoncat
	 *
	 */
	class Operator {
		private final int order;
		private final int value;

		public Operator(int order, int value) {
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
}
