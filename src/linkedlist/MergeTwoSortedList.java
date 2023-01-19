package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.LinkedListNode;


/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/800332?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * https://www.youtube.com/watch?v=Xb4slcp1U38&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=30
 * 
 * */
public class MergeTwoSortedList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized merge approach used in merge operation in merge sort
	// time complexity O(n)
	// space complexity O(1)
	// in place merge
	private static void type2() {
		LinkedListNode<Integer> list1 = new LinkedListNode<>(1, 4, 5, 7);
		LinkedListNode<Integer> list2 = new LinkedListNode<>(2, 3, 6, 8, 9);
		LinkedListNode<Integer> head = null;
		if (null != list1 && null != list2) {
			LinkedListNode<Integer> headCopy = null, current = null;
			// assigning the head and copy of head
			if (list1.data < list2.data) {
				head = headCopy = list1;
				list1 = list1.next;
			} else {
				head = headCopy = list2;
				list2 = list2.next;
			}
			// we will merge here
			while (null != list1 && null != list2) {
				if (list1.data < list2.data) {
					current = list1;
					list1 = list1.next;
				} else {
					current = list2;
					list2 = list2.next;
				}
				headCopy.next = current;// changing the next pointer of the previous node
				headCopy = current;// assigning the current pointer to next loop
			}
			// at this point either l1 or l2 is null
			// so we can directly attach the remaining linkedlist it the head
			headCopy.next = null != list1 ? list1 : list2;
		} else if (null == list1) {
			head = list2;
		} else if (null == list2) {
			head = list1;
		}
		System.out.println(head);
	}

	// brute force approach
	// putting all items in list O(n1+n2)
	// sorting the list O((n1+n2)*log(n1+n2))
	// creating the the linked list with all the items
	// time complexity O(n1+n2)+O((n1+n2)*log(n1+n2))+O(n1+n2)
	// space complexity O(2*(n1+n2)) for list+linked list
	private static void type1() {
		LinkedListNode<Integer> list1 = new LinkedListNode<>(1, 4, 5, 7);
		LinkedListNode<Integer> list2 = new LinkedListNode<>(2, 3, 6, 8, 9);
		LinkedListNode<Integer> list1Copy = list1, list2Copy = list2, head = null, headCopy = null;
		List<Integer> list = new ArrayList<>();
		while (null != list1Copy) {
			list.add(list1Copy.data);
			list1Copy = list1Copy.next;
		}
		while (null != list2Copy) {
			list.add(list2Copy.data);
			list2Copy = list2Copy.next;
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			if (null == head) {
				headCopy = new LinkedListNode<>(list.get(i));
				head = headCopy;
			} else {
				headCopy.next = new LinkedListNode<>(list.get(i));
				headCopy = headCopy.next;
			}
		}
		System.out.println(head);
	}

}
