# IdentifyTheLargestOutlierInAnArray

**Topic:** `hashing` | **File:** `com/problems/hashing/IdentifyTheLargestOutlierInAnArray.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/contest/weekly-contest-426/problems/identify-the-largest-outlier-in-an-array/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach very good example of hashing the numbers are like [a,b,c,d, sum, outlier] if we count the total and subtract outlier then we will get 2*sum, so we will use a set, store all the numbers and then check if (total-outlier)/2 present in the set or not but there can but some edge cases like total-outlier is not even also outlier can be equal to the computed sum, at that time we have to check if the freq of the outlier is >= 2 then there might be more than one answer, so we will store all the numbers in an array and then return the max

```java
private static void type2() {
        int[] nums = {-2, -1, -3, -6, 4};
        int ans = getLargestOutlier2(nums);
        System.out.println(ans);
    }
    public static int getLargestOutlier2(int[] nums) {
        int total = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, 1 + freq.getOrDefault(num, 0));
            total += num;
        }
        List<Integer> potentialOutliers = new ArrayList<>();
        for (int outlier : nums) {
            int rem = total - outlier;
            if (rem % 2 != 0) continue;
            int sum = rem / 2;
            if ((sum == outlier && freq.get(sum) >= 2) ||
                    (sum != outlier && freq.containsKey(sum)))
                potentialOutliers.add(outlier);
        }
        return Collections.max(potentialOutliers);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
