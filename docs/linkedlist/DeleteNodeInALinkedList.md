# DeleteNodeInALinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/delete-node-in-a-linked-list/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/1105578)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/delete-node-of-linked-list_8160463)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=icnp4FJdZ_c&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=32)
- [📄 takeUforward](https://takeuforward.org/data-structure/delete-given-node-in-a-linked-list-o1-approach/)

## 📝 Problem Statement

Delete a given node in a linked list (without access to head).

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly. It is guaranteed that the node to be deleted is not a tail node in the list.

**Time Complexity:** `O(1)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		// You will not be given access to the head of the list,
		// instead you will be given access to the node to be deleted directly.
		// It is guaranteed that the node to be deleted is not a tail node in the list.
		Node node = new Node(5);
		Node head = new Node(1, 2, 3, 4)
				.next(node)
				.next(new Node(6, 7, 8, 9));
		print(head);
		node.data = node.next.data;
		node.next = node.next.next;
		print(head);
	}
}
```
