package problems.linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/763406?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=Of0HPkk3JgI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=35
 * 
 * */
public class ReverseLinkedlistInGroupsOfSizeK {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// In place reversal
	// O(n) for calculating the length
	// O(n) for in place reversal
	// total time complexity O(2n)
	// space complexity O(1)
	private static void type3() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		int k = 4;
		if (null != head && null != head.next && k != 1) {
			int length = length(head);
			// we are taking 3 pointers here previous, current and next
			// as the first pointer does not have any previous so we will add dummy node
			Node<Integer> dummyHead = new Node<>(0);
			dummyHead.next = head;
			Node<Integer> previous = dummyHead, current, next;
			// we will start from 1
			while (length >= k) {
				current = previous.next;
				next = current.next;
				for (int i = 1; i < k; i++) {
					// at the starting list is 0->1->2->3->4, pre=0 cur=1 next=2
					// after 1 iteration, it will be 0->2->1->3->4, pre=0,cur=1,next=3
					// after 2 iteration, it will be 0->3->2->1->4, pre=0,cur=1,next=4
					// the main operation is to take the next element and put it at the first
					// we are not changing the current or previous
					current.next = next.next;
					next.next = previous.next;
					previous.next = next;
					next = current.next;
				}
				previous = current;
				length -= k;
			}
			head = dummyHead.next;
		}
		System.out.println("rotated list is " + head);
	}

	private static int length(Node<Integer> head) {
		int count = 0;
		while (null != head) {
			count++;
			head = head.next;
		}
		return count;
	}

	// sliding window
	// O(n) for sliding the window
	// O(n) for reversal of window in every k
	// total time complexity O(2n)
	// space complexity O(1)
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		int k = 3;
		// start will always be last pointer of the previous window
		// for the first element there is no previous so we have added a dummy pointer
		// then attach the head with the dummy pointer
		// from go first to last node of any window we need to go size-1 step
		int n = k - 1;
		Node<Integer> dummy = new Node<>(0);
		dummy.next = head;
		Node<Integer> start = dummy, current = head, next, right, left;
		while (null != current) {
			// if we start traversing from start of the window then
			// after k-1 operation current will be on last node of window
			if (n == 0) {
				// breaks the link of windows last node to the start of the next window
				// else reverse function will reverse all the remaining node
				next = current.next;
				current.next = null;
				current = next;
				// now start= 0->window=1->2->3->null current=4
				// left is 1
				left = start.next;
				right = reverse(left);
				// after reverse right is 3 and list is 0->1<-2<-3||4->5->6..
				start.next = right; // 0->3
				left.next = current;// 1->4
				start = left; // start=3
				n = k - 1;
			} else if (null == current.next) {
				// current.next is null then it is the last node but n!=0
				// that means it is the last window that we can ignore
				// if we have to reverse this last uneven window then we can just add this
				// condition to the previous if clause
				// if (n == 0 || null == current.next)
				break;
			} else {
				current = current.next;
				n--;
			}
			//
		}
		head = dummy.next;
		System.out.println("rotated list is " + head);
	}

	private static Node<Integer> reverse(Node<Integer> head) {
		Node<Integer> current = null, previous = null;
		while (null != head) {
			previous = current;
			current = head;
			head = head.next;
			current.next = previous;
		}
		return current;
	}

	// brute force
	// O(n) for inserting everything on array
	// O(n) for reversal of the array
	// O(n) to put it back to linked list
	// total time complexity O(3n)
	// space complexity O(n)
	private static void type1() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		int k = 3;
		List<Node<Integer>> list = new ArrayList<>();
		int left = 0, right = 0;
		Node<Integer> current = head, next;
		while (null != current) {
			next = current.next;
			current.next = null;
			list.add(current);
			right++;
			if (right % k == 0) {
				reverse(list, left, right - 1);
				left = right;
			}
			if (null == next) {
				break;
			}
			current = next;
		}
		head = new Node<>(0);
		current = head;
		for (Node<Integer> item : list) {
			current.next = item;
			current = current.next;
		}
		head = head.next;
		System.out.println("rotated list is " + head);
	}

	private static void reverse(List<Node<Integer>> list, int left, int right) {
		Node<Integer> leftElement;
		while (left < right) {
			leftElement = list.get(left);
			list.set(left, list.get(right));
			list.set(right, leftElement);
			left++;
			right--;
		}

	}

}
