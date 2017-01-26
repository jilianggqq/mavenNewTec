package edu.gqq.leetcode;

public class OddEvenLinkedList_328 {
	public ListNode oddEvenList(ListNode head) {
		ListNode dim1 = new ListNode(0);
		ListNode dim2 = new ListNode(0);
		ListNode odd = dim1;
		ListNode even = dim2;
		boolean isOdd = true;
		while (head != null) {
			// System.out.println(head.val);
			if (isOdd) {
				odd.next = head;
				odd = odd.next;
//				odd.next = null;
				isOdd = false;
			} else {
				even.next = head;
				even = even.next;
//				even.next = null;
				isOdd = true;
			}
			head = head.next;
		}
		even.next = null;
		ListNode test1 = dim1;
		// while (test1 != null) {
		// System.out.println(x);
		// }

		odd.next = dim2.next;
		return dim1.next;
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
		OddEvenLinkedList_328 odd = new OddEvenLinkedList_328();
		ListNode fin = odd.oddEvenList(ln1);
		while (fin != null) {
			System.out.println(fin.val);
			fin = fin.next;
		}
		System.out.println(1);
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
