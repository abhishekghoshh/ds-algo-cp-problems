# RemoveDuplicatesFromSortedList

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/RemoveDuplicatesFromSortedList.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=p10f-VpO4nE)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach using the prev pointer if the current pointer is same as the prev pointer then we will not add the current pointer we will go to the next

```java
private static void type2() {
        Node node = new Node(1, 1, 2, 3, 3);
        Node ans = deleteDuplicates(node);
        PrintUtl.print(ans);
    }
    public static Node deleteDuplicates(Node head) {
        // we will use an extra node as dummy head
        Node dummyHead = new Node(Integer.MIN_VALUE);
        Node prev = dummyHead;
        while (null != head) {
            Node next = head.next;
            head.next = null; // detaching the curr link
            // current node is not same as the prev, so we will add the current node to prev and update prev to curr
            if (prev.val != head.val) {
                prev.next = head;
                prev = head;
            }
            head = next; // going to the next
        }
        return dummyHead.next;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
