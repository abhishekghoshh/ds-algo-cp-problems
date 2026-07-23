# MaximumCoinsFromKConsecutiveBags

**Topic:** `slidingwindow`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/)

## 📝 Problem Statement

we have to use 0 for that positions

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

we want consecutive sequence, so we will sort the array based on their starting time now we will apply sliding window, but here we have to do it wisely, as some position might be empty we have to use 0 for that positions

```java
    private static void type1() {
    }

    public long maximumCoins(int[][] coins, int k) {
        int n = coins.length;
        Arrays.sort(coins, Comparator.comparingInt(p -> p[0]));
        long max = 0;
        long coin = 0;
        int i = 0;
        int start = coins[0][0];
        while (i < n) {
            int[] bags = coins[i++];

        }
        return max;
    }
}
```
