# SubarraysWithSumK

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/subarrays-with-sum-k_6922076)

## 📝 Problem Statement

we can also do it recursive way

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

we can use a sliding window here

```java
    private static void type3() {
    }
```

### Approach 2

iterative way

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

### Approach 1: 🔨 Brute Force

we can also do it recursive way

```java
    private static void type1() {
    }


}
```
