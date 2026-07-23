# Strings

## Overview

**44 files** covering string manipulation, palindrome problems, pattern matching algorithms (KMP, Rabin-Karp, Boyer-Moore, Z-Function), and encoding problems.

## Algorithm Implementations

### KMP Algorithm (`com/algo/string/KMPAlgorithm.java`)

```java
// Find pattern occurrences in text using LPS (Longest Prefix Suffix) array
// Type 2: Working implementation

char[] st = (pattern + "&" + text).toCharArray();
int[] lps = new int[st.length];
int i = 1, j = 0;

while (i < st.length) {
    if (st[i] == st[j]) {
        lps[i] = j + 1;
        i++; j++;
    } else if (j > 0) {
        j = lps[j - 1];
    } else {
        i++;
    }
}
// Positions where lps[i] == pattern.length() are matches
```

### Rabin-Karp (`com/algo/string/RabinKarp.java`)

Rolling hash technique for pattern matching. O(n+m) average, O(nm) worst.

### Boyer-Moore (`com/algo/string/BoyerMoore.java`)

Uses bad character heuristic to skip characters.

### Z-Function (`com/algo/string/ZFunction.java`)

Computes Z-array where `Z[i]` = longest prefix of `s` starting at position `i` that matches prefix of `s`.

## Problem Categories

### Basics

| Problem | Technique |
|---------|-----------|
| Reverse String | Two-pointer swap |
| Reverse Words | Split, reverse each word, join |
| Reverse Words III | Reverse each word in-place |
| Is Subsequence | Two-pointer or DP |
| Length of Last Word | Traverse from end |
| Longest Common Prefix | Sort + compare first and last |
| Check Anagrams | Character frequency map (int[26]) |
| Group Anagrams | Sorted string as key in HashMap |
| Sort by Character Frequency | Frequency map + priority queue |
| Isomorphic Strings | Two maps: s→t and t→s |
| Word Pattern | Map char→word and word→char |
| Merge Strings Alternately | Two-pointer interleaving |
| Backspace Compare | Stack simulation or reverse traversal |
| Roman ↔ Integer | Map + iterate |
| String to Integer (atoi) | Handle sign, overflow, skip whitespace |
| Count and Say | Run-length encoding generation |
| Compare Version Numbers | Split by `.`, compare numerically |

### Valid Parentheses Problems

| Problem | Approach |
|---------|----------|
| Valid Parentheses | Stack matching |
| Min Remove to Make Valid | Mark invalid positions, filter |
| Min Add to Make Valid | Count unmatched open/close |
| Max Nesting Depth | Track current depth |

### Palindrome Problems

```java
// Check Palindrome with skip (Valid Palindrome II):
boolean isPalindrome(String s, int l, int r) {
    while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
    return true;
}
// Main check: if mismatch, try skipping left or right
if (s.charAt(l) != s.charAt(r))
    return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
```

| Problem | Approach |
|---------|----------|
| Valid Palindrome | Two-pointer with char cleaning |
| Valid Palindrome II | Skip one character check |
| Longest Palindrome | Count pairs + optional center |
| Longest Palindromic Substring | Expand around center (O(n²)) or Manacher (O(n)) |
| Palindromic Substrings | Count all palindromes - expand center |
| Count Palindromic Subsequences | DP: 2D table |
| Shortest Palindrome | KMP/Z-function on reversed string |
| Smallest Palindromic Rearrangement | Sort + place mirrors |

### Pattern Matching & Substrings

| Problem | Approach |
|---------|----------|
| Find First Occurrence | Sliding window, KMP |
| Repeated String Match | Check if B is substring of repeated A |
| Repeated DNA Sequences | Sliding window + HashSet |
| Longest Happy Prefix | KMP LPS array (last value) |
| Longest Duplicate Substring | Binary search + Rolling hash |
| Partition String | Greedy window expansion |

### Encoding

| Problem | Technique |
|---------|-----------|
| Encode/Decode Strings | Length prefix + delimiter |
| Encode/Decode TinyURL | Hash-based encoding |
| Decode String | Stack-based: `3[a2[c]]` → `accaccacc` |
| Generate Tag for Video Caption | String manipulation |
