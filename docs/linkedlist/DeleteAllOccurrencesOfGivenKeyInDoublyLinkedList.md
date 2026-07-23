# DeleteAllOccurrencesOfGivenKeyInDoublyLinkedList

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/DeleteAllOccurrencesOfGivenKeyInDoublyLinkedList.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Mh0NH_SD92k)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Exactly the same as the previous just here we will not remove the previous pointer

```java
private static void type3() {
        DNode head = new DNode(10, 4, 10, 3, 5, 20, 10);
        int k = 10;
        DNode node = head;
        // this is a dummy head node
        DNode newHead = new DNode(-1);
        DNode prev = newHead;
        while (node != null) {
            // we will only add the node if the data is not equal to k
            if (node.data != k) {
                prev.next = node;
                node.prev = prev;
                prev = node;
            }
            node = node.next;
        }
        // deleting the last pointer
        prev.next = null;
        // as the head had dummy so skipping the first node
        head = newHead.next;
        print(head);
    }
```

### Approach 2

Explain this in the interview optimized approach rather saving it to the array then again creating the linked list from the array we can directly just reuse the existing pointer

```java
private static void type2() {
        DNode head = new DNode(10, 4, 10, 3, 5, 20, 10);
        int k = 10;
        DNode node = head;
        // this is a dummy head node
        DNode newHead = new DNode(-1);
        DNode prev = newHead;
        while (node != null) {
            // we will only add the node if the data is not equal to k
            if (node.data != k) {
                prev.next = node;
                node.prev = prev;
                prev = node;
            }
            node = node.next;
        }
        // we can also simply do the prev.next=null
        // but to remove the prev pointer, we have to do this
        if (prev.next != null) {
            prev.next.prev = null;
            prev.next = null;
        }
        head = newHead.next;
        if (head != null) head.prev = null;
        print(head);
    }
```

### Approach 1 — Brute Force

Brute force approach store it in an array then create a doubly linked list from that array

```java
private static void type1() {
        DNode head = new DNode(10, 4, 10, 3, 5, 20, 10);
        int k = 10;
        DNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            if (node.data != k) list.add(node.data);
            node = node.next;
        }
        // this is a dummy head node
        DNode newHead = new DNode(-1);
        DNode prev = newHead;
        for (int data : list) {
            DNode curr = new DNode(data);
            // attaching the pointer
            prev.next = curr;
            curr.prev = prev;
            // changing the previous the pointer
            prev = curr;
        }
        // removing the dummy node and also the removing the previous pointer pointing to dummy
        head = newHead.next;
        if (head != null) head.prev = null;
        print(head);
    }
```
