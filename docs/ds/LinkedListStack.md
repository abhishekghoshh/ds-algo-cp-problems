# LinkedListStack

## Description

Singly-linked-list-based stack with search capability. Implements `Stack<T>` and `Iterable<T>`.

## Code

```java
package com.ds.stack;

public class LinkedListStack<T> implements Iterable<T>, Stack<T> {
    private final LinkedList<T> list = new LinkedList<>();

    public LinkedListStack() {}
    public LinkedListStack(T firstElem) { push(firstElem); }

    public int size() { return list.size(); }
    public boolean isEmpty() { return size() == 0; }
    public void push(T elem) { list.addLast(elem); }
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    // Search from top of stack (last = top)
    // Returns -1 if not found
    public int search(T elem) {
        int i = 0;
        for (T item : list) if (item.equals(elem)) return i; else i++;
        return -1;
    }
}
```

## Key Feature

The `search()` method traverses from the bottom of the stack, returning the 1-based distance from the top (matching Java's `java.util.Stack.search()` semantics).
