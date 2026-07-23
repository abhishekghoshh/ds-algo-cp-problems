# MinimumNumberOfOperationsToMakeElementsInArrayDistinct

**Topic:** `array` | **File:** `com/problems/array/MinimumNumberOfOperationsToMakeElementsInArrayDistinct.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Rather going from first if we go from the last if we go from the last till freq of any element is greater than 1

```java
private static void type3() {
        int[] nums = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        int ans = minimumOperations3(nums);
        System.out.println(ans);
    }
    private static int minimumOperations3(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        int rem = (n % 3);
        int parts = (n / 3) + (rem > 0 ? 1 : 0);
        int i = n - 1;
        // checking for the first part individually if there is any reminder
        while (rem > 0) {
            rem--;
            int num = nums[i--];
            freq[num]++;
            if (freq[num] == 2) return parts;
        }
        // this means n has a reminder but that part only contained the unique elements,
        // so we will decrement the part needed
        if (n % 3 != 0) parts--;

        // checking for the remaining parts which is multiple of length 3
        while (parts > 0) {
            int d = 3;
            while (d > 0) {
                int num = nums[i--];
                freq[num]++;
                if (freq[num] == 2) return parts;
                d--;
            }
            parts--;
        }
        return parts;
    }
```

### Approach 2

Hashing approach we will store the freq of the numbers and as we well as store a variable to keep track the number of non-unique elements. so that we do not need to go through the entire freq map or array every time, to check how many non-unique are left

```java
private static void type2() {
        int[] nums = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        int ans = minimumOperations2(nums);
        System.out.println(ans);
    }
    public static int minimumOperations2(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] freq = new int[101];
        int nonUnique = 0;
        for (int num : nums) {
            freq[num]++;
            // if freq 2, that means it is non-unique,
            // we do not need to check for > 2 as once it is non-unique, it will stay as non-unique
            if (freq[num] == 2) nonUnique++;
        }
        // now we will loop till non-unique count is 0
        // (non-unique-count > 0) means there should be at least 2 elements in the array
        int i = 0;
        while (nonUnique > 0) {
            count++;
            int first = nums[i], second = nums[i + 1];
            // decreasing the freq of first and checking if the freq reduced to 1
            freq[first]--;
            if (freq[first] == 1) nonUnique--;
            // decreasing the freq of first and checking if the freq reduced to 1
            freq[second]--;
            if (freq[second] == 1) nonUnique--;
            // checking if there is the third element or not, if it has third then only we will check for it
            if (i + 2 < n) {
                int third = nums[i + 2];
                freq[third]--;
                if (freq[third] == 1) nonUnique--;
            }
            i = i + 3;
        }
        return count;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
