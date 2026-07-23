# Dynamic Array

## Solution Link
- [YouTube - WilliamFiset](https://www.youtube.com/watch?v=tvw4v7FEF1w&list=PLDV1Zeh2NRsB6SWUrDFW2RmDotAfPbeHu&index=5)

## Description

Generic dynamic array implementation with automatic resizing (doubles capacity when full), binary search, iterator support, and fluent API.

## Key Operations

| Operation | Time |
|-----------|------|
| `get(index)` | O(1) |
| `set(index, elem)` | O(1) |
| `add(elem)` | O(1) amortized |
| `removeAt(index)` | O(n) |
| `remove(elem)` | O(n) |
| `binarySearch(key)` | O(log n) |
| `reverse()` | O(n) |
| `sort()` | O(n log n) |

## Code

```java
package com.ds.array;

public class Array<T> implements Iterable<T> {
    private T[] data;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAP = 1 << 3;  // 8

    public Array() { this(DEFAULT_CAP); }

    public Array(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        data = (T[]) new Object[capacity];
    }

    // Given an array make it a dynamic array
    public Array(T[] array) {
        if (array == null) throw new IllegalArgumentException("Array cannot be null");
        data = java.util.Arrays.copyOf(array, array.length);
        capacity = size = array.length;
    }

    // Add an element - doubles capacity when full
    public void add(T elem) {
        if (size + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2; // double the size
            data = java.util.Arrays.copyOf(data, capacity);
        }
        data[size++] = elem;
    }

    // Remove at index - shifts remaining elements left
    public void removeAt(int index) {
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        --size; --capacity;
    }

    public boolean remove(T elem) {
        for (int i = 0; i < size; i++)
            if (data[i] == elem) { removeAt(i); return true; }
        return false;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T tmp = data[i];
            data[i] = data[size - i - 1];
            data[size - i - 1] = tmp;
        }
    }

    public int binarySearch(int key) {
        return java.util.Arrays.binarySearch(data, 0, size, key);
    }
}
```

## Usage

```java
Array<Integer> arr = new Array<>(14);
arr.add(1); arr.add(122);
arr.set(1, 2);
arr.add(-1);
arr.sort();
for (Integer i : arr) System.out.print(i + " ");
```
