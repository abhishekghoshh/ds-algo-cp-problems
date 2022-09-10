package problems.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// efficient approach without any extra space
	// but it can go more than o(n)
	// as it will
	// tortoise method
	// here we have a slow node and fast node
	// slow node goes one node at a time
	// fast node goes two nodes
	// if there is any loop then slow and fast will travel with different speed
	// and after some they will reach to same node
	// if there is no cycle then fast will exhaust automatically
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2).cycle(new Node<>(10, 11), new Node<>(15, 30, 45));
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		boolean hasCycle = false;
		while (null != fast && null != fast.next) {
			if (fast.next.next == null) {
				// no cycle is present
				// early break to reduce extra computation
				break;
			}
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
		Node<Integer> head = new Node<>(1, 2).cycle(new Node<>(10, 11), new Node<>(15, 30, 45));
		Set<Node<Integer>> set = new HashSet<>();
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
