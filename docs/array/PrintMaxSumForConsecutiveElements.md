# PrintMaxSumForConsecutiveElements

**Topic:** `array`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/maximum-subarray_893296)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=AHZpyENo7k4&t=1209s)
- [📄 takeUforward](https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

Kadane's Algorithm we carry a sub array if its sum is positive else we'll initialize it to 0 If sum < 0: discard the sum calculated

```java
    private static void type2() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;
        int tempStart = 0;
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) tempStart = i; // starting index
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
                start = tempStart;
                end = i;
            }
            // If sum < 0: discard the sum calculated
            sum = Math.max(sum, 0);
        }
        for (int i = start; i <= end; i++)
            answer.add(nums[i]);
        System.out.println(answer);
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(n)`

```java
    private static void type1() {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = Integer.MIN_VALUE;
        int n = array.length;
        List<Integer> answer = null, temp;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            temp = new ArrayList<>();
            for (int j = i; j < n; j++) {
                temp.add(array[j]);
                sum = sum + array[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    answer = new ArrayList<>(temp);
                }
            }
        }
        System.out.println(answer);
    }
}
```
