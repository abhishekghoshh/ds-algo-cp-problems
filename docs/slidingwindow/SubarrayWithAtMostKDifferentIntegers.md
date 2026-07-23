# SubarrayWithAtMostKDifferentIntegers

**Topic:** `slidingwindow`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/subarrays-with-k-different-integers/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=akwRFY2eyXs)
- [▶ YouTube](https://www.youtube.com/watch?v=CBSeilNvZHs)
- [▶ YouTube](https://www.youtube.com/watch?v=etI6HqWVa8U)

## 📝 Problem Statement

with at most k integers, and we are storing it counts array.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach sliding window technique let's take an example suppose we have array 1234 if we add 5 to it to make it 12345 so what will be new substring count it will be (oldCount + substring ending with 5) let see how many can be possible ending with 5 12345, 2345, 345, 45, 5 the count is 5 which is same as the new length of the string so if we can calculate the substring added for every new integer appended then we will find the all the subarray with at most k integer when distinct elements exceed k then we will move the left pointer length of the new substring

```java
    private static void type2() {
        int[] nums = {1, 2, 1, 2, 3, 4};
        int k = 3;
        int n = nums.length;
        int[] freq = new int[n + 1];
        int distinct = 0;
        int count = 0;
        for (int left = 0, right = 0; right < n; right++) {
            int num = nums[right];
            if (freq[num] == 0) distinct++;
            freq[num]++;
            while (left < n && distinct > k) {
                int leftItem = nums[left++];
                freq[leftItem]--;
                if (freq[leftItem] == 0) distinct--;
            }
            // length of the new substring
            count += (right - left + 1);
        }
        System.out.println(count);
    }
```

### Approach 1: 🔨 Brute Force

brute force for every i we are computing how many subarrays can be possible with at most k integers, and we are storing it counts array. it will store how much subarray possible for every number until k if the set size is already k, and we are getting a new number then we will break

**Time Complexity:** `O(n^2)`

```java
    private static void type1() {
        int[] nums = {1, 2, 1, 2, 3, 4};
        int k = 3;
        int count = subarraysWithAtMostKDistinct1(nums, k);
        System.out.println(count);
    }

    private static int subarraysWithAtMostKDistinct1(int[] nums, int k) {
        int count = 0, n = nums.length;
        Set<Integer> set = new HashSet<>();
        // it will store how much subarray possible for every number until k
        int[] counts = new int[k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // if the set size is already k, and we are getting a new number then we will break
                if (set.size() == k && !set.contains(nums[j])) break;
                set.add(nums[j]);
                counts[set.size()]++;
            }
            set.clear();
        }
        for (int c : counts) count += c;
        return count;
    }
}
```
