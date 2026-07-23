# Generic Heap

## Description

Generic min-heap supporting any `Comparable<T>` type. Implements swim/sink operations, heapify from array or collection, removal at arbitrary index, and heap validation.

## Code

```java
package com.ds.heap;

public class Heap<T extends Comparable<T>> {
    private List<T> heap = null;

    public Heap() { this(1); }
    public Heap(int sz) { heap = new ArrayList<>(sz); }

    // Heapify from array in O(n)
    public Heap(T[] elems) {
        int heapSize = elems.length;
        heap = new ArrayList<>(heapSize);
        heap.addAll(Arrays.asList(elems));
        int middle = Math.max(0, (heapSize / 2) - 1);
        for (int i = middle; i >= 0; i--) sink(i);
    }

    // Heapify from collection in O(n)
    public Heap(Collection<T> elems) {
        int heapSize = elems.size();
        heap = new ArrayList<>(heapSize);
        heap.addAll(elems);
        int middle = Math.max(0, (heapSize / 2) - 1);
        for (int i = middle; i >= 0; i--) sink(i);
    }

    public T peek() { return isEmpty() ? null : heap.get(0); }

    // Remove root O(log n)
    public T poll() { return removeAt(0); }

    // Insert O(log n)
    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();
        heap.add(elem);
        swim(size() - 1);
    }

    // Bubble up O(log n)
    private void swim(int child) {
        int parent = (child - 1) / 2;
        while (child > 0 && less(child, parent)) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // Sink down O(log n)
    private void sink(int parent) {
        int heapSize = size();
        while (true) {
            int left = 2 * parent + 1, right = 2 * parent + 2;
            int smallest = parent;
            if (left < heapSize && less(left, smallest)) smallest = left;
            if (right < heapSize && less(right, smallest)) smallest = right;
            if (smallest == parent) break;
            swap(smallest, parent);
            parent = smallest;
        }
    }

    // Remove at arbitrary index O(log n)
    private T removeAt(int i) {
        if (isEmpty()) return null;
        int indexOfLastElem = size() - 1;
        T removed = heap.get(i);
        swap(i, indexOfLastElem);
        heap.remove(indexOfLastElem);
        if (i == indexOfLastElem) return removed;
        T elem = heap.get(i);
        sink(i);
        if (heap.get(i).equals(elem)) swim(i);
        return removed;
    }

    // Validation method for testing
    public boolean isMinHeap(int parent) {
        int heapSize = size();
        if (parent >= heapSize) return true;
        int left = 2 * parent + 1, right = 2 * parent + 2;
        if (left < heapSize && !less(parent, left)) return false;
        if (right < heapSize && !less(parent, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) <= 0;
    }
}
```

## Key Features

- **Generic**: Works with any `Comparable<T>`
- **Heapify O(n)**: Batch construction from array/collection
- **Arbitrary removal**: `removeAt(i)` - rare in heap implementations
- **Validation**: `isMinHeap()` recursively validates heap invariant
