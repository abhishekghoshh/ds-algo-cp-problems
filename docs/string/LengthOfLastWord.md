# LengthOfLastWord

**Topic:** `string`  
**Tags:** Array, String

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/length-of-last-word/description/)

## 📝 Problem Statement

Return the length of the last word in a string.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach we will start from the last and skip till there is a character from that point we will start again and go till there is a space or till the start skip all the trailing spaces going till we encounter a space

**Time Complexity:** `O(n)`

```java
    private static void type2() {
        String s = "Hello World";
        int ans = lengthOfLastWord2(s);
        System.out.println(ans);
    }

    public static int lengthOfLastWord2(String s) {
        int n = s.length();
        int c = 0, i = n - 1;
        // skip all the trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') i--;
        // going till we encounter a space
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            c++;
        }
        return c;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
