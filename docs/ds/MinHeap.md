# MinHeap

## Description

Integer-specific min-heap implemented as an array-based binary heap. Supports O(log n) insert/extract and O(n) heapify construction.

## Code

```java
package com.ds.heap;

public class MinHeap {
    private final int[] heap;
    private int size;
    private final int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize];
    }

    // Build heap from array in O(n) time
    public MinHeap(int[] array) {
        this.maxsize = array.length;
        this.size = array.length;
        this.heap = Arrays.copyOf(array, size);
        for (int i = this.size / 2 - 1; i >= 0; i--)
            minHeapify(i);
    }

    // Recursive heapify-down
    private void minHeapify(int pos) {
        if (isLeaf(pos)) return;
        int lowest = pos;
        if (leftChild(pos) < size && heap[lowest] > heap[leftChild(pos)])
            lowest = leftChild(pos);
        if (rightChild(pos) < size && heap[lowest] > heap[rightChild(pos)])
            lowest = rightChild(pos);
        if (lowest != pos) {
            swap(pos, lowest);
            minHeapify(lowest);
        }
    }

    // Insert and bubble up
    public void insert(int element) {
        heap[size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // Extract minimum (root)
    public int extractMin() {
        int popped = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);
        return popped;
    }

    public int peek() { return heap[0]; }
    public int size() { return this.size; }
    public boolean isEmpty() { return this.size() == 0; }

    // Helper index calculations
    private int parent(int pos) { return (pos - 1) / 2; }
    private int leftChild(int pos) { return (2 * pos) + 1; }
    private int rightChild(int pos) { return (2 * pos) + 2; }
    private boolean isLeaf(int pos) { return pos > (size / 2) - 1 && pos <= size; }
}
```

## Complexity

| Operation | Time |
|-----------|------|
| Construction (heapify) | O(n) |
| Insert | O(log n) |
| Extract Min | O(log n) |
| Peek | O(1) |

## Key Insight

**Heapify in O(n):** Building from leaves up (size/2-1 down to 0) is O(n), not O(n log n). Most nodes are near the bottom and sink very little.
