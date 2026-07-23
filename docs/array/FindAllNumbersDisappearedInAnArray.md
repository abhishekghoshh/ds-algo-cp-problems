# FindAllNumbersDisappearedInAnArray

**Topic:** `array` | **File:** `com/problems/array/FindAllNumbersDisappearedInAnArray.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=8i-f24YFWC4)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println(ans);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        // we will create a boolean array to mark all the elements which are present
        boolean[] isPresent = new boolean[n + 1];
        for (int num : nums) isPresent[num] = true;
        // now we will store all the elements for which the value is false
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!isPresent[i]) ans.add(i);
        }
        return ans;
    }
```
