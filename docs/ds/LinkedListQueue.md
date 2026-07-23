# LinkedListQueue

## Description

Queue implementation backed by `com.ds.linkedlist.LinkedList`. Uses addLast for enqueue and removeFirst for dequeue.

## Code

```java
package com.ds.queue;

public class LinkedListQueue<T> implements Iterable<T>, Queue<T> {
    private final LinkedList<T> list = new LinkedList<>();

    public LinkedListQueue() {}
    public LinkedListQueue(T firstElem) { offer(firstElem); }

    public int size() { return list.size(); }
    public boolean isEmpty() { return size() == 0; }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }

    public void offer(T elem) { list.addLast(elem); }
}
```

## Complexity

All operations O(1) — head and tail pointers in the backing linked list.
