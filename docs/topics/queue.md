# Queue

## Overview

**5 files** covering queue implementations and sliding window maximum.

## Prerequisite Data Structures

### ArrayQueue (`com/ds/queue/ArrayQueue.java`)

Circular array implementation:

```java
public class ArrayQueue<T> implements Queue<T> {
    // Capacity = data.length - 1 (one slot reserved)
    public void offer(T elem)   // O(1) - circular insertion
    public T poll()             // O(1) - circular removal
    public T peek()             // O(1)
    public boolean isEmpty()    // front == rear
    public boolean isFull()     // (front + n - rear) % n == 1
}
```

## Problem Solutions

| Problem | Approach |
|---------|----------|
| Queue using Arrays | Simple array with front/rear pointers |
| Queue using LinkedList | Head-tail linked list |
| Queue using Stack | Two stacks: push O(1), pop amortized O(1) |
| Deque using LinkedList | Doubly linked list |

### Sliding Window Maximum (Deque-based)

```java
// O(n) using monotonic deque
Deque<Integer> dq = new ArrayDeque<>();
for (int i = 0; i < k; i++) {
    while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
        dq.pollLast();
    dq.offerLast(i);
}
result[0] = arr[dq.peekFirst()];

for (int i = k; i < n; i++) {
    // Remove out-of-window indices
    while (!dq.isEmpty() && dq.peekFirst() <= i - k)
        dq.pollFirst();
    // Maintain decreasing order
    while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
        dq.pollLast();
    dq.offerLast(i);
    result[i - k + 1] = arr[dq.peekFirst()];
}
```
