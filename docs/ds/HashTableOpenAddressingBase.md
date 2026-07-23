# HashTable — Open Addressing Base

## Description

Abstract base class for open addressing hash tables. Uses **lazy deletion** (TOMBSTONE marker) and supports arbitrary probe sequences via subclass template methods. Default capacity 7, load factor 0.65.

## Code

```java
package com.ds.hashtable;

public abstract class HashTableOpenAddressingBase<K, V> implements Iterable<K> {
    protected double loadFactor;
    protected int capacity, threshold, modificationCount;
    protected int usedBuckets, keyCount;
    protected K[] keys;
    protected V[] values;
    protected final K TOMBSTONE = (K) (new Object());  // deletion marker

    private static final int DEFAULT_CAPACITY = 7;
    private static final double DEFAULT_LOAD_FACTOR = 0.65;

    // Subclasses implement these for specific probing strategies
    protected abstract void setupProbing(K key);
    protected abstract int probe(int x);
    protected abstract void adjustCapacity();

    public V insert(K key, V val) {
        if (key == null) throw new IllegalArgumentException("Null key");
        if (usedBuckets >= threshold) resizeTable();
        setupProbing(key);
        final int offset = normalizeIndex(key.hashCode());

        for (int i = offset, j = -1, x = 1; ; i = normalizeIndex(offset + probe(x++))) {
            if (keys[i] == TOMBSTONE) {         // deleted slot
                if (j == -1) j = i;              // remember first tombstone
            } else if (keys[i] != null) {        // occupied slot
                if (keys[i].equals(key)) {       // key exists — update
                    V oldValue = values[i];
                    if (j == -1) values[i] = val;
                    else {
                        keys[i] = TOMBSTONE;     // lazy deletion relocation
                        values[i] = null;
                        keys[j] = key;
                        values[j] = val;
                    }
                    return oldValue;
                }
            } else {                             // empty slot
                if (j == -1) {                   // insert here
                    usedBuckets++; keyCount++;
                    keys[i] = key; values[i] = val;
                } else {                         // insert at tombstone (optimization)
                    keyCount++;
                    keys[j] = key; values[j] = val;
                }
                modificationCount++;
                return null;
            }
        }
    }

    protected void resizeTable() {
        increaseCapacity();  // 2*capacity + 1
        adjustCapacity();
        threshold = (int) (capacity * loadFactor);
        // Rehash all entries into new table (swap arrays, re-insert)
    }

    protected void increaseCapacity() { capacity = (2 * capacity) + 1; }

    // GCD helper for probing constant selection
    protected static final int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

## Key Design Features

1. **TOMBSTONE marker**: Avoids the need to shift elements on deletion. Marked as deleted but not null, so probing continues through tombstones.

2. **Lazy Deletion Relocation**: When searching, if a tombstone is found before the actual key, the implementation can relocate the key to the tombstone position — this is called "lazy deletion relocation" and reduces future probe lengths.

3. **Template Method Pattern**: Subclasses implement `setupProbing()`, `probe()`, and `adjustCapacity()` to define the specific open addressing scheme.

4. **GCD-based capacity**: Capacity is adjusted so that `gcd(probe_step, capacity) == 1`, ensuring all buckets can be probed (prevents infinite loops).

## Complexity

| Operation | Average | Worst |
|-----------|---------|-------|
| Insert | O(1) | O(n) |
| Search | O(1) | O(n) |
| Delete | O(1) | O(n) |

With a good hash function and load factor < 0.65, clustering is minimal.
