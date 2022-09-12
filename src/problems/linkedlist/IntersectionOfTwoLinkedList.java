package problems.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/630457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34
 * 
 * */
public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
		type4();
	}

	// best optimized approach
	// two linked list having common point
	// time complexity O(2*max(n1,n2)))
	// space complexity O(1)
	// let's say n1<n2 and n1=m1+d and n2=m2+d
	// l1 will exhaust after m1+d traversal then we are assigning it to l2
	// same with l2
	// l2 will exhaust after m2+d traversal then we are assigning it to l1
	// let say after exhausting l1 again starts from l1, so it will have to go m2
	// distance to find intersection, so after m1+d+m2 distance first pointer will
	// again find the intersection point
	// after exhausting l2 again starts from l1, so it will have to go m1
	// distance to find intersection, so after m2+d+m1 distance second pointer will
	// again find the intersection point
	// both the point is traversing with same speed, and we after m1+m2+d the both
	// pointer will be same
	// so if we traverse both pointer in a loop until they became same then we will
	// find our answer
	private static void type4() {
		Node<Integer> common = new Node<>(15, 30);
		Node<Integer> headA = new Node<>(10, 6, 9).next(common);
		Node<Integer> headB = new Node<>(10, 11).next(common);
		Node<Integer> h1 = headA, h2 = headB;
		while (h1 != h2) {
			h1 = null != h1 ? h1.next : headB;
			h2 = null != h2 ? h2.next : headA;
		}
		// if there is no intersection point then it h1 will be null
		System.out.println(null != h1 ? h1 : "[]");
	}

	// optimized approach
	// two linked list having common point
	// time complexity O(2*max(n1,n2)))
	// space complexity O(1)
	private static void type3() {
		Node<Integer> common = new Node<>(15, 30);
		Node<Integer> headA = new Node<>(10, 6, 9).next(common);
		Node<Integer> headB = new Node<>(10, 11).next(common);
		int count1 = 0, count2 = 0;
		Node<Integer> h1 = headA, h2 = headB;
		while (null != h1 || null != h2) {
			if (null != h1) {
				count1++;
				h1 = h1.next;
			}
			if (null != h2) {
				count2++;
				h2 = h2.next;
			}
		}
		while (null != headA && null != headB && headA != headB) {
			if (count1 > count2) {
				headA = headA.next;
				count1--;
			} else if (count1 < count2) {
				headB = headB.next;
				count2--;
			} else {
				headA = headA.next;
				headB = headB.next;
			}

		}
		System.out.println(null != headA ? headA.toString() : "[]");
	}

	// note here two linked list has the common data not the common pointer
	// time complexity O((n1+n2))+O(max((n1+n2)))
	// space complexity O(1)
	private static void type2() {
		Node<Integer> headA = new Node<>(10, 6, 9, 15, 30);
		Node<Integer> headB = new Node<>(10, 15, 30);
		Node<Integer> point = null;
		int count1 = count(headA);
		int count2 = count(headB);
		boolean hasCommon = false;
		while (count1 > count2) {
			headA = headA.next;
			count1--;
		}
		while (count2 > count1) {
			headB = headB.next;
			count2--;
		}
		while (null != headA && null != headB) {
			if (headA.data == headB.data) {
				if (!hasCommon) {
					hasCommon = true;
					point = headA;
				}
			} else {
				if (hasCommon) {
					hasCommon = false;
				}
			}
			headA = headA.next;
			headB = headB.next;
		}
		System.out.println(null != point ? point.toString() : "[]");
	}

	// hashing approach
	// time complexity(O(n1+n2)
	// space complexity O(n1)
	private static void type1() {
		Node<Integer> common = new Node<>(15, 30);
		Node<Integer> headA = new Node<>(10, 6, 9).next(common);
		Node<Integer> headB = new Node<>(10, 11).next(common);
		Node<Integer> point = null;
		Set<Node<Integer>> set = new HashSet<>();
		for (Node<Integer> node1 = headA; null != node1; node1 = node1.next) {
			set.add(node1);
		}
		for (Node<Integer> node2 = headB; null != node2; node2 = node2.next) {
			if (set.contains(node2)) {
				point = node2;
				break;
			}
		}
		System.out.println(point);
	}

	// brute force approach
	// time complexity(O(n1*n2)
	// space complexity (1)
	private static void type0() {
		Node<Integer> common = new Node<>(15, 30);
		Node<Integer> headA = new Node<>(10, 6, 9).next(common);
		Node<Integer> headB = new Node<>(10, 11).next(common);
		Node<Integer> point = null;
		for (Node<Integer> node1 = headA; null != node1; node1 = node1.next) {
			for (Node<Integer> node2 = headB; null != node2; node2 = node2.next) {
				if (node1 == node2) {
					point = node1;
					break;
				}
			}
			if (null != point) {
				break;
			}
		}
		System.out.println(common);
	}

	private static int count(Node<Integer> head) {
		int length = 0;
		while (null != head) {
			head = head.next;
			length++;
		}
		return length;
	}
}
