package problems.linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/799352?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * hhttps://leetcode.com/problems/palindrome-linked-list/
 * 
 * Solution link : 
 * https://www.youtube.com/watch?v=-DtNInqFUXs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=37
 * 
 * TODO check https://leetcode.com/submissions/detail/797070641/
 * */
public class IsPalindromeOrNot {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// fist we will find the middle O(n/2)
	// reverse the remaining list O(n/2)
	// check for equality for list[0,n/2) and list[n/2,n) O(n/2)
	// again reverse the last half list O(n/2)
	// total time complexity O(2n)
	// space complexity O(1)
	private static void type2() {
		Node<Integer> head = null;
		head = new Node<>(1, 2, 3, 5, 3, 2, 1);
		// head = new Node<>(1, 2, 3, 3, 2, 1);
		// head = new Node<>(1, 2, 1);
		// head = new Node<>(1, 1);
		// head = new Node<>(1);
		int size = 0;
		Node<Integer> fast = head, slow = head, rightListStart, reversedRightListStart, leftListStart,
				reversedRightListStartCopy;
		boolean isPalindrome = true;
		while (null != fast && null != fast.next) {
			size = size + 2;
			slow = slow.next;
			fast = fast.next.next;
			if (null != fast && null == fast.next) {
				size++;
			}
		}
		// only one node is in linked list
		// so loop didn't got executed so slow will head pointer
		if (head != slow) {
			// adjust the right list start
			if (size % 2 == 0) {
				rightListStart = slow;
			} else {
				rightListStart = slow.next;
			}
			// reverse the remaining right
			reversedRightListStart = reverse(rightListStart);
			// check while the right list is not null or any mismatch
			reversedRightListStartCopy = reversedRightListStart;
			leftListStart = head;
			while (null != reversedRightListStart) {
				if (reversedRightListStart.data != leftListStart.data) {
					isPalindrome = false;
					break;
				}
				reversedRightListStart = reversedRightListStart.next;
				leftListStart = leftListStart.next;
			}
			// again reverse the right part
			reverse(reversedRightListStartCopy);
		}
		System.out.println("list is palidrome " + isPalindrome);
	}

	private static Node<Integer> reverse(Node<Integer> head) {
		Node<Integer> current = null, previous = null;
		while (null != head) {
			if (null == current) {
				current = head;
				head = head.next;
				current.next = null;
			} else {
				previous = current;
				current = head;
				head = head.next;
				current.next = previous;
			}
		}
		return current;
	}

	// brute force approach
	// time complexity O(2n)
	// space complexity O(n)
	private static void type1() {
		Node<Integer> head = new Node<>(1, 2, 3, 3, 2, 1);
		List<Integer> list = new ArrayList<>();
		while (null != head) {
			list.add(head.data);
			head = head.next;
		}
		int left = 0, right = list.size() - 1;
		boolean isPalindrome = true;
		while (left < right) {
			if (list.get(left) != list.get(right)) {
				isPalindrome = false;
				break;
			}
			left++;
			right--;
		}
		System.out.println("list is palidrome " + isPalindrome);
	}

}
