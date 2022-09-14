package problems.linkedlist;

import java.util.ArrayList;
import java.util.List;

import util.LinkedListNode;

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
		LinkedListNode<Integer> head = null;
		head = new LinkedListNode<>(1, 2, 3, 5, 3, 2, 1);
		// head = new LinkedListNode<>(1, 2, 3, 3, 2, 1);
		// head = new LinkedListNode<>(1, 2, 1);
		// head = new LinkedListNode<>(1, 1);
		// head = new LinkedListNode<>(1);
		int size = 0;
		LinkedListNode<Integer> fast = head, slow = head, right, left, rightCopy;
		boolean isPalindrome = true;
		while (null != fast && null != fast.next) {
			size = size + 2;
			slow = slow.next;
			fast = fast.next.next;
			// fast is standing on last element
			// number of nodes are odd
			if (null != fast && null == fast.next) {
				size++;
			}
		}
		// head==slow will occur when only one node is in linked list
		// as loop didn't got executed so slow will head pointer
		if (head != slow) {
			// adjust the right list start
			// if size is odd then slow will point it exactly middle of the node
			// so we have to move it to next
			// if size is even then then it will be at the starting of the 2nd half
			if (size % 2 == 1) {
				slow = slow.next;
			}
			// reverse the remaining right
			rightCopy = right = reverse(slow);
			left = head;
			// check while the right list is not null or any mismatch
			while (null != right) {
				if (right.data != left.data) {
					isPalindrome = false;
					break;
				}
				right = right.next;
				left = left.next;
			}
			// again reverse the right part
			reverse(rightCopy);
		}
		System.out.println("list is palidrome " + isPalindrome);
	}

	private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> current = null, previous = null;
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
		LinkedListNode<Integer> head = new LinkedListNode<>(1, 2, 3, 3, 2, 1);
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
