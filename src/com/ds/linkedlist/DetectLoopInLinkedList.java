package com.ds.linkedlist;

import com.algo.linkedlist.Node;
import com.util.PrintUtl;

import java.util.HashSet;
import java.util.Set;
/*
 * 
 * problem links :
 * https://leetcode.com/problems/linked-list-cycle/
 * https://www.codingninjas.com/codestudio/problems/628974
 * https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974
 *
 * Solution link :
 * https://www.youtube.com/watch?v=wiOo4DC5GGA
 * https://www.youtube.com/watch?v=354J83hX7RI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=35
 *
 * https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/
 * */
public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// tortoise method
	// efficient approach without any extra space
	// but it can go more than o(n)
	// as it will
	// here we have a slow node and fast node
	// slow node goes one node at a time,
	// fast node goes two nodes
	// if there is any loop then slow and fast will travel with different speed
	// and after some they will reach the same node
	// if there is no cycle then fast will exhaust automatically
	private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5);
		Node node1 = new Node(6);
		Node node2 = new Node(7, 8, 9);
		Node.attach(head, node1, node2);
		PrintUtl.print(head);
		node2.last(node1);

		Node slow = head;
		Node fast = head;
		boolean hasCycle = false;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}
		System.out.println("cycle present : " + hasCycle);
	}

	// brute force approach
	// time complexity o(n)
	// space complexity o(n)
	private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5);
		Node node1 = new Node(6);
		Node node2 = new Node(7, 8, 9);
		Node.attach(head, node1, node2);
		PrintUtl.print(head);
		node2.last(node1);

		Set<Node> set = new HashSet<>();
		boolean hasCycle = false;
		while (null != head) {
			if (set.contains(head)) {
				hasCycle = true;
				break;
			}
			set.add(head);
			head = head.next;
		}
		System.out.println("cycle present : " + hasCycle);
	}
}
