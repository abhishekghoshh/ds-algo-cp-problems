# ConvertAnArrayIntoA2DArrayWithConditions

**Topic:** `array`  
**Tags:** Array,

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=9pl1QiaGgmI)

## 📝 Problem Statement

Convert array to 2D array with distinct row elements.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

little more optimized than before using the hashing just here we will be doing it differently here we will go through the nums array and increasing the frequency if the current freq is f, then we will add that item to the f-1 index on the answer list

```java
    private static void type3() {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> ans = findMatrix3(nums);
        System.out.println(ans);
    }

    private static List<List<Integer>> findMatrix3(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        // here we will go through the nums array and increasing the frequency
        // if the current freq is f, then we will add that item to the f-1 index on the answer list
        for (int num : nums) {
            freq[num]++;
            int f = freq[num];
            if (list.size() < f) list.add(new ArrayList<>());
            list.get(f - 1).add(num);
        }
        return list;
    }
```

### Approach 2

optimized approach using hashing using an array as a frequency amp we will take max freq variable, because the maximum size of answer will be maximum freq of the most frequent number adding lists to our answer list beforehand now we will iterate over (1 to n) and add the elements

```java
    private static void type2() {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> ans = findMatrix2(nums);
        System.out.println(ans);
    }

    private static List<List<Integer>> findMatrix2(int[] nums) {
        int n = nums.length;
        // using an array as a frequency amp
        int[] freq = new int[n + 1];
        // we will take max freq variable,
        // because the maximum size of answer will be maximum freq of the most frequent number
        int maxF = 0;
        for (int num : nums) {
            freq[num]++;
            maxF = Math.max(maxF, freq[num]);
        }
        // adding lists to our answer list beforehand
        List<List<Integer>> list = new ArrayList<>(maxF);
        for (int i = 0; i < maxF; i++) list.add(new ArrayList<>());
        // now we will iterate over (1 to n) and add the elements
        for (int num = 1; num <= n; num++) {
            int f = freq[num];
            for (int j = 0; j < f; j++) list.get(j).add(num);
        }
        return list;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
