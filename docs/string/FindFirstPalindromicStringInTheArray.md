# FindFirstPalindromicStringInTheArray

**Topic:** `string` | **File:** `com/problems/string/FindFirstPalindromicStringInTheArray.java`

**Tags:** String, Array, Two pointer

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=4JA5MW772N0)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String ans = firstPalindrome(words);
        System.out.println(ans);
    }
    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word, 0, word.length() - 1))
                return word;
        }
        return "";
    }
```
