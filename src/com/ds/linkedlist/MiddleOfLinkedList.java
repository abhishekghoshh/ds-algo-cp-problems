package com.ds.linkedlist;

import com.algo.linkedlist.Node;

import static com.util.ArrayUtil.print;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * https://www.codingninjas.com/codestudio/problems/973250
 * https://www.codingninjas.com/studio/problems/middle-of-linked-list_973250
 *
 * Solution link :
 * https://www.youtube.com/watch?v=7LjQ57RqgEc
 * https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29
 *
 * https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/
 */
public class MiddleOfLinkedList {

	/*
	 * If the length is even then we will return the 2nd element
	 *  1,2,3,4,5 -> 3
	 *  1,2,3,4,5,6 -> 4
	 *  for even elements if we want to return the first element then can store that element to previous pointer
	 * */
	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// Tortoise method
	// we will take 2 pointer slow and fast.
	// one will go next, and one will go next to next,
	// So 2nd pointer will go twice the first pointer,
	// so when 2nd pointer reaches the end, the first pointer only goes to half
	private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5);
		print(head);
		Node slow = head, fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		print(head);
	}

	// brute force approach
	// first will count the length
	// now it will go half of the length
	private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5);
		print(head);
		int n = 0;
		Node node = head;
		while (null != node) {
			node = node.next;
			n++;
		}
		n = n / 2;
		node = head;
		while (n != 0) {
			node = node.next;
			n--;
		}
		print(node);
	}

}
