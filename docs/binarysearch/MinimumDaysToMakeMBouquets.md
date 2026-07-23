# MinimumDaysToMakeMBouquets

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/rose-garden_2248080)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=TXAuxeYBTdg)
- [📄 takeUforward](https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/)

## 📝 Problem Statement

Find minimum days to make m bouquets.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

binary search on answer approach we will find min and max and we will apply binary search on that for every mid we will check if the day allocation possible or not if (bloomDay.length < m * k) return -1;

```java
    private static void type2() {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
//        if (bloomDay.length < m * k) return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, answer = -1;
        for (int bloom : bloomDay) {
            if (bloom > max) max = bloom;
            if (bloom < min) min = bloom;
        }
        int low = min, high = max, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (canCreateBouquets(bloomDay, mid, m, k)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean canCreateBouquets(int[] bloomDay, int day, int m, int k) {
        int count = 0, adjacent = 0;
        for (int oneBloomDay : bloomDay) {
            if (oneBloomDay <= day) {
                adjacent++;
                if (adjacent == k) {
                    count++;
                    if (count == m) return true;
                    adjacent = 0;
                }
            } else adjacent = 0;
        }
        return false;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {

    }
}
```
