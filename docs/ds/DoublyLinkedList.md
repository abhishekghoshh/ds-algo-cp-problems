# DoublyLinkedList

## Description

Generic doubly linked list with bidirectional traversal. O(1) add/remove at both ends, O(n) for index-based operations. Removal at arbitrary node is O(1) once the node reference is obtained.

## Code

```java
package com.ds.linkedlist;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T> {
        private T data;
        private Node<T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data; this.prev = prev; this.next = next;
        }
    }

    // O(1) operations:
    public void addFirst(T elem) { ... }   // insert at head
    public void addLast(T elem) { ... }    // insert at tail
    public T removeFirst() { ... }         // remove from head
    public T removeLast() { ... }          // remove from tail

    // O(1) removal given node reference:
    private T remove(Node<T> node) {
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();
        node.next.prev = node.prev;
        node.prev.next = node.next;
        T data = node.data;
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    // O(n) index-based removal — optimized by direction:
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        Node<T> trav;
        // Search from front or back depending on which is closer
        if (index < size / 2)
            for (int i = 0, trav = head; i != index; i++) trav = trav.next;
        else
            for (int i = size - 1, trav = tail; i != index; i--) trav = trav.prev;
        return remove(trav);
    }
}
```

## Key Advantage over Singly LinkedList

- **O(1) removeLast**: No traversal needed (tail has prev pointer)
- **Bidirectional iteration**: Can traverse in both directions
- **O(1) node removal**: Once you have a reference to a node, you can remove it without traversing from head

## Usage in LRU Cache

The doubly linked list is the data structure behind LRU cache — O(1) removals from any position (when you have the node reference via HashMap).
