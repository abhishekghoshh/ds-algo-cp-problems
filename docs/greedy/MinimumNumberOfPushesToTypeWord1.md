# MinimumNumberOfPushesToTypeWord1

**Topic:** `greedy` | **File:** `com/problems/greedy/MinimumNumberOfPushesToTypeWord1.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        String word = "xycdefghij";
        int ans = minimumPushes(word);
        System.out.println(ans);
    }
    public static int minimumPushes(String word) {
        int n = word.length();
        int keys = 8, num = 1;
        int ans = 0;
        while (n > 0) {
            // if the characters are not a multiple of keys, then we will take
            // the remaining letters, else we will always take keys=8
            ans += num * Math.min(keys, n);
            // we will increase the f for the next letter in the keypad
            num++;
            // we will decrease the 8 characters from the word
            n -= keys;
        }
        return ans;
    }
```
