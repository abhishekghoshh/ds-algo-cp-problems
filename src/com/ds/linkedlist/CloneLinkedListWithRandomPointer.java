package com.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.algo.linkedlist.Node;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * https://www.codingninjas.com/codestudio/problems/873376
 * https://www.codingninjas.com/studio/problems/clone-a-linked-list-with-random-pointers_983604
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=q570bKdrnlw
 * https://www.youtube.com/watch?v=VNf6VynfpdM
 *
 * https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/
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
		Node head = buildRandom();

		Node start = head, copy, current;
		// duplicate nodes will be made
		while (null != start) {
			current = start;// creating one copy for future
			start = start.next;// goes to next element of the actual list
			copy = new Node(current.data); // creating duplicate node
			copy.next = current.next;// assigning duplicates next to current next
			current.next = copy;// assigning current next to duplicate
			// so duplicate node successfully place in between actual list node
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
		// we will create a dummy node for storing the duplicate nodes
		Node newHead = new Node(0), previous;
		previous = newHead;
		// at this point also node size is 2n
		// we will separate two list in this loop
		while (null != start) {
			current = start;// creating one copy for future
			start = start.next.next;// goes to next element of the actual list
			// pointing in between duplicate node to duplicate list's next
			previous.next = current.next;
			previous = previous.next;// previous moves to current duplicate node
			// at this point duplicate node is pointing to next element of actual list
			// so we will assign current's next pointer to duplicate's next
			// so actual list will restore again
			current.next = previous.next;
		}
		// as there was a dummy node at first
		// so we will remove it
		newHead = newHead.next;
		System.out.println("Actual " + head);
		System.out.println("Copy " + newHead);
	}

	// brute force approach
	// time complexity O(2n)
	// space complexity O(n)
	private static void type1() {
		Node head = buildRandom();
		// creating a dummy node for head at last we will remove it
		Node newHead = new Node(0);
		Node newHeadCopy = newHead;
		Node current, start = head;
		Map<Node, Node> mapping = new HashMap<>();
		while (null != start) {
			current = new Node(start.data);
			newHeadCopy.next = current;
			newHeadCopy = current;
			mapping.put(start, current);
			start = start.next;
		}
		start = head;
		// as newHead has an extra dummy pointer
		newHeadCopy = newHead.next;
		while (null != newHeadCopy) {
			newHeadCopy.random = null != start.random ? mapping.get(start.random) : null;
			start = start.next;
			newHeadCopy = newHeadCopy.next;
		}
		// as there was a dummy node at first
		// so we will remove it
		newHead = newHead.next;
		System.out.println("Actual " + head);
		System.out.println("Copy " + newHead);
	}

	private static Node buildRandom() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

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
