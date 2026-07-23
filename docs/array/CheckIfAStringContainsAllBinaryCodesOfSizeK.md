# CheckIfAStringContainsAllBinaryCodesOfSizeK

**Topic:** `array`  
**Tags:** Arrays, String, Bit manipulation, hashing, sliding window

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=qU32rTy_kOM)

## 📝 Problem Statement

Check if string contains all binary codes of length K.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach first we will calculate the upper range of bits it will be 0 to 2^k-1 we use a boolean set for 2^k numbers we will use a sliding window and convert the binary array to the decimal number. at last, we will check if all the index has a true or not in the set (1<<k) is the same as 2^k using a sliding window to compute the sum of first k length binary array now we will compute for the remaining array removing the left most bit and adding the current bit

```java
    private static void type2() {
        String s = "00110110";
        int k = 2;
        boolean ans = hasAllCodes2(s, k);
        System.out.println(ans);
    }

    public static boolean hasAllCodes2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < k) return false;
        // (1<<k) is the same as 2^k
        int N = 1 << k;
        boolean[] set = new boolean[N];

        // using a sliding window to compute the sum of first k length binary array
        int i = 0;
        int sum = 0;
        while (i < k) {
            int bit = arr[i++] - '0';
            sum = (sum * 2) + bit;
        }
        set[sum] = true;
        // now we will compute for the remaining array
        while (i < n) {
            int leftBit = arr[i - k] - '0';
            int bit = arr[i++] - '0';
            // removing the left most bit and adding the current bit
            sum = (sum * 2) - (leftBit * N) + bit;
            set[sum] = true;
        }
        // at last, we will check if all the index has a true or not in the set
        for (int j = 0; j < N; j++) {
            if (!set[j]) return false;
        }
        return true;
    }
```

### Approach 1: 🔨 Brute Force

brute force

```java
    private static void type1() {
    }
}
```
