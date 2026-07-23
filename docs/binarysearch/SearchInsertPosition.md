# SearchInsertPosition

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/search-insert-position/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=6zhGS79oQ4k&t=1187s)
- [📄 takeUforward](https://takeuforward.org/arrays/search-insert-position/)

## 📝 Problem Statement

Find the position to insert a target in a sorted array.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int answer = searchInsert(nums, target);
        System.out.println(answer);
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int answer = n;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (target <= nums[mid]) {
                if (target == nums[mid]) return mid;
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int n = nums.length;
        int answer = n;
        for (int i = 0; i < n; i++) {
            if (target <= nums[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

}
```
