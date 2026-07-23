# FindFirstPalindromicStringInTheArray

**Topic:** `string`  
**Tags:** String, Array, Two pointer

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=4JA5MW772N0)

## 📝 Problem Statement

Tags: String, Array, Two pointer

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

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

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
```
