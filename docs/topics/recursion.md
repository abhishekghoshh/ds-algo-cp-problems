# Recursion & Backtracking

## Overview

**39 files** covering recursion fundamentals, backtracking (N-Queens, Sudoku, Rat in a Maze), subsets/combinations/permutations generation, and advanced problems.

## Core Pattern: Backtracking Template

```java
void backtrack(state, options, result) {
    if (isComplete(state)) {
        result.add(copyOf(state));
        return;
    }
    for (choice : getChoices(state)) {
        if (isValid(choice, state)) {
            apply(state, choice);
            backtrack(state, options, result);
            undo(state, choice);
        }
    }
}
```

## Problem Categories

### Fundamentals

| Problem | Key Concept |
|---------|------------|
| **Factorial** | `n! = n * (n-1)!` - simple recursion |
| **Fibonacci** | `fib(n) = fib(n-1) + fib(n-2)` |
| **Tower of Hanoi** | Move n disks: recurse on n-1, move largest, recurse again |
| **Binary Search Recursively** | Divide and conquer |
| **Reverse Array** | Two-pointer swap recursively |
| **Check Palindrome** | Compare ends recursively |

### Stack Operations (Recursive)

| Problem | Technique |
|---------|-----------|
| **Sort Stack** | Recursively remove all elements, insert sorted |
| **Reverse Stack** | Recursively remove, insert at bottom |
| **Delete Middle** | Recursively track depth, skip middle element |

### Power Set / Subset Generation

```java
// Power Set with unique elements:
void generate(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));  // add current subset
    for (int i = idx; i < nums.length; i++) {
        current.add(nums[i]);
        generate(i + 1, nums, current, result);
        current.remove(current.size() - 1);
    }
}

// Power Set with duplicates: sort + skip consecutive duplicates
// Only pick the first occurrence in each recursive level
```

### Combinations

```java
// Combination Sum 1: Can reuse same element unlimited times
// For each index, either keep using it or move to next

// Combination Sum 2: Each element used once, avoid duplicates
// Sort + skip consecutive same values

// Combination Sum 3: Choose k numbers from 1..9 summing to n
// Standard backtracking with size and sum constraints

// Combination Sum 4: Count combinations (DP-based)
// dp[target] = sum(dp[target - num]) for each num
```

### Permutations

```java
// Permutations of unique elements:
void permute(int[] nums, int start, List<List<Integer>> result) {
    if (start == nums.length) {
        result.add(toList(nums));
        return;
    }
    for (int i = start; i < nums.length; i++) {
        swap(nums, start, i);
        permute(nums, start + 1, result);
        swap(nums, start, i);  // backtrack
    }
}

// Permutations with duplicates: track visited or use Set at each level
// Kth Permutation Sequence: mathematical (factoradic) approach
```

### Constraint Satisfaction Problems

| Problem | Key Technique |
|---------|--------------|
| **N-Queens** | Place column by column, check row + diagonals |
| **Optimized N-Queens** | O(1) safety check using row[], upperDiag[], lowerDiag[] |
| **Rat in a Maze** | 4-directional DFS with visited matrix |
| **M-Coloring Problem** | Try each color, check adjacent nodes |
| **Sudoku Solver** | Find empty cell, try 1-9, validate constraints |
| **Word Search I** | DFS on 4 neighbors, mark visited cells |
| **Word Search II** | Word Search with Trie optimization |

### N-Queens - Detailed Implementation

```java
// Type 1: O(3n) safety check per placement
boolean isSafe(char[][] board, int row, int col) {
    // Check row to the left
    for (int i = 0; i < col; i++)
        if (board[row][i] == 'Q') return false;
    // Check upper-left diagonal
    for (int r=row, c=col; r>=0 && c>=0; r--, c--)
        if (board[r][c] == 'Q') return false;
    // Check lower-left diagonal
    for (int r=row, c=col; r<n && c>=0; r++, c--)
        if (board[r][c] == 'Q') return false;
    return true;
}

// Type 2: O(1) safety check with hashing
int[] leftRow = new int[n];
int[] lowerDiagonal = new int[2*n - 1];    // r + c
int[] upperDiagonal = new int[2*n - 1];    // (n-1) + c - r

boolean isSafe(int r, int c) {
    return leftRow[r] == 0
        && lowerDiagonal[r + c] == 0
        && upperDiagonal[n - 1 + c - r] == 0;
}
```

### String / Expression Backtracking

| Problem | Technique |
|---------|-----------|
| **Letter Combinations of Phone** | Iterate digit mappings |
| **Palindrome Partitioning** | Cut at each position if prefix is palindrome |
| **Generate Parentheses** | Track open/close counts |
| **Expression Add Operators** | Insert +, -, * between digits to reach target |
| **Parsing Boolean Expression** | Recursive descent parsing |

### Other Recursive Problems

| Problem | Approach |
|---------|----------|
| **Josephus Problem** | `jos(n,k) = (jos(n-1,k) + k) % n` |
| **K-th Symbol in Grammar** | Binary tree pattern: `k-th = ~(k/2)-th if k is odd` |
| **Find K-th Bit in N-th Binary String** | Recursive inversion pattern |
| **Largest Number in K Swaps** | Try swapping with max digit, backtrack |
| **Count Good Numbers** | Even positions: 5 options, odd positions: 4 options |
| **More Subsequence** | Count distinct subsequences with DP |
| **Fill Special Grid** | Backtracking on custom grid |
| **Subarrays with Sum K** | Recursive with sliding window |
