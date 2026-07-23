# SmallestPalindromicRearrangement2

**Topic:** `string`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii)

## 📝 Problem Statement

Rearrange a string to form the lexicographically smallest palindrome (Part 2).

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {
    }
```

### Approach 1: 🔨 Brute Force

```java
    private static void type1() {
        String s = "bacab";
        int k = 1;
        String ans = smallestPalindrome1(s, k);
        System.out.println(ans);
    }

    public static String smallestPalindrome1(String s, int k) {
        long f = 1;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char ch : arr) {
            freq[ch - 'a']++;
        }

        return null;
    }
}
```
