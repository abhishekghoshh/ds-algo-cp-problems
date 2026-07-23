# Tries

## Overview

**8 files** covering Trie implementation, prefix-based operations, and XOR maximization using tries.

## Core Trie Implementation

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    
    // For counting prefixes:
    int countEndsWith;
    int countPrefix;
}
```

## Problem Solutions

| Problem | Approach |
|---------|----------|
| **Implement Trie (Prefix Tree)** | insert, search, startsWith |
| **Implement Trie II** | Count words, count prefixes, erase |
| **Longest String with All Prefixes** | Build trie, DFS for complete words |
| **Count Distinct Substrings** | Insert all suffixes into trie, count nodes |
| **Longest Duplicate Substring** | Binary search + trie/rolling hash |
| **Word Dictionary (with wildcards)** | DFS with . matching any char |
| **Power Set via Trie** | Trie-based subset generation |
| **Extra Characters in String** | DP + trie for dictionary lookup |

### Maximum XOR Problems (Trie-Based)

```java
// Build binary trie (each node has 2 children: 0 and 1)
// For each number, find complement path to maximize XOR

class BinaryTrieNode {
    BinaryTrieNode[] child = new BinaryTrieNode[2];
    void insert(int num) {
        BinaryTrieNode curr = this;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[bit] == null)
                curr.child[bit] = new BinaryTrieNode();
            curr = curr.child[bit];
        }
    }
    int maxXOR(int num) {
        BinaryTrieNode curr = this;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[1 - bit] != null) {
                result |= (1 << i);
                curr = curr.child[1 - bit];
            } else {
                curr = curr.child[bit];
            }
        }
        return result;
    }
}
```

| Problem | Technique |
|---------|-----------|
| Max XOR of Two Numbers | Binary trie, find complement for each |
| Max XOR of Number with Array Items | Pre-build trie from array |
| Max XOR with Element ≤ Limit | Sort queries + offline processing with trie |
