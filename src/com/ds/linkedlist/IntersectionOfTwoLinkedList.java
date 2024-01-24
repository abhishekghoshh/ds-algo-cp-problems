package com.ds.linkedlist;

import com.algo.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

import static com.util.ArrayUtil.print;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * https://www.codingninjas.com/codestudio/problems/630457
 * https://www.codingninjas.com/studio/problems/-intersection-of-two-linked-lists_630457
 *
 * Solution link :
 * https://www.youtube.com/watch?v=0DYoPz2Tpt4
 * https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34
 *
 * https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/
 * */
public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
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
		Node common = new Node(15, 30);
		Node headA = new Node(10, 6, 9).next(common);
		Node headB = new Node(10, 11).next(common);
		Node h1 = headA, h2 = headB;
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
		Node common = new Node(15, 30);
		Node headA = new Node(10, 6, 9).next(common);
		Node headB = new Node(10, 11).next(common);

		System.out.println(null != headA ? headA.toString() : "[]");
	}

	private static Node getIntersectionNode3(Node headA, Node headB) {
		int n1 = 0, n2 = 0;
		Node h1 = headA, h2 = headB;
		while (null != h1 || null != h2) {
			if (null != h1) {
				n1++;
				h1 = h1.next;
			}
			if (null != h2) {
				n2++;
				h2 = h2.next;
			}
		}
		while (null != headA && null != headB && headA != headB) {
			if (n1 > n2) {
				headA = headA.next;
				n1--;
			} else if (n1 < n2) {
				headB = headB.next;
				n2--;
			} else {
				headA = headA.next;
				headB = headB.next;
			}
		}
		return headA;
	}


	// hashing approach
	// time complexity(O(n1+n2)
	// space complexity O(n1)
	private static void type2() {
		Node common = new Node(15, 30);
		Node headA = new Node(10, 6, 9).next(common);
		Node headB = new Node(10, 11).next(common);
		Node point = getIntersectionNode2(headA, headB);
		print(point);
	}

	private static Node getIntersectionNode2(Node headA, Node headB) {
		Set<Node> set = new HashSet<>();
		for (Node node1 = headA; null != node1; node1 = node1.next)
			set.add(node1);

		for (Node node2 = headB; null != node2; node2 = node2.next)
			if (set.contains(node2)) return node2;

		return null;
	}

	// brute force approach
	// time complexity(O(n1*n2)
	// space complexity (1)
	private static void type1() {
		Node common = new Node(15, 30);
		Node headA = new Node(10, 6, 9).next(common);
		Node headB = new Node(10, 11).next(common);
		Node point = getIntersectionNode1(headA, headB);
		print(point);
	}

	private static Node getIntersectionNode1(Node headA, Node headB) {
		for (Node node1 = headA; null != node1; node1 = node1.next)
			for (Node node2 = headB; null != node2; node2 = node2.next)
				if (node1 == node2) return node1;
		return null;
	}


}
