package com.simoncat.learn.Q002_AddTwoNumbers;

public class Solution_01 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode head = result;
		int plus = 0;
		
		while (l1 != null && l2 != null) {
			int res = l1.val + l2.val + plus;
			ListNode cur;
			if (res > 9) {
				cur = new ListNode(res - 10);
				plus = 1;
			} else {
				cur = new ListNode(res);
				plus = 0;
			}
			result.next = cur;
			
			l1 = l1.next;
			l2 = l2.next;
			result = cur;
		}
		
		while (l1 != null) {
			int res = l1.val + plus;
			ListNode cur;
			if (res > 9) {
				cur = new ListNode(res - 10);
				plus = 1;
			} else {
				cur = new ListNode(res);
				plus = 0;
			}
			result.next = cur;
			
			l1 = l1.next;
			result = cur;
		}
		
		while (l2 != null) {
			int res = l2.val + plus;
			ListNode cur;
			if (res > 9) {
				cur = new ListNode(res - 10);
				plus = 1;
			} else {
				cur = new ListNode(res);
				plus = 0;
			}
			result.next = cur;
			
			l2 = l2.next;
			result = cur;
		}
		
		if (plus != 0) {
			result.next = new ListNode(1);;
		}
		
		return head.next;
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
