# InsertAtEndOfDoublyLinkedList

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/InsertAtEndOfDoublyLinkedList.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/insert-at-end-of-doubly-linked-list_8160464)

## Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/insert-at-end-of-doubly-linked-list/)

## Approaches

Implementation:

### Implementation

Iterative way we will find the last nonNull node then attach the new node

```java
private static void type1() {
        DNode node = new DNode(4, 10, 3, 5);
        int k = 9;
        DNode head = insertAtTail1(node, k);
        print(head);
    }
    private static DNode insertAtTail1(DNode head, int k) {
        DNode node = new DNode(k);
        if (head == null) return node;
        DNode current = head;
        // Traverse to the end of the doubly linked list
        while (null != current.next)
            current = current.next;
        current.next = node;
        node.prev = current;
        return head;
    }
```
