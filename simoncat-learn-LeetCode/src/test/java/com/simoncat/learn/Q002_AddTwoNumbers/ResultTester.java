package com.simoncat.learn.Q002_AddTwoNumbers;

import java.util.LinkedList;

import org.junit.Test;

import com.simoncat.learn.Q002_AddTwoNumbers.Solution_01.ListNode;

public class ResultTester {

	private ListNode createTestResource(int num) {
		ListNode head = new ListNode(0);
		ListNode pointer = head;
		ListNode cur;
		while(num > 0) {
			int val = num % 10;
			num = num / 10;
			
			cur = new ListNode(val);
			pointer.next = cur;
			pointer = cur;
		}
		return head.next;
	}
	
	@Test
	public void test1() {
		Solution_01 solution = new Solution_01();
		ListNode l1 = createTestResource(12);
		ListNode l2 = createTestResource(122);
		ListNode expected = createTestResource(134);
		ListNode result = solution.addTwoNumbers(l1, l2);
		while(expected != null && result != null) {
			System.out.println("Result is : " + result.val
					+ " and Expected is : " + expected.val + ". It's " + (result.val == expected.val));
			expected = expected.next;
			result = result.next;
		}
	}
	
	@Test
	public void test2() {
		Solution_01 solution = new Solution_01();
		ListNode l1 = createTestResource(5);
		ListNode l2 = createTestResource(5);
		ListNode expected = createTestResource(10);
		ListNode result = solution.addTwoNumbers(l1, l2);
		while(expected != null && result != null) {
			System.out.println("Result is : " + result.val
					+ " and Expected is : " + expected.val + ". It's " + (result.val == expected.val));
			expected = expected.next;
			result = result.next;
		}
		if (expected != null || result != null) {
			System.out.println("Result is Wrong");
		}
	}
}
