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
		type2();
	}

	// TODO explain the first type then optimize to the current type in the interview
	// similar to previous type
	// but with the little optimization
	private static void type2() {
		Node head = new Node(-1, 5, 3, 4, 0, 5, 7, 2);
		Node newHead = insertionSortList2(head);
		print(newHead);
	}

	private static Node insertionSortList2(Node head) {
		Node newHead = new Node(Integer.MIN_VALUE);
		// here we will also store the last value of the sorted list
		// if the current node value is greater than last node pf the sorted list
		// then we can directly append to the last node and update the last node
		Node last = newHead;
		Node node = head, next;
		while (null != node) {
			next = node.next;
			// if the current node data value is greater than previous
			// then we don't need to do anything
			// we will just attach it to the previous
			if (last.data <= node.data) {
				last.next = node;
				last = node;
			} else {
				// else we have to insert the node
				insert(node, newHead);
			}
			node = next;
		}
		last.next = null;
		return newHead.next;
	}

	// simple insertion approach
	private static void type1() {
		Node head = new Node(-1, 5, 3, 4, 0, 5, 7, 2);
		Node newHead = insertionSortList1(head);
		print(newHead);
	}

	private static Node insertionSortList1(Node head) {
		// first we will create a dummy node with Integer.MIN_VALUE
		// we know all our nodes will be bigger than this
		// so this new head will become the sorted list.
		//  we will traverse the list, and then we will add the node into
		// the sorted list to its proper position
		Node newHead = new Node(Integer.MIN_VALUE);
		Node node = head, next;
		while (null != node) {
			next = node.next;
			// from the start of the list we will check
			// insert the node to its proper position
			insert(node, newHead);
			node = next;
		}
		newHead = newHead.next;
		return newHead;
	}

	private static void insert(Node node, Node head) {
		// head is the dummy node with Integer.MIN_VALUE
		// so any node whatever is the value will be added after this;
		// we will try to find the node after which the current node
		// should be added
		Node prev = head;
		// we all always check with the nxt value data
		// if next value data is also lesser than current node data
		// then we go to the next again, continue
		while (null != prev.next && prev.next.data < node.data)
			prev = prev.next;
		// so we have find out the position
		// node will be placed inside prev and prev.next
		node.next = prev.next;
		prev.next = node;
	}

}
