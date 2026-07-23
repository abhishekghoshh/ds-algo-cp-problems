# DistributeElementsIntoTwoArrays1

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)

## 📝 Problem Statement

Distribute elements into two arrays (Part 1).

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

in place study it one more time

```java
    private static void type2() {
        int[] nums = {5, 4, 3, 8};
        int[] ans = resultArray2(nums);
        PrintUtl.print(ans);
    }

    // todo study it one more time
    private static int[] resultArray2(int[] nums) {
        int idx = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[idx] > nums[i - 1]) {
                int num = nums[i];
                idx++;
                for (int j = i; j > idx; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[idx] = num;
            }
        }
        return nums;
    }
```

### Approach 1: 🔨 Brute Force

using extra space

```java
    private static void type1() {
        int[] nums = {5, 4, 3, 8};
        int[] ans = resultArray1(nums);
        PrintUtl.print(ans);
    }

    public static int[] resultArray1(int[] nums) {
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int[] ans = new int[n];
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            int last1 = list1.get(list1.size() - 1);
            int last2 = list2.get(list2.size() - 1);
            if (last1 > last2) list1.add(nums[i]);
            else list2.add(nums[i]);
        }
        int i = 0;
        for (int num : list1) ans[i++] = num;
        for (int num : list2) ans[i++] = num;

        return ans;
    }
}
```
