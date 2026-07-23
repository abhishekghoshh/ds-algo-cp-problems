# NumberOfGoodPairs

**Topic:** `array` | **File:** `com/problems/array/NumberOfGoodPairs.java`

**Tags:** Array, Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-good-pairs/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=BqhDFUo1rjs&t=1s)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

This is exactly like the previous but here we will use array instead of map, as we know the range of the numbers also the default value of the int array is 0

```java
private static void type3() {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int ans = numIdenticalPairs3(nums);
        System.out.println(ans);
    }
    public static int numIdenticalPairs3(int[] nums) {
        int[] freq = new int[101];
        int total = 0;
        for (int num : nums) {
            // checking the previous count of num
            total += (freq[num]);
            // updating the count of num
            freq[num]++;
        }
        return total;
    }
```

### Approach 2

This optimized approach using hashmap lets say we are currently on num = 5, now we need how many 5 we had in previous we could store that easily in a hashmap for the first time we see any element there will be 0 times we have seen this element previously, so we will have a default value in hashmap

```java
private static void type2() {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int ans = numIdenticalPairs2(nums);
        System.out.println(ans);
    }
    public static int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int num : nums) {
            // checking the previous count of num
            total += (map.getOrDefault(num, 0));
            // updating the count of num
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        return total;
    }
```

### Approach 1 — Brute Force

Brute force approach for every index we will check if the previous elements if there are same elements we will increment the total

```java
private static void type1() {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int ans = numIdenticalPairs1(nums);
        System.out.println(ans);
    }
    public static int numIdenticalPairs1(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) total++;
            }
        }
        return total;
    }
```
