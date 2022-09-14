package problems.linkedlist;

import java.util.HashSet;
import java.util.Set;
/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/628974?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * https://www.youtube.com/watch?v=354J83hX7RI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=35
 * 
 * */
public class HasCycle {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// tortoise method
	// efficient approach without any extra space
	// but it can go more than o(n)
	// as it will
	// here we have a slow node and fast node
	// slow node goes one node at a time
	// fast node goes two nodes
	// if there is any loop then slow and fast will travel with different speed
	// and after some they will reach to same node
	// if there is no cycle then fast will exhaust automatically
	private static void type2() {
		LinkedListNode<Integer> head = new LinkedListNode<>(1, 2).cycle(new LinkedListNode<>(10, 11), new LinkedListNode<>(15, 30, 45));
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
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
		LinkedListNode<Integer> head = new LinkedListNode<>(1, 2).cycle(new LinkedListNode<>(10, 11), new LinkedListNode<>(15, 30, 45));
		Set<LinkedListNode<Integer>> set = new HashSet<>();
		boolean hasCycle = false;
		while (null != head) {
			if (!set.contains(head)) {
				set.add(head);
				head = head.next;
			} else {
				hasCycle = true;
				break;
			}
		}
		System.out.println("cycle present : " + hasCycle);
	}
}
