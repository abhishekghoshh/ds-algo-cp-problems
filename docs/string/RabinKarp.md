# Rabin-Karp Algorithm

## Problem Link
- [GeeksforGeeks - Search Pattern](https://practice.geeksforgeeks.org/problems/31272eef104840f7430ad9fd1d43b434a4b9596b/1)
- [LeetCode - Repeated String Match](https://leetcode.com/problems/repeated-string-match/)

## Solution Link
- [YouTube](https://www.youtube.com/watch?v=qQ8vS2btsxI)
- [Blog - GeeksforGeeks](https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/)


A&nbsp;text&nbsp;string in which you want to search.


A&nbsp;pattern&nbsp;string that you are looking for within the&nbsp;text.


Return all positions (0-based indexing) where the pattern&nbsp;occurs as a substring in the&nbsp;t


A&amp;nbsp;text&amp;nbsp;string in which you want to search.


A&amp;nbsp;pattern&amp;nbsp;string that you are looking for within the&amp;nbsp;text.


Return all positions (0-based indexing) where the pattern&amp;nbsp;occurs as a substring in the&amp;nbsp;t

## Approaches

### Type 1: Brute Force

```java
private static void type1() {
    String str = "AABAACAADAABAABA";
    String pat = "AABA";
    char[] s = str.toCharArray();
    char[] p = pat.toCharArray();
    int n1 = s.length, n2 = p.length;
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < n1 - n2 + 1; i++) {
        int j = 0;
        while (j < n2) { if (s[i + j] != p[j]) break; j++; }
        if (j == n2) answer.add(i);
    }
    System.out.println(answer);
}
```

### Type 2: Rabin-Karp with Rolling Hash

```java
private static void type2() {
    final int size = 256;   // character set size
    final int prime = 101;  // prime for modular hashing

    String string = "AABAACAADAABAABA";
    String pattern = "AABA";
    char[] sArr = string.toCharArray();
    char[] pArr = pattern.toCharArray();
    int n1 = sArr.length, n2 = pArr.length;

    int patternHash = 0;  // hash value for pattern
    int textHash = 0;     // hash value for current text window
    int highestPower = 1;
    List<Integer> answer = new ArrayList<>();

    // h = d^(m-1) % q
    for (int i = 0; i < n2 - 1; i++)
        highestPower = (highestPower * size) % prime;

    // Calculate hash of pattern and first window of text
    for (int i = 0; i < n2; i++) {
        textHash = (size * textHash + sArr[i]) % prime;
        patternHash = (size * patternHash + pArr[i]) % prime;
    }

    // Slide window over text
    for (int i = 0; i <= n1 - n2; i++) {
        if (patternHash == textHash) {
            // Verify character by character (hash collision check)
            int j = 0;
            while (j < n2) { if (sArr[i + j] != pArr[j]) break; j++; }
            if (j == n2) answer.add(i);
        }
        if (i < n1 - n2) {
            // Rolling hash: remove leftmost char, add new right char
            textHash = (size * textHash
                     - size * highestPower * sArr[i]
                     + sArr[i + n2]) % prime;
            // Handle negative modulo
            textHash = textHash >= 0 ? textHash : (textHash + prime);
        }
    }
    System.out.println(answer.isEmpty() ? -1 : answer);
}
```

## Rolling Hash Formula

```
hash(s[i+1..i+m]) = d * hash(s[i..i+m-1]) - d^m * s[i] + s[i+m]
```

Where `d = size` (256 for ASCII), and operations are modulo `prime` (101).

## Complexity
- **Average**: O(n + m) — hash computation + sliding window
- **Worst**: O(nm) — when all hashes match but characters don't (hash collision)
- **Space**: O(1)

## Key Insight

Instead of comparing all characters in each window, we compare hash values (O(1)). Only when hashes match do we verify character-by-character. The rolling hash formula lets us compute the next window's hash in O(1) from the current hash.
