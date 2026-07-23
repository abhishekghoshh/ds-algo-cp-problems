# Queue Interface

## Description

Generic queue interface defining core FIFO operations.

```java
package com.ds.queue;

public interface Queue<T> {
    void offer(T elem);  // enqueue
    T poll();            // dequeue
    T peek();            // front element
    int size();
    boolean isEmpty();
}
```

## Implementations

- `com.ds.queue.ArrayQueue<T>` — Circular array with fixed capacity
- `com.ds.queue.LinkedListQueue<T>` — Singly linked list based
- `com.ds.queue.Deque` — Placeholder (not yet implemented)
