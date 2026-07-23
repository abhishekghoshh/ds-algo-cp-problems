# IsSubsequence

**Topic:** `string`  
**Tags:** Array, String

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/is-subsequence/description/)

## 📝 Problem Statement

Check if string s is a subsequence of string t.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach if n1 is 0, that means it is empty and empty string is subsequence of all the string if n1 > n2 means s has more characters, so it will never be a subsequence now we will take a variable and increment it once there is a match in the t string, and we will check if idx value is equal to n1 or not

**Time Complexity:** `O(n)`

```java
    private static void type2() {
        String s = "abc", t = "ahbgdc";
        boolean ans = isSubsequence2(s, t);
        System.out.println(ans);
    }

    public static boolean isSubsequence2(String s, String t) {
        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
        int n1 = arr1.length, n2 = arr2.length;
        // if n1 is 0, that means it is empty and empty string is subsequence of all the string
        if (n1 == 0) return true;
        // if n1 > n2 means s has more characters, so it will never be a subsequence
        if (n1 > n2) return false;
        // now we will take a variable and increment it once there is a match in the t string,
        // and we will check if idx value is equal to n1 or not
        int idx = 0;
        for (char ch : arr2) {
            if (arr1[idx] == ch) idx++;
            if (idx == n1) return true;
        }
        return false;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
