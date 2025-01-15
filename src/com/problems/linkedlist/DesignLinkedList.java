package com.problems.linkedlist;

/*
 *
 * problem links :
 * https://leetcode.com/problems/design-linked-list/description/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Wf4QhpdVFQo
 *
 * https://github.com/neetcode-gh/leetcode/blob/main/java/0707-design-linked-list.java
 * https://neetcode.io/solutions/design-linked-list
 * */

// TODO Explore later and code walkthrough
public class DesignLinkedList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		class Node {
			final int val;
			Node prev;
			Node next;

			public Node(int val) {
				this.val = val;
				this.prev = null;
				this.next = null;
			}
		}
		class MyLinkedList {
			final Node start;
			final Node end;
			int n = 0;

			public MyLinkedList() {
				start = new Node(0);
				end = new Node(0);
				start.next = end;
				end.prev = start;
			}

			public int get(int index) {
				Node cur = start.next;
				while (cur != null && index > 0) {
					cur = cur.next;
					index -= 1;
				}
				if (cur != null && cur != end && index == 0) {
					return cur.val;
				}
				return -1;
			}

			public void addAtHead(int val) {
				addInBetween(start, new Node(val), start.next);
			}

			public void addAtTail(int val) {
				addInBetween(end.prev, new Node(val), end);
			}

			public void addAtIndex(int index, int val) {
				if (index == 0) {
					addAtHead(val);
				} else if (index == n) {
					addAtTail(val);
				} else if (index > 0 && index < n) {
					Node current = start.next;
					while (index > 0) {
						current = current.next;
						index--;
					}
					addInBetween(current.prev, new Node(val), current);
				}
			}

			private void addInBetween(Node prev, Node current, Node next) {
				n++;
				prev.next = current;
				current.prev = prev;
				current.next = next;
				next.prev = current;
			}


			public void deleteAtIndex(int index) {
				if (index < 0 || index >= n) {
					return;
				} else if (index == 0) {
					n--;
					Node next = start.next;
					start.next = next.next;
					next.next.prev = start;
				} else if (index == n - 1) {
					n--;
					Node prev = end.prev;
					end.prev = prev.prev;
					prev.prev.next = end;
				} else {
					Node cur = start.next;
					n--;
					while (index > 0) {
						cur = cur.next;
						index--;
					}
					Node next = cur.next;
					Node prev = cur.prev;
					next.prev = prev;
					prev.next = next;
				}
			}
		}

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
		myLinkedList.get(1);              // return 2
		myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
		myLinkedList.get(1);

	}


	// solution from
	private static void type1() {
		class ListNode {
			final int val;
			ListNode prev;
			ListNode next;

			public ListNode(int val) {
				this.val = val;
				this.prev = null;
				this.next = null;
			}
		}

		class MyLinkedList {

			final ListNode left;
			final ListNode right;

			public MyLinkedList() {
				left = new ListNode(0);
				right = new ListNode(0);
				left.next = right;
				right.prev = left;
			}

			public int get(int index) {
				ListNode cur = left.next;
				while (cur != null && index > 0) {
					cur = cur.next;
					index -= 1;
				}
				if (cur != null && cur != right && index == 0) {
					return cur.val;
				}
				return -1;
			}

			public void addAtHead(int val) {
				ListNode node = new ListNode(val);
				ListNode next = left.next;
				ListNode prev = left;
				prev.next = node;
				next.prev = node;
				node.next = next;
				node.prev = prev;
			}

			public void addAtTail(int val) {
				ListNode node = new ListNode(val);
				ListNode next = right;
				ListNode prev = right.prev;
				prev.next = node;
				next.prev = node;
				node.next = next;
				node.prev = prev;
			}

			public void addAtIndex(int index, int val) {
				ListNode cur = left.next;
				while (cur != null && index > 0) {
					cur = cur.next;
					index -= 1;
				}
				if (cur != null && index == 0) {
					ListNode node = new ListNode(val);
					ListNode next = cur;
					ListNode prev = cur.prev;
					prev.next = node;
					next.prev = node;
					node.next = next;
					node.prev = prev;
				}
			}

			public void deleteAtIndex(int index) {
				ListNode cur = left.next;
				while (cur != null && index > 0) {
					cur = cur.next;
					index -= 1;
				}
				if (cur != null && cur != right && index == 0) {
					ListNode next = cur.next;
					ListNode prev = cur.prev;
					next.prev = prev;
					prev.next = next;
				}
			}
		}

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2);
		myLinkedList.get(1);              // return 2
		myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
		myLinkedList.get(1);
	}

}
