# SearchElementInLinkedList

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/SearchElementInLinkedList.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/search-in-a-linked-list_975381)

## Solution Links

- [📄 takeUforward](https://takeuforward.org/linked-list/search-an-element-in-a-linked-list/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Recursive way

```java
private static void type2() {
        Node head = new Node(3, 6, 2, 7, 9, -1);
        int k = 2;

        int answer = search2(head, k);
        System.out.println(answer);
    }
    private static int search2(Node head, int k) {
        if (head == null) return 0;
        if (head.data == k) return 1;
        return search2(head.next, k);
    }
```

### Approach 1 — Brute Force

Iterative way

```java
private static void type1() {
        Node head = new Node(3, 6, 2, 7, 9, -1);
        int k = 2;

        int answer = search1(head, k);
        System.out.println(answer);
    }
    private static int search1(Node node, int k) {
        while (null != node) {
            if (node.data == k) return 1;
            node = node.next;
        }
        return 0;
    }
```
