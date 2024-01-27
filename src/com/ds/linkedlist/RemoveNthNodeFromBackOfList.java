package com.ds.linkedlist;

import com.algo.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

import static com.util.PrintUtl.print;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * https://www.codingninjas.com/codestudio/problems/799912
 * https://www.codingninjas.com/studio/problems/delete-kth-node-from-end_799912
 *
 * Solution link :
 * https://www.youtube.com/watch?v=3kMKYQ2wNIU
 * https://www.youtube.com/watch?v=Lhu3MsXZy-Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=31
 *
 * https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/
 * */
public class RemoveNthNodeFromBackOfList {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 3;
		Node result = removeNthFromEnd4(head, n);
		print(result);
	}

	public static Node removeNthFromEnd4(Node head, int n) {
		if (head.next == null) return null;
		// Create two pointers, fast and slow
		Node fast = head;
		Node slow = head;

		// Move the fast pointer N nodes ahead
		for (int i = 0; i < n; i++)
			fast = fast.next;

		// If fast becomes null, the Nth node from the end is the head
		if (fast == null) return head.next;

		// Move both pointers until fast reaches the end
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		// Delete the Nth node from the end
        slow.next = slow.next.next;
        return head;
	}

	// TODO explain this in the interview
	// TODO check once more
	// same as previous just a little optimized
	private static void type3() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 3;
		Node result = removeNthFromEnd3(head, n);
		print(result);
	}

	public static Node removeNthFromEnd3(Node head, int n) {
		// if there is a single pointer, then we will return null
		// because n can be maximum and minimum 1
		// we have to remove the head pointer
		if (head.next == null) return null;
		// we will add a dummy pointer at the start
		// for our reference because the head pointer can also be deleted
		Node right = new Node();
		right.next = head;
		// moving the right pointer to the end of the window
		// after n operation it right will go to the last element of the window
		for (int i = 0; i < n; i++)
			right = right.next;
		// as we have added a node for the previous,
		// that is why we have again added one dummy node
		Node start = new Node();
		Node left = start;
		left.next = head;
		while (right != null && right.next != null) {
			right = right.next;
			left = left.next;
		}
		// detaching the pointer
		left.next = left.next.next;
		return start.next;
	}
	// two pointer or sliding window technique
	// time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 3;
		Node result = removeNthFromEnd2(head, n);
		print(result);
	}

	public static Node removeNthFromEnd2(Node head, int n) {
		// if there is a single pointer, then we will return null
		// because n can be maximum and minimum 1
		// we have to remove the head pointer
		if (head.next == null) return null;
		Node left = head, right = head, prev;
		// moving the right pointer to the end of the window
		// after n-1 operation it right will go to the last element of the window
		for (int i = 1; i < n && null != right; i++)
			right = right.next;

		// right will be null only if listLength <= n
		// suppose the length of list is n, then after only n-1 traversal it will go to
		// the last element
		if (null == right || null == right.next) {
			head = head.next;
		} else {
			// suppose the list is 1 2 3 4 5 6 7 8 9 and n = 3
			// then after n-1=2 traversal right will go 3 and left is 1
			// We will slide the window to the last element not the null
			// at this point right will be 9 and left will be 7
			// our target is to remove 7
			// we will assign the left pointer to prev before moving it to next,
			// so prev is pointing to 6 now
			// our work is now 6.next=7.next then free the 7 pointer
			prev = left;
			while (null != right.next) {
				right = right.next;
				prev = left;
				left = left.next;
			}
			prev.next = left.next;
		}
		return head;
	}


	// brute force approach
	// we will store finds out the nth node
	// by storing all the nodes in an array list
	// then we will just point the prev.next = node.next
	private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5);
		int n = 2;
		Node result = removeNthFromEnd1(head, n);
		print(result);
	}

	public static Node removeNthFromEnd1(Node head, int n) {
		// if there is a single pointer, then we will return null
		// because n can be maximum and minimum 1
		// we have to remove the head pointer
		if (head.next == null) return null;
		List<Node> list = new ArrayList<>();
		Node node = head;
		while (null != node) {
			list.add(node);
			node = node.next;
		}
		int size = list.size();
		// if linked list size equal to n
		// then we have to remove the first pointer
		if (size == n) return head.next;
		// we will get the target pointer and it's previous pointer
		node = list.get(size - n);
		Node prev = list.get(size - n - 1);
		// we will change the pointer
		prev.next = node.next;
		return head;
	}

}
