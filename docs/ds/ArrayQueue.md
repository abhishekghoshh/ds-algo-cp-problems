# ArrayQueue

## Description

Circular array queue implementation with fixed capacity. Uses one wasted slot to distinguish full from empty.

## Code

```java
package com.ds.queue;

public class ArrayQueue<T> implements Queue<T> {
    private final Object[] data;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        // ArrayQueue maximum size is data.length - 1 (one slot reserved)
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }

    public void offer(T elem) {
        if (isFull()) throw new RuntimeException("Queue is full");
        data[rear++] = elem;
        rear = adjustIndex(rear, data.length);
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        front = adjustIndex(front, data.length);
        return (T) data[front++];
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        front = adjustIndex(front, data.length);
        return (T) data[front];
    }

    public int size() {
        return adjustIndex(rear + data.length - front, data.length);
    }

    public boolean isEmpty() { return rear == front; }

    public boolean isFull() {
        return (front + data.length - rear) % data.length == 1;
    }

    private int adjustIndex(int index, int size) {
        return index >= size ? index - size : index;
    }
}
```

## Circular Buffer Design

```
Capacity = 5, data.length = 6 (one slot wasted)
front=0, rear=0 → empty (front == rear)
Add 1,2,3: front=0, rear=3 → [1,2,3,_,_,_]
Remove 1:   front=1, rear=3 → [_,2,3,_,_,_]
Add 4,5,6:  front=1, rear=0 → [_,2,3,4,5,6] → FULL (rear+1 wraps to front)
```

The wasted slot allows distinguishing empty (front==rear) from full ((rear+1)%len==front).
