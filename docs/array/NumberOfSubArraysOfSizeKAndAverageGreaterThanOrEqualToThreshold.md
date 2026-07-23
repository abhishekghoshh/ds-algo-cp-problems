# NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold

**Topic:** `array`  
**Tags:** Array, Sliding-Window

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=D8B4tKxMTnY)

## 📝 Problem Statement

then slide the window one by one and check the average

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

brute force

```java
    private static void type2() {

    }
}
```

### Approach 1: 🔨 Brute Force

using the sliding window approach first calculate for the first window then slide the window one by one and check the average calculating the first window shifting the window checking if the average is greater than the threshold or not

```java
    private static void type1() {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 5;
        int threshold = 5;
        int ans = numOfSubarrays2(arr, k, threshold);
        System.out.println(ans);
    }

    public static int numOfSubarrays2(int[] arr, int k, int threshold) {
        int sum = 0;
        int n = arr.length;
        // calculating the first window
        for (int i = 0; i < k; i++) sum += arr[i];
        int count = (sum / k) >= threshold ? 1 : 0;
        for (int i = k; i < n; i++) {
            // shifting the window
            sum += (arr[i] - arr[i - k]);
            // checking if the average is greater than the threshold or not
            if ((sum / k) >= threshold) count++;
        }
        return count;
    }
```
