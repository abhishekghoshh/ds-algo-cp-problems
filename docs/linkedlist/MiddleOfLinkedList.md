# MiddleOfLinkedList

**Topic:** `linkedlist`  

## 📝 Problem Statement

Given the head of a singly linked list, return the middle node of the linked list.

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/973250)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=7LjQ57RqgEc)
- [▶ YouTube](https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29)
- [▶ YouTube](https://www.youtube.com/watch?v=A2_ldqM4QcY)
- [📄 takeUforward](https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/)

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach Tortoise method we will take 2 pointer slow and fast. one will go next, and one will go next to next, So 2nd pointer will go twice the first pointer, so when 2nd pointer reaches the end, the first pointer only goes to half

```java
	private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5);
		Node ans = middleNode2(head);
		print(ans);
	}

	private static Node middleNode2(Node head) {
		Node slow = head, fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next; // going next
			fast = fast.next.next; // going to next twice
		}
		return slow;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach first will count the length now it will go half of the length counting the size of the linked list now we will go to the node

```java
	private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5);
		Node ans = middleNode1(head);
		print(ans);
	}

	private static Node middleNode1(Node head) {
		Node node = head;
		// counting the size of the linked list
		int n = 0;
		while (null != node) {
			node = node.next;
			n++;
		}
		// now we will go to the node
		n = n / 2;
		node = head;
		while (n != 0) {
			node = node.next;
			n--;
		}
		return node;
	}

}
```
