# Heap / Priority Queue

## Overview

**22 files** covering heap implementation, K-th element problems, merge operations, frequency-based problems, and median finding.

## Prerequisites

### Heap (`com/ds/heap/Heap.java`)

Generic min-heap implementation:

```java
public class Heap<T extends Comparable<T>> {
    // Constructors:
    Heap()              // default capacity
    Heap(T[] elems)     // heapify in O(n)
    Heap(Collection<T>) // heapify in O(n)
    
    // Operations:
    T peek()            // O(1) - min element
    T poll()            // O(log n) - remove and return min
    void add(T elem)    // O(log n) - insert
    boolean remove(T e) // O(n) - search and remove
    boolean contains(T e) // O(n)
    
    // Internal:
    swim(int i)         // O(log n) - bubble up
    sink(int i)         // O(log n) - sink down
    heapify()           // O(n) - from array
}
```

### MinHeap & MaxHeap (`com/ds/heap/MinHeap.java`, `com/ds/heap/MaxHeap.java`)

Integer-specific heap implementations with `extractMin()`/`extractMax()`.

## Problem Categories

### K-th Element Problems

```java
// Kth Largest: Min-heap of size K (keep smallest K of the large elements)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int num : nums) {
    minHeap.offer(num);
    if (minHeap.size() > k) minHeap.poll();
}
return minHeap.peek();

// Kth Smallest: Max-heap of size K (keep largest K of the small elements)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

| Problem | Heap Type | Size |
|---------|-----------|------|
| Kth Largest Element | Min-heap | K |
| Kth Smallest Element | Max-heap | K |
| K Largest Elements | Min-heap | K |
| Kth Largest in Stream | Min-heap | K |
| Sort K-sorted Array | Min-heap | K+1 |
| K Closest Points to Origin | Max-heap or sorting |
| K-th Nearest Obstacle Queries | Min-heap |

### Merge Operations

| Problem | Technique |
|---------|-----------|
| Merge K Sorted Arrays | Min-heap of size K (one element from each) |
| Merge K Sorted Lists | Min-heap of size K (list heads) |
| Sum between K1 & K2 Smallest | Find both k-th elements, sum in between |
| Find K Pairs with Smallest Sums | Min-heap of (sum, i, j) |

```java
// Merge K Sorted Lists:
PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
for (ListNode head : lists)
    if (head != null) heap.offer(head);

ListNode dummy = new ListNode(0), curr = dummy;
while (!heap.isEmpty()) {
    ListNode node = heap.poll();
    curr.next = node;
    curr = curr.next;
    if (node.next != null) heap.offer(node.next);
}
```

### Frequency-Based Problems

| Problem | Technique |
|---------|-----------|
| K Most Frequent Elements | Map counts → min-heap of size K |
| Sort by Increased Frequency | Map counts, custom comparator |
| Top K Frequent Words | Map counts → max-heap with lexicographic tiebreak |
| Task Scheduler | Max-heap of frequencies + cooldown tracking |
| Hands of Straights | Min-heap + group checking |

### Two-Heap Pattern (Stream Median)

```java
// Find Median from Data Stream using two heaps:
MaxHeap left;   // smaller half
MinHeap right;  // larger half

void addNum(int num) {
    if (left.isEmpty() || num <= left.peek())
        left.offer(num);
    else
        right.offer(num);
    // Balance: |left| = |right| or |right| + 1
    if (left.size() > right.size() + 1) right.offer(left.poll());
    if (right.size() > left.size()) left.offer(right.poll());
}

double findMedian() {
    if (left.size() > right.size()) return left.peek();
    return (left.peek() + right.peek()) / 2.0;
}
```

### Other Heap Problems

| Problem | Technique |
|---------|-----------|
| Last Stone Weight | Max-heap: smash two largest |
| Connect N Ropes (Min Cost) | Min-heap: combine two smallest repeatedly |
| Replace Elements by Rank | Sort with index tracking |
| Design Twitter | Map + heap for news feed |
| Maximum Sum Combination | K largest from two arrays |
| Convert MinHeap to MaxHeap | Reverse heapify from bottom |

### Dijkstra-Style Problems

| Problem | Technique |
|---------|-----------|
| Min Time to Reach Last Room I & II | Dijkstra with heap on 2D grid |
| Choose K Elements with Max Sum | Heap-based selection |
