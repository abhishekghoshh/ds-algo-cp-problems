# CapacityToShipPackagesWithinDDays

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/capacity-to-ship-packages-within-d-days_1229379)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=MG-Ac4TAvTY)
- [📄 takeUforward](https://takeuforward.org/arrays/capacity-to-ship-packages-within-d-days/)

## 📝 Problem Statement

Given weights of packages and days D, find the minimum ship capacity to ship all packages within D days.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as previous just we are just modifying the code little bit

```java
    private static void type3() {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        int high = 0, low = 0;
        for (int weight : weights) {
            high += weight;
            if (low < weight) low = weight;
        }
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int curDays = 0;
            int curSum = 0;
            for (int weight : weights) {
                if (curSum + weight > mid) {
                    curDays++;
                    curSum = 0;
                }
                curSum += weight;
            }
            if (curDays >= days) low = mid + 1;
            else high = mid;
        }
        System.out.println(low);
    }
```

### Approach 2

binary search on method approach

```java
    private static void type2() {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        int answer = Integer.MAX_VALUE, sum = 0;
        for (int weight : weights) sum += weight;
        int low = 1, high = sum, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (isPossible(weights, mid, days)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isPossible(int[] weights, int mid, int days) {
        int sum = 0, count = 0;
        for (int weight : weights) {
            if (weight > mid) return false;
            sum += weight;
            if (sum == mid) {
                sum = 0;
                count++;
            } else if (sum > mid) {
                sum = weight;
                count++;
            }
        }
        if (sum > 0) count++;
        return count <= days;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
