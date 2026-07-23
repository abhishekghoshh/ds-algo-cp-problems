# SubarraysWithSumK

**Topic:** `recursion` | **File:** `com/problems/recursion/SubarraysWithSumK.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/subarrays-with-sum-k_6922076)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

We can use a sliding window here

```java
private static void type3() {
    }
```

### Approach 2

Iterative way

```java
private static void type2() {
        int[] nums = {1, 2, 3, 1, 1, 1};
        long k = 3;

        int n = nums.length;
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> bucket = new LinkedList<>();
        long remaining;
        for (int i = 0; i < n; i++) {
            remaining = k;
            bucket.clear();
            for (int j = i; j < n; j++) {
                remaining -= nums[j];
                bucket.add(nums[j]);
                if (remaining == 0) answer.add(new LinkedList<>(bucket));
                else if (remaining < 0) break;
            }
        }
        System.out.println(answer);
    }
```

### Approach 1 — Brute Force

We can also do it recursive way

```java
private static void type1() {
    }
```
