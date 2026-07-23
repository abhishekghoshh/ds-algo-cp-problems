# CountOfSmallerNumbersAfterSelf

**Topic:** `fenwicktree` | **File:** `com/problems/fenwicktree/CountOfSmallerNumbersAfterSelf.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=WpttRpfw28U&list=PLEL7R4Pm6EmBxBrEq8g2L3MF3W3Shnk58&index=3)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Same as the inversion count problem using fenwick tree but here we will do differently we will not create the fenwick tree first and decrease the count rather we will start from clean tree we do it from the last and increase the frequency of num by one and the last we reverse the ans we will also tackle negative numbers here

```java
private static void type2() {
        int[] nums = {2, 0, 5, -1, -3, 1, 3, 4, 0, 2, -1, 0, 1, 0};
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        // first we will be calculating the max number and will create an array for holding all of this
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }
        // as fenwick tree is 1 indexed, so we will use offset and -min+1 not -min
        int offset = -min + 1;
        int N = max + offset + 1;
        // here we will use an empty tree
        // we will start from the last, and we will increase the frequency by one
        // here we will not need the freq array even
        // it is a clever approach as we are skipping the fenwick tree building time and freq array time and space
        int[] tree = new int[N];
        List<Integer> list = new ArrayList<>();
        // now here we will take num from last and increase the frequency by 1
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i] + offset;
            update(tree, N - 1, num, 1);
            list.add(query(tree, num - 1));
        }
        Collections.reverse(list);
        System.out.println(list);
    }
```

### Approach 1 — Brute Force

Brute force time complexity O(n^2) space complexity O(1)

**Complexity:** Time: o(n^2) | Space: o(1)

```java
private static void type1() {
        int[] nums = {2, 0, 5, -1, -3, 1, 3, 4, 0, 2, -1, 0, 1, 0};
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) count++;
            }
            list.add(count);
        }
        Collections.reverse(list);
        System.out.println(list);
    }
```
