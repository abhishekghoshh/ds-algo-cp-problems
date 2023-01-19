package linkedlist;

import util.LinkedListNode;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/add-two-numbers-as-linked-lists_1170520?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/add-two-numbers/ 
 * 
 * https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=33
 * 
 * */
public class AddTwoNumbers {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// time complexity o(max(m,n))
	// space complexity O(1)
	// in place summation
	// here we will modify the existing list
	// we will use l1 if it's not null else l2
	private static void type2() {
//		LinkedListNode<Integer> l1 = new LinkedListNode<>(2, 4, 3, 5);
//		LinkedListNode<Integer> l2 = new LinkedListNode<>(5, 6, 4, 4, 8, 2);
		LinkedListNode<Integer> l1 = new LinkedListNode<>(9, 9, 9, 9, 9, 9, 9, 9);
		LinkedListNode<Integer> l2 = new LinkedListNode<>(9, 9, 9, 9);
		int carry = 0, sum;
		// assigning head to l1 or l2
		LinkedListNode<Integer> head = null != l1 ? l1 : l2;
		// made a copy of head for our computation
		LinkedListNode<Integer> prev = head;
		while (null != l1 || null != l2 || carry != 0) {
			sum = ((null != l1) ? l1.data : 0) + ((null != l2) ? l2.data : 0) + carry;
			if (null != l1) {
				// we are assuming that we will use l1 if not null
				l1.data = sum % 10;
				prev = l1;
			} else if (null == l1 && null != l2) {
				// we will use l2 for computation
				l2.data = sum % 10;
				// l1 has exhausted then we need to point last of l1 to current node of l2
				// prev was point to l1 so prev.next=l2 will work
				// after attaching now assign l2 to prev
				prev.next = l2;
				prev = l2;
			} else {
				prev.next = new LinkedListNode<>(carry);
			}
			carry = sum / 10;
			l1 = (null != l1) ? l1.next : l1;
			l2 = (null != l1) ? l1.next : l1;
		}
		head.print();
	}

	// time complexity o(max(m,n)+1)
	// space o(max(m,n)+1)
	private static void type1() {
		LinkedListNode<Integer> l1 = new LinkedListNode<>(2, 4, 3, 5);
		LinkedListNode<Integer> l2 = new LinkedListNode<>(5, 6, 4);
		int carry = 0, sum = 0;
		// assigning a dummy pointer
		LinkedListNode<Integer> head = new LinkedListNode<>(0);
		// prev will pointing to head
		LinkedListNode<Integer> prev = head, current;
		// loop will go until both is null or carry is 0
		while (null != l1 || null != l2 || carry != 0) {
			// sum and carry is calculated even if there is any null list
			sum = ((null != l1) ? l1.data : 0) + ((null != l2) ? l2.data : 0) + carry;
			carry = sum / 10;
			// temporary creating node
			current = new LinkedListNode<>(sum % 10);
			// attaching current pointer to the previous pointer
			// and then assigning current pointer to previous
			prev.next = current;
			prev = current;
			// going to next node if list is not null
			l1 = (null != l1) ? l1.next : l1;
			l2 = (null != l1) ? l1.next : l1;
		}
		head = head.next;
		head.print();
	}

}
