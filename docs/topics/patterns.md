# DSA Patterns

## Overview

Common problem-solving patterns for data structures and algorithms interviews. These patterns reappear across hundreds of LeetCode problems.

## Key Pattern Videos

- [LeetCode Was Hard Until I Learned THESE 8 Patterns](https://www.youtube.com/watch?v=RYT08CaYq6A)
- [Data Structures was HARD until I Learned these 8 Patterns](https://www.youtube.com/watch?v=qec07Rm04oc)
- [DSA was hard until I learned these 10 Patterns](https://www.youtube.com/watch?v=aWjFPloGYmg)
- [How to Solve ANY LeetCode Problem (Step-by-Step)](https://www.youtube.com/watch?v=OTNe0eV8418)
- [LeetCode was HARD until I Learned these 15 Patterns](https://blog.algomaster.io/p/15-leetcode-patterns)

## Core DSA Patterns

### 1. Two Pointers
Used when working with sorted arrays/lists, finding pairs or subarrays.

```java
// Opposite direction: sorted pair sum
int l = 0, r = n - 1;
while (l < r) {
    int sum = arr[l] + arr[r];
    if (sum == target) return true;
    else if (sum < target) l++;
    else r--;
}

// Same direction: removing duplicates
int i = 0;
for (int j = 1; j < n; j++)
    if (arr[j] != arr[i]) arr[++i] = arr[j];
```

**Problems:** Two Sum, Three Sum, Container With Most Water, Trapping Rain Water, Remove Duplicates

### 2. Sliding Window
Used when finding subarray/substring matching certain constraints.

**Fixed Window:** Max sum of size K, anagrams
**Variable Window:** Longest substring without repeating chars, minimum window substring
**At Most K → Exactly K:** `exactlyK = atMostK(k) - atMostK(k-1)`

### 3. Binary Search
Used on sorted arrays or monotonic answer spaces.

**Pattern:** Binary search on answer space `[minPossible, maxPossible]` for capacity/optimization problems (Koko Eating Bananas, Ship Packages, Split Array Largest Sum).

### 4. Prefix Sum
Used for range queries and subarray sum problems.

```java
// Subarray sum = K using prefix sum map
Map<Integer, Integer> prefixSumCount = new HashMap<>();
prefixSumCount.put(0, 1);
int sum = 0, count = 0;
for (int num : nums) {
    sum += num;
    count += prefixSumCount.getOrDefault(sum - k, 0);
    prefixSumCount.merge(sum, 1, Integer::sum);
}
```

### 5. Fast & Slow Pointers (Tortoise & Hare)
Used for cycle detection in linked lists, finding middle, etc.

### 6. Monotonic Stack
Used for next greater/smaller element, histogram problems.

```java
// Next Greater Element
Stack<Integer> stack = new Stack<>();
for (int i = n-1; i >= 0; i--) {
    while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
        stack.pop();
    result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
    stack.push(i);
}
```

### 7. Top K / Heap Pattern
Used for k-th largest/smallest, frequency-based problems.

```java
// Kth largest using min-heap of size K
PriorityQueue<Integer> heap = new PriorityQueue<>();
for (int num : nums) {
    heap.offer(num);
    if (heap.size() > k) heap.poll();
}
return heap.peek();
```

### 8. Backtracking
Used for combinatorial problems (permutations, combinations, subsets, N-Queens).

```java
void backtrack(state, start, result) {
    result.add(copy(state));
    for (int i = start; i < n; i++) {
        state.add(candidate);
        backtrack(state, i+1, result);
        state.removeLast();
    }
}
```

### 9. Dynamic Programming
Recognized by overlapping subproblems and optimal substructure.

**Key patterns:** Fibonacci-style, 0/1 Knapsack, LCS, LIS, MCM, DP on grids, DP on stocks.

### 10. Graph Traversal (BFS / DFS)
Used for grid problems, connectivity, shortest paths (unweighted).

### 11. Union Find (Disjoint Set)
Used for connected components, MST (Kruskal's), graph connectivity.

### 12. Trie (Prefix Tree)
Used for dictionary operations, prefix matching, XOR maximization.

### 13. Interval Merging
```java
// Sort by start, merge overlapping
Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
List<int[]> merged = new ArrayList<>();
for (int[] interval : intervals) {
    if (merged.isEmpty() || merged.getLast()[1] < interval[0])
        merged.add(interval);
    else
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
}
```

### 14. Matrix Traversal
Spiral, diagonal, boundary traversal patterns.

### 15. Bit Manipulation
Used for space optimization, XOR problems, subset generation.

## DSA Patterns Cheat Sheet

| Pattern | When to Use | Key Data Structure |
|---------|------------|-------------------|
| Two Pointers | Sorted arrays, pairs | Array pointers |
| Sliding Window | Subarrays/substrings | Hash Map, pointers |
| Binary Search | Sorted data, monotonic spaces | Array indices |
| Prefix Sum | Range queries, subarray sums | Array, HashMap |
| Fast & Slow | Cycle detection, middle | Linked list pointers |
| Monotonic Stack | Next greater/smaller | Stack |
| Top K | K-th elements, frequencies | Heap |
| Backtracking | Combinations, permutations | Recursion |
| DP | Overlapping subproblems | Array/Matrix |
| BFS/DFS | Graphs, trees, grids | Queue/Stack |
| Union Find | Connected components | Parent array |
| Trie | Prefix matching, XOR max | Trie nodes |
| Intervals | Overlapping ranges | Sorted array |
| Bit Manipulation | Space optimization | Bit operations |
