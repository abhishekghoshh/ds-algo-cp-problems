# HashTable — Separate Chaining

## Description

Generic hash table using **separate chaining** (LinkedList buckets) for collision resolution. Default capacity 8, load factor 0.75. Auto-resizes by doubling.

## Code

```java
package com.ds.hashtable;

class Entry<K, V> {
    int hash;
    K key;
    V value;
    public Entry(K key, V value) {
        this.key = key; this.value = value;
        this.hash = key.hashCode();
    }
    public boolean equals(Entry<K, V> other) {
        if (hash != other.hash) return false;
        return key.equals(other.key);
    }
}

public class HashTableSeparateChaining<K, V> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 1 << 3; // 8
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private final double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<Entry<K, V>>[] table;

    // Normalize hash to [0, capacity)
    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    public V insert(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null key");
        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucketIndex = normalizeIndex(newEntry.hash);
        return bucketInsertEntry(bucketIndex, newEntry);
    }

    private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null) table[bucketIndex] = bucket = new LinkedList<>();
        Entry<K, V> existentEntry = bucketSeekEntry(bucketIndex, entry.key);
        if (existentEntry == null) {
            bucket.add(entry);
            if (++size > threshold) resizeTable();  // auto-resize
            return null;
        } else {
            V oldVal = existentEntry.value;
            existentEntry.value = entry.value;
            return oldVal;
        }
    }

    public V get(K key) {
        if (key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        return entry != null ? entry.value : null;
    }

    public V remove(K key) {
        if (key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }

    private void resizeTable() {
        capacity *= 2;
        threshold = (int) (capacity * maxLoadFactor);
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];
        // Rehash all entries into new table
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null)
                for (Entry<K, V> entry : bucket) {
                    int bucketIndex = normalizeIndex(entry.hash);
                    LinkedList<Entry<K, V>> newBucket = newTable[bucketIndex];
                    if (newBucket == null) newTable[bucketIndex] = newBucket = new LinkedList<>();
                    newBucket.add(entry);
                }
        }
        table = newTable;
    }
}
```

## Complexity

| Operation | Average | Worst |
|-----------|---------|-------|
| Insert | O(1) | O(n) |
| Search | O(1) | O(n) |
| Delete | O(1) | O(n) |

Worst case occurs when all keys hash to the same bucket (poor hash function / adversarial input).

## Key Design Features

- **Load factor 0.75**: Resize when 75% full
- **Doubling**: Capacity doubles on resize (powers of 2)
- **Hash normalization**: `(hash & 0x7FFFFFFF) % capacity` strips sign bit
- **Iterator**: ConcurrentModificationException if modified during iteration
