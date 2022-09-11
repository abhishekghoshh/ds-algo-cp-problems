package problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/873376?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * https://www.youtube.com/watch?v=VNf6VynfpdM
 * 
 * */
public class CloneLinkedListWithRandomPointer {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// time complexity o(3n)
	// space complexity O(1)
	// we will place the new duplicate pointers in between of the exiting linked
	// list nodes in the first loop
	// on the second loop we will assign random pointers
	// on the third loop we will remove the duplicate nodes
	private static void type2() {
		Node<Integer> head = buildLinkedListWithRandomPointer();
		Node<Integer> start = head, copy, current, newHead = null, newHeadCopy = null;
		// duplicate nodes will be made
		while (null != start) {
			current = start;
			start = start.next;
			copy = new Node<>(current.data);
			copy.next = current.next;
			current.next = copy;
		}
		start = head;
		// at this point node size is 2n
		// so we don't have to check start.next
		// random pointers will be allocated at this point
		while (null != start) {
			start.next.random = null != start.random ? start.random.next : null;
			start = start.next.next;
		}
		start = head;
		// we will separate two list in this loop
		while (null != start) {
			current = start;
			start = start.next.next;
			if (null == newHead) {
				newHeadCopy = current.next;
				current.next = newHeadCopy.next;
				newHead = newHeadCopy;
			} else {
				newHeadCopy.next = current.next;
				newHeadCopy = current.next;
				current.next = newHeadCopy.next;
			}
		}
		System.out.println("Actual " + head);
		System.out.println("Copy " + newHead);
	}

	// brute force approach
	// time complexity O(2n)
	// space complexity O(n)
	private static void type1() {
		Node<Integer> head = buildLinkedListWithRandomPointer();
		Node<Integer> newHead = null, newHeadCopy = null, current, start = head;
		Map<Node<Integer>, Node<Integer>> mapping = new HashMap<>();
		while (null != start) {
			if (null == newHead) {
				newHeadCopy = new Node<>(start.data);
				newHead = newHeadCopy;
			} else {
				current = new Node<>(start.data);
				newHeadCopy.next = current;
				newHeadCopy = current;
			}
			mapping.put(start, newHeadCopy);
			start = start.next;
		}
		start = head;
		newHeadCopy = newHead;
		while (null != newHeadCopy) {
			newHeadCopy.random = null != start.random ? mapping.get(start.random) : null;
			start = start.next;
			newHeadCopy = newHeadCopy.next;
		}
		System.out.println("Actual " + head);
		System.out.println("Copy " + newHead);
	}

	private static Node<Integer> buildLinkedListWithRandomPointer() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);

		node1.random = node3;
		node2.random = node1;
		node3.random = null;
		node4.random = node2;
		node5.random = node4;

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		return node1;
	}

}
