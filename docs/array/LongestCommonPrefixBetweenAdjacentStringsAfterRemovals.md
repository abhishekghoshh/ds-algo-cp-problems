# LongestCommonPrefixBetweenAdjacentStringsAfterRemovals

**Topic:** `array` | **File:** `com/problems/array/LongestCommonPrefixBetweenAdjacentStringsAfterRemovals.java`

**Tags:** Arrays, hashing, prefix array

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-common-prefix-between-adjacent-strings-after-removals/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using a prefix and suffix array

```java
private static void type2() {
        String[] words = {"jump", "run", "run", "jump", "run"};
        int[] ans = longestCommonPrefix2(words);
        PrintUtl.print(ans);
    }
    private static int[] longestCommonPrefix2(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        int[] suffix = new int[n];
        int sMax = 0;
        int[] prefTemp = new int[n];
        for (int i = n - 1; i >= 0; i--) {

        }
        return ans;
    }
```

### Approach 1 — Brute Force

Brute force solution using priority queue

```java
private static void type1() {
        String[] words = {"jump", "run", "run", "jump", "run"};
        int[] ans = longestCommonPrefix1(words);
        PrintUtl.print(ans);
    }
    public static int[] longestCommonPrefix1(String[] words) {
        int n = words.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(i, i + 1, prefix(words[i], words[i + 1])));
        }
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int pre = i - 1, post = i + 1;
            int max = 0;
            if (pre >= 0 && post < n) {
                max = prefix(words[pre], words[post]);
            }
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                st.push(p);
                if (p.start != i && p.end != i) {
                    max = Math.max(max, p.prefix);
                    break;
                }
            }
            ans[i] = max;
            while (!st.isEmpty()) pq.add(st.pop());
        }
        return ans;
    }
    public static int prefix(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (a.charAt(i1) == b.charAt(i2)) {
                i1++;
                i2++;
            } else {
                return i1;
            }
        }
        return Math.min(n1, n2);
    }
```
