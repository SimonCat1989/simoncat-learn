package com.simoncat.learn.Q001_TwoSum;


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
public class Solution_02_TimeLimitExceeded {

	private int[] nums;
	private int length;
	private int target;
	private int[] numOrders;

	public int[] twoSum(int[] nums, int target) {
		this.nums = nums;
		this.length = nums.length;
		this.target = target;
		this.numOrders = new int[length];
		for (int i = 0; i < length; i++) {
			this.numOrders[i] = i + 1;
		}

		// Assume the input parameter is correct.
		if (validation(this.nums)) {
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
	private boolean validation(int[] nums) {
		if (length <= 0) {
			System.out.println("Invalid input !");
			return false;
		}
		return true;
	}

	/**
	 * Sort the encapsulated number list.
	 * 
	 * @param nums
	 * @return
	 */
	private void sort() {
		int left = 0;
		int right = length - 1;

		quickSort(left, right);
	}

	/**
	 * This method is used to sort the array using quicksort algorithm. It takes
	 * the left and the right end of the array as the two cursors.
	 * 
	 * @param left
	 * @param right
	 */
	private void quickSort(int left, int right) {

		// If both cursor scanned the complete array quicksort exits
		if (left >= right)
			return;

		// For the simplicity, we took the right most item of the array as a
		// pivot
		int pivot = nums[right];
		int partition = partition(left, right, pivot);

		// Recursively, calls the quicksort with the different left and right
		// parameters of the sub-array
		quickSort(0, partition - 1);
		quickSort(partition + 1, right);
	}

	/**
	 * This method is used to partition the given array and returns the integer
	 * which points to the sorted pivot index
	 * 
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	private int partition(int left, int right, int pivot) {
		int leftCursor = left - 1;
		int rightCursor = right;
		while (leftCursor < rightCursor) {
			while (nums[++leftCursor] < pivot)
				;
			while (rightCursor > 0 && nums[--rightCursor] > pivot)
				;
			if (leftCursor >= rightCursor) {
				break;
			} else {
				swap(leftCursor, rightCursor);
			}
		}
		swap(leftCursor, right);
		return leftCursor;
	}

	/**
	 * This method is used to swap the values between the two given index
	 * 
	 * @param left
	 * @param right
	 */
	public void swap(int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		
		int tempOrder = numOrders[left];
		numOrders[left] = numOrders[right];
		numOrders[right] = tempOrder;
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

		int result = nums[low] + nums[high];
		if (result == target) {
			int lowOrder = numOrders[low];
			int highOrder = numOrders[high];
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
