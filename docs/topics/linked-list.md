# Linked List

## Overview

**34 files** covering singly and doubly linked list operations, reversal techniques, cycle detection, merge operations, and advanced problems like LRU/LFU cache.

## Prerequisite Data Structures

### ListNode (`com/ds/linkedlist/Node.java`)

```java
public class Node {
    public int data;        // value (also accessible as `val`)
    public Node next;       // next pointer
    public Node bottom;     // for multi-level lists (flattening)
    public Node random;     // for deep copy with random pointers
    
    // Constructor chaining: Node(1, 2, 3, 4) creates 1→2→3→4
    public Node(int val, int... others) { ... }
    
    // Fluent API: node.chain(newNode) appends to end
    public Node chain(Node node) { ... }
    
    // Multi-level: node.bottom(5,6,7) creates bottom chain
    public Node bottom(int... datas) { ... }
}
```

### DoublyListNode (`com/ds/linkedlist/DNode.java`)

```java
public class DNode {
    public int data;
    public DNode prev, next;
}
```

### Generic Linked List (`com/ds/linkedlist/LinkedList.java`)

```java
// Singly linked list with head, tail, size
public class LinkedList<T> implements Iterable<T> {
    public void add(T elem)          // O(1) - add to tail
    public void addFirst(T elem)     // O(1)
    public void addLast(T elem)      // O(1)
    public void addAt(int index, T data) // O(n)
    public T removeFirst()           // O(1)
    public T removeLast()            // O(n) - need to traverse
    public T removeAt(int index)     // O(n)
    public int indexOf(Object obj)   // O(n)
    public boolean contains(Object obj) // O(n)
}
```

### Generic Doubly Linked List (`com/ds/linkedlist/DoublyLinkedList.java`)

Same API as singly linked list, but with O(1) `removeLast()` and bidirectional traversal.

## Problem Categories

### Basic Operations

| Problem | Key Concepts |
|---------|-------------|
| **Introduction to LinkedList** | Creating nodes, understanding pointers |
| **Insert Node** | Insert at head, tail, or specific position |
| **Delete Node** | Remove by reference (copy next node's data) |
| **Delete Last Node** | Traverse to second-last |
| **Find Length** | Iterative traversal |
| **Search Element** | Linear search through list |

### Doubly Linked List Operations

| Problem | Key Insights |
|---------|-------------|
| **Insert at End** | O(1) with tail pointer |
| **Delete Last Node** | O(1) with tail.prev |
| **Reverse DLL** | Swap prev and next for all nodes |
| **Find Pairs with Sum** | Two-pointer from ends of sorted DLL |
| **Delete All Occurrences** | Traverse and reconnect |

### Reversal Techniques

```java
// Iterative reversal (3-pointer):
Node prev = null, curr = head, next;
while (curr != null) {
    next = curr.next;    // save next
    curr.next = prev;    // reverse link
    prev = curr;         // advance prev
    curr = next;         // advance curr
}
return prev;  // new head

// Reverse LinkedList II (reversing a sublist):
// 1. Find the node before sublist (prev) and start of sublist
// 2. Reverse nodes in range
// 3. Reconnect: prev.next = reversedHead, sublistEnd.next = afterEnd

// Reverse in groups of K:
// Recursively reverse first K, then recursively process rest
```

### Cycle Detection & Manipulation

```java
// Floyd's Cycle Detection (Tortoise & Hare)
Node slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;        // 1 step
    fast = fast.next.next;   // 2 steps
    if (slow == fast) return true;  // cycle exists
}

// Find starting node of cycle:
// 1. Detect cycle (meeting point)
// 2. Reset one pointer to head, move both 1 step at a time
// 3. Where they meet = cycle start

// Length of loop:
// After finding meeting point, count nodes in cycle

// Check Palindrome:
// 1. Find middle (slow/fast pointer)
// 2. Reverse second half
// 3. Compare first half with reversed second half
// 4. Restore original list (optional)
```

### Two-Pointer / Multi-Pointer Problems

| Problem | Technique |
|---------|-----------|
| **Middle of LinkedList** | Slow and fast pointer (fast moves 2 steps) |
| **Nth Node from End** | Gap of N between two pointers |
| **Delete Middle Node** | Slow-fast pointer + prev tracking |
| **Intersection of Two Lists** | Align lengths, then walk together |
| **Intersection II** | Using HashSet (alternative approach) |

### Sorting Linked Lists

| Problem | Approach |
|---------|----------|
| **Merge Two Sorted Lists** | Two-pointer merge |
| **Insertion Sort** | O(n²) iterative insertion |
| **Merge Sort** | Divide and conquer, find middle, merge sorted halves |
| **Sort 0s, 1s, 2s** | Count frequencies or three-pointer partitioning |

### Merge Sort on Linked List - Detailed

```java
// O(n log n) using divide and conquer:
Node sortList(Node head) {
    if (head == null || head.next == null) return head;
    
    // Find middle
    Node mid = findMiddle(head);
    Node right = mid.next;
    mid.next = null;  // split
    
    // Recursively sort both halves
    Node leftSorted = sortList(head);
    Node rightSorted = sortList(right);
    
    // Merge sorted halves
    return merge(leftSorted, rightSorted);
}
```

### Advanced Problems

| Problem | Technique |
|---------|-----------|
| **Swap Nodes in Pairs** | Three-pointer manipulation |
| **Rotate List to Right** | Find k % len, cut and reconnect |
| **Reorder List** | Find middle, reverse second half, interleave |
| **Flatten Multi-level List** | Recursively flatten bottom chain |
| **Clone with Random Pointer** | Three passes: interleave copies, set random, separate |
| **Add Two Numbers** | Simulate addition with carry |
| **Add 1 to Number** | Reverse, add 1, reverse back |
| **Segregate Odd/Even** | Split into two lists, reconnect |
| **Design LinkedList** | Full custom linked list with add/delete/get operations |

### Cache Implementations

| Cache | Implementation |
|-------|---------------|
| **LRU Cache** | DoublyLinkedList + HashMap → O(1) operations |
| **LFU Cache** | Frequency map + DLL per frequency → O(1) operations |

```java
// LRU Cache structure:
class LRUCache {
    Map<Integer, Node> map;          // key → node
    DoublyLinkedList list;            // ordered by recency
    
    int get(int key) {
        // move accessed node to head (most recent)
    }
    
    void put(int key, int value) {
        // if exists: update and move to head
        // if full: remove tail (least recent)
        // add to head
    }
}
```
