# KMP Algorithm (Knuth-Morris-Pratt)

## Problem Link
- [LeetCode - Find First Occurrence in String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)
- [Coding Ninjas](https://www.codingninjas.com/codestudio/problems/1112621)

## Solution Link
- [Pepcoding YouTube](https://www.youtube.com/watch?v=__Cu92rei1s)
- [NeetCode YouTube](https://www.youtube.com/watch?v=JoF0Z7nVSrA)

## Approaches

### Type 1: Broken Implementation (`// TODO fix this solution`)

Uses a pattern array approach (not LPS). The author notes it is broken and needs fixing.

```java
// TODO fix this solution - it is not working
// check algoexpert for explanation
private static void type1() {
    String str = "aaxaabcaaaax";
    String ptrn = "aabcaa";
    char[] s1 = str.toCharArray();
    char[] s2 = ptrn.toCharArray();
    int n2 = s2.length, n1 = s1.length;
    int[] pattern = new int[n2];
    Arrays.fill(pattern, -1);

    // building pattern array
    int i = 1, j = 0;
    while (i < n2) {
        if (s2[i] == s2[j]) { pattern[i] = j; i++; j++; }
        else if (j > 0) j = pattern[j - 1] + 1;
        else i++;
    }
    // matching against text
    i = j = 0;
    int answer = -1;
    while (i < n1) {
        if (s1[i] == s2[j]) {
            if (j == n2 - 1) { answer = i - n2 + 1; break; }
            i++; j++;
        } else if (j > 0) j = pattern[j - 1] + 1;
        else i++;
    }
}
```

### Type 2: Working LPS-Based Implementation

Uses the Longest Prefix Suffix (LPS) array approach. Concatenates `pattern + "&" + text` and computes the LPS array for the combined string. Pattern matches occur where `lps[i] == pattern.length()`.

```java
private static void type2() {
    String string = "aaxaabcaaaaxaabcaa";
    String pattern = "aabcaa";

    char[] st = (pattern + "&" + string).toCharArray();
    int n1 = st.length;
    int n2 = pattern.length();
    int[] lps = new int[n1];

    int i = 1, j = 0;
    while (i < n1) {
        if (st[i] == st[j]) {
            lps[i] = j + 1;
            i++; j++;
        } else if (j > 0) {
            j = lps[j - 1];
        } else {
            i++;
        }
    }
    // count occurrences (lps[i] == pattern length means pattern ends at i)
    int count = 0;
    for (int num : lps) count += num == n2 ? 1 : 0;
    System.out.println(count);
}
```

## How LPS Array Works

```
pattern = "aabcaa"
LPS:       [0, 1, 0, 0, 1, 2]

Combined string = "aabcaa&aaxaabcaaaaxaabcaa"
LPS of combined: [... positions where value == 6 indicate pattern matches ...]
```

The `&` separator prevents false matches across the pattern/text boundary. When `lps[i] == pattern.length()`, it means the prefix of length n2 ending at position i matches the pattern.

## Complexity
- **Time**: O(n + m) where n = text length, m = pattern length
- **Space**: O(n + m) for LPS array
