# DetectLoopInLinkedList

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/DetectLoopInLinkedList.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/linked-list-cycle/description/)
- [📄 NeetCode](https://neetcode.io/problems/linked-list-cycle-detection)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/628974)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wiOo4DC5GGA)
- [▶ YouTube](https://www.youtube.com/watch?v=354J83hX7RI)
- [▶ YouTube](https://www.youtube.com/watch?v=gBTe7lFR3vc)
- [📄 takeUforward](https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Tortoise method efficient approach without any extra space but it can go more than O(n) as it will here we have a slow node and fast node slow node goes one node at a time, fast node goes two nodes if there is any loop then slow and fast will travel with different speed and after some they will reach the same node if there is no cycle then fast will exhaust automatically

```java
private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5);
		Node node1 = new Node(6);
		Node node2 = new Node(7, 8, 9);
		Node.attach(head, node1, node2);
		PrintUtl.print(head);
		node2.last(node1);

		boolean hasCycle = hasCycle2(head);
		System.out.println("cycle present : " + hasCycle);
	}
	private static boolean hasCycle2(Node head) {
		Node slow = head;
		Node fast = head;
		// traversing the linked list
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		return false;
	}
```

### Approach 1 — Brute Force

Brute force approach time complexity o(n) space complexity o(n)

**Complexity:** Time: o(n) | Space: o(n)

```java
private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5);
		Node node1 = new Node(6);
		Node node2 = new Node(7, 8, 9);
		Node.attach(head, node1, node2);
		PrintUtl.print(head);
		node2.last(node1);

		boolean hasCycle = hasCycle1(head);
		System.out.println("cycle present : " + hasCycle);
	}
	private static boolean hasCycle1(Node head) {
		Set<Node> set = new HashSet<>();
		while (null != head) {
			if (set.contains(head)) return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}
```
