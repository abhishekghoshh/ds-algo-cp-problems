# ReverseString

**Topic:** `string` | **File:** `com/problems/string/ReverseString.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/reverse-string/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=_d0T_2Lk2qA)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        String s = "Hello world";
        char[] arr = s.toCharArray();
        reverseString(arr);
        System.out.println(new String(arr));
    }
    public static void reverseString(char[] s) {
        int n = s.length;
        int i = 0, j = n - 1;
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }
```
