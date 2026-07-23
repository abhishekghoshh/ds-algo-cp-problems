# Permutations2

**Topic:** `recursion` | **File:** `com/problems/recursion/Permutations2.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/permutations-ii/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=qhBVWf0YafA)

## Approaches

Implementation:

### Implementation

It is from the permutation1 problem check all the solutions of permutation1 digits are strictly in this range -10 <= d <= 10

```java
private static void type1() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = permuteUnique(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteUnique(0, nums, ans);
        return ans;
    }
    private static void permuteUnique(int start, int[] nums, List<List<Integer>> ans) {
        int n = nums.length;
        if (start == n) {
            ans.add(toList(nums));
            return;
        }
        int N = 21, offset = 10;
        boolean[] set = new boolean[N];
        for (int i = start; i < n; i++) {
            int num = nums[i];
            if (!set[num + offset]) {
                set[num + offset] = true;
                // swapping the element
                swap(nums, start, i);
                permuteUnique(start + 1, nums, ans);
                // swapping again to retain the nums array
                swap(nums, start, i);
            }
        }
    }
    private static List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int item : nums) list.add(item);
        return list;
    }
    private static void swap(int[] nums, int left, int right) {
        int num = nums[left];
        nums[left] = nums[right];
        nums[right] = num;
    }
```
