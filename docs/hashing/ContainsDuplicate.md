# ContainsDuplicate

**Topic:** `hashing`  
**Tags:** Array, Hashing

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/contains-duplicate/description/)
- [📄 NeetCode](https://neetcode.io/problems/duplicate-integer)

## 🎥 Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/contains-duplicate-check-if-a-value-appears-atleast-twice/)

## 📝 Problem Statement

set add returns false that means item is already present

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

set add returns false that means item is already present

```java
    private static void type1() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean ans = containsDuplicate1(nums);
        System.out.println(ans);
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // set add returns false that means item is already present
            if (!set.add(num)) return true;
        }
        return false;
    }
}
```
