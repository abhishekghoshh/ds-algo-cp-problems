# Hashing

## Overview

**10 files** covering hash table implementations (separate chaining, open addressing, linear probing), and practical hashing problems.

## Prerequisite Data Structures

### Separate Chaining (`com/ds/hashtable/HashTableSeparateChaining.java`)

```java
public class HashTableSeparateChaining<K,V> {
    // Uses LinkedList buckets
    // Default capacity: 8, load factor: 0.75
    // Collision resolution: chaining in bucket
    
    private int normalizeIndex(int hash) {
        return (hash & 0x7FFFFFFF) % capacity;  // strip sign, mod capacity
    }
    
    // Auto-resize when size > threshold (capacity * loadFactor)
    // Doubles capacity on resize
}
```

### Open Addressing Base (`com/ds/hashtable/HashTableOpenAddressingBase.java`)

```java
public abstract class HashTableOpenAddressingBase<K,V> {
    // TOMBSTONE marker for lazy deletion
    // Capacity adjustments for probing
    // Default capacity: 7, load factor: 0.65
    
    // Subclasses implement:
    abstract void setupProbing(K key);
    abstract int probe(int x);         // probe function
    abstract void adjustCapacity();    // capacity adjustments
    
    // Key operations:
    V insert(K key, V val)
    V get(K key)
    V remove(K key)
    boolean hasKey(K key)
}
```

### Linear Probing (`com/ds/hashtable/HashTableLinearProbing.java`)

```java
public class HashTableLinearProbing<K,V> extends HashTableOpenAddressingBase<K,V> {
    private static final int LINEAR_CONSTANT = 17;
    
    @Override
    protected int probe(int x) {
        return LINEAR_CONSTANT * x;  // step size = 17
    }
    
    @Override
    protected void adjustCapacity() {
        while (gcd(LINEAR_CONSTANT, capacity) != 1)
            capacity++;  // ensure gcd(constant, capacity) = 1
    }
}
```

## Problem Solutions

### Design Problems

| Problem | Approach |
|---------|----------|
| Design HashSet | Array of linked lists or open addressing |
| Design HashMap | Similar to HashSet with key-value pairs |

### Pattern Matching with Hashing

| Problem | Key Insight |
|---------|------------|
| Two Sum | HashMap: complement → index |
| Contains Duplicate | HashSet tracking |
| Contains Duplicate II | HashMap: index with distance check |
| Check Anagrams | Frequency array (int[26]) |
| Frequencies in Limited Range | Array of size N+1 |

### Advanced Hashing Problems

| Problem | Technique |
|---------|-----------|
| Path Crossing | HashSet of (x,y) pairs |
| Calculate Score After Instructions | HashMap for memoization |
| First Missing Positive | In-place hashing using array indices |
| Minimum Deletions for K Distinct | Frequency map + sort |
| Identify Largest Outlier | Frequency tracking |
