# DesignLinkedList

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/DesignLinkedList.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-linked-list/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Wf4QhpdVFQo)
- [https://github.com/neetcode-gh/leetcode/blob/main/java/0707-design-linked-list.java](https://github.com/neetcode-gh/leetcode/blob/main/java/0707-design-linked-list.java)

## Approaches

Implementation:

### Implementation

Explore later and code walkthrough

```java
private static void type1() {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
		myLinkedList.get(1);              // return 2
		myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
		myLinkedList.get(1);
	}
```
