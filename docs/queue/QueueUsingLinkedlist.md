# QueueUsingLinkedlist

**Topic:** `queue` | **File:** `com/problems/queue/QueueUsingLinkedlist.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/implement-queue-using-linked-list_8161235)

## Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/implement-queue-using-linked-list/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {

    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.offer(7);
        queue.offer(14);
        queue.offer(24);
        queue.offer(34);
        System.out.println("The peek of the queue before deleting any element " + queue.peek());
        System.out.println("The size of the queue before deletion " + queue.size());
        System.out.println("The first element to be deleted " + queue.poll());
        System.out.println("The peek of the queue after deleting an element " + queue.peek());
        System.out.println("The size of the queue after deleting an element " + queue.size());
    }
```
