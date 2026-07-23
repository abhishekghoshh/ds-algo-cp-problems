# MovesZeroToEnd

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/move-zeroes/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/ninja-and-the-zero-s_6581958)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wvcQg43_V8U&t=1633s)
- [📄 takeUforward](https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/)
- [▶ YouTube](https://www.youtube.com/watch?v=aayNRwUN3Do)
- [https://www.hellointerview.com/learn/code/two-pointers/move-zeroes](https://www.hellointerview.com/learn/code/two-pointers/move-zeroes)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

2 pointer approach In place swapping lets divide the problem first we will find the first 0th index if we find a 0 and zeroI is not initialized, then initialize it now we have found a non-zero element, and there is surely a zero element in the left side then we will swap them

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
    private static void type3() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes3(nums);
        print(nums);
    }

    private static void moveZeroes3(int[] nums) {
        int n = nums.length;
        int slow, fast;
        for (slow = 0, fast = 0; fast < n; fast++) {
            if (nums[fast] != 0)
                nums[slow++] = nums[fast];
        }
        for (int i = slow; i < n; i++) nums[i] = 0;
    }


    // In place swapping
    // time complexity O(n)
    // space complexity O(1)
    // lets divide the problem
    // first we will find the first 0th index
    private static void type2_() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2_(nums);
        print(nums);
    }

    private static void moveZeroes2_(int[] nums) {
        int zeroI = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // if we find a 0 and zeroI is not initialized, then initialize it
            if (nums[i] == 0 && zeroI == -1) {
                zeroI = i;
            } else if (nums[i] != 0 && zeroI != -1) {
                // now we have found a non-zero element, and there is surely a zero element in the left side
                // then we will swap them
                nums[zeroI++] = nums[i];
                nums[i] = 0;
            }
        }
    }
```

### Approach 2

In place swapping

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
    private static void type2() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
        print(nums);
    }

    private static void moveZeroes2(int[] nums) {
        int n = nums.length;
        int zerothIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                swap(nums, zerothIndex++, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        ArrayUtil.swap(arr, i, j);
    }
```

### Approach 1: 🔨 Brute Force

This is not in place it is using an extra array

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(n)`

```java
    private static void type1() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes1(nums);
        print(nums);
    }

    private static void moveZeroes1(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        int j = 0;
        for (int num : nums) {
            if (num != 0) copy[j++] = num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = i < j ? copy[i] : 0;
        }
    }
}
```
