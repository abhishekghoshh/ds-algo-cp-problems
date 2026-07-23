# HashTable — Linear Probing

## Description

Concrete implementation of open addressing with **linear probing**. Uses a step constant of 17 and adjusts capacity to ensure `gcd(17, capacity) == 1` for full coverage.

## Code

```java
package com.ds.hashtable;

public class HashTableLinearProbing<K, V> extends HashTableOpenAddressingBase<K, V> {
    private static final int LINEAR_CONSTANT = 17;

    public HashTableLinearProbing() { super(); }
    public HashTableLinearProbing(int capacity) { super(capacity); }
    public HashTableLinearProbing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    @Override
    protected void setupProbing(K key) {
        // No special setup needed for linear probing
    }

    @Override
    protected int probe(int x) {
        return LINEAR_CONSTANT * x;  // step size = 17 * attempt number
    }

    @Override
    protected void adjustCapacity() {
        // Ensure gcd(constant, capacity) = 1 for full probing coverage
        while (gcd(LINEAR_CONSTANT, capacity) != 1) {
            capacity++;
        }
    }
}
```

## Linear Probing Formula

```
Probe sequence: h(k) + 17*1, h(k) + 17*2, h(k) + 17*3, ...
```

The step size of 17 ensures that the probe step is relatively prime to the table capacity, preventing probe cycles.

## Why gcd(step, capacity) == 1 matters

If `gcd(step, capacity) = d > 1`, only `capacity/d` buckets would be reachable. Consider:
- capacity = 10, step = 5: probes 0, 5, 0, 5, ... (only 2 of 10 buckets)
- capacity = 10, step = 3: probes 0, 3, 6, 9, 2, 5, 8, 1, 4, 7 (all 10 buckets)
