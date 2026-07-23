# LongestStringChain

**Topic:** `dp` | **File:** `com/problems/dp/LongestStringChain.java`

**Tags:** Array, Hash Table, Two Pointers, String, Dynamic Programming, Sorting

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-string-chain/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-string-chain_3752111)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=YY8iBaYcc4g&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=46)
- [▶ YouTube](https://www.youtube.com/watch?v=7b0V1gT_TIk)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-string-chain-dp-45/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Check other submissions from the leetcode

```java
private static void type4() {
    }
```

### Approach 3

Explain this approach in the interview exactly like the previous, but here we will use some clever optimizations

```java
private static void type3() {
        String[] words = {"bdca", "bda", "ca", "dca", "a"};
        int ans = longestStrChain2(words);
        System.out.println(ans);
    }
    public static int longestStrChain2(String[] words) {
        int n = words.length;
        if (n == 1) return 1;
        // we will convert everything into a char array, for faster checking
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) arr[i] = words[i].toCharArray();
        // we will sort the array with their length, so that the lesser string comes at the left
        Arrays.sort(arr, Comparator.comparingInt(w -> w.length));
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            char[] curr = arr[i];
            int prevMax = 0;
            int prevI = i - 1;
            // as the array is sorted, so we will start from i-1 and go till i>=0
            while (prevI >= 0) {
                char[] prev = arr[prevI];
                int n1 = curr.length, n2 = prev.length;
                // if the prevWord is smaller than currWord.len-1 then we can make answer from that word
                if (n2 + 1 < n1) break;
                if ((n1 == n2 + 1) && hasOneExtraLetter(curr, prev))
                    prevMax = Math.max(prevMax, dp[prevI]);
                prevI--; // decrementing the prev pointer
            }
            dp[i] = prevMax + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
```

### Approach 2

Copying the logic from the longest increasing subsequence where we are using a single dp array to store the longest increasing subsequence for the current index

```java
private static void type2() {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int ans = longestStrChain1(words);
        System.out.println(ans);
    }
    public static int longestStrChain1(String[] words) {
        int n = words.length;
        if (n == 1) return n;
        // we will convert everything into a char array, for faster checking
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) arr[i] = words[i].toCharArray();
        // we will sort the array with their length, so that the lesser string comes at the left
        Arrays.sort(arr, Comparator.comparingInt(w -> w.length));
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            char[] currWord = arr[i];
            int prevMax = 0;
            for (int prev = 0; prev < i; prev++) {
                char[] prevWord = arr[prev];
                // we will check if the current word is a one-letter extra word or not
                if (hasOneExtraLetter(currWord, prevWord))
                    prevMax = Math.max(prevMax, dp[prev]);
            }
            dp[i] = prevMax + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static boolean hasOneExtraLetter(char[] w1, char[] w2) {
        int j = 0, n1 = w1.length, n2 = w2.length;
        // if the length different is not 1, then we will directly return false
        if (n2 + 1 != n1) return false;
        // we will increase j if the character matches
        for (char ch : w1)
            if (j < n2 && ch == w2[j]) j++;
        // if j is n2 then it is a match
        return j == n2;
    }
```

### Approach 1 — Brute Force

To compare two strings and check if they form a valid chain simple recursive brute force approach

```java
private static void type1() {

    }
```
