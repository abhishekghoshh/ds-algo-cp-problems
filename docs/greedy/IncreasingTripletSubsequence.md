# IncreasingTripletSubsequence

**Topic:** `greedy`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/increasing-triplet-subsequence)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=-tqUs4Qt9TU)
- [▶ YouTube](https://www.youtube.com/watch?v=yEFlGWOVH8g)

## 📝 Problem Statement

Check if an increasing triplet subsequence exists.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

see the youtube video

```java
    private static void type2() {
        int[] nums = {1, 5, 0, 6, 4};
        boolean answer = increasingTriplet(nums);
        System.out.println(answer);
    }

    //TODO
    // see the youtube video
    // explain yourself
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= minOne) minOne = num;
            else if (num <= minTwo) minTwo = num;
            else return true;
        }
        return false;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {

    }
}
```
