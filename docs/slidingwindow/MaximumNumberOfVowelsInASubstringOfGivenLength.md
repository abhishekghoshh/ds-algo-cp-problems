# MaximumNumberOfVowelsInASubstringOfGivenLength

**Topic:** `slidingwindow`  
**Tags:** Array, Sliding window

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=kEfPSzgL-Ss)

## 📝 Problem Statement

Maximum vowels in any substring of given length.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

sliding window approach for the first window for the remaining window

```java
    private static void type2() {
        String s = "abciiidef";
        int k = 3;
        int ans = maxVowels2(s, k);
        System.out.println(ans);
    }

    public static int maxVowels2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int v = 0;
        // for the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(arr[i])) v++;
        }
        int max = v;
        // for the remaining window
        for (int i = k; i < n; i++) {
            if (isVowel(arr[i])) v++;
            if (isVowel(arr[i - k])) v--;
            max = Math.max(max, v);
        }
        return max;
    }

    static boolean isVowel(char ch) {
        return switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
```

### Approach 1: 🔨 Brute Force

brute force

```java
    private static void type1() {

    }
}
```
