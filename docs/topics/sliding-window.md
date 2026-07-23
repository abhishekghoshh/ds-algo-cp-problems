# Sliding Window

## Overview

**27 files** covering fixed-size and variable-size sliding window problems, substring problems with constraints, and window optimization techniques.

## Pattern Templates

### Fixed Size Window

```java
// Initial window
for (int i = 0; i < k; i++) process(arr[i]);

// Slide window
for (int i = k; i < n; i++) {
    remove(arr[i - k]);      // remove leftmost
    add(arr[i]);              // add new element
    updateResult();
}
```

### Variable Size Window

```java
int left = 0, result = 0;
for (int right = 0; right < n; right++) {
    add(arr[right]);
    while (conditionViolated()) {
        remove(arr[left]);
        left++;
    }
    result = Math.max(result, right - left + 1);
}
```

## Problem Categories

### Fixed Size Window

| Problem | Window Size | Constraint |
|---------|------------|------------|
| Max Sum Subarray of Size K | Fixed k | Maximize sum |
| First Negative in Every Window | Fixed k | First negative number |
| Count Occurences of Anagrams | Fixed k (pattern length) | Anagrams of pattern |
| Max of All Subarrays of Size K | Fixed k | Sliding window maximum (deque) |
| Max Vowels in Substring | Fixed k | Count vowels |
| Min Diff Between Highest/Lowest | Size k after sorting | Min range |
| Number of Zero-Filled Subarrays | Variable (consecutive zeros) | Count arithmetic |
| Count Distinct in Every Window | Fixed k | Distinct count per window |

### Sliding Window Maximum - Detailed

```java
// Using Deque: maintain indices of decreasing values
Deque<Integer> dq = new ArrayDeque<>();
for (int i = 0; i < k; i++) {
    while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
    dq.offerLast(i);
}
for (int i = k; i < n; i++) {
    result[i-k] = arr[dq.peekFirst()];
    while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
    while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
    dq.offerLast(i);
}
```

### Variable Size Window

| Problem | Optimization |
|---------|-------------|
| Longest Substring w/ K Unique Chars | Frequency map + shrink when > K |
| Longest Substring w/o Repeating Chars | HashSet + shrink on duplicate |
| Fruit Into Baskets (Pick Toys) | At most 2 distinct fruits |
| Minimum Window Substring | Shrink until valid, track minimum |
| Minimum Window Subsequence | Find shortest window containing subsequence |
| Max Sum Distinct Subarray of Length K | Fixed size + distinct check |

### At Most K Pattern

When the problem asks for "exactly K", use: `exactlyK = atMostK(arr, k) - atMostK(arr, k-1)`

```java
int atMostK(int[] arr, int k) {
    int left = 0, count = 0;
    Map<Integer, Integer> freq = new HashMap<>();
    for (int right = 0; right < arr.length; right++) {
        freq.merge(arr[right], 1, Integer::sum);
        while (freq.size() > k) {
            freq.merge(arr[left], -1, Integer::sum);
            if (freq.get(arr[left]) == 0) freq.remove(arr[left]);
            left++;
        }
        count += right - left + 1;
    }
    return count;
}
```

| Problem | Constraint |
|---------|-----------|
| Subarrays with Exactly K Different Ints | `exactlyK(n) = atMostK(n,k) - atMostK(n,k-1)` |
| Binary Subarrays with Sum K | `exactlyK = atMostK(k) - atMostK(k-1)` |
| Count Nice Subarrays | Exactly K odd numbers |

### Other Sliding Window Problems

| Problem | Technique |
|---------|-----------|
| Max Consecutive Ones III | At most K zeros flipped |
| Longest Repeating Char Replacement | At most K replacements (windowLen - maxFreq ≤ K) |
| Permutation in String | Fixed window + frequency match |
| Number of Substrings w/ All 3 Characters | At least 1 of a, b, c |
| Container with Most Water | Two-pointer (not strictly sliding) |
| Frequency of Most Frequent Element | Sorting + sliding window on sum |
| Maximum Points from Cards | Pick k from front or back |
| Max Subarray with Equal Products | Variable window with product tracking |
