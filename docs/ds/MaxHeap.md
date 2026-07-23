# MaxHeap

## Description

Integer-specific max-heap mirroring the MinHeap implementation. Largest element at root. O(log n) insert/extract, O(n) heapify.

## Code

```java
package com.ds.heap;

public class MaxHeap {
    private final int[] heap;
    private int size;
    private final int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize];
    }

    public MaxHeap(int[] array) {
        this.maxsize = array.length;
        this.size = array.length;
        this.heap = Arrays.copyOf(array, size);
        for (int i = this.maxsize / 2 - 1; i >= 0; i--)
            maxHeapify(i);
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) return;
        int highest = pos;
        if (leftChild(pos) < size && heap[pos] < heap[leftChild(pos)])
            highest = leftChild(pos);
        if (leftChild(pos) < size && heap[pos] < heap[rightChild(pos)])
            highest = rightChild(pos);
        if (highest != pos) { swap(pos, highest); maxHeapify(highest); }
    }

    public void insert(int element) {
        heap[size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return popped;
    }

    public int peek() { return heap[0]; }
    public boolean isEmpty() { return this.size() != 0; }
}
```

## Complexity

Same as MinHeap: O(n) heapify, O(log n) insert/extract, O(1) peek.

## Usage in Competitive Programming

- **Kth smallest element**: Max-heap of size k
- **Priority scheduling**: Extract highest priority
- **Heap sort**: Extract max repeatedly
