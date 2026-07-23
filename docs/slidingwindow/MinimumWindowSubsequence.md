# MinimumWindowSubsequence

**Topic:** `slidingwindow`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/minimum-window-subsequence_2181133)
- [📄 LeetCode](https://leetcode.com/problems/minimum-window-subsequence/description/)

## 🎥 Solution Links

- CodeByVansh : https://www.youtube.com/watch?v=B6scRxy_Zwo
- Happy Coding : https://www.youtube.com/watch?v=PYEb5UFwz2M

## 📝 Problem Statement

Find the minimum window in S containing T as a subsequence.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

same as before but it is slightly better as we are not looping backwards to find the start of the window instead setting the start once the counter == 0

```java
    private static void type4() {
        String s = "abcdebdde";
        String t = "bde";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n1 = sArr.length;
        int n2 = tArr.length;
        int minStart = -1, start = -1, end = 0, counter = 0;
        int res = Integer.MAX_VALUE;
        while (end < n1 && counter < n2) {
            if (sArr[end] == tArr[counter]) {
                if (counter == 0) start = end;
                counter++;
            }
            if (counter == n2) {
                if (res > end - start + 1) {
                    res = end - start + 1;
                    minStart = start;
                }
                counter = 0;
                end = start + 1;
            } else {
                end++;
            }
        }
        String str = minStart == -1 ? "" : s.substring(minStart, minStart + res);
        System.out.println(str);
    }
```

### Approach 3

best solution to explain once the counter == n then we going back track to find the start of the window

```java
    private static void type3() {
        String s = "abcdebdde";
        String t = "bde";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n1 = sArr.length;
        int n2 = tArr.length;
        int minStart = -1, start, end = 0, counter = 0;
        int res = Integer.MAX_VALUE;
        while (end < n1 && counter < n2) {
            if (sArr[end] == tArr[counter]) counter++;
            if (counter == n2) {
                start = end;
                counter = n2 - 1;
                while (counter >= 0)
                    if (sArr[start--] == tArr[counter]) counter--;
                start++;
                if (res > end - start + 1) {
                    res = end - start + 1;
                    minStart = start;
                }
                counter = 0;
                end = start + 1;
            }
            end++;
        }
        String str = minStart == -1 ? "" : s.substring(minStart, minStart + res);
        System.out.println(str);
    }
```

### Approach 2

Dynamic programming approach study it later

**Time Complexity:** `O(n*m)`
**Space Complexity:** `O(n*m)`

```java
    private static void type2() {

    }
```

### Approach 1: 🔨 Brute Force

Brute force approach

```java
    private static void type1() {
        String s = "abcdebdde";
        String t = "bde";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n1 = sArr.length;
        int n2 = tArr.length;
        int start = 0, min = Integer.MAX_VALUE, counter;

        for (int left = 0; left < n1; left++) {
            counter = 0;
            for (int right = left; right < n1; right++) {
                if (sArr[right] == tArr[counter]) counter++;
                if (counter == n2) {
                    if (min > right - left + 1) {
                        min = right - left + 1;
                        start = left;
                    }
                    break;
                }
            }
        }
        String answer = min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
        System.out.println(answer);
    }
}
```
