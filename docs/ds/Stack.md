# Stack Interface

## Description

Generic stack interface defining the core stack operations.

```java
package com.ds.stack;

public interface Stack<T> {
    int size();
    boolean isEmpty();
    void push(T elem);
    T pop();
    T peek();
}
```

## Implementations

- `com.ds.stack.ArrayStack<T>` — Array-based with dynamic resizing
- `com.ds.stack.LinkedListStack<T>` — Singly linked list based with search
