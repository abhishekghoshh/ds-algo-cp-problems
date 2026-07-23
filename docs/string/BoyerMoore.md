# Boyer-Moore Algorithm

## Problem Link
- (No specific problem link in source)

## Solution Link
- [YouTube](https://www.youtube.com/watch?v=hXqRLILcC1k)
- [GeeksforGeeks](https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/)

## Approach

Boyer-Moore uses the **bad character heuristic** to skip as many characters as possible. The key insight: align the pattern from right to left, and when a mismatch occurs, shift based on the last occurrence of the mismatched character.

## Code

```java
package com.algo.string;

public class BoyerMoore {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        String text = "test, this is a test";
        String pattern = "test";
        List<Integer> answer = match(text, pattern);
        System.out.println(answer);
    }

    private static List<Integer> match(String text, String pattern) {
        List<Integer> answer = new ArrayList<>();
        char[] arr = text.toCharArray();
        char[] ptrn = pattern.toCharArray();
        int m = ptrn.length;
        int n = arr.length;

        final int NO_OF_CHARS = 256;
        int[] badChar = new int[NO_OF_CHARS];
        // shift table: record last occurrence of each character in pattern
        Arrays.fill(badChar, -1);
        for (int i = 0; i < m; i++)
            badChar[ptrn[i]] = i;

        int s = 0, j;
        while (s <= (n - m)) {
            j = m - 1;
            // Compare from right to left
            while (j >= 0 && ptrn[j] == arr[s + j])
                j--;

            if (j < 0) {
                // Full match found
                answer.add(s);
                // Shift: next char in text aligned with its last occurrence in pattern
                s += (s + m < n) ? m - badChar[arr[s + m]] : 1;
            } else {
                // Mismatch: shift so bad char aligns with its last occurrence
                // max(1, ...) ensures positive shift
                s += Math.max(1, j - badChar[arr[s + j]]);
            }
        }
        return answer;
    }
}
```

## Bad Character Heuristic

Preprocess the pattern to record the **last position** of each character. When a mismatch occurs at position `j` in the pattern:
- Find the mismatched character `c = text[s+j]`
- Shift pattern so that `c` in the pattern aligns with `c` in the text
- Shift amount = `j - badChar[c]`

## Complexity
- **Best**: O(n/m) — when characters in text don't appear in pattern
- **Worst**: O(nm) — when all characters match except the last (e.g., pattern "baaaa", text "aaaa...")
- **Average**: Sublinear — often faster than KMP in practice

## Key Insight

Boyer-Moore compares the pattern from **right to left**, which allows larger skips than left-to-right algorithms. By preprocessing the "bad character" table, most mismatches can skip multiple characters at once.
