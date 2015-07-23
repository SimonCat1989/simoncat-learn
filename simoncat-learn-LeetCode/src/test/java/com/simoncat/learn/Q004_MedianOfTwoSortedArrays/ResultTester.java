package com.simoncat.learn.Q004_MedianOfTwoSortedArrays;

import org.junit.Test;


public class ResultTester {
	
	private static final int[] NUMS1 = new int[]{1,2,3,4,5};
	private static final int[] NUMS2 = new int[]{8,9,10};
	
	@Test
	public void test1() {
		Solution_01 solution = new Solution_01();
		double result = solution.findMedianSortedArrays(NUMS1, NUMS2);
		System.out.println("The result is :" + result + ". " + (result == 4.5));
	}
}
