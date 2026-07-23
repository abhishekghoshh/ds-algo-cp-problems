# RemoveLinkedListElements

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/RemoveLinkedListElements.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/remove-linked-list-elements/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=JI71sxtHTng)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach we will use a previous pointer

```java
private static void type2() {
        Node head = new Node(1, 2, 6, 3, 4, 5, 6);
        int val = 6;
        Node ans = removeElements(head, val);
        PrintUtl.print(ans);
    }
    public static Node removeElements(Node head, int val) {
        // we will create a dummy node and assign that to the prev
        Node dummyHead = new Node();
        Node prev = dummyHead;
        // traversing the linked list
        while (null != head) {
            Node next = head.next;
            head.next = null; // breaking the link
            if (head.val != val) {
                prev.next = head;
                prev = head;
            }
            // going to the next
            head = next;
        }
        return dummyHead.next;
    }
```

### Approach 1 — Brute Force

Brute force approach we will use a list, if the node val is not equal to val then we will add it to the list

```java
private static void type1() {

    }
```
