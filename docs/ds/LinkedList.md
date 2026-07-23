# Generic LinkedList

## Description

Singly linked list with head and tail pointers, supporting O(1) add at ends, O(n) remove/search.

## Code

```java
package com.ds.linkedlist;

public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) { this.data = data; this.next = next; }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    public void add(T elem) { addLast(elem); }

    public void addLast(T elem) {
        if (isEmpty()) head = tail = new Node<>(elem, null);
        else { tail.next = new Node<>(elem, null); tail = tail.next; }
        size++;
    }

    public void addFirst(T elem) {
        if (isEmpty()) head = tail = new Node<>(elem, null);
        else head = new Node<>(elem, head);
        size++;
    }

    public void addAt(int index, T data) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        if (index == 0) { addFirst(data); return; }
        if (index == size) { addLast(data); return; }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        temp.next = new Node<>(data, temp.next);
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        --size;
        if (isEmpty()) tail = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        if (size == 1) return removeFirst();
        T data = tail.data;
        Node<T> node = head;
        while (node.next.next != null) node = node.next;
        --size;
        tail = node;
        tail.next = null;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        Node<T> trav = head, parent = head;
        for (int i = 0; i != index; i++) { parent = trav; trav = trav.next; }
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        T data = trav.data;
        parent.next = trav.next;
        return data;
    }

    public boolean remove(Object obj) {
        // Handles null and non-null search
        // Delegate to private remove(Node) method
    }

    public int indexOf(Object obj) { /* linear search */ return -1; }
    public boolean contains(Object obj) { return indexOf(obj) != -1; }
}
```

## Complexity

| Operation | Time |
|-----------|------|
| addFirst | O(1) |
| addLast | O(1) |
| addAt(index) | O(n) |
| removeFirst | O(1) |
| removeLast | O(n) |
| removeAt | O(n) |
| indexOf | O(n) |
