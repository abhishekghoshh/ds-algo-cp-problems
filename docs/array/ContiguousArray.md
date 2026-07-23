# ContiguousArray

**Topic:** `array`  
**Tags:** Array, Hashing, Prefix Sum,

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/contiguous-array/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=agB1LyObUNE)

## 📝 Problem Statement

Longest contiguous subarray with equal 0s and 1s.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as previous but here we will use array as map, we will fill array with infinity

```java
    private static void type3() {
        int[] nums = {0, 1, 0};
        int ans = findMaxLength3(nums);
        System.out.println(ans);
    }

    public static int findMaxLength3(int[] nums) {
        int INF = (int) 1e5 + 1;
        int n = nums.length;
        int offset = n;
        int[] map = new int[(2 * n) + 1];
        Arrays.fill(map, INF);
        map[offset] = -1;
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) sum++;
            else sum--;
            if (map[sum + offset] != INF) {
                int left = map[sum + offset];
                max = Math.max(max, i - left);
            } else
                map[sum + offset] = i;
        }
        return max;
    }
```

### Approach 2

prefix sum approach using map we will use a sum variable +1 when we see a 1 and -1 when we see a 0, and we will maintain [sum,index] in the map if the sum is in the map then we will get the left index then we will get the length => (i - left index) we will not update index for the sum if that is already present

```java
    private static void type2() {
        int[] nums = {0, 1, 0};
        int ans = findMaxLength2(nums);
        System.out.println(ans);
    }

    public static int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) sum++;
            else sum--;
            if (map.containsKey(sum)) {
                int left = map.get(sum);
                max = Math.max(max, i - left);
            } else map.put(sum, i);
        }
        return max;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
