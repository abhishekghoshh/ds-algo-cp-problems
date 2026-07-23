# CountSubstringsOfLengthK

**Topic:** `string`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/count-with-k-different-characters_1214627)

## 📝 Problem Statement

Count substrings of exact length K with distinct characters.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

sliding window approach

```java
    private static void type2() {
        String str = "aacfssa";
        int k = 2;
        int n = str.length();
        char[] arr = str.toCharArray();
        System.out.println(getCount(arr, n, k) - getCount(arr, n, k - 1));
    }

    private static int getCount(char[] arr, int n, int k) {
        int[] freq = new int[26];
        int left = 0, ch, leftItem, distinct = 0;
        int count = 0;
        for (int right = 0; right < n; right++) {
            ch = arr[right] - 'a';
            if (freq[ch] == 0) distinct++;
            freq[ch]++;
            while (left < n && distinct > k) {
                leftItem = arr[left++] - 'a';
                freq[leftItem]--;
                if (freq[leftItem] == 0) distinct--;
            }
            count += right - left + 1;
        }
        return count;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
