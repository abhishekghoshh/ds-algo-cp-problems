# Z-Function / LPS Array

## Problem Link
- [LeetCode - Find First Occurrence in String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

## Solution Link
- [Pepcoding YouTube](https://www.youtube.com/watch?v=QlwzsWs0oyc)

## Approaches

### Type 1: Z-Array via KMP-style LPS

Computes the LPS array for the concatenated string `pattern + "&" + text`, then extracts the Z-array (LPS values for the text portion only).

```java
private static void type1() {
    String str = "aaxaabcaaaaxaabcaa";
    String ptrn = "aabcaa";

    char[] st = (ptrn + "&" + str).toCharArray();
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
    // Extract Z-array (text portion only, skip pattern+separator)
    int[] zArray = Arrays.copyOfRange(lps, ptrn.length() + 1, lps.length);
    print(zArray);
}
```

### Type 2: Direct LPS Array Computation

Computes the LPS (Longest Prefix Suffix) array for a single string. `lps[i]` = length of the longest proper prefix of `str[0..i]` that is also a suffix.

```java
private static void type2() {
    String text = "aaxaabcaaaaxaabcaa";
    char[] st = text.toCharArray();
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
    print(lps);
}
```

## Relationship Between LPS, Z-Function, and KMP

- **LPS array**: For each position i, stores the length of the longest proper prefix that matches a suffix ending at i. Used by KMP for pattern matching.
- **Z-array**: For each position i, stores the length of the longest substring starting at i that matches a prefix. Can be derived from LPS of `pattern + separator + text`.
- **KMP uses LPS** to decide how far to shift after a mismatch.

## Complexity

- **Time**: O(n) — each character is compared at most twice (amortized)
- **Space**: O(n) for the LPS/Z array
