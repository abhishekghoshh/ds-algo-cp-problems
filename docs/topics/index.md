# Data Structures, Algorithms & Competitive Programming

A comprehensive collection of **820+ Java implementations** covering Data Structures, Algorithms, and Competitive Programming problem solutions from LeetCode, GeeksForGeeks, Coding Ninjas, and more.

## Project Structure

```
src/com/
├── algo/          # Algorithm implementations (16 files)
│   ├── sort/      # 12 sorting algorithms
│   ├── string/    # 4 string matching algorithms
│   └── unionfind/ # Union-Find / Disjoint Set
├── ds/            # Data structure implementations (30 files)
│   ├── array/     # Dynamic Array
│   ├── linkedlist/# Singly & Doubly Linked List
│   ├── stack/     # Stack (Array & Linked List based)
│   ├── queue/     # Queue (Array & Linked List based, Deque)
│   ├── heap/      # MinHeap, MaxHeap, Generic Heap
│   ├── hashtable/ # Separate Chaining, Open Addressing, Linear Probing
│   └── binarytree/# BST, Splay Tree, TreeNode utilities
├── problems/      # Problem solutions (766 files)
│   ├── array/             (122 files)
│   ├── binarysearch/      (42 files)
│   ├── binarysearchtree/  (19 files)
│   ├── binarytree/        (44 files)
│   ├── bitmanipulation/   (39 files)
│   ├── dp/                (58 files)
│   ├── fenwicktree/       (6 files)
│   ├── graph/             (51 files)
│   ├── greedy/            (18 files)
│   ├── hashing/           (10 files)
│   ├── heap/              (22 files)
│   ├── linkedlist/        (34 files)
│   ├── logicbuilding/     (4 files)
│   ├── math/              (8 files)
│   ├── prime/             (10 files)
│   ├── queue/             (5 files)
│   ├── recursion/         (39 files)
│   ├── segmenttree/       (11 files)
│   ├── slidingwindow/     (27 files)
│   ├── special/           (15 files - Jump Game, Meet in middle, DSA Pumbai)
│   ├── stack/             (32 files)
│   ├── string/            (44 files)
│   └── trie/              (8 files)
└── util/           # Utilities (11 files)
```

## Code Architecture Pattern

Every solution file follows a **progressive disclosure** pattern where multiple approaches are presented from brute force to optimal:

```java
public class ProblemName {
    public static void main(String[] args) {
        type1();  // Brute force / simplest approach
        type2();  // Improved approach (memoization, hashing, etc.)
        type3();  // Further optimized approach (tabulation, two-pointer, etc.)
        type4();  // Space optimized or alternative technique
    }
}
```

Each file includes:
- **Problem/Solution links**: LeetCode, GFG, NeetCode, Striver, Aditya Verma, PepCoding
- **Approach descriptions**: Clear comments explaining the technique
- **Complexity analysis**: Time and space complexity annotated inline
- **TODO markers**: Interview notes, broken fixes, areas to revisit

## Topics Covered

| Topic | Files | Description |
|-------|-------|-------------|
| [Arrays](./arrays.md) | 122 | Subarrays, prefix sum, two pointers, matrix operations |
| [Binary Search](./binary-search.md) | 42 | Standard, rotated arrays, 2D matrices, capacity problems |
| [Binary Search Tree](./binary-search-tree.md) | 19 | BST operations, traversal, validation, conversion |
| [Binary Tree](./binary-tree.md) | 44 | Traversals, views, construction, path problems |
| [Bit Manipulation](./bit-manipulation.md) | 39 | XOR tricks, bit operations, number theory |
| [Dynamic Programming](./dynamic-programming.md) | 58 | Knapsack, LCS, LIS, MCM, DP on stocks, DP on squares |
| [Fenwick Tree](./fenwick-tree.md) | 6 | BIT implementation, inversion count, range queries |
| [Graph](./graph.md) | 51 | BFS/DFS, Dijkstra, MST, SCC, Topo Sort |
| [Greedy](./greedy.md) | 18 | Interval scheduling, fractional knapsack, meeting rooms |
| [Hashing](./hashing.md) | 10 | Separate chaining, open addressing, linear probing |
| [Heap / Priority Queue](./heap.md) | 22 | K-th problems, merge K sorted, median stream |
| [Linked List](./linked-list.md) | 34 | Operations, reversal, cycle detection, merge sort |
| [Math](./maths.md) | 8 | GCD, LCM, primes, digit operations |
| [Meet in the Middle](./meet-in-the-middle.md) | 6 | Search space splitting, subset sum |
| [Prime Numbers](./prime.md) | 10 | Sieve, segmented sieve, factorization |
| [Queue](./queue.md) | 5 | Array/LL implementations, deque |
| [Recursion & Backtracking](./recursion.md) | 39 | Power sets, N-Queens, Sudoku, permutations |
| [Segment Tree](./segment-tree.md) | 11 | Range queries, lazy propagation |
| [Sliding Window](./sliding-window.md) | 27 | Fixed & variable size, anagrams, substrings |
| [Stack](./stack.md) | 32 | Monotonic stack, expression evaluation, histogram |
| [Strings](./strings.md) | 44 | KMP, Rabin-Karp, palindromes, pattern matching |
| [Tries](./tries.md) | 8 | Prefix tree, XOR maximization, string operations |
| [Two Pointers](./two-pointers.md) | - | Pairs, partitions, Dutch National Flag |

## Time Complexity Limits

For competitive programming (~10^8 operations/sec):

| Complexity | Max Input Size |
|-----------|---------------|
| O(1) | Tiny inputs |
| O(log N) | 10^9 |
| O(N) | 10^8 |
| O(N log N) | 10^5 |
| O(N²) | 10^4 |
| O(N³) | 10² |
| O(2^N), O(N!) | n ≤ 10 |

## Resources

- [GitHub](https://github.com/abhishekghoshh)
- [LeetCode](https://leetcode.com/u/abhishekghoshh/)
- [AlgoMonster](https://algo.monster/dashboard)
