# MinimumLengthOfStringAfterDeletingSimilarEnds

**Topic:** `array`  
**Tags:** Array, String, Two pointer

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=318hrWVr_5U)

## 📝 Problem Statement

Tags: Array, String, Two pointer

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach classic problem of 2 pointer if the in both end the character are same then we will shrink we will shrink till the characters are same if characters are different then we will break shrinking the left side if (i to j) all characters are same then after left shrinking i wil go till j he answer will be 0 that time shrinking the right side length of the string

```java
    private static void type2() {
        String s = "aabccabba";
        int ans = minimumLength2(s);
        System.out.println(ans);
    }


    public static int minimumLength2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            // if characters are different then we will break
            if (arr[i] != arr[j]) break;
            char ch = arr[i];
            // shrinking the left side
            while (i < j && arr[i] == ch) i++;
            // if (i to j) all characters are same then after left shrinking i wil go till j he answer will be 0 that time
            if (i == j) return 0;
            // shrinking the right side
            while (i < j && arr[j] == ch) j--;
        }
        // length of the string
        return (j - i + 1);
    }
```

### Approach 1: 🔨 Brute Force

```java
    private static void type1() {
    }
}
```
