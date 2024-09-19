package com.problems.linkedlist;

import com.ds.linkedlist.Node;

import java.util.Stack;

import static com.util.PrintUtl.print;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/reverse-linked-list/
 * https://www.naukri.com/code360/problems/799897
 * https://www.naukri.com/code360/problems/reverse-linked-list_920513
 *
 * Solution link :
 * https://www.youtube.com/watch?v=D2vI2DNJGd8
 * https://www.youtube.com/watch?v=iRtLEoL-r-g
 *
 * https://takeuforward.org/data-structure/reverse-a-linked-list/
 * */
public class ReverseOfLinkedList {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}


	// this is a recursive approach
	// where we store the recursion stack to store the pointer
	// after each recursion we reverse the pointer direction
	private static void type4() {
		Node head = new Node(10, 6, 9, 15, 30);
		print(head);
		head = reverseLinkedList(head);
		print(head);
	}

	// Function to reverse a singly
	// linked list using a recursion
	public static Node reverseLinkedList(Node head) {
		// If the linked list is empty or has only one node, return the head as it is already reversed.
		if (head == null || head.next == null) return head;
		// Reverse the linked list starting
		// from the second node (head.next).
		Node newHead = reverseLinkedList(head.next);
		// Save a reference to the node following the current 'head' node.
		Node next = head.next;
		// Make the 'front' node point to the current 'head' node in the reversed order.
		next.next = head;
		// Break the link from the current 'head' node to the 'front' node to avoid cycles.
		head.next = null;
		// Return the 'newHead,' which is the new head of the reversed linked list.
		return newHead;
	}

	// TODO explain this in the interview
	// In place reverse without extra space
	private static void type3() {
		Node head = new Node(10, 6, 9, 15, 30);
		print(head);
		// new head is the new head, at first it is assigned to null
		// next pointer is to store the next pointer until we do the intermediate
		// operation
		// while(null!=head){next = head.next;head = next;}
		// the upper code snippet will traverse the linkedlist
		// newHead actually keeps track of the previous element
		// at first we are assigning next element to next pointer otherwise we will
		// lose the next pointer, then we are attaching the next pointer to previous
		// here we are breaking the forward link and establishes a reverse link
		// then we are assigning current node to previous, which will help in the next iteration
		Node prev = null, next, curr = head;
		while (null != curr) {
			next = curr.next;
			curr.next = prev;// attaching the pointer to the previous element
			prev = curr;// assigning the previous pointer to current
			curr = next;
		}
		print(prev);

	}

	// We will use a stack to store the pointer's data in reverse
	// then we will connect
	private static void type2() {
		Node head = new Node(10, 6, 9, 15, 30);
		print(head);
		// Create a temporary pointer to traverse the linked list
		Node node = head;
		// Create a stack to temporarily store the data values
		Stack<Integer> stack = new Stack<>();
		// Step 1: Push the values of the linked list onto the stack
		while (node != null) {
			// Push the current node's data onto the stack
			stack.push(node.data);
			// Move to the next node in the linked list
			node = node.next;
		}
		// Reset the temporary pointer to the head of the linked list
		node = head;
		// Step 2: Pop values from the stack
		// and update the linked list
		while (node != null) {
			// Set the current node's data to the value at the top of the stack
			node.data = stack.pop();
			// Move to the next node in the linked list
			node = node.next;
		}
		// Return the new head of the reversed linked list
		print(head);
	}

	// Brute force approach
	// we will store the pointers in an array
	// then we will attach the pointer links in reverse
	private static void type1() {

	}
}
