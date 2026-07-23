# LeadersInAnArray

**Topic:** `array`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/superior-elements_6783446)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cHrH9CQ8pmY)
- [📄 takeUforward](https://takeuforward.org/data-structure/leaders-in-an-array/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {
        int[] nums = {1, 2, 3, 2};
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                answer.add(max);
            }
        }
        System.out.println(answer);
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
    private static void type1() {
        int[] nums = {1, 2, 3, 2};
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            boolean isGreaterThanAllRight = true;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    isGreaterThanAllRight = false;
                    break;
                }
            }
            if (isGreaterThanAllRight) answer.add(nums[i]);
        }
        System.out.println(answer);
    }
}
```
