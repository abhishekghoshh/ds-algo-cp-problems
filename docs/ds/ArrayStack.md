# ArrayStack

## Description

Array-based stack with dynamic resizing. Implements the `Stack<T>` interface.

## Code

```java
package com.ds.stack;

public class ArrayStack<T> implements Stack<T> {
    private int size;
    private int capacity;
    private Object[] data;
    private static final int DEF_CAP = 1 << 3;  // 8

    public ArrayStack() { this(DEF_CAP); }
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(T elem) {
        if (size == capacity) increaseCapacity();
        data[size++] = elem;
    }

    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalArgumentException();
        T elem = (T) data[--size];
        data[size] = null;  // prevent memory leak
        return elem;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException();
        return (T) data[size - 1];
    }
}
```

## Complexity

All operations O(1) amortized (push doubles capacity when full).
