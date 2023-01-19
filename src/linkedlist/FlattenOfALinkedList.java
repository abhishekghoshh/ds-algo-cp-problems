package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import util.LinkedListNode;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/1112655?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=ysytSSXpAI0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=39
 * 
 * Read 
 * https://www.geeksforgeeks.org/flattening-a-linked-list/
 * */
//Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
//(i) a next pointer to the next node,
//(ii) a bottom pointer to a linked list where this node is head.
//Each of the sub-linked-list is in sorted order.
//Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
//Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
public class FlattenOfALinkedList {

	public static void main(String[] args) {
		LinkedListNode.TO_STRING_APPROACH = LinkedListNode.ToStringApproach.WITH_BOTTOM;
		type1();
		type2();
		type3();
	}

	// using priority queue
	// same approach used in merge K sorted list into one list
	// time complexity O(n*m*log(n))
	// space complexity O(n) for priority queue
	private static void type3() {
		LinkedListNode<Integer> head = new LinkedListNode<>(5).bottom(7, 8, 30).attach(new LinkedListNode<>(10).bottom(20))
				.attach(new LinkedListNode<>(19).bottom(22, 50)).attach(new LinkedListNode<>(28).bottom(35, 40, 45));
		PriorityQueue<LinkedListNode<Integer>> heap = new PriorityQueue<>(
				(node1, node2) -> Integer.compare(node1.data, node2.data));
		LinkedListNode<Integer> current = head, next, lowest, currentLowest;
		while (null != current) {
			heap.offer(current);
			next = current.next;
			current.next = null;
			current = next;
		}
		head = new LinkedListNode<>(0);
		current = head;
		while (!heap.isEmpty()) {
			lowest = heap.poll();
			if (!heap.isEmpty()) {
				currentLowest = heap.peek();
				while (null != lowest && lowest.data <= currentLowest.data) {
					current.bottom = lowest;
					lowest = lowest.bottom;
					current = current.bottom;
				}
				if (null != lowest) {
					heap.offer(lowest);
				}
			} else {
				while (null != lowest) {
					current.bottom = lowest;
					lowest = lowest.bottom;
					current = current.bottom;
				}
			}
		}
		head = head.bottom;
		System.out.println(head);
	}

	// merge approach
	// recursively merge last and second last then merge it to previous and the
	// process goes on
	// let's say there is n right nodes and on each m bottom nodes
	// total time complexity O(n*n*m)
	// space complexity O(1)
	private static void type2() {
		LinkedListNode<Integer> head = new LinkedListNode<>(5).bottom(7, 8, 30).attach(new LinkedListNode<>(10).bottom(20))
				.attach(new LinkedListNode<>(19).bottom(22, 50)).attach(new LinkedListNode<>(28).bottom(35, 40, 45));
		head = flatten(head);
		System.out.println(head);
	}

	private static LinkedListNode<Integer> flatten(LinkedListNode<Integer> head) {
		if (null == head || null == head.next) {
			return head;
		}
		head.next = flatten(head.next);
		head = merge(head, head.next);
		// at this point l1 and l2 are merged in l1's bottom
		// but there is a link between l1.next and l2
		// so, after merge operation we are breaking the next link
		head.next = null;
		return head;
	}

	// merge opration
	private static LinkedListNode<Integer> merge(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		// as l1 and l2 sorted order and the linked list it also sorted
		// so l1.data<l2.data
		// first pointer will always be l1's
		LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
		LinkedListNode<Integer> prev = dummy;
		while (null != l1 && null != l2) {
			if (l1.data <= l2.data) {
				prev.bottom = l1;
				prev = l1;
				l1 = l1.bottom;
			} else {
				prev.bottom = l2;
				prev = l2;
				l2 = l2.bottom;
			}
		}
		if (null != l1) {
			prev.bottom = l1;
		} else {
			prev.bottom = l2;
		}

		return dummy.bottom;
	}

	// brute force approach
	// let's say there is n right nodes and on each m bottom nodes
	// O(n*m) to put it in array
	// O((n*m)log(n*m)) to sort the array
	// O(n*m) to create new linked list
	// total time complexity O(2*m*n)+O(m*n*log(m*n))
	// space complexity O(m*n) to store it in array
	private static void type1() {
		LinkedListNode<Integer> head = new LinkedListNode<>(5).bottom(7, 8, 30).attach(new LinkedListNode<>(10).bottom(20))
				.attach(new LinkedListNode<>(19).bottom(22, 50)).attach(new LinkedListNode<>(28).bottom(35, 40, 45));
		LinkedListNode<Integer> current = head, bottom, next, bottomNext;
		List<LinkedListNode<Integer>> list = new ArrayList<>();
		while (null != current) {
			bottom = current;
			while (null != bottom) {
				list.add(bottom);
				bottomNext = bottom.bottom;
				bottom.bottom = null;
				bottom = bottomNext;
			}
			next = current.next;
			current.next = null;
			current = next;
		}
		Collections.sort(list, (node1, node2) -> Integer.compare(node1.data, node2.data));
		head = new LinkedListNode<>(0);
		current = head;
		for (LinkedListNode<Integer> node : list) {
			current.bottom = node;
			current = node;
		}
		head = head.bottom;
		System.out.println(head);
	}

}
