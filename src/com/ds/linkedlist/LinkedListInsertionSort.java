package com.ds.linkedlist;

import com.algo.linkedlist.Node;

import static com.util.ArrayUtil.print;

/*
 * Problem link :
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Kk6mXAzqX3Y
 * https://www.youtube.com/watch?v=gAkRfdtDOaA
 * https://www.youtube.com/watch?v=gwW8U4exaYs
 * 
 */
public class LinkedListInsertionSort {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		Node head = new Node(-1, 5, 3, 4, 0, 5, 7, 2);
		Node newHead = insertionSortList1(head);
		print(newHead);
	}

	private static Node insertionSortList1(Node head) {
		Node newHead = new Node(Integer.MIN_VALUE);
		Node prev;
		Node node = head, next;
		while (null != node) {
			next = node.next;
			prev = newHead;
			while (null != prev.next && prev.next.data < node.data)
				prev = prev.next;
			node.next = prev.next;
			prev.next = node;
			node = next;
		}
		newHead = newHead.next;
		return newHead;
	}

}
